package rieit.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rieit.config.ConfigurationClass;

public class DriverFactory
{

	private DriverFactory(){
	   //Do-nothing..
	}
   
	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance()
	{
		return instance;
	}
	
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()   // thread local driver object for WebDriver.
	{
		
		protected WebDriver initialValue()
		{
			Dimension d = new Dimension(1000,1000);
			
			ConfigurationClass config= new ConfigurationClass();
			String browser = config.getBrowser();
			WebDriver webDriver=null;
			
			try{
				if (browser.equalsIgnoreCase("Firefox")) {
				webDriver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"/home/administrator/Downloads/chromedriver");
				webDriver = new ChromeDriver();
			} /*else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"/home/administrator/Downloads/selenium-2.41.0/selenium-server-2.41.0");
				driver = new InternetExplorerDriver();
			}*/
			webDriver.manage().window().setSize(d);
		
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
			return webDriver;
		}
	};
	
	public WebDriver getDriver()      // call this method to get the driver object and launch the browser
	{	
		return driver.get();
	}

	public void removeDriver()       // Quits the driver and closes the browser
	{
		driver.get().quit();
      	driver.remove();
	}
}
