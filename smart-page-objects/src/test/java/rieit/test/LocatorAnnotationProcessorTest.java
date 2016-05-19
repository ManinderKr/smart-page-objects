package rieit.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.junit.After;
import org.junit.Test;
import rieit.app.Google;
import rieit.config.ConfigurationClass;
import rieit.page.PageComponent;
import rieit.page.PostPageComponentInjectionProcessor;
import static org.junit.Assert.*;

public class LocatorAnnotationProcessorTest {

	ConfigurationClass config= new ConfigurationClass();
	String Url = config.getUrl();
	
	@Test
	public void Should_Be_Able_To_Check_The_Output_List_Of_Components_Contained_Same_Components_Which_Are_Passed_As_Annotations_To_This_Class() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException{
	
		Google googlePage = new Google(Url);
		
		PostPageComponentInjectionProcessor postPageComponentInjectionProcessor= new PostPageComponentInjectionProcessor(googlePage);
		
		Field[] fields= googlePage.getClass().getDeclaredFields();
		
		java.util.List<PageComponent> listelements= postPageComponentInjectionProcessor.getPageComponents();
		 
		int flag=0;
		
			for(PageComponent list: listelements){
			
				for(Field field: fields){

					if(field.getType().equals(list.getClass())){
			
						flag++;
			
					}
				}
			}
		
		assertEquals(flag,listelements.size());	
	}
	
	@After
	public void afterTest() {
		
		DriverFactory.getInstance().removeDriver();
	}

}
