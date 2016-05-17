package rieit.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationClass {
 
	protected static Properties prop=null;
	protected InputStream input= ConfigurationClass.class.getClassLoader().getResourceAsStream("config.property");
	
		public ConfigurationClass() {
		
			prop=new Properties();
			try {
				prop.load(input);
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		/**
		 * {@link ConfigurationClass}{@link getBrowser()}accepts a browser which is provided by the user in property file. 
		 * 
		 * @return browser.
		 *        
		 */
		
		public  String getBrowser(){
			return (prop.getProperty("browser"));
		}
		
		/**
		 * {@link ConfigurationClass}{@link getUrl()}accepts a url which is provided by the user in property file. 
		 * 
		 * @return url.
		 *        
		 */
		
		public String getUrl(){
			return prop.getProperty("url");
		}			
}
	


