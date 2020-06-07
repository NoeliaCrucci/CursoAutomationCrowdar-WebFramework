package business;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import interfaces.BusinessInterface;
import pages.LoginPage;

public class NetflixLoginWithInvalidCredentialsBusiness implements BusinessInterface {
	private LoginPage loginPage;
	
	public NetflixLoginWithInvalidCredentialsBusiness(WebDriver driver) {
		super();
		this.loginPage = new LoginPage(driver);
	}
	
	public void perform (String user, String pass) {
		loginPage.insertUser(user);
		loginPage.insertPass(pass);
		loginPage.cickButtonIniciarSesion();
		
		Assert.assertEquals("Contraseña incorrecta.", loginPage.getValidationMessage1Text());
	}
	
	
	
}

	
