package rieit.page;

public class GoogleResult1 extends BasePage{

	@Locator(id = "rso")
	private PageComponent ResultComponent ;
	
    public GoogleResult1(String url) {
    	super(url);
	}

	@Override
	public boolean isReady() {
	
		boolean isComponentReady= true;
		
	
			PageComponent pageComponent = ResultComponent;
			
			if(pageComponent != null)
			{
				isComponentReady = pageComponent.isEnabled() && pageComponent.isVisible();
			}
			
			if (!isComponentReady) {
				return isComponentReady;
			}
			
		
		return isComponentReady;
	}	
	
}
