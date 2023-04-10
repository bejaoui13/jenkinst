package regiter_Utile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class R_LoginPage extends R_BasePage{
	
	public R_LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="Email") WebElement emaillog;
	@FindBy(name="Password") WebElement passwordlog;
	@FindBy(xpath ="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button") WebElement loginbouton;


	public void authentification(String email, String password)
	{
		emaillog.sendKeys(email);
		passwordlog.sendKeys(password);
		loginbouton.click();
	}
	
}
