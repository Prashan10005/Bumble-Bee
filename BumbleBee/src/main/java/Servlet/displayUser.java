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
import ModelBean.user;

/**
 * Servlet implementation class displayUser
 */
public class displayUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;
    
    public void init() {
    	dbManager = new dbManager();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayUser() {
        super();
        // TODO Auto-generated constructor stub
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
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;	
		case "/update":
			updateUser(request, response);
			break;	
		default :
			listUser(request, response);
			break;
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminHome.jsp");
		dispatcher.forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String nic = request.getParameter("nic");
        String email = request.getParameter("email");
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        user user = new user(fName,lName,email,nic,mobile);
        dbManager.manageUser(user);
        response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
		dbManager.deleteUser(nic);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
		user excistingUser = dbManager.selectUser(nic);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminHome.jsp");
		request.setAttribute("user", excistingUser);
		dispatcher.forward(request, response);
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<user> listUser = dbManager.selectAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminHome.jsp");		
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
