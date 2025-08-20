package eample;

import java.util.Scanner;

import Quizdao.QuizDao;
import Quizdao.teacherDao;

public class teacher {
	
	public static void main(String args[]) throws ClassNotFoundException {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter the name");
		String username=scanner.next();
		
		System.out.println("enter the password");
		String password=scanner.next();
		
		if(teacherDao.TeacherLogin(username, password)) {
			System.out.print("login successfully welcome ,"+username);
			showStudentScore();
		}else {
			System.out.print("invalid data");
		}
		scanner.close();
	}

	public static void showStudentScore() throws ClassNotFoundException {    
		System.out.print("\nStudent Quiz Score:\n");
		QuizDao.showAllResult();
		
	}

}
