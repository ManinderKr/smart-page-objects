package configurationPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigurationClass {

	private static WebDriver driver;

	protected static Properties prop=null;
	protected static InputStream input= ConfigurationClass.class.getClassLoader().getResourceAsStream("config.property");
	
	/**
	 * {@link ConfigurationClass}{@link openBrowser()}accepts a browser which is passed by the user and checks 
	 * which browser it is whether Firefox or chrome.
	 * 
	 * @return browser.
	 *        
	 */
	public static  WebDriver openBrowser() {
	
		try {
		prop=new Properties();
		prop.load(input);

		String browser=prop.getProperty("browser");

		Dimension d = new Dimension(900,900);
			
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"/home/administrator/Downloads/chromedriver");
				driver = new ChromeDriver();
			} /*else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"/home/administrator/Downloads/selenium-2.41.0/selenium-server-2.41.0");
				driver = new InternetExplorerDriver();
			}*/
			driver.manage().window().setSize(d);
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return driver;
	}
}
