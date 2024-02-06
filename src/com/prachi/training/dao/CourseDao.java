package com.prachi.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prachi.training.model.Course;
import com.prachi.training.model.User;

public class CourseDao {
	
	private String JDBCURL="jdbc:mysql://localhost:3306/TrainingPrDb";
	private String JDBC_USER="root";
	private String JDBC_PASSWORD="root123";

	private static final String INSERT_USERS_SQL = "INSERT INTO course" + "  (course_id, c_name, c_desp, c_fees,c_resource) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	
	private static final String SELECT_USER_BY_ID = "select course_id,c_name,c_desp,c_fees,c_resource from course where course_id =?";
	private static final String SELECT_ALL_USERS = "select * from course";
	private static final String DELETE_USERS_SQL = "delete from course where course_id = ?;";
	private static final String UPDATE_USERS_SQL = "update course set c_name = ?,c_desp= ?, c_fees =?,c_resource=? where course_id = ?;";

	public CourseDao()
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
	
	public void insertUser(Course course) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		//user_id, name, phone_no, email,address,reg_date,password,upload_photo
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, course.getCourse_id());
			preparedStatement.setString(2,course.getC_name() );
			preparedStatement.setString(3,course.getC_desc() );
			preparedStatement.setString(4,course.getC_fees() );
			preparedStatement.setString(5,course.getC_resource());
			


			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Course> selectAllCourse() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Course> course = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("course_id");
				String name = rs.getString("c_name");
				String desc = rs.getString("c_desp");
				String fees = rs.getString("c_fees");
				String resource = rs.getString("c_resource");

				course.add(new Course(id,name,desc,fees,resource));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println("2:"+course.size());
		return course;
	}
	
	
	public boolean updateCourse(Course course) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, course.getC_name());
			statement.setString(2, course.getC_desc());
			statement.setString(3, course.getC_fees());
			statement.setString(4, course.getC_resource());
			statement.setInt(5, course.getCourse_id());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public Course selectCourse(int id) {
		Course course = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
						// Step 4: Process the ResultSet object.
			//user_id, name, phone_no, email,address,reg_date,password,upload_photo

			while (rs.next()) {
				
				int u_id = rs.getInt("course_id");
				String name = rs.getString("c_name");
				String desc = rs.getString("c_desp");
				String fees = rs.getString("c_fees");
				String resrc = rs.getString("c_resource");
				
				course = new Course(u_id, name, desc,fees,resrc);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println("User Name(in DAO)"+course.getC_name());
		return course;
	}
	public boolean deleteCourse(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
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
