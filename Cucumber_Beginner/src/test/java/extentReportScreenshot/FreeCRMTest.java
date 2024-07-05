package extentReportScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FreeCRMTest {
	WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host Name","Suriya Windows");
		extent.addSystemInfo("User Name", "Suriya Devi");
		extent.addSystemInfo("Environment","QA");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver,String ScreenshotName) throws IOException {
		String dateName =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
				// under src folder
		String destination = System.getProperty("user.dir") +  "/FailedTestsScreenshots/" +ScreenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
		
	}
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://freecrm.com/");
		
	}
	
	@Test
	public void freeCRMTitleTest() {
		extentTest = extent.startTest("freeCRMTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");
	}
	
	@Test
	public void freemCRMLogoTest(){
		extentTest = extent.startTest("freemCRMLogoTest");
		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive111']")).isDisplayed();
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			//to add name in extent report
			extentTest.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getName());
			//to add error/exception in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable());
			
			String screenshotPath= FreeCRMTest.getScreenshot(driver, result.getName());
			 //to add screenshot in extent report
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenshotPath));
			//to add screencast/video in extent report
			extentTest.log(LogStatus.FAIL,extentTest.addScreencast(screenshotPath));
			
				}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP,"TEST CASE SKIPPED IS "+result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS,"TEST CASE PASSED IS "+result.getName());
		}
		//ending test and ends the current test and prepare to create html report
		extent.endTest(extentTest);
		driver.quit();
	}
}
