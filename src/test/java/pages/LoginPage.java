package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	
	private WebDriver driver;
	private static final String ButtonLogInCss = ".btn.login-button.btn-submit.btn-small";
	private static final String ValidationMessage1CSS = "#appMountPoint > div > div.login-body > div > div > div.hybrid-login-form-main > div > div.ui-message-contents > b";
	private static final String ValidationMessage2CSS = "#appMountPoint > div > div.login-body > div > div > div.hybrid-login-form-main > form > div.nfInput.nfEmailPhoneInput.nfEmailPhoneInError.login-input.login-input-email > div.inputError";
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public  void insertUser (String user) {
		WebElement userName = driver.findElement(By.id("id_userLoginId"));
		userName.clear();
		userName.sendKeys("mail@mail.com");
		//userName.sendKeys(Keys.TAB);
		
	
	}
	
	public  void insertEmptyUser () {
		WebElement userName = driver.findElement(By.id("id_userLoginId"));
		userName.clear();
		userName.sendKeys(Keys.TAB);
		implicitlyWait();
		cickButtonIniciarSesion();
	}

	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void insertPass (String pass) {
		WebElement userPass = driver.findElement(By.id("id_password"));
		userPass.clear();
		userPass.sendKeys(pass);
		
	}
	
	public void cickButtonIniciarSesion () {
		WebElement buttonIniciarSesion = driver.findElement(By.cssSelector(ButtonLogInCss));
		buttonIniciarSesion.click();
		implicitlyWait();
		
	}
	

	public String getValidationMessage1Text() {
		return  driver.findElement(By.cssSelector(ValidationMessage1CSS)).getText();
	}
	
	public String getValidationMessage2Text() {
		return  driver.findElement(By.cssSelector(ValidationMessage2CSS)).getText();
	}
	
	
}
