package rieit.app;

import rieit.page.BasePage;
import rieit.page.WebPageComponent;
import rieit.page.LocatorAnnoationProcessor;
import rieit.page.PageComponent;

public class GoogleResult1 extends BasePage{

	@WebPageComponent(id = "rcnt")
	private ResultComponent ResultComponent ;
	
	public void call(){
		
	   	LocatorAnnoationProcessor.inject(this);
  	}

    public GoogleResult1(String url) {
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
