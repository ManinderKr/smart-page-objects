package rieit.page;

import java.util.List;

@SuppressWarnings("unchecked")
public class PostPageComponentInjectionProcessor {

	protected List<PageComponent>  pageComponents = null;

	
	/**
	 * {@link PostPageComponentInjectionProcessor} {@link #PostPageComponentInjectionProcessor(Object)} inject the pageComponents 
	 * declared by the user into a list.
	 * 
	 * @return List of PageCOmponents.
	 */
	
	public PostPageComponentInjectionProcessor (Object instance) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		Object basepage=  instance.getClass().getSuperclass();
		Object listfield= ((Class<? extends Object>) basepage).getDeclaredField("pageComponents").get(basepage);
		if (listfield instanceof List){
			setPageComponents((List<PageComponent>) listfield);
		
		}
	}

	public List<PageComponent> getPageComponents() {
		return pageComponents;
	}

	public void setPageComponents(List<PageComponent> pageComponents) {
		this.pageComponents = pageComponents;
	}

}
