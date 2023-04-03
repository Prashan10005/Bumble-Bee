package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import ModelBean.cart;
/**
 * Servlet implementation class cartRemove
 */
public class cartRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String proID = request.getParameter("proID");
			if(proID != null) {
				HttpSession session = request.getSession();
				ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
				if(cart_list != null) {
					for(cart c:cart_list) {
						if(c.getProID()== Integer.parseInt(proID)) {
							cart_list.remove(cart_list.indexOf(c));
							break; 
						}
					}
					response.sendRedirect("manageOrders.jsp"); 
				}
			} else {
				response.sendRedirect("manageOrders.jsp");
			}
		}
	}

	
}
