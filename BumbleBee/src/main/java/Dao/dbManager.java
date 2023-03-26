package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelBean.admin;
import ModelBean.user;

public class dbManager {

	private static final String DRIVER_NAME ="com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bumble+bee";

	
	private Connection getConnection() {
		try {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(DB_URL,"root","");
		} catch (Exception e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		}
		}
	
	private static void close(Connection con) {
		if (con != null) {
		try {
		con.close();
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		}
		}
		}

	private static void close(Statement stmt) {
		if (stmt != null) {
		try {
		stmt.close();
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		}
		}
		}
	
	private static final String INSERTUSER = "INSERT INTO user(fName,lName,nic,age,address,email,mobile,password) VALUES(?, ?, ?,?,?,?,?,?)";
	private static final String INSERTADMIN = "INSERT INTO admin(fName,lName,nic,email,mobile,password) VALUES(?,?, ?, ?,?,?)";

	
	public int insertUser(user user) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
		conn = getConnection();
		stmt = conn.prepareStatement(INSERTUSER, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, user.getfName());
		stmt.setString(2, user.getlName());
		stmt.setString(3, user.getNic());
		stmt.setInt(4,user.getAge());
		stmt.setString(5, user.getAddress());
		stmt.setString(6, user.getEmail());
		stmt.setInt(7, user.getMobile());
		stmt.setString(8, user.getPassword());
		
		int result = stmt.executeUpdate();
		return result;
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		} finally {
		close(stmt);
		close(conn);
		}

	}
	
	public int insertAdmin(admin admin) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
		conn = getConnection();
		stmt = conn.prepareStatement(INSERTADMIN, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, admin.getfName());
		stmt.setString(2, admin.getlName());
		stmt.setString(3, admin.getNic());
		stmt.setString(4, admin.getEmail());
		stmt.setInt(5, admin.getMobile());
		stmt.setString(6, admin.getPassword());
		
		int result = stmt.executeUpdate();
		return result;

		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		} finally {
		close(stmt);
		close(conn);
		}

	}
	
	public boolean checkUserNic(String nic) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
		conn = getConnection();
		PreparedStatement query = conn.prepareStatement("SELECT * FROM `user` WHERE NIC ='"+nic+"'");
		boolean row = query.execute();
        return true;
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		} finally {
		close(stmt);
		close(conn);
		}
		
	}
	
	public boolean checkAdminNic(String nic) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
		conn = getConnection();
		PreparedStatement query = conn.prepareStatement("SELECT * FROM `admin` WHERE NIC ='"+nic+"'");
		boolean row = query.execute();
        return true;
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException(e);
		} finally {
		close(stmt);
		close(conn);
		}
	}
	
	public boolean adminLogin(admin admin) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM admin WHERE nic = ? and password = ? ");
			stmt.setString(1,admin.getNic());
			stmt.setString(2,admin.getPassword());
			System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
	}
	
	public boolean userLogin(user user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM user WHERE nic = ? and password = ? ");
			stmt.setString(1,user.getNic());
			stmt.setString(2,user.getPassword());
			System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
	}
}