package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Products1 {
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
			String sql = "INSERT INTO Products(ProductID,ProductName,SupplierID,CategoryID,Unit,Price)" +
					"VALUES (10,'Sir Rodneys Marmalade',8,3,'30 gift boxes',81)";
			st.executeUpdate(sql);
			String sql1 = "INSERT INTO Products(ProductID,ProductName,SupplierID,CategoryID,Unit,Price)" +
					"VALUES (11,'Mishi Kobe Niku',4,6,'18 - 500 g pkgs.',97)";
			st.executeUpdate(sql1);
			sql1 = "INSERT INTO Products(ProductID,ProductName,SupplierID,CategoryID,Unit,Price)" +
					"VALUES (12,'Alice Mutton',7,6,'20 - 1 kg tins',39)";
			st.executeUpdate(sql1);
			sql1 = "INSERT INTO Products(ProductID,ProductName,SupplierID,CategoryID,Unit,Price)" +
					"VALUES (13,'Gustafs Knäckebröd',9,5,'24 - 500 g pkgs.',21)";
			st.executeUpdate(sql1);
			sql1 = "INSERT INTO Products(ProductID,ProductName,SupplierID,CategoryID,Unit,Price)" +
					"VALUES (14,'Tunnbröd',9,5,'12 - 250 g pkgs.',9)";
			st.executeUpdate(sql1);
			System.out.println("Inserted records into the table...");

			// create the java statement
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
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
