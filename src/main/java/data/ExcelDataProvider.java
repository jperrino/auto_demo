package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelDataProvider(String filePath)
	{
		try
		{
		File src = new File(filePath);
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		}
		catch(FileNotFoundException e)
		{
		System.out.println(e.getMessage());
		fis = null;
		}
		catch(IOException e)
		{
		System.out.println(e.getMessage());
		wb = null;
		}
	}
	
	public String getData(int sheetIndex, int row, int column)
	{
		sheet = wb.getSheetAt(0);
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public int getRowCount(int sheetIndex)
	{
		return (wb.getSheetAt(sheetIndex).getLastRowNum())+1;
	}
	
	public int getRowColumnCount(int sheetIndex, int rowIndex)
	{
		return wb.getSheetAt(sheetIndex).getRow(rowIndex).getLastCellNum();
	}
	
	public void closeStream()
	{
		if(wb != null)
		{
			try {
				wb.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				wb = null;
			}
		}
		if(fis != null)
		{
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				fis = null;
			}
			
		}
	}
	
	

}
