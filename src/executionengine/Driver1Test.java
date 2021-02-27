package executionengine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import base_package.Actionkeyword;
import base_package.Constants;
import util.Excelutils;

public class Driver1Test 
{
	public static String sactionkeyword;
	public static Properties OR;
	public static String Pageobject;
	String Filepath=Constants.Excelpath;
	String repo_path=Constants.OR_path;
		
  @Test(priority=1)
  public void func1() throws IOException
  {
	  FileInputStream fs=new FileInputStream(repo_path);
	  Excelutils.setExcelFile(Filepath, "First");
	  for(int i=0;i<=3;i++)
	  {
	  sactionkeyword=Excelutils.getExcelData(i, Constants.Col_Action);
	  Pageobject=Excelutils.getExcelData(i, Constants.Col_Object);
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
	  }
  }
  
/*@Test(priority=2,dependsOnMethods= {"func1"})
  public void func2() throws IOException
  {
	  //FileInputStream fs=new FileInputStream(repo_path);
	 // Excelutils.setExcelFile(Filepath, "First");
	  for(int i=0;i<=3;i++)
	  {
	  sactionkeyword=Excelutils.getExcelData(i, Constants.Col_Action);
	  Pageobject=Excelutils.getExcelData(i, Constants.Col_Object);
	  if(sactionkeyword.equals("openbrowser"))
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
	  }
  }*/
}