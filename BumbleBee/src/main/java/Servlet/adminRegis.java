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
 * Servlet implementation class adminRegis
 */
public class adminRegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;
    
    public void init() {
    	dbManager = new dbManager();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminRegis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String nic = request.getParameter("nic");
        String email = request.getParameter("email");
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        String password = request.getParameter("password");
        
        
        boolean search = dbManager.checkAdminNic(nic); 
    	if(search){
    		RequestDispatcher req = request.getRequestDispatcher("alreadyRegis.jsp");
    		req.forward(request, response);
    	}else {
    		admin newAdmin = new admin(fName,lName,nic,email,mobile,password);
            dbManager.insertAdmin(newAdmin);
            RequestDispatcher req = request.getRequestDispatcher("adminRegis.jsp");
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
