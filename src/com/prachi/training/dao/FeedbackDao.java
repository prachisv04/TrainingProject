package com.prachi.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prachi.training.model.Enroll;
import com.prachi.training.model.Feedback;

public class FeedbackDao {
	private String JDBCURL="jdbc:mysql://localhost:3306/TrainingPrDb";
	private String JDBC_USER="root";
	private String JDBC_PASSWORD="root123";

	private static final String INSERT_USERS_SQL = "INSERT INTO feedback" + "  (user_id, name, email, feedback) VALUES "
			+ " (?, ?, ?, ?);";
	
	
	private static final String SELECT_ALL_USERS = "select * from feedback";
	
	public FeedbackDao()
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
	
	public void insertFeed(Feedback feed) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		//user_id, name, phone_no, email,address,reg_date,password,upload_photo
		System.out.println("dao:"+feed.getUser_id());
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, feed.getUser_id());
			preparedStatement.setString(2,feed.getName());
			preparedStatement.setString(3,feed.getEmail());
			preparedStatement.setString(4,feed.getFeedbadck());
			


			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Feedback> selectAllFeed() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Feedback> feedList = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int U_id = rs.getInt("user_id");
				String Name = rs.getString("name");
				String email = rs.getString("email");
				String Feedback = rs.getString("feedback");

				feedList.add(new Feedback(U_id,Name,email,Feedback));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println("feedlist size:"+feedList.size());
		return feedList;
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

	
	
}
