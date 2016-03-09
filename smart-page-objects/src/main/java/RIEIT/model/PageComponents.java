package RIEIT.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageComponents {

	WebDriver driver;
	By username = By.name("user");
	By password = By.name("pass");
	By loginButton = By.name("btn login");

	public PageComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUserName(String strusername) {
		driver.findElement(username).setKeys("admin");
	}

	public void typePassword(String strpass) {
		driver.findElement(password).setKeys("1234");
	}

	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
}
