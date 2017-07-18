package b;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read1 {
	
	 @SuppressWarnings("resource")
	public static void main(String[] args) 
	    {
	        try
	        {
	            FileInputStream file = new FileInputStream(new File("D:\\Excel1.xlsx"));
	 
	            XSSFWorkbook workbook = new XSSFWorkbook(file);

	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            java.util.Iterator <Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();
	                
	               
	                System.out.println(row.getCell(0).getStringCellValue());
	            }
	            file.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    }

}
