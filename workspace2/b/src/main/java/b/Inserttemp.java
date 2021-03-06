package b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import b.TempVO;

public class Inserttemp {
	public static void main(String[] args){
		List<TempVO> dataArr = new ArrayList<TempVO>();
		TempVO data = new TempVO();
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("D:\\temp.xlsx"));
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
			
			 data = new TempVO();
			 
			
			data.setDay(row.getCell(0).getDateCellValue());
			data.setTemperature((float)row.getCell(1).getNumericCellValue());

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
					Date Day1 =dataArr.get(i).getDay();
					SimpleDateFormat Day = new SimpleDateFormat("yyyy/MM/dd");  
					String date = Day.format(Day1);
					String sql = "INSERT INTO Temp(Day,Temperature)" +
							"VALUES ('"+date+"','"+dataArr.get(i).getTemperature()+"')";
					System.out.println(sql);
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
