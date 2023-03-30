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
	private static final String SELECTUSERBYNIC = "SELECT nic, fName, lName,email,mobile from user where nic =?";
	private static final String SELECTALLUSERS = "SELECT * from user ";
	private static final String DELETEUSER = "DELETE from user where nic =?";
	private static final String UPDATEUSER = "UPDATE user set fName=?,lName=?,email=?,mobile? where nic=?";
	
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
	
	public boolean checkUser(user user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM user WHERE nic = ?");
			stmt.setString(1,user.getNic());
			System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
	}
	
	public boolean checkAdmin(admin admin) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("SELECT * FROM admin WHERE nic = ? ");
			stmt.setString(1,admin.getNic());
			System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            status = rs.next();
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
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
	
	public boolean updateUser(user user)  {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("UPDATE user SET password = ? WHERE nic = ?");
			stmt.setString(1,user.getPassword());
			stmt.setString(2,user.getNic());
			boolean rowUpdated = stmt.executeUpdate() > 0;
	        close(stmt);
	        close(conn);
	       
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
}
	public boolean updateAdmin(admin admin)  {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("UPDATE admin SET password = ? WHERE nic = ?");
			stmt.setString(1,admin.getPassword());
			stmt.setString(2,admin.getNic());
			boolean rowUpdated = stmt.executeUpdate() > 0;
	        close(stmt);
	        close(conn);
	       
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
}
	
	public boolean manageUser(user user)  {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(UPDATEUSER, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,user.getfName());
			stmt.setString(2,user.getlName());
			stmt.setString(3,user.getEmail());
			stmt.setInt(4,user.getMobile());
			stmt.setString(5,user.getNic());
			boolean rowUpdated = stmt.executeUpdate() > 0;
	        close(stmt);
	        close(conn);
	       
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return status;
}	
	public user selectUser(String nic) {
		Connection conn = null;
		PreparedStatement stmt = null;
		user user = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SELECTUSERBYNIC, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,nic);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String fName = rs.getString("fName");
				String lName = rs.getString("lName");
				String email = rs.getString("email");
				int mobile = rs.getInt("mobile");
				user = new user(fName,lName,nic,email,mobile);
			}
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
	}
		return user;
}
	
	public List<user> selectAllUser() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<user> users = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SELECTALLUSERS, Statement.RETURN_GENERATED_KEYS);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String fName = rs.getString("fName");
				String lName = rs.getString("lName");
				String nic = rs.getString("nic");
				String email = rs.getString("email");
				int mobile = rs.getInt("mobile");
				users.add(new user(fName,lName,nic,email,mobile));
			}
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
	}
		return users;
}
	
	public boolean deleteUser(String nic)  {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean rowDeleted;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(DELETEUSER, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,nic);
			rowDeleted = stmt.executeUpdate() > 0;
	        close(stmt);
	        close(conn);
	       
		} catch (SQLException e) {
            // process sql exception
			throw new RuntimeException(e);
        }
        return rowDeleted;
}
}