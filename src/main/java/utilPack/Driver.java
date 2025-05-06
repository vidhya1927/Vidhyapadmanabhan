package utilPack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Driver {
	protected static ExtentTest test;
	static ExtentReports report;
	public WebDriver driver;

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will start the report generation. 
	***********************************************************************************/
	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("DemoBlaze Automation Suite");
	}


	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will initialize the browser. 
	***********************************************************************************/
	@BeforeMethod
	@Parameters("Browser")
	public void initializeDriver(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser type");
			return;
		}

		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='65%'");
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will close the driver. 
	***********************************************************************************/
	@AfterMethod
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will stop the report generation. 
	***********************************************************************************/
	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
}
