package rieit.page;

import java.util.Collections;

public class Google1 extends BasePage{

	PageComponent[] googlepageComponent ; 
	
	public Google1(String url ,PageComponent[] googlepageComponent ) {
		super(url);
		
		System.out.println("PageComps:   "+googlepageComponent);
		//this.googlepageComponent = googlepageComponent;
		this.googlepageComponent = googlepageComponent.clone();
	}
	
	@SuppressWarnings("unchecked")
	
	public Google click() {
		locate(ButtonComponent.class).click();

		return new Google("url", Collections.EMPTY_LIST);
	}

	/**
	 * {@link Google}{@link #boxComponent()} locate the {@link BoxComponent}.
	 * 
	 * 
	 * @return text
	 */
	
	@SuppressWarnings("unchecked")
	
	public GoogleResult boxComponent() {
		locate(BoxComponent.class);

		return new GoogleResult("Url",  Collections.EMPTY_LIST);
	}
	

	/**
	 * {@link Google}{@link #submitSearchQuery(String)} able the user to enter
	 * the text or query.
	 * 
	 * @param query
	 * 
	 * @return text
	 */

	@SuppressWarnings("unchecked")
	
	public GoogleResult submitSearchQuery(String query) {
		locate(BoxComponent.class).type(query);
		//locate(ButtonComponent.class).click();

		return new GoogleResult("Url",  Collections.EMPTY_LIST);
	}
	
	/**
	 * {@link Google}{@link #clearSearchQuery()} clear the query or text present in {@link BoxComponent}.
	 * 
	 * @return empty {@link BoxComponent}.
	 */
	
	@SuppressWarnings("unchecked")
	
	public GoogleResult clearSearchQuery() {
		locate(BoxComponent.class).clearQuery();
		
		return new GoogleResult("Url",  Collections.EMPTY_LIST);
	}
	

	@SuppressWarnings("unchecked")


	private <PC extends PageComponent> PC locate(Class<PC> pageComponentClass) {
		System.out.println("PAGE COMPONENT  : "+ googlepageComponent[0]);
		
		PageComponent pageComponent =  googlepageComponent[0];
		PageComponent pc = googlepageComponent[0];
		
		int counter = 0;
		
		for (int i =0;i<  googlepageComponent.length; i++) {
			 pageComponent =  googlepageComponent[i];
		
			 System.out.println("PAGE COMPONENT inside loop : "+ googlepageComponent[i]);
			
			 if (pageComponentClass.isInstance(pageComponent)) {
				// XXX: Review!! Do we need this cast?
				
				counter=1;
			    pc = pageComponent;
				System.out.println("counter : "+counter);
			}
		
		}
		if(counter != 1){
			throw new RuntimeException(String.format("Unable to find PageComponent specified by class '%s' in Page class '%s'",
					pageComponentClass.getName(), getClass().getName()));	
		}
		return  (PC) pc;
	}
	
	
	@Override
	public boolean isReady() {
	
		boolean isComponentReady= true;
		
		for( int i = 0; i <  googlepageComponent.length - 1; i++)
		{
			PageComponent pageComponent =  googlepageComponent[i];
			
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
		

	
		
		
		
		
		
		
