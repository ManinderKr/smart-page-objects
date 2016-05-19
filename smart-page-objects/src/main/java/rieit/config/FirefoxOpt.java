package rieit.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.Dimension;

public class FirefoxOpt {
	
	protected static Properties prop=null;
	protected InputStream input= ConfigurationClass.class.getClassLoader().getResourceAsStream("firefoxPrp");
	
	private int width;
	
	private int height;
	
	public Dimension dimension; 
	
	public FirefoxOpt() {
		
			prop=new Properties();
			try {
				prop.load(input);
				width = Integer.parseInt(prop.getProperty("width"));
				height = Integer.parseInt(prop.getProperty("height"));
				dimension = new Dimension(width,height);
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		public Dimension getDimension() {
			return dimension;
		}
	
		/**
		 * {@link ChromeOpt}{@link getPlatform()} specify the platform on which the browser should be run.
		 * 											
		 *  @return   A platform wheather {WINDOWS|XP|VISTA|MAC|LINUX|UNIX|ANDROID}.      
		 */
		
		public  String getPlatform(){
			return (prop.getProperty("platform"));
		}
		
}
