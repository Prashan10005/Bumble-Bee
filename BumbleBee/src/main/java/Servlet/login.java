package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Dao.dbManager;
import ModelBean.admin;
import ModelBean.user;
/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;
    
    public void init() {
    	dbManager = new dbManager();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
        String password = request.getParameter("password");
        admin adminBean = new admin();
        adminBean.setNic(nic);
        adminBean.setPassword(password);
        user userBean = new user();
        userBean.setNic(nic);
        userBean.setPassword(password);
        if (dbManager.adminLogin(adminBean)) {
        	request.getSession().setAttribute("auth", adminBean);
        	RequestDispatcher req = request.getRequestDispatcher("adminHome.jsp");
			req.include(request, response);
        } else if (dbManager.userLogin(userBean)) {
        	request.getSession().setAttribute("auth", userBean);
        	RequestDispatcher req = request.getRequestDispatcher("userProfile.jsp");
			req.include(request, response);
        } else {
        	RequestDispatcher req = request.getRequestDispatcher("invalidLogin.jsp");
			req.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
