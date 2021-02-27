package executionengine;
import java.io.FileInputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import java.util.Properties;

import base_package.Actionkeyword;
import base_package.Constants;
import util.Excelutils;
public class Driver1
{
	public static Properties OR;
	public static String sactionkeyword;
	public static String Pageobject;
	public static void main(String[] args) throws Exception
	{
//String filepath="D:\\Software\\Java Workspace\\Master.xlsx";
		String filepath=Constants.Excelpath;
		String repo_path=Constants.OR_path;
		FileInputStream fs=new FileInputStream(repo_path);
		OR=new Properties(System.getProperties());
		OR.load(fs);
		Excelutils.setExcelFile(filepath, "First");
		for(int i=0;i<=4;i++)
			{
			//sactionkeyword=External_excel.getExcelData(i,4);
			sactionkeyword=Excelutils.getExcelData(i, Constants.Col_Action);
			Pageobject=Excelutils.getExcelData(i, Constants.Col_Object);
			System.out.println("Page Object is" + " " + Pageobject);
				if(sactionkeyword.equals("openBrowser"))
					{
					Actionkeyword.openBrowser();
					}
				else if(sactionkeyword.equals("navigate"))
				{
					Actionkeyword.navigate();
				}
				else if(sactionkeyword.equals("InputUsername"))
				{
					Actionkeyword.input_username(Pageobject);
				}
				/*else if(sactionkeyword.equals("click_next"))
				{
					Actionkeyword.click_next(Pageobject);
				}*/
			}
	}}
