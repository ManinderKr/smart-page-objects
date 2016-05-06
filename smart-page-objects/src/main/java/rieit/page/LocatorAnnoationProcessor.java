package rieit.page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openqa.selenium.By;

public class LocatorAnnoationProcessor {

	@SuppressWarnings("unchecked")
	public static void inject(final Object instance) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException {
	
		// get super class for current Page instance 
		
		// get collection which holds all PageComponents
				
		// instantiate a new ArrayList of PageComponent

		
		List<PageComponent>  pageComponents = null; 

		final Field[] fields = instance.getClass().getDeclaredFields();
	
		Object basepage=  instance.getClass().getSuperclass();
			Object listfield= ((Class<? extends Object>) basepage).getDeclaredField("pageComponents").get(basepage);
			if (listfield instanceof List){
				pageComponents= (List<PageComponent>) listfield;
			}
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(WebPageComponent.class)) {
				WebPageComponent locator = field.getAnnotation(WebPageComponent.class);
				field.setAccessible(true); // should work on private fields
				try {
					if (isIdBasedLocator(locator)) {
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.id(locator.id()));
						field.set(instance, pageComponent);
						pageComponents.add((PageComponent) pageComponent);
						
					} else if (isNameBasedLocator(locator)){
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.name(locator.name()));
						field.set(instance, pageComponent);
						pageComponents.add((PageComponent) pageComponent);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static boolean isNameBasedLocator(WebPageComponent locator) {
		return locator.name() != null && !locator.name().isEmpty();
	}

	private static boolean isIdBasedLocator(WebPageComponent locator) {
		return locator.id() != null && !locator.id().isEmpty();
	}
}