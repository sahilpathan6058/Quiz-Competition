package eample;

import java.sql.SQLException;
import java.util.Scanner;
import DBConnection.DbConnection;
import Quizdao.QuizDao;

public class Quiz {
	
	public static String grade (int score) {
		
		if(score >=9) {
			return "A";
		}else if(score >=7) {
			return "B";
		}else if(score >=5) {
			return "C";
		}else if(score >=2) {
			return "D";
		}else {
			return "Fail";
		}
			
	} 
	
	public static void StartQuiz(int id, int RollNo, String username) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nwelcome to the quiz!.. ");	
		int score=0;
		
		System.out.println("\nQ1: Which is the largest state in India by area?");
		System.out.println("1) Uttar Pradesh 2)Maharashtra 3)Rajasthan 4)Madhya Pradesh");
		if(scanner.nextInt()==3)score++;
		
        System.out.println("\nQ2: Who developed Java?");
        System.out.println("1) James Gosling  2) Bjarne Stroustrup  3) Dennis Ritchie  4) Guido van Rossum");
        if (scanner.nextInt() == 1) score++;

		
        System.out.println("\nQ3: Which keyword is used to define a class in Java?");
        System.out.println("1)class  2) define 3)  struct 4)  create");
        if (scanner.nextInt() == 1) score++;
        
        System.out.println("\nQ4: Which of the following is not a Java primitive data type?");
        System.out.println("1)int  2) float  3) String  4) char");
        if (scanner.nextInt() == 3) score++;
        
        System.out.println("\nQ5:Which method is called automatically when an object is created?");
        System.out.println("1) Constructor  2) finalize() 3) main() 4)new()");
        if (scanner.nextInt() == 1) score++;
        
        System.out.println("\nQ6:What is the default value of a boolean variable in Java?");
        System.out.println("1)true  2)false 3)0  4)null");
        if (scanner.nextInt() == 2) score++;
        
        System.out.println("\nQ7:Which keyword is used to prevent inheritance in Java?");
        System.out.println("1) static  2) final  3)abstract  4) private");
        if (scanner.nextInt() == 2) score++;
        
        System.out.println("\nQ8:What is the size of an int variable in Java?");
        System.out.println("1)  2 bytes 2) 4 bytes 3) 8 bytes  4) 16 bytes");
        if (scanner.nextInt() == 2) score++;
        
        System.out.println("\nQ9:Which of the following is used to create an object in Java?");
        System.out.println("1) malloc() 2)alloc()  3) new  4) create");
        if (scanner.nextInt() == 3) score++;
        
        System.out.println("\nQ10: What is 5 + 3?");
        System.out.println("1) 6  2) 7  3) 8  4) 9");
        if (scanner.nextInt() == 3) score++;
        
        System.out.println("\nQuiz complete your score:"+score +"/10");
        
        
        String grade=grade(score);
        System.out.println("your grade :"+grade);
        
        if(score >= 2) {
        	System.out.println("congrats you are passed..");
        }else {
        	System.out.println("better luck next time..");
        	
      
        	

        	
        }
        boolean isSaved = QuizDao.QuizResult(id, RollNo, username, score,grade);
        if (isSaved) {
            System.out.println("Your quiz result has been saved in the database.");
        } else {
            System.out.println("Failed to save quiz result.");
        }
        
        scanner.close();
	}

}
