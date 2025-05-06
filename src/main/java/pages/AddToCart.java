package pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import objectRepository.AddtoCartPage_Obj;
import utilPack.GeneralUtility;

public class AddToCart extends GeneralUtility {

	GeneralUtility generalutility;
	Assert asrt;
	String username;
	String password;
	
	AddtoCartPage_Obj addtocartPageObj = new AddtoCartPage_Obj();
	GeneralUtility generalutil = new GeneralUtility(driver);
	public AddToCart(WebDriver driver) {
		super(driver);
		generalutility = new GeneralUtility(driver);
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform add the product to Cart. 
	***********************************************************************************/
	public void Demoblaze_AddtoCart() throws InterruptedException, IOException {
		// product selection
		try {
			generalutil.buttonClick(addtocartPageObj.TxtProduct());
		test.log(LogStatus.INFO, "Add to Cart: Clicked on Product Successfully");
		asrt.assertTrue(generalutil.isExists(addtocartPageObj.CartPage()),
				"User is not able to navigate to cart page after clicking add to cart.");
		generalutil.buttonClick(addtocartPageObj.BtnaddToCart());
		Thread.sleep(5000);
		Alert alert2 = driver.switchTo().alert();
		String AlertText2 = alert2.getText();
		Assert.assertEquals("Product added.", AlertText2);
		alert2.accept();
		test.log(LogStatus.PASS, "Add to Cart Successful");
		}
		catch(Exception e)
		{
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Add to Cart Failed");
		test.log(LogStatus.FAIL, "Add to Cart failed");
		}
	}
	}
