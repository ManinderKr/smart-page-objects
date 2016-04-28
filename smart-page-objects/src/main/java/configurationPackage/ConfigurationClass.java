package configurationPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ConfigurationClass {

	private static WebDriver driver;

	protected static Properties prop=null;
	protected static InputStream input= ConfigurationClass.class.getClassLoader().getResourceAsStream("configurationPackage/config.properties");
	
	public static WebDriver openBrowser(String browser) throws IOException {
		
		prop=new Properties();
		prop.load(input);

		Dimension d = new Dimension(420,600);
		driver.manage().window().setSize(d);
		prop.getProperty("browser");
		
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"D:/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
}
