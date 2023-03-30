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
 * Servlet implementation class resetPassowrd
 */
public class resetPassowrd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;
    
    public void init() {
    	dbManager = new dbManager();
    }
      
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPassowrd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
        String password = request.getParameter("password");
        
        user userBean = new user();
        userBean.setNic(nic);
        userBean.setPassword(password);
        admin adminBean = new admin();
        adminBean.setNic(nic);
        adminBean.setPassword(password);
        
        if(dbManager.checkUser(userBean)) {
    	    dbManager.updateUser(userBean);
    	    RequestDispatcher req = request.getRequestDispatcher("passChangeSuccess.jsp");
    		req.forward(request, response);
        }else if(dbManager.checkAdmin(adminBean)){
        	dbManager.updateAdmin(adminBean);
    	    RequestDispatcher req = request.getRequestDispatcher("passChangeSuccess.jsp");
    		req.forward(request, response);
        }else {
        	RequestDispatcher req = request.getRequestDispatcher("unRegisNic.jsp");
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
