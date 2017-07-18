package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
public class Products {
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
			String query = "SELECT * FROM Products";

			// create the java statement
			st = conn.createStatement();

			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				int Productid = rs.getInt("ProductID");
				String ProductName = rs.getString("ProductName");
				int Supplierid = rs.getInt("SupplierID");
				int Categoryid = rs.getInt("CategoryID");
				String Unit = rs.getString("Unit");
				String Price = rs.getString("Price");
				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s\n", Productid, ProductName, Supplierid, Categoryid, Unit, Price);
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
