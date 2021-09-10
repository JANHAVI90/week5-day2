package Week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][]readData(String Book1) throws IOException {
		XSSFWorkbook workbook= new XSSFWorkbook ("./data/Book1.xlsx");
		XSSFSheet worksheet = workbook.getSheet(Book1); 
		XSSFRow row =worksheet .getRow(1);
		short lastCellNum =worksheet.getRow(0).getLastCellNum();
		int lastRowNum = worksheet.getLastRowNum();
		String[][]data= new String[lastRowNum][lastCellNum];
		for(int i=1;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				String text = worksheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text+"  ");
				data[i-1][j]=text;
				
				
			}
		}
		
		workbook.close();
		return data;
		
	
		
		
		// TODO Auto-generated method stub

	}

}
