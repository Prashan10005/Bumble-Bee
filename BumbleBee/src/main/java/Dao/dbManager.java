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
import ModelBean.loan;
import ModelBean.product;
import ModelBean.cart;
import ModelBean.order;

public class dbManager {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bumble+bee";

	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL, "root", "");
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
	private static final String SELECTALLUSERS = "SELECT * from user ";
	private static final String INSERTORDER = "INSERT INTO order(uID,proID,quantity,date) VALUES( ?, ?,?,?)";
	

	public int insertUser(user user) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERTUSER, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getfName());
			stmt.setString(2, user.getlName());
			stmt.setString(3, user.getNic());
			stmt.setInt(4, user.getAge());
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
			stmt.setString(1, user.getNic());
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
			stmt.setString(1, admin.getNic());
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
			stmt.setString(1, admin.getNic());
			stmt.setString(2, admin.getPassword());
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
			stmt.setString(1, user.getNic());
			stmt.setString(2, user.getPassword());
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return status;
	}

	public boolean updateUser(user user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("UPDATE user SET password = ? WHERE nic = ?");
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getNic());
			boolean rowUpdated = stmt.executeUpdate() > 0;
			close(stmt);
			close(conn);

		} catch (SQLException e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return status;
	}

	public boolean updateAdmin(admin admin) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("UPDATE admin SET password = ? WHERE nic = ?");
			stmt.setString(1, admin.getPassword());
			stmt.setString(2, admin.getNic());
			boolean rowUpdated = stmt.executeUpdate() > 0;
			close(stmt);
			close(conn);

		} catch (SQLException e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return status;
	}

	public List<user> selectAllUser() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<user> users = new ArrayList<user>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SELECTALLUSERS, Statement.RETURN_GENERATED_KEYS);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String fName = rs.getString("fName");
				String lName = rs.getString("lName");
				String nic = rs.getString("nic");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				int mobile = rs.getInt("mobile");
				users.add(new user(fName,lName,nic,age,email,mobile));
			}
		} catch (SQLException e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return users;
	}

	public List<product> getAllProduct() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<product> product = new ArrayList<product>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from product", Statement.RETURN_GENERATED_KEYS);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int proID = rs.getInt("proID");
				String proName = rs.getString("proName");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				product.add(new product(proID, proName, category, price, image));
			}
		} catch (SQLException e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return product;
	}

	public List<cart> displayCart(ArrayList<cart> cartList) {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<cart> products = new ArrayList<cart>();
		try {
			if (cartList.size() > 0) {
				for (cart item : cartList) {
					conn = getConnection();
					stmt = conn.prepareStatement("select * from product where proID=?",
							Statement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, item.getProID());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						cart row = new cart();
						row.setProID(rs.getInt("proID"));
						row.setProName(rs.getString("proName"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getDouble("price"));
						products.add(row);
					}
				}
			}
		} catch (Exception e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return products;
	}

	public double getTotal(ArrayList<cart> cartList) {
		Connection conn = null;
		PreparedStatement stmt = null;
		double sum = 0;
		try {
			if (cartList.size() > 0) {
				for (cart item : cartList) {
					conn = getConnection();
					stmt = conn.prepareStatement("select price from product where proID=?", Statement.RETURN_GENERATED_KEYS);	
					stmt.setInt(1, item.getProID());
					ResultSet rs = stmt.executeQuery();
					
					while (rs.next()) {
						sum+= rs.getDouble("price");
					}
				}
			}
						
		} catch (Exception e) {
			// process sql exception
			throw new RuntimeException(e);
		}
		return sum;
	}
	
	public int insertOrder(order order) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERTORDER, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, order.getuID());
			stmt.setInt(2,order.getProID());
			stmt.setInt(3, order.getQuantity());
			stmt.setString(4, order.getDate());
					
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
	public int insertProduct(product product) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("INSERT INTO product(proName,category,price,image) VALUES( ?, ?,?,?)");
			stmt.setString(1, product.getProName());
			stmt.setString(2,product.getCategory());
			stmt.setDouble(3, product.getPrice() );
			stmt.setString(4, product.getImage());
					
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
}