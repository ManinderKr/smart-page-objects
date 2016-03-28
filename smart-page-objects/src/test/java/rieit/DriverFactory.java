package rieit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
	{
		@Override
		protected WebDriver initialValue()
		{
			return new FirefoxDriver();
		}
	};

	public WebDriver getDriver()
	{
		return driver.get();
	}

	public void removeDriver()
	{
		driver.get().quit();
      	driver.remove();
	}
}
