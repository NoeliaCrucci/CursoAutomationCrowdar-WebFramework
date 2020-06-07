package business;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import interfaces.BusinessInterface2;
import pages.LoginPage;

public class NetflixLoginWithoutCredentialsBusiness implements BusinessInterface2 {
	private LoginPage loginPage;
	

	public NetflixLoginWithoutCredentialsBusiness(WebDriver driver) {
		super();
		this.loginPage = new LoginPage (driver);
	}
	
	public void perform () {
	
		loginPage.insertEmptyUser();
		
				
		Assert.assertEquals("Ingresa un email o un número de teléfono válido.", loginPage.getValidationMessage2Text());
		}
}
