package rieit.app;

import java.lang.reflect.InvocationTargetException;

import rieit.page.BasePage;
import rieit.page.WebPageComponent;
import rieit.page.LocatorAnnoationProcessor;
import rieit.page.PageComponent;

public class GoogleResult1 extends BasePage{

	@WebPageComponent(id = "rcnt")
	private ResultComponent ResultComponent ;
	
	public void call() throws NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
	   	LocatorAnnoationProcessor.inject(this);
  	}

    public GoogleResult1(String url) throws NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	super(url);
    	call();
	}

	@Override
	public boolean isReady() {
	
		boolean isComponentReady= true;
	
			PageComponent rs = ResultComponent;
			
			if(rs != null)
				{
					isComponentReady = rs.isEnabled() && rs.isVisible();
				}
			
			if (!isComponentReady) {
					return isComponentReady;
				}

		return isComponentReady;
	}	
	
}
