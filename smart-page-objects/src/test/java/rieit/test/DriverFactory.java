package rieit.test;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import rieit.config.ChromeOpt;
import rieit.config.ConfigurationClass;
import rieit.config.FirefoxOpt;

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
			Dimension d = null ;
			
			ConfigurationClass config= new ConfigurationClass();
			String browser = config.getBrowser();
			WebDriver webDriver=null;
			
			try{
				if (browser.equalsIgnoreCase("Firefox")) {
					
					FirefoxOpt firefoxopt = new FirefoxOpt();
					 
					FirefoxBinary binary= new FirefoxBinary();
						binary.addCommandLineOptions("/usr/bin/firefox");
			
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
						capabilities.setCapability(BROWSER_NAME, browser);
						capabilities.setCapability(PLATFORM, firefoxopt.getPlatform());
						
						d=firefoxopt.getDimension();
					
					webDriver = new FirefoxDriver(binary, new FirefoxProfile() , capabilities);
				
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"/home/administrator/Downloads/chromedriver");
				
					ChromeOpt chromeOpt = new ChromeOpt();
					
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
						capabilities.setCapability(BROWSER_NAME, browser);
						capabilities.setCapability(PLATFORM, Platform.fromString(chromeOpt.getPlatform()));
						
						d=chromeOpt.getDimension();
				
					webDriver = new ChromeDriver(capabilities);
				
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

