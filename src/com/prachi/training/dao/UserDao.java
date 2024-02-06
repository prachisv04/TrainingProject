package com.prachi.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prachi.training.model.User;

//this provide crud op for user
public class UserDao {
	
	private String JDBCURL="jdbc:mysql://localhost:3306/TrainingPrDb";
	private String JDBC_USER="root";
	private String JDBC_PASSWORD="root123";

	private static final String INSERT_USERS_SQL = "INSERT INTO user1" + "  (user_id, name, phone_no, email,address,reg_date,password,upload_photo) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	
	private static final String SELECT_USER_BY_ID = "select user_id,name,phone_no,email,address,reg_date,password,upload_photo from user1 where email =?";
	private static final String SELECT_ALL_USERS = "select * from user1";
	private static final String DELETE_USERS_SQL = "delete from user1 where user_id = ?;";
	private static final String UPDATE_USERS_SQL = "update user1 set name = ?,email= ?, address =? where email = ?;";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public UserDao()
	{
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBCURL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		//user_id, name, phone_no, email,address,reg_date,password,upload_photo
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getUser_id());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setLong(3, user.getPhone_no());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getReg_date());
			preparedStatement.setString(7, user.getPassword());
			preparedStatement.setString(8, user.getUpload_photo());


			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public User selectUser(String email) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
						// Step 4: Process the ResultSet object.
			//user_id, name, phone_no, email,address,reg_date,password,upload_photo

			while (rs.next()) {
				
				int u_id = rs.getInt("user_id");
				String name = rs.getString("name");
				long Phn = rs.getLong("phone_no");
				String mail = rs.getString("email");
				String adrs = rs.getString("address");
				String rdt = rs.getString("reg_date");
				String pwd = rs.getString("password");
				String photo = rs.getString("upload_photo");
				user = new User(u_id, name, Phn,mail,adrs,rdt, pwd,photo);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println("User Name(in DAO)"+user.getName());
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int u_id = rs.getInt("user_id");
				String name = rs.getString("name");
				long Phn = rs.getLong("phone_no");
				String mail = rs.getString("email");
				String adrs = rs.getString("address");
				String rdt = rs.getString("reg_date");
				String pwd = rs.getString("password");
				String photo = rs.getString("upload_photo");
				users.add(new User(u_id, name, Phn,mail,adrs,rdt, pwd,photo));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public boolean validate(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from user1 where email = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		System.out.println(user.getEmail());
		ps.setString(2, user.getPassword());
		System.out.println(user.getPassword());

		ResultSet rs = ps.executeQuery();
		status = rs.first();
		System.out.println(status);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}



}
