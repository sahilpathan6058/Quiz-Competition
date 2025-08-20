package Quizdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DbConnection;

public class StudentDao {
    
    public static boolean StudentRegister(int student_id, int RollNo, String username, String password) throws ClassNotFoundException {
        String query = "INSERT INTO student (student_id, RollNo, username, Password) VALUES (?, ?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, student_id);
            stmt.setInt(2, RollNo); 
            stmt.setString(3, username);
            stmt.setString(4, password);

            int rowaffect = stmt.executeUpdate();
            return rowaffect > 0; 

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean StudentLogin(int student_id, int RollNo, String username, String password) throws ClassNotFoundException {
        String query = "SELECT * FROM student WHERE student_id = ? AND RollNo = ? AND username = ? AND Password = ?";

        try (Connection con= DbConnection.getConnection();
        		PreparedStatement stmt=con.prepareStatement(query)){
        	
        	  stmt.setInt(1, student_id);
              stmt.setInt(2, RollNo); 
              stmt.setString(3, username);
              stmt.setString(4, password);
              
              ResultSet rs=stmt.executeQuery();
              return rs.next();
        	
        	
        }catch(SQLException e) {
        	System.out.println(e);
        	return false;
        	
        }
    }
}
	


