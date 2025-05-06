package objectRepository;

import org.openqa.selenium.By;
import java.util.*;


public class AddtoCartPage_Obj
{
	public By BtnaddToCart(){return By.xpath("//a[text()='Add to cart']");}
	public By Btn_CartLogin(){return By.xpath("//button[text()='Log in']");}	
	public By TxtProduct() {return By.xpath("//a[text()='Samsung galaxy s6']");}
	public By Btn_PlaceOrder() {return By.xpath("//button[text()='Place Order']");}	
	public By TxtOrderField(String idName) {return By.xpath("//input[@id='"+idName+"']");}
    public By BtnPurchase() {return By.xpath("//button[text()='Purchase']");}    
	public By CartPage(){return By.xpath("//h2[text()='Samsung galaxy s6']");}
 
}
