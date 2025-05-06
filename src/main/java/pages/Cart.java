package pages;

import java.io.IOException;
import java.io.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import objectRepository.CartPage_Obj;
import utilPack.GeneralUtility;

public class Cart extends GeneralUtility {

	GeneralUtility generalutility;
	Assert asrt;
	String username;
	String password;
	
	CartPage_Obj cartPageObj = new CartPage_Obj();
	GeneralUtility generalutil = new GeneralUtility(driver);
	
	public Cart(WebDriver driver) {
		super(driver);
		generalutility = new GeneralUtility(driver);
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform the order placing of the selected product. 
	***********************************************************************************/
	public void Demoblaze_OrderPlace() throws InterruptedException, IOException {
		// product order
		try {
			
			
			generalutil.buttonClick(cartPageObj.CartMenut());		
			asrt.assertTrue(generalutil.isExists(cartPageObj.CartText()),
			"User is not able to navigate to cart page after clicking cart menu.");
			asrt.assertTrue(generalutil.isExists(cartPageObj.ProductSelected()),
					"User is not able to navigate to cart page after clicking cart menu.");
			generalutil.buttonClick(cartPageObj.PlaceOrder());
			Thread.sleep(5000);			
		test.log(LogStatus.INFO, "Add to Cart: Clicked on Place Order Successfully");
		generalutil.setData(cartPageObj.NameField(), "Vidhya");
		Thread.sleep(500);	
		generalutil.setData(cartPageObj.CountryField(), "India");
		Thread.sleep(500);
		generalutil.setData(cartPageObj.CityField(), "TVM");
		Thread.sleep(500);
		generalutil.setData(cartPageObj.CardField(), "4242");
		Thread.sleep(500);
		generalutil.setData(cartPageObj.MonthField(), "11");
		Thread.sleep(500);
		generalutil.setData(cartPageObj.YearField(), "2030");
		Thread.sleep(500);
		generalutil.buttonClick(cartPageObj.PurchaseBtn());
		
		//Thread.sleep(500);		
		asrt.assertTrue(generalutil.isExists(cartPageObj.ThankMessage()),
				"User is not able to view Thank you for your purchase!");		
		generalutil.buttonClick(cartPageObj.OKBtn());			
		test.log(LogStatus.PASS, "Thank Message Successful");

		}
		catch(Exception e)
		{
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Order Place Failed");
		test.log(LogStatus.FAIL, "Order Place failed");
		}
	}
	}
