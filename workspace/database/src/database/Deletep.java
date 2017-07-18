package database;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
public class Deletep {
	public static void main(String[] args)
	{
		Statement st = null;
		try
		{
			// create the mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "abcd1234");

			// create the mysql delete statement.
			// i'm deleting the row where the id is "3", which corresponds to my
			// "Barney Rubble" record.
			st = conn.createStatement();
			String query = "delete from Products where ProductID IN(11,12,13,14)";
			st.executeUpdate(query);
			System.out.println("The records are deleted from the table");
			st.close();
			conn.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}
}
