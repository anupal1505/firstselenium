package util;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils 
{
private static XSSFWorkbook Excelworkbook;
private static XSSFSheet excelsheet;
private static XSSFCell cell;
public static void setExcelFile(String Path,String Sheet) throws IOException
	{
		FileInputStream File=new FileInputStream(Path);
		Excelworkbook =new XSSFWorkbook(File);
		excelsheet=Excelworkbook.getSheet(Sheet);
	}
	public static String getExcelData(int rowno,int colno)
	{
		cell=excelsheet.getRow(rowno).getCell(colno);
		String celldata=cell.getStringCellValue();
		return celldata;
	}
}