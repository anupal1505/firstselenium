package base_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Actionkeyword
{
public static WebDriver dr;
public static  Properties prop;
public static void openBrowser() throws IOException
{
	System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
	prop=new Properties();	
	FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//resources//projectconfig.properties");
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
	//System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Drivers\\msedgedriver.exe");
	//dr=new EdgeDriver();
	dr=new ChromeDriver();
	//dr.get("https://www.icicidirect.com");
	File screenshotfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotfile,new File("D:\\screenshot.png"));
}
public static void navigate() throws IOException
{
	dr.get(Constants.URL);
	File screenshotfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotfile,new File("D:\\Testcase1\\screenshot.png"));
}
public static void input_username(String object) throws IOException
{
	//dr.findElement(By.xpath(".//*[@id=\"identifierId\"]")).sendKeys(Constants.username);
	//dr.findElement(By.xpath(".//*[@id=\"identifierId\"]")).sendKeys(Keys.ENTER);
	dr.findElement(By.xpath("//*[@id=\"divSearch\"]/a[3]")).click();
	dr.findElement(By.xpath("//*[@id=\"txtuid\"]")).sendKeys(Constants.username);
	File screenshotfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotfile,new File("D:\\Testcase2\\screenshot1.png"));
}
/*public static void click_next(String object) throws IOException
{
	dr.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
	File screenshotfile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotfile,new File("D:\\Testcase2\\screenshot1.png"));
}*/


}
