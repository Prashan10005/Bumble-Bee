package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import Dao.dbManager;
import ModelBean.*;
import ModelBean.user;

/**
 * Servlet implementation class checkout
 */
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			HttpSession session = request.getSession();
			ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
			user auth = (user) session.getAttribute("auth");
			
			if(cart_list != null && auth !=null) {
				for(cart c:cart_list) {
					order order = new order();
					order.setuID(auth.getNic());
					order.setProID(c.getProID());
					order.setQuantity(c.getQuantity());
					order.setDate(format.format(date));
					
					dbManager orderDao = new dbManager();
					orderDao.insertOrder(order);
					
				}
				cart_list.clear();
				response.sendRedirect("buyProducts.jsp");
			}else {
				if(auth == null) response.sendRedirect("Login.jsp");
				response.sendRedirect("manageOrders.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
