package objectRepository;

import org.openqa.selenium.By;
import java.util.*;


public class HomePage_Obj
{
	public By SignIn(){return By.xpath("//a[@id='signin2']");}
	public By SignInPopup(){return By.xpath("//h5[@id='signInModalLabel']");}	 
	public By UserName(){return By.xpath("//input[@id='sign-username']");}
	public By password(){return By.xpath("//input[@id='sign-password']");}
	public By SignUp(){return By.xpath("//button[text()='Sign up']");}	
	public By UserLogin(){return By.xpath("//a[@id='login2']");}
	public By LoginUsername(){return By.xpath("//input[@id='loginusername']");}
	public By LoginPassword(){return By.xpath("//input[@id='loginpassword']");}
	public By BtnLogin(){return By.xpath("//button[text()='Log in']");}
	public By SuccessMessage() {return By.xpath("//a[starts-with(text(),'Welcome')]");} 
	public By Success(String username) {return By.xpath("//a[contains(text(),'"+username+"')]");}		
}
