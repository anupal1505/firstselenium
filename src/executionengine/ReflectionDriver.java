package executionengine;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import base_package.Actionkeyword;
import base_package.Constants;
import util.Excelutils;
public class ReflectionDriver {
public static Actionkeyword actionkey;
public static Properties OR;
public static String sactionkeyword;
public static String Pageobject;
public static Method method[];
/*public ReflectionDriver() 
	{
		actionkey=new Actionkeyword();
		method=actionkey.getClass().getMethods();
	}*/
	public static void main(String[] args) throws Exception
	{
		String filepath=Constants.Excelpath;
		String repo_path=Constants.OR_path;
		FileInputStream fs=new FileInputStream(repo_path);
		OR=new Properties(System.getProperties());
		OR.load(fs);
		Excelutils.setExcelFile(filepath, "First");
		for(int i=1;i<=3;i++)
			{
			sactionkeyword=Excelutils.getExcelData(i, Constants.Col_Action);
			Pageobject=Excelutils.getExcelData(i, Constants.Col_Object);
			System.out.println("Page Object is" + " " + Pageobject);
			actionkey=new Actionkeyword();
			method=actionkey.getClass().getMethods();
			execute_Actions();
			}
	}
	private static void execute_Actions() throws Exception {
		for(int i=0;i<method.length;i++)
		{
			if(method[i].getName().equals(sactionkeyword))
			{
				method[i].invoke(actionkey);
			}
		}
		
	}}
