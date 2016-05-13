package rieit.test;

import java.lang.reflect.InvocationTargetException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import rieit.app.Google1;
import rieit.config.ConfigurationClass;
import rieit.page.LocatorAnnotationProcessor;
import rieit.page.PageComponent;
import rieit.page.PostPageComponentInjectionProcessor;
import java.lang.reflect.Field;

public class LocatorAnnotationProcessorTest {

	ConfigurationClass config= new ConfigurationClass();
	String Url = config.getUrl();
	
	@SuppressWarnings({ "static-access" })
	@Test
	public void Should_Be_Able_To_Check_The_Annotation_Value_Is_Passed_From_One_Class_To_Another_Class_Or_Not() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException{
		
		Google1 googlePage = new Google1(Url);
		
		LocatorAnnotationProcessor locatorAnnotationProcessor = new LocatorAnnotationProcessor();
		
		PostPageComponentInjectionProcessor postPageComponentInjectionProcessor= new PostPageComponentInjectionProcessor(googlePage);
		
		Field[] fields= googlePage.getClass().getDeclaredFields();
	
		locatorAnnotationProcessor.inject(googlePage);
		
		postPageComponentInjectionProcessor.getPageComponents();
		
		Assert.assertNotNull(postPageComponentInjectionProcessor.getPageComponents());
		Assert.assertFalse(postPageComponentInjectionProcessor.getPageComponents().isEmpty());
		Assert.assertNotEquals(postPageComponentInjectionProcessor.getPageComponents().size(),2);
		Assert.assertNotNull(postPageComponentInjectionProcessor.getPageComponents().get(0));
		Assert.assertNotNull(postPageComponentInjectionProcessor.getPageComponents().get(1));
		
		PageComponent boxComponent = postPageComponentInjectionProcessor.getPageComponents().get(0);
	
		PageComponent buttonComponent = postPageComponentInjectionProcessor.getPageComponents().get(1);
		
		for (Field field : fields) {
			if(field.getType().getName().equals("rieit.app.ButtonComponent") ){
				field.setAccessible(true);
				rieit.app.ButtonComponent btncmp = (rieit.app.ButtonComponent) field.get(googlePage);
				Assert.assertEquals(btncmp.getLocator(), buttonComponent.getLocator());
			}else if (field.getType().getName().equals("rieit.app.BoxComponent")){
				field.setAccessible(true);
				rieit.app.BoxComponent bxcmp = (rieit.app.BoxComponent) field.get(googlePage);
				Assert.assertEquals(bxcmp.getLocator(), boxComponent.getLocator());
			}
		}
	
	}
	
	@After
	public void afterTest() {
		
		DriverFactory.getInstance().removeDriver();
	}

}
