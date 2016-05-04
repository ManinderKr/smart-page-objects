package configurationPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyClass {
/*static{
	  final Properties prop=new Properties();
	 final InputStream input= ReadPropertyClass.class.getClassLoader().getResourceAsStream("config.property");
	//prop=new Properties();
	try {
		prop.load(input);
		
		System.out.println("input  "+input+ " "+prop.getProperty("url"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
	protected static Properties prop=null;
	protected InputStream input= ReadPropertyClass.class.getClassLoader().getResourceAsStream("config.property");
	
	
		public ReadPropertyClass() {
		
			prop=new Properties();
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public  String getBrowser(){
			return prop.getProperty("browser");
		}
		
		public String getUrl(){
			return prop.getProperty("url");
		}			
}
	


