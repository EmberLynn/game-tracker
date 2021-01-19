/**
 * 
 */
package Application;

import java.sql.*;
import java.util.Scanner;

/**
 * @author ember
 *
 */
public class MainApp {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Games";
	
	static final String USER = "root";
	static final String PASS = "password";

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*
		 * 1. List
		 * 	--can add and choose game we are currently timing
		 * 2. Timer
		 * 	--timer start
		 * 	--timer stop
		 * 	--timer needs to add to current totals
		 * 3. List Times
		 * 	--for now, we want it to display a list of the games played and their time total 
		 * Let's build this for starters and see what we can pull apart afterward!
		 * 
		 * 
		 * What we need:
		 * -show list
		 * -show what game is currently selected
		 * -show timer and start and stop options
		 * -list total times for all game entered
		 * 
		 * */
		Connection conn = null;
		try 
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection success!\n");
			
		}catch(SQLException se)
		{
			System.out.println("Connection failed!");
			se.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	
		
		Scanner input = new Scanner(System.in);
		int selection = 0;
		
		do {
			System.out.println("Gamer Logger!\n"+
				"Keeps Track So You Don't Have To!\n");
		
			System.out.println("1.Select Game\n"+
				"2.List Times\n"+
				"3.Exit\n"+
				"Enter selection:");
			
			selection = input.nextInt();
			
			if(selection == 1)
			{
				gameMenu();
			}
			
		} while (selection != 3);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection did not close!");
		}
		input.close();
	}
	
	public static void gameMenu() 
	{
		Scanner input = new Scanner(System.in);
		int selection = 0;
		//String gameName;
		
		do {
			System.out.println("1. Add Game\n"+
					"2. Choose Game\n"+
					"3. Back\n"+
					"Enter selection:");

			selection = input.nextInt();
		
			
		} while (selection != 3);
		
		input.close();
	}

}
