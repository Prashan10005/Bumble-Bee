package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Dao.dbManager;
import ModelBean.user;

/**
 * Servlet implementation class regisUser
 */
public class regisUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dbManager dbManager;
    
    public void init() {
    	dbManager = new dbManager();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regisUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String nic = request.getParameter("nic");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        String password = request.getParameter("password");
        
       
        if(age <17) {
        	RequestDispatcher req = request.getRequestDispatcher("minorRegis.jsp");
    		req.forward(request, response);
        }else {
        	boolean search = dbManager.checkUserNic(nic); 
        	if(search){
        		RequestDispatcher req = request.getRequestDispatcher("alreadyRegis.jsp");
        		req.forward(request, response);
        	}else {
        		user newuser1 = new user(fName,lName,nic,age,address,email,mobile,password);
        	    dbManager.insertUser(newuser1);
        	    RequestDispatcher req = request.getRequestDispatcher("regisSuccess.jsp");
        		req.forward(request, response);
        	}
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
