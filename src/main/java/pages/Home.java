package pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import objectRepository.HomePage_Obj;
import objectRepository.HomePage_Obj;
import utilPack.GeneralUtility;

public class Home extends GeneralUtility {

	GeneralUtility generalutility;
	Assert asrt;
	String username;
	String password;
	
	HomePage_Obj homePageObj = new HomePage_Obj();
	GeneralUtility generalutil = new GeneralUtility(driver);	
	
	public Home(WebDriver driver) {
		super(driver);
		generalutility = new GeneralUtility(driver);
	}

	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform new Sign Up. 
	***********************************************************************************/
	
	public void Demoblaze_SignUp() throws InterruptedException, IOException {
		try {
		// Sign Up with user credentials
			generalutil.buttonClick(homePageObj.SignIn());
		asrt.assertTrue(generalutil.isExists(homePageObj.SignInPopup()),
				"User is not able to view  sign up popup on clicking sign up button");

		generalutil.setData(homePageObj.UserName(), "Vidhya" + generalutil.CreateRandomWithoutNumbers(4));
		username = generalutil.GetValue(homePageObj.UserName());
		test.log(LogStatus.INFO, "Signup: Username entered successfully - "+ username);
		generalutil.setData(homePageObj.password(), "P" + generalutil.CreateRandomWithoutNumbers(4));
		password = generalutil.GetValue(homePageObj.password());
		test.log(LogStatus.INFO, "Sign Up: Password entered successfully - "+ password);
		generalutil.buttonClick(homePageObj.SignUp());
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String AlertText = alert.getText();
		Assert.assertEquals("Sign up successful.", AlertText);
		alert.accept();
		test.log(LogStatus.PASS, "Sign up successful");
		}
		catch(Exception e)
		{
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Sign Up Failed");	
		test.log(LogStatus.FAIL, "Sign up failed");
		}
		}
	
	/**********************************************************************************
	Date:
	Author: Vidhya P
	Description: This method will perform Login. 
	***********************************************************************************/
	public void Demoblaze_Login() throws InterruptedException, IOException {
		try {
			generalutil.buttonClick(homePageObj.UserLogin());
		asrt.assertTrue(generalutil.isExists(homePageObj.UserLogin()),
				"User is not able to view the Login up popup on clicking login button");
		generalutil.setData(homePageObj.LoginUsername(), username);
		test.log(LogStatus.INFO, "Login: Username entered successfully - "+ username);
		generalutil.setData(homePageObj.LoginPassword(), password);
		test.log(LogStatus.INFO, "Login: Password entered successfully - "+ password);
		generalutil.buttonClick(homePageObj.BtnLogin());
		asrt.assertTrue(generalutil.isExists(homePageObj.Success(username)),
				"User is not able to login to the application");
		test.log(LogStatus.PASS, "Login successful");
		}
		catch(Exception e)
		{
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Login Failed");	
		test.log(LogStatus.FAIL, "Login failed");
		}
	}
	
	
	}


