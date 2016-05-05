package rieit.page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class LocatorAnnoationProcessor {

	
	public static void inject(Object instance) throws NoSuchMethodException, SecurityException, NoSuchFieldException {
	
		// get super class for current Page instance 
		
		// get collection which holds all PageComponents
				
		// instantiate a new ArrayList of PageComponent
		
		 @SuppressWarnings("rawtypes")
		Class basepage= instance.getClass().getSuperclass();
			
			protected List<PageComponent> googlePageComponents = new ArrayList<PageComponent>(); 
		 
			basepage.add(fields);

		Field[] fields = instance.getClass().getDeclaredFields();
	   
		for (Field field : fields) {
			if (field.isAnnotationPresent(WebPageComponent.class)) {
				WebPageComponent locator = field.getAnnotation(WebPageComponent.class);
				field.setAccessible(true); // should work on private fields
				try {
					if (isIdBasedLocator(locator)) {
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.id(locator.id()));
						field.set(instance, pageComponent);
						
						// add this field to ArrayList of Components
						
					} else if (isNameBasedLocator(locator)){
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.name(locator.name()));
						field.set(instance, pageComponent);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void list() {
		// TODO Auto-generated method stub
		
	}

	private static void basepage() {
		// TODO Auto-generated method stub
		
	}

	private static boolean isNameBasedLocator(WebPageComponent locator) {
		return locator.name() != null && !locator.name().isEmpty();
	}

	private static boolean isIdBasedLocator(WebPageComponent locator) {
		return locator.id() != null && !locator.id().isEmpty();
	}
}