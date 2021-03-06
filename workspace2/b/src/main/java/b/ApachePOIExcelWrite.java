package b;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcelWrite {
	private static final String FILE_NAME = "d:/Excel1.xlsx";

    public static void main(String[] args) {
    		Connection conn = null;
    		Statement st = null;
    		ResultSet rs = null;
    		List<MarksVO> dataArr = new ArrayList<MarksVO>();
    		try
    		{
    			

    			String myUrl = "jdbc:mysql://localhost:3306/testdb";
    			Class.forName("com.mysql.jdbc.Driver");
    			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");



    			
    			String query = "SELECT * FROM marks";
    			st = conn.createStatement();
    			rs = st.executeQuery(query);
    			while (rs.next())
    			{
    				MarksVO data=new MarksVO();
    				String name = rs.getString("Name");
    				String dateOfBirth = rs.getString("DateOfBirth");
    				int tamil = rs.getInt("Tamil");
    				int english = rs.getInt("English");
    				int mathematics = rs.getInt("Mathematics");
    				int physics = rs.getInt("Physics");
    				int chemistry = rs.getInt("Chemistry");
    				int biology = rs.getInt("Biology");
    				
    				
    				System.out.println(name);
    				System.out.println(dateOfBirth);
    				System.out.println(tamil);
    				System.out.println(english);
    				System.out.println(mathematics);
    				System.out.println(physics);
    				System.out.println(chemistry);
    				System.out.println(biology);
    				
    				
    				
    				String output = name +"   "+ dateOfBirth+"    "+tamil+"    "+english+"    "+mathematics+"    "+physics+"    "+chemistry+"   "+biology;
    				data.setName(name);
    				data.setDateofbirth(dateOfBirth);
    				data.setTamil(tamil);
    				data.setEnglish(english);
    				data.setMathematics(mathematics);
    				data.setPhysics(physics);
    				data.setChemistry(chemistry);
    				data.setBiology(biology);
    				
    				
    				dataArr.add(data);
    				
    				
    			}
    }
    		catch (Exception e)
    		{
    			System.err.println("Got an exception! ");
    			e.printStackTrace();
    		}


    		finally {
    			try {
    				if(st!= null){
    					st.close();}
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    			try {
    				if(rs!= null){
    					rs.close();}
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    			try {
    				if(conn!= null){
    					conn.close();}
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}

    		
    		
    Object[] tmpData ;
    Object[][] seriesData = new Object[dataArr.size()][8];
	for(int i=0;i<dataArr.size();i++){
		tmpData = new Object[]{dataArr.get(i).getName(),dataArr.get(i).getDateofbirth(),dataArr.get(i).getTamil(),dataArr.get(i).getEnglish(),dataArr.get(i).getMathematics(),dataArr.get(i).getPhysics(),dataArr.get(i).getChemistry(),dataArr.get(i).getBiology() };
		seriesData[i]=tmpData;
	}
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Mark list");
        XSSFRow rowhead=   sheet.createRow((short)0);
        rowhead.createCell((short) 0).setCellValue("Name");
        rowhead.createCell((short) 1).setCellValue("DOB");
        rowhead.createCell((short) 2).setCellValue("Tamil");
        rowhead.createCell((short) 3).setCellValue("English");
        rowhead.createCell((short) 4).setCellValue("Mathematics");
        rowhead.createCell((short) 5).setCellValue("Physics");
        rowhead.createCell((short) 6).setCellValue("Chemistry");
        rowhead.createCell((short) 7).setCellValue("Biology");

        Object[][] datatypes =  seriesData;
        System.out.println(seriesData);
        int rowNum = 1;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
