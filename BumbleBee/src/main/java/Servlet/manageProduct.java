package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.dbManager;
import ModelBean.*;

/**
 * Servlet implementation class manageProduct
 */
public class manageProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;

	public void init() {
		dbManager = new dbManager();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public manageProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proName = request.getParameter("proName");
		String category = request.getParameter("category");
		double price = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");

		product newProduct = new product(proName, category, price, image);
		dbManager.insertProduct(newProduct);
		RequestDispatcher req = request.getRequestDispatcher("manageProduct.jsp");
		req.forward(request, response);
	}

}
