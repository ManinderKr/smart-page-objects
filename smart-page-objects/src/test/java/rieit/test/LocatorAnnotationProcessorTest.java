package rieit.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.junit.After;
import org.junit.Test;
import rieit.app.Google1;
import rieit.config.ConfigurationClass;
import rieit.page.LocatorAnnotationProcessor;
import rieit.page.WebPageComponent;
import static org.junit.Assert.*;

public class LocatorAnnotationProcessorTest {

	ConfigurationClass config= new ConfigurationClass();
	String Url = config.getUrl();
	
	@SuppressWarnings({ "static-access" })
	@Test
	public void Should_Be_Able_To_Check_The_Annotation_Value_Is_Passed_From_One_Class_To_Another_Class_Or_Not() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException{
		
		LocatorAnnotationProcessor locatorAnnotationProcessor = new LocatorAnnotationProcessor();
		
		Google1 googlePage = new Google1( Url);
		
		Field[] fields= googlePage.getClass().getDeclaredFields();
		
			for(Field field: fields){
				if (field.isAnnotationPresent(WebPageComponent.class)) {
					WebPageComponent locator = field.getAnnotation(WebPageComponent.class);
					field.setAccessible(true);
					
					if (locatorAnnotationProcessor.isIdBasedLocator(locator)) {
						assertNotNull(locator.id());
					}
					else if(locatorAnnotationProcessor.isNameBasedLocator(locator)){
				
						assertNotNull(locator.name());
					}
				}
			}
	
	}
	
	@After
	public void afterTest() {
		
		DriverFactory.getInstance().removeDriver();
	}
	
}
