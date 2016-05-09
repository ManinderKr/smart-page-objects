package rieit.page;

import java.util.List;

@SuppressWarnings("unchecked")
public class PostPageComponentInjectionProcessor {

	List<PageComponent>  pageComponents = null;
	
	public PostPageComponentInjectionProcessor(final Object instance) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		Object basepage=  instance.getClass().getSuperclass();
		Object listfield= ((Class<? extends Object>) basepage).getDeclaredField("pageComponents").get(basepage);
		if (listfield instanceof List){
			pageComponents= (List<PageComponent>) listfield;
			
			System.out.println("pageComponents*: " +pageComponents);
		}
	}
}
