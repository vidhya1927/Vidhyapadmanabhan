package testExecution.Demoblaze;

import java.io.IOException;
import org.testng.annotations.Test;

import pages.AddToCart;
import pages.Cart;
import pages.Home;
import utilPack.Driver;


public class TestPage extends Driver
{
    @Test()
    public void TC_EndToEndTest() throws InterruptedException, IOException
    {
    	Home homepage=new Home(driver);
    	AddToCart addtocartpage=new AddToCart(driver);
    	Cart cartpage=new Cart(driver);
    	homepage.Demoblaze_SignUp();
    	homepage.Demoblaze_Login();
    	addtocartpage.Demoblaze_AddtoCart();
    	cartpage.Demoblaze_OrderPlace();
    }
}
