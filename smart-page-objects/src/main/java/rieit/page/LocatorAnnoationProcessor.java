package rieit.page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.By;

public class LocatorAnnoationProcessor {

	public static void inject(final Object instance) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException {
		
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
						postPageComponent.pageComponents.add((PageComponent) pageComponent);
					
						System.out.println("pageComponents1 : " +((PageComponent)pageComponent));
						
					} else if (isNameBasedLocator(locator)){
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.name(locator.name()));
						field.set(instance, pageComponent);
						postPageComponent.pageComponents.add((PageComponent) pageComponent);
						
						System.out.println("pageComponents2: " +((PageComponent)pageComponent));
						
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











