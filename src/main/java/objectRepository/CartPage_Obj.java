package objectRepository;

import org.openqa.selenium.By;
import java.util.*;


public class CartPage_Obj
{	
	public By CartMenut(){return By.xpath("//a[@id='cartur']");}
	public By CartText(){return By.xpath("//h2[contains(text(),'Products')]");}
	public By ProductSelected(){return By.xpath("//td[contains(text(),'Samsung galaxy s6')]");}		
	public By PlaceOrder() {return By.xpath("//button[contains(text(),'Place Order')]");}	
	public By NameField() {return By.xpath("//input[@id='name']");}	
	public By CountryField() {return By.xpath("//input[@id='country']");}
	public By CityField() {return By.xpath("//input[@id='city']");}	
	public By CardField() {return By.xpath("//input[@id='card']");}		
	public By MonthField() {return By.xpath("//input[@id='month']");}	
	public By YearField() {return By.xpath("//input[@id='year']");}	
	public By PurchaseBtn() {return By.xpath("//button[@onClick='purchaseOrder()']");}
	public By ThankMessage() {return By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");}
	public By OKBtn() {return By.xpath("//button[@tabindex='1']");}	 
}