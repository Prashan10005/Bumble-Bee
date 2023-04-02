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
 * Servlet implementation class moveToCart
 */
public class moveToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			ArrayList<cart> cartList = new ArrayList<>();

			int proID = Integer.parseInt(request.getParameter("proID"));
			cart cm = new cart();
			cm.setProID(proID);
			cm.setQuantity(1);

			HttpSession session = request.getSession();
			ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("buyProducts.jsp");
			} else {
				cartList = cart_list;
				boolean exist = false;

				for (cart c : cartList) {
					if (c.getProID() == proID) {
						exist = true;
						out.println("<h3 style='color:crimson; text-align:center'>Item Already Avilable at the Cart.<a href='manageOrders.jsp'>Go to Cart Page</a></h3>");
					}
				}
				if (!exist) {
					cartList.add(cm);
					response.sendRedirect("buyProducts.jsp");
				}
			}
			
		}
	}

}
