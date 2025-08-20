package Quizdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DbConnection;

public class teacherDao {
	public static boolean TeacherLogin(String username,String password) throws ClassNotFoundException {
		String query="SELECT * FROM teacher where username=? and password=?";
		
		try (Connection con=DbConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement(query)){
			
			stmt.setString(1,username);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			
			return rs.next();
		}catch(SQLException e) {
			System.out.print(e);
			return false;
		}
	}

}
 