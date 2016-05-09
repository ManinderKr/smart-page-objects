package rieit.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import rieit.test.DriverFactory;

public abstract class BasePage {
	
	private WebDriver driver = DriverFactory.getInstance().getDriver();      // This will invoke your WebDriver and launches the browser
	
	private String url = "";

	protected static List<PageComponent> pageComponents = new ArrayList<PageComponent>(); 
	
	
	/**
	 * {@link BasePage} {@link #isReady()} returns True only when the page is ready (i.e. components or  
	 * locators on the page is enabled and visible) for access.
	 */
	
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
	
	/**
	 * {@link BasePage} {@link #getUrl()} accepts the Url provided by user.
	 * 
	 */
	public String getUrl( ) {		
		return driver.getCurrentUrl();
	}

	/**
	 * {@link BasePage} {@link #open()} accepts the Url provided by user and open it.
	 * 
	 */
	public void open() {
	
		driver.get(url);
	}

	/**
	 * {@link BasePage} {@link #reload()} refresh the WebPage using the same Url provided by user.
	 * 
	 */	
	public void reload() {
		driver.navigate().refresh();
		
	}
	
}
