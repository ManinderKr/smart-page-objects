package rieit.page;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.openqa.selenium.By;

public class LocatorAnnoationProcessor {

	public static void inject(Object instance) {
		Field[] fields = instance.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Locator.class)) {
				Locator locator = field.getAnnotation(Locator.class);
				field.setAccessible(true); // should work on private fields
				try {
					if (isIdBasedLocator(locator)) {
						Constructor<? extends Object> constructor = field.getType().getConstructor(By.class);
						Object pageComponent = constructor.newInstance(By.id(locator.id()));
						field.set(instance, pageComponent);
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

	private static boolean isNameBasedLocator(Locator locator) {
		return locator.name() != null && !locator.name().isEmpty();
	}

	private static boolean isIdBasedLocator(Locator locator) {
		return locator.id() != null && !locator.id().isEmpty();
	}
}