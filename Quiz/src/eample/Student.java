package eample;

import java.sql.SQLException;
import java.util.*;
import Quizdao.StudentDao;
import DBConnection.DbConnection;

public class Student {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter Student ID:");
            int student_id = scanner.nextInt();

            System.out.println("Enter Roll No:");
            int RollNo = scanner.nextInt();

            System.out.println("Enter name:");
            String username = scanner.next();

            System.out.println("Enter Password:");
            String password = scanner.next();

            if (StudentDao.StudentRegister(student_id, RollNo, username, password)) {
                System.out.println("Registration successful! You can now log in.");

                // Immediately ask for login after successful registration
                System.out.println("\nPlease login now:");

                System.out.println("Enter Student ID:");
                student_id = scanner.nextInt();

                System.out.println("Enter Roll No:");
                RollNo = scanner.nextInt();

                System.out.println("Enter Name:");
                username = scanner.next();

                System.out.println("Enter Password:");
                password = scanner.next();

                if (StudentDao.StudentLogin(student_id, RollNo, username, password)) {
                    System.out.println("Login successful! Welcome, " + username);
                    Quiz.StartQuiz(student_id, RollNo, username);
                } else {
                    System.out.println("Invalid login. Please try again.");
                }

            } else {
                System.out.println("Registration failed. Try again.");
            }

        } else if (choice == 2) {
            System.out.println("Enter Student ID:");
            int student_id = scanner.nextInt();

            System.out.println("Enter Roll No:");
            int RollNo = scanner.nextInt();

            System.out.println("Enter Name:");
            String username = scanner.next();

            System.out.println("Enter Password:");
            String password = scanner.next();

            if (StudentDao.StudentLogin(student_id, RollNo, username, password)) {
                System.out.println("Login successful! Welcome, " + username);
                Quiz.StartQuiz(student_id, RollNo, username);
            } else {
                System.out.println("Invalid login. Please try again.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
