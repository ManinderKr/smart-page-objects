package rieit.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;

public class ChromeOpt {

	protected static Properties prop=null;
	protected InputStream input= ConfigurationClass.class.getClassLoader().getResourceAsStream("chromePrp");
	
	private int width;
	
	private int height;
	
	public Dimension dimension; 
	
	public ChromeOpt() {
		
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
		 * {@link ChromeOpt}{@link getCount()} gives the number of times to run this set of capabilities/tests.
		 *         
		 */
		
		public  String getCount(){
			return (prop.getProperty("count"));
		}
		
		
		/**
		 * {@link ChromeOpt}{@link getShardTestFiles()} tells wheather the tests are shared by the no. of browsers or not.
		 *  
		 * @param <code>true</code> if the tests are shared by no. of browsers.
		 * 			<code>false</code> if the tests are not shared.									       
		 */
		
		public  String getShardTestFiles(){
			return (prop.getProperty("sharedTestFiles"));
		}
		
		/**
		 * {@link ChromeOpt}{@link getMaxInstances()} gives the maximum number of browser instances that can run in parallel for this
     	 *											set of capabilities. This is only needed if shardTestFiles is true.
		 *         
		 */
		
		public  String getMaxInstances(){
			return (prop.getProperty("maxInstances"));
		}
}
