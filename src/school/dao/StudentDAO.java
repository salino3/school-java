package school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
	private Connection connection;

	public StudentDAO(Connection connection) {
		this.connection = connection;
	}

	public void addStudent(String name) {
		String sql = "INSERT INTO students (name) VALUES (?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.executeUpdate();
			System.out.println("Student " + name + " added successfully!");
		} catch (SQLException e) {
			System.err.println("Error inserting student: " + e.getMessage());
		}
	}
}
