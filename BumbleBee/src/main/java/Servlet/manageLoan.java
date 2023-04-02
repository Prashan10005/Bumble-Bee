package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Dao.dbManager;
import ModelBean.loan;
import ModelBean.user;
/**
 * Servlet implementation class manageLoan
 */
public class manageLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageLoan() {
    	this.dbManager = new dbManager();
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertLoan(request, response);
			break;
		case "/delete":
			deleteLoan(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;	
		case "/update":
			updatetLoan(request, response);
			break;	
		default :
			listLoan(request, response);
			break;
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("loanNew.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusNIC = request.getParameter("cusNIC");
		Double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
		Double usedAmount = Double.parseDouble(request.getParameter("usedAmount"));
		Double balance = Double.parseDouble(request.getParameter("balance"));
		int installment = Integer.parseInt(request.getParameter("installment"));
		loan newLoan = new loan(cusNIC,loanAmount,usedAmount,balance,installment);
		dbManager.insertLoan(newLoan);
		response.sendRedirect("list");
	}
	
	private void deleteLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusNIC = request.getParameter("cusNIC");
		dbManager.deleteUser(cusNIC);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusNIC = request.getParameter("cusNIC");
		loan excistingLoan = dbManager.selectLoan(cusNIC);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loanNew.jsp");
		request.setAttribute("loan", excistingLoan);
		dispatcher.forward(request, response);
	}
	
	private void updatetLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusNIC = request.getParameter("cusNIC");
		Double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
		Double usedAmount = Double.parseDouble(request.getParameter("usedAmount"));
		Double balance = Double.parseDouble(request.getParameter("balance"));
		int installment = Integer.parseInt(request.getParameter("installment"));
		loan loan = new loan(cusNIC,loanAmount,usedAmount,balance,installment);
		dbManager.insertLoan(loan);
		response.sendRedirect("list");
	}
	
	private void listLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<loan> listLoan = dbManager.selectAllLoan();
		request.setAttribute("listLoan", listLoan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("approveUser.jsp");		
		dispatcher.forward(request, response);
	}
}
