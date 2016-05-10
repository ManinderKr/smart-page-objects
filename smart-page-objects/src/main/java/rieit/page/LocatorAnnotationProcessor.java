package rieit.page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.By;

public class LocatorAnnotationProcessor {
	
	
	/**
	 * {@link LocatorAnnotationProcessor} {@link #inject(Object)} inject the instance of a class and annotation values used in that class
	 *  and process them.
	 *  
	 * @return locator
	 * 
	 */
	
	public static void inject(final Object instance) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		
		final Field[] fields = instance.getClass().getDeclaredFields();
		
		PostPageComponentInjectionProcessor postPageComponent = new PostPageComponentInjectionProcessor(instance);
	
		for (Field field : fields) {
			if (field.isAnnotationPresent(WebPageComponent.class)) {
				WebPageComponent locator = field.getAnnotation(WebPageComponent.class);
				field.setAccessible(true); // should work on private fields
				try {
					if (isIdBasedLocator(locator)) {
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.id(locator.id()));
						field.set(instance, pageComponent);
						postPageComponent.getPageComponents().add((PageComponent) pageComponent);
					
					} else if (isNameBasedLocator(locator)){
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.name(locator.name()));
						field.set(instance, pageComponent);
						postPageComponent.getPageComponents().add((PageComponent) pageComponent);
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * {@link LocatorAnnotationProcessor} {@link #isNameBasedLocator(WebPageComponent)} checks the annotation passed to a 
	 * pageComponent having name as a locator is not null and not Empty.
	 *  
	 * @return locator
	 * 
	 */
	
	public static boolean isNameBasedLocator(WebPageComponent locator) {
		return locator.name() != null && !locator.name().isEmpty();
	}
	
	
	/**
	 * {@link LocatorAnnotationProcessor} {@link #isIdBasedLocator(WebPageComponent)} checks the annotation passed to a 
	 * pageComponent having id as a locator is not null and not Empty.
	 *  
	 * @return locator
	 * 
	 */
	
	public static boolean isIdBasedLocator(WebPageComponent locator) {
		return locator.id() != null && !locator.id().isEmpty();
	}
	
}











