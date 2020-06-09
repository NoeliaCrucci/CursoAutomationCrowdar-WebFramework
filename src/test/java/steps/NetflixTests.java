//Refactor2 Clase 4
package steps;

import org.junit.Ignore;
import org.openqa.selenium.chrome.ChromeDriver;
import business.NetflixLoginWithInvalidCredentialsBusiness;
import business.NetflixLoginWithoutCredentialsBusiness;
import interfaces.BusinessInterface;
import interfaces.BusinessInterface2;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class NetflixTests {
	
	private ChromeDriver driver;
	private BusinessInterface netflixLoginWithInvalidCredentialsBusiness;
	private BusinessInterface2 netflixLoginWithoutCredentialsBusiness;
	private LoginPage loginPage;
	
	
	@Given("^I am in the LoginPage$")
	public void i_am_in_the_loginpage(){
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.netflix.com/ar/Login");
		netflixLoginWithInvalidCredentialsBusiness = new NetflixLoginWithInvalidCredentialsBusiness (driver);
		netflixLoginWithoutCredentialsBusiness = new NetflixLoginWithoutCredentialsBusiness (driver);
		loginPage = new LoginPage (driver);
	}
	
	@When ("^I enter invalid credentials$")
	public void i_enter_invalid_credentials() {
		String user = "mail@mail.com";
		String pass = "A123";
		netflixLoginWithInvalidCredentialsBusiness.perform(user, pass);
	}
	
	@Then ("^I get the massage: Contraseña incorrecta$")
	public void verify_Validation_Message1 () {
		loginPage.getValidationMessage1Text();
		this.finishTest();
	}
	
	@When ("^I dont enter credentials$")
	public void whenAUserLoginWithoutCredentials() {
		netflixLoginWithoutCredentialsBusiness.perform();
	}
	
	@Then ("^I get the massage: Ingresa un email o un número de teléfono válido$")
	public void verify_Validation_Message2 () {
	this.finishTest();	
	}
	

	
	@After
	public void finishTest() {
		driver.quit();	
	}
	
	
}
