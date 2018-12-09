package Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	public static long PAGE_LOAD_TIMEOUT = 20;
	String filepath, propvalue;
	static String value;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static XSSFRow Row;
	static DataFormatter formatter = new DataFormatter();
	
	public String readProperty(String path, String property)
	{
		this.filepath = path;
		value = property;
		try 
		{
			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			propvalue = prop.getProperty(value);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return propvalue;
	}
	
	public String readExcel(String path, String sheetname, int row, int column)
	{
		this.filepath = path;
		try
		{
			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetname);
			this.propvalue = formatter.formatCellValue(sheet.getRow(row).getCell(column));
			wb.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to read excel file because of below error:");
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			System.out.println("Unable to read excel file because of below error:");
			e.printStackTrace();
		}
		return propvalue;
	}
	
	public static Object[][] readExcelDataArray(String path, String sheetname)
	{
		String [][] dataArray = null;
		try
		{
			//File file = new File(path);
			FileInputStream fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetname);
			int startRow = 1;
			int startCol = 0;
			int totalCols, cj;
			int ci = 0;
			int totalRows = sheet.getLastRowNum();
			Row = sheet.getRow(0);
			totalCols = Row.getLastCellNum();
			dataArray = new String[totalRows][totalCols];
			
			for (int i = startRow; i <= totalRows; i++, ci++)
			{
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++)
				{
					dataArray[ci][cj] = getCellData(i, j);
				}
			}
			wb.close();
		}catch(FileNotFoundException ex)
		{
			System.out.println("Could not read the Excel sheet. Something may be wrong with the excel path or sheet name.");
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			System.out.println("Could not read the Excel sheet.");
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Could not read the Excel sheet.");
			ex.printStackTrace();
		}
		return (dataArray);
	}
	
	public static String getCellData(int rowNum, int colNum)
	{
		try
		{
			value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		}
		catch(Exception ex)
		{
			System.out.println("Could not read the Excel sheet.");
			System.out.println(ex.getMessage());
		}
		return value;
	}
}
