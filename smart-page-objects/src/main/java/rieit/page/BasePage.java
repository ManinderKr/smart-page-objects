package rieit.page;
import org.openqa.selenium.WebDriver;

import rieit.DriverFactory;


public abstract class BasePage {
	
	private WebDriver driver = DriverFactory.getInstance().getDriver();
	
	private String url = "";  

	public abstract boolean isReady();
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public BasePage(String url){
	this.url = url;	
	}
	
	public String getUrl( ) {		
		return driver.getCurrentUrl();
	}


	
	public void open() {
		
		driver.get(url);
	}

	public void reload() {
		driver.navigate().refresh();
		
	}
	
}
