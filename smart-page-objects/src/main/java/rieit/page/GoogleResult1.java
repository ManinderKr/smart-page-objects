package rieit.page;

public class GoogleResult1 extends BasePage{

    PageComponent[] googleResultPageComponents ; 
	
    public GoogleResult1(String url, PageComponent[] googleResultPageComponents) {
    	super(url);
    	
		System.out.println("PageComps:   "+googleResultPageComponents);

		this.googleResultPageComponents = googleResultPageComponents.clone();
	}

	@Override
	public boolean isReady() {
	
		boolean isComponentReady= true;
		
		for( int i = 0; i <  googleResultPageComponents.length - 1; i++)
		{
			PageComponent pageComponent =  googleResultPageComponents[i];
			
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
