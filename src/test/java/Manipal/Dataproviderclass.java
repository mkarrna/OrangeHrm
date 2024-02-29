package Manipal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataproviderclass {
	
	@DataProvider(name="supplier")
	public Object[][] dataSupplier() {
		
		String excelFilePath = System.getProperty("user.dir")+"\\files\\Book11.xlsx";
		File excelFile = new File(excelFilePath);
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowsCount = sheet.getPhysicalNumberOfRows(); //count rows
		int colsCount = sheet.getRow(0).getLastCellNum(); //count column
		
		Object[][] data = new Object[rowsCount-1][colsCount];
		
		for(int r=0;r<rowsCount-1;r++) {  
			
			XSSFRow row = sheet.getRow(r+1);
			
			for(int c=0;c<colsCount;c++) {
				
				XSSFCell cell = row.getCell(c);
				
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					data[r][c] = cell.getStringCellValue();
					break;
				
				case NUMERIC:
					data[r][c] = (int)cell.getNumericCellValue();
					break;
					
				case BOOLEAN:
					data[r][c] = cell.getBooleanCellValue();
					break;
				default:
					break;
				
				}
				
			}
			
		}
		
		return data;
		
	}

}
