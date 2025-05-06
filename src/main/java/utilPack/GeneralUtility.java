package utilPack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GeneralUtility extends Driver {

	protected static WebDriver driver;
	WebElement webElement;
	List<WebElement> webElements;
	Assert asrt;
	JavascriptExecutor js;
	Select select;
	String data;
	int exitVal;

	public GeneralUtility(WebDriver driver) {
		GeneralUtility.driver = driver;
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method is to perform button click. 
	***********************************************************************************/
	public void buttonClick(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement);
		webElement.click();
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method is to set data. 
	***********************************************************************************/
	public void setData(By locator, String text) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement);
		webElement.clear();
		webElement.sendKeys(text);

	}
	
	
	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method is to get the text. 
	***********************************************************************************/
	public String GetText(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		data = webElement.getText();
		return data;
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method is to validate the text using locator and expected text for assertEquals. 
	***********************************************************************************/
	public void validateText(By locator, String expectedText) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		String actualText = webElement.getText();
		asrt.assertEquals(actualText, expectedText);

	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method is to validate the text using locator for assertTrue. 
	***********************************************************************************/
	public boolean validateText(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		boolean status = webElement.isDisplayed();
		asrt.assertTrue(status);
		return status;
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method is for explicit wait. 
	***********************************************************************************/
	public WebDriverWait getWait() { 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class); 
		return wait;

	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will click an element. 
	***********************************************************************************/
	public void excuteJsClick(By locator) {

		js = (JavascriptExecutor) driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement);
		js.executeScript("arguments[0].click();", webElement);
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will highlight the background. 
	***********************************************************************************/
	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgColor = element.getCssValue("backgroundColor");
		js.executeScript("arguments[0].setAttribute('style', 'background: " + bgColor + "; border: 2px solid red;');",
				element);
	}

	
	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will create a random string without Numbers by passing number of characters. 
	***********************************************************************************/
	public static String CreateRandomWithoutNumbers(int n) {

		// choose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	
	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform Get Value. 
	***********************************************************************************/
	public String GetValue(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		data = webElement.getAttribute("value");
		return data;
	}

	
	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform isExists Validation. 
	***********************************************************************************/
	public boolean isExists(By locator) {
		boolean status = false;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		try {
			webElement = driver.findElement(locator);
			if (webElement.isDisplayed())
				status = true;
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}

	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform the screenshot capture. 
	***********************************************************************************/
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

}
