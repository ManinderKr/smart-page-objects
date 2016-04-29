package rieit;

import org.openqa.selenium.WebDriver;
import configurationPackage.ConfigurationClass;

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
		

		@Override
		protected WebDriver initialValue()
		{
			return ConfigurationClass.openBrowser();
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
		//driver.quit();
	}
}

