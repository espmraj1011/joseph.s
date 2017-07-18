package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			// create our mysql database connection
			//	      String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");

			// our SQL SELECT query. 
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM persons";

			// create the java statement
			st = conn.createStatement();

			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				int Personid = rs.getInt("PersonID");
				String LastName = rs.getString("LastName");
				String FirstName = rs.getString("FirstName");
				String Address = rs.getString("Address");
				String City = rs.getString("City");

				// print the results
				System.out.format("%s, %s, %s, %s, %s\n", Personid, LastName, FirstName, Address, City);
			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
