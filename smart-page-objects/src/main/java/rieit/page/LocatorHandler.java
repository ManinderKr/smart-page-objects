package rieit.page;

import java.lang.reflect.Field;

public class LocatorHandler {
	
	    public static void inject(Object instance) {
	        Field[] fields = instance.getClass().getDeclaredFields();
	        for (Field field : fields) {
	            if (field.isAnnotationPresent(Locator.class)) {
	                Locator set = field.getAnnotation(Locator.class);
	                field.setAccessible(true); // should work on private fields
	                try {
	                    field.set(instance, set.id());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}

	
	

