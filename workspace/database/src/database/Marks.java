package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Marks {
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement st = null;
		try
		{
			// create our mysql database connection
			//	      String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");
			String a,b; int c,d,e,f,g,h,i;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Name");
			a=s.next();
			System.out.println("Enter the Date of birth");
			b=s.next();
			System.out.println("Tamil marks");
			c=s.nextInt();
			System.out.println("English marks");
			d=s.nextInt();
			System.out.println("Mathematics marks");
			e=s.nextInt();
			System.out.println("Physics marks");
			f=s.nextInt();
			System.out.println("Chemistry marks");
			g=s.nextInt();
			System.out.println("Biology marks");
			h=s.nextInt();
			i=c+d+e+f+g+h;
			st = conn.createStatement();
			String sql = "INSERT INTO Marks(Name,DateOfBirth,Tamil,English,Mathematics,Physics,Chemistry,Biology,Total)" +
					"VALUES ('"+a+"','"+b+"',"+c+","+d+","+e+","+f+","+g+","+h+","+i+")";
			st.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}
	}
}
