package rieit.page;

import java.util.ArrayList;
import java.util.List;

public class Google1 extends BasePage{

	@Locator(id="lst-ib")
	public BoxComponent searchBoxComponent ; 
	
	@Locator(name="btnG")
	public ButtonComponent searchButtonComponent ;
	
	public void call()
  		{
	   		LocatorAnnoationProcessor.inject(this);

  		}

	public Google1(String url) {
			super(url);
			call();
		}
	
	
	/**
	 * {@link Google}{@link #boxComponent()} locate the {@link BoxComponent}.
	 * 
	 * 
	 * @return text
	 */
	
	public GoogleResult1 boxComponent() {
		locate(BoxComponent.class);			
		return new GoogleResult1("http://www.google.com/");
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
	
	public <P extends BasePage> P submitSearchQuery(String query) {
		locate(BoxComponent.class).type(query);
		locate(ButtonComponent.class).click();
				
		if (query.trim().equals(""))
		return (P) new Google1( "http://www.google.com/" );

		return (P) new GoogleResult1("http://www.google.com/");
	}
	
	
	/**
	 * {@link Google}{@link #clearSearchQuery()} clear the query or text present in {@link BoxComponent}.
	 * 
	 * @return empty {@link BoxComponent}.
	 */
	
	public GoogleResult1 clearSearchQuery() {
		locate(BoxComponent.class).clearQuery();
		
		return new GoogleResult1("http://www.google.com/");
	}
	
	
	@SuppressWarnings("unchecked")
	private <PC extends PageComponent> PC locate(Class<PC> pageComponentClass) {
		
		List<PageComponent> list = new ArrayList<PageComponent>();
			  list.add(searchBoxComponent);
			  list.add(searchButtonComponent);
		
			  int counter = 0;
	
			  if (pageComponentClass.isInstance(searchBoxComponent)) {
				 		counter=1;	
				 		return (PC)searchBoxComponent ; 		
					}
			 
			  else if(pageComponentClass.isInstance(searchButtonComponent)){ 
						counter=1;
						return (PC)searchButtonComponent ; 			
			  		}
		
			  if(counter != 1){
						throw new RuntimeException(String.format("Unable to find PageComponent specified by class '%s' in Page class '%s'",
						pageComponentClass.getName(), getClass().getName()));	
					}		
		return (PC) list;		
	}
	
	
	@Override
	public boolean isReady() {
		
		ButtonComponent pc1 = searchButtonComponent ;
		BoxComponent pc=searchBoxComponent ; 

		  boolean isComponentReady= true;
		
				if(pc != null || pc1 !=null)
					{
						isComponentReady = pc.isEnabled() && pc.isVisible();
					}
			
				if (!isComponentReady) {
						return isComponentReady;
					}
				
		return isComponentReady;
	}	
}		
		
