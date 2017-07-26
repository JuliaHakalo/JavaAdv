package database;

import java.sql.*;
import java.util.Scanner;



public class Main {

	static boolean isRun = true;
	public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/mybase?useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	
	public static final String CREATE_TABLE_PERSON_QUERY_IF_NOT_EXISTS = 
			"CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT, "
			+ "name VARCHAR(255), age INT,  heigth INT, weight INT, gender VARCHAR(20),hobby VARCHAR(30),single VARCHAR(15), education VARCHAR(50), profession VARCHAR(50))";
	
	public static final String INSERT_PERSON = 
			"INSERT INTO person(name, age, heigth,weight,gender,hobby,single,education,profession) VALUES (?,?,?,?,?,?,?,?,?)";
	
	public static final String UPDATE_PERSON = 
			"update person set name=?, age=?, heigth=?,weight=?, gender=?, hobby=?,single=?,education=?,profession=? where id = ?";
	
	public static final String DELETE_PERSON = "delete from person where id=?";


	public static void main(String[] args) {

		while (isRun) {
			try {
				Connection connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
				Scanner sc = new Scanner(System.in);
				System.out.println("1 - Створити таблицю");
				System.out.println("2 - Додати рядок у таблицю");
				System.out.println("3 - Редагувати рядок");
				System.out.println("4 - Видалити рядок");
				System.out.println("anykey - вийти з програми");
				int a = sc.nextInt();
				switch (a) {
				case 1: {
					Statement statement = connection.createStatement();
					statement.execute(CREATE_TABLE_PERSON_QUERY_IF_NOT_EXISTS);
					statement.close();
				}
				break;
				case 2: {PreparedStatement statement = 
						connection.prepareStatement(INSERT_PERSON);
					System.out.println("Enter person name");
					String personName = sc.next();
					statement.setString(1, personName);
					System.out.println("Enter age");
					int age = sc.nextInt();
					statement.setInt(2, age);
					System.out.println("Enter heigth");
					int heigth = sc.nextInt();
					statement.setInt(3, heigth);
					System.out.println("Enter weight");
					int weight = sc.nextInt();
					statement.setInt(4, weight);
					System.out.println("Enter gender");
					String gender = sc.next();
					statement.setString(5, gender);
					System.out.println("Enter hobby");
					String hobby = sc.next();
					statement.setString(6, hobby);
					System.out.println("Enter single");
					String single = sc.next();
					statement.setString(7, single);
					System.out.println("Enter education");
					String education = sc.next();
					statement.setString(8, education);
					System.out.println("Enter profession");
					String profession = sc.next();
					statement.setString(9, profession);
					statement.executeUpdate();
					statement.close();
				}
				break;
				case 3:{
					PreparedStatement statement = 
							connection.prepareStatement(UPDATE_PERSON);
				System.out.println("Enter id");
				String a2 = sc.next();
				statement.setString(10, a2);
					System.out.println("Enter person name");
					String a1 = sc.next();
					statement.setString(1, a1);
					System.out.println("Enter age");
					int b = sc.nextInt();
					statement.setInt(2, b);
					System.out.println("Enter heigth");
					int c = sc.nextInt();
					statement.setInt(3, c);
					System.out.println("Enter weight");
					int d = sc.nextInt();
					statement.setInt(4, d);
					System.out.println("Enter gender");
					String e = sc.next();
					statement.setString(5, e);
					System.out.println("Enter hobby");
					String f = sc.next();
					statement.setString(6, f);
					System.out.println("Enter single");
					String g = sc.next();
					statement.setString(7, g);
					System.out.println("Enter education");
					String h = sc.next();
					statement.setString(8, h);
					System.out.println("Enter profession");
					String i = sc.next();
					statement.setString(9, i);
					statement.executeUpdate();
					statement.close();
				}
				break;
				case 4:{
					PreparedStatement statement = 
							connection.prepareStatement(DELETE_PERSON);
					System.out.println("Enter id");
					int b = sc.nextInt();
					statement.setInt(1, b);
					statement.executeUpdate();
					statement.close();
				}
				break;
				default:{
					isRun=false;
					
				}
				break;
			
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}


	}

}
}
