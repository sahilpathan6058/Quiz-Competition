package Quizdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DbConnection;

public class QuizDao {
	

    public static boolean QuizResult(int Id, int RollNo, String username, int score, String grade) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO quiz_result (id, RollNo, username, score, grade) VALUES (?, ?, ?, ?,?)";

      
        Connection con = DbConnection.getConnection();
        
        if (con == null) {
            System.out.println("Database connection failed.");
            return false; 
        }

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, Id);
            stmt.setInt(2, RollNo);
            stmt.setString(3, username);
            stmt.setInt(4, score);
            stmt.setString(5, grade);

            int rowsAffect = stmt.executeUpdate();
            if (rowsAffect > 0) {
                System.out.println("Quiz result saved successfully.");
                return true;
            } else {
                System.out.println("Failed to save quiz result.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error saving quiz result: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

	public static void showAllResult() throws ClassNotFoundException {
		String query="select * from quiz_result ";
		
		try (Connection con=DbConnection.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			
			ResultSet rs=stmt.executeQuery();
			
			System.out.println("ID\tRollNo\tusername\tScore\tgrade");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"\t"+rs.getInt("RollNo")+"\t"+ rs.getString("username") + "\t" + rs.getInt("score") + "\t" + rs.getString("grade"));
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
				


	}

}
