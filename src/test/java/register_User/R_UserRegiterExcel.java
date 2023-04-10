package register_User;

import regiter_Utile.R_ExcelReader;
import regiter_Utile.R_HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import regiter_Utile.R_LoginPage;
import register_User.R_UserRegisterPgae;

public class R_UserRegiterExcel extends R_TestBase {

	R_ExcelReader readExcel;
	R_HomePage homepage;
	R_UserRegisterPgae registerByexcel;
	R_LoginPage userlogin;

	@DataProvider(name = "UserData")
	public String[][] userregisterData() throws IOException {
		R_ExcelReader readdata= new R_ExcelReader();
		return  readdata.getdataexcel();
 
	}

	@Test(priority = 1, dataProvider = "UserData")
	public void UserRegisterOK(String fname, String lname, String emailbox, String companybox, String passw,
			String confpassw, String day, String mois, String year) {

		homepage = new R_HomePage(driver);
		homepage.openRegsiterpage();
		registerByexcel = new R_UserRegisterPgae(driver);
		registerByexcel.userRegister(fname, lname, emailbox, companybox, passw, confpassw, day, mois, year);
		 
        Assert.assertTrue(registerByexcel.successMessage.getText().contains("Your registration completed"));
        
        
        homepage.loginPage();
        userlogin= new R_LoginPage(driver);
        userlogin.authentification(emailbox, passw);
       String actualreslt=registerByexcel.logoutlink.getText();
		Assert.assertTrue(actualreslt.contains("Log out"));
		registerByexcel.userlogout();

 	}

}
