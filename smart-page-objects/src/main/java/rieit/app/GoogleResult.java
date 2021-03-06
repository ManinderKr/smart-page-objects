package rieit.app;

import java.lang.reflect.InvocationTargetException;
import rieit.page.BasePage;
import rieit.page.WebPageComponent;
import rieit.page.LocatorAnnotationProcessor;
import rieit.page.PageComponent;

public class GoogleResult extends BasePage{

	@WebPageComponent(id = "rcnt")
	private ResultComponent ResultComponent ;
	
	public void call() throws NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
	   	LocatorAnnotationProcessor.inject(this);
  	}

    public GoogleResult(String url) throws NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	super(url);
    	call();
	}

	@Override
	public boolean isReady() {
	
		boolean isComponentReady= true;
		
		  for(PageComponent pageComponent : pageComponents){
				if(pageComponent != null)
					{
						isComponentReady = pageComponent.isEnabled() && pageComponent.isVisible();
					}
			
				if (!isComponentReady) {
						return isComponentReady;
					}
		  }
		return isComponentReady;
	}	
	
}
