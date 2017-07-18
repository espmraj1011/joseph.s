package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Category1 {
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

			// our SQL SELECT query. 
			// if you only need a few columns, specify them by name instead of using "*"
			st = conn.createStatement();
			String sql = "INSERT INTO Categories(CategoryID,CategoryName,Description)" +
					"VALUES (5,'Grains/Cereals','Breads, crackers, pasta, and cereal')";
			st.executeUpdate(sql);
			sql = "INSERT INTO Categories(CategoryID,CategoryName,Description)" +
					"VALUES (6,'Meat/Poultry','Prepared meats')";
			st.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

			// create the java statement	
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
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}