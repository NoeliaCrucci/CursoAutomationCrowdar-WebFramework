//Refactor1 Clase 4
package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import business.NetflixLoginWithInvalidCredentialsBusiness;
import business.NetflixLoginWithoutCredentialsBusiness;
import interfaces.BusinessInterface;
import interfaces.BusinessInterface2;



public class NetflixTests {

	private ChromeDriver driver;
	private BusinessInterface netflixLoginWithInvalidCredentialsBusiness;
	private BusinessInterface2 netflixLoginWithoutCredentialsBusiness;
	
	
	@Before
	public void setUpTests() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.netflix.com/ar/Login");
		netflixLoginWithInvalidCredentialsBusiness = new NetflixLoginWithInvalidCredentialsBusiness (driver);
		netflixLoginWithoutCredentialsBusiness = new NetflixLoginWithoutCredentialsBusiness (driver);
			
	}

	@Test
	public void whenAUserLoginWithInvalidCredentials() {
		String user = "mail@mail.com";
		String pass = "A123";
		netflixLoginWithInvalidCredentialsBusiness.perform(user, pass);
		
	}

	@Test
	public void whenAUserLoginWithoutCredentials() {
		netflixLoginWithoutCredentialsBusiness.perform();
	}
	
	@After
	public void finishTest() {
		driver.quit();	
	}
	
	
}
