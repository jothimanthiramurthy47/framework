package guru99;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Comparator;


public class TC001 
{
	//commit ;kwrmgjlkrw
	public ChromeDriver driver;
	  private String baseUrl;
	  public int scc = 0;
	  private StringBuffer verificationErrors = new StringBuffer();
@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		baseUrl = "http://live.guru99.com/index.php/";
	
	}
@Test
	public void verifySortedName() throws IOException
	{
		driver.get("http://live.guru99.com/index.php/");
		SoftAssert sa=new SoftAssert();
		try {
			sa.assertEquals(driver.getTitle(), "THIS IS DEMO SITE");

		}
		catch (Error e)
		{
			verificationErrors.append(e.toString());
		}
				
		driver.findElementByXPath("//a[@class='level0 ']").click();
		sa.assertEquals(driver.getTitle(),"Mobile");
		scc=scc+1;
		new Select(driver.findElementByXPath("//select[@title='Sort By']")).selectByVisibleText("Name");
	    File src=driver.getScreenshotAs(OutputType.FILE);
	    File target=new File("./screenshot/"+scc+".png");
	    FileUtils.copyFile(src, target);
			
	}
@AfterTest
public void tearDowm() 
{
	driver.close();
}

}
