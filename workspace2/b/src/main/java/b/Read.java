package b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Read {
	public static void main(String[] args){
		List<MarksVO> dataArr = new ArrayList<MarksVO>();
		MarksVO data = new MarksVO();
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("D:\\Excel1.xlsx"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheetAt(0);

		java.util.Iterator <Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) 
		{
			Row row = rowIterator.next();
			String val =row.getCell(0).getStringCellValue();
			if(val.equals("Name")){  
				continue;
			}

			 data = new MarksVO();
			System.out.println(row.getCell(0));
			data.setName(row.getCell(0).getStringCellValue()); 
			data.setDateofbirth(row.getCell(1).getStringCellValue());
			data.setTamil((int)row.getCell(2).getNumericCellValue());
			data.setEnglish((int)row.getCell(3).getNumericCellValue());
			data.setMathematics((int)row.getCell(4).getNumericCellValue());
			data.setPhysics((int)row.getCell(5).getNumericCellValue());
			data.setChemistry((int)row.getCell(6).getNumericCellValue());
			data.setBiology((int)row.getCell(7).getNumericCellValue());
			dataArr.add(data);
		}
			System.out.println(dataArr);
			Connection conn = null;
			Statement st = null;
			try
			{
				String myUrl = "jdbc:mysql://localhost:3306/testdb";
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(myUrl, "root", "abcd1234");
				st = (Statement) conn.createStatement();
				for(int i=0; i<dataArr.size();i++){
					String sql = "INSERT INTO marks(Name,DateOfBirth,Tamil,English,Mathematics,Physics,Chemistry,Biology)" +
							"VALUES ('"+dataArr.get(i).getName()+"','"+dataArr.get(i).getDateofbirth()+"',"+dataArr.get(i).getTamil()+","+dataArr.get(i).getEnglish()+","+dataArr.get(i).getMathematics()+","+dataArr.get(i).getPhysics()+","+dataArr.get(i).getChemistry()+","+dataArr.get(i).getBiology()+")";
					st.executeUpdate(sql);
				}
				System.out.println("Inserted records into the table...");
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
