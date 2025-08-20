package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DbConnection {		
	 public static Connection getConnection()throws ClassNotFoundException, SQLException{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb","root","#Sp6058");
		return con;
	}
			
			

}
	
	





