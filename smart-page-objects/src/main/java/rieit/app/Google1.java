package rieit.app;

import java.util.List;

import rieit.page.BasePage;
import rieit.page.LocatorAnnoationProcessor;
import rieit.page.PageComponent;
import rieit.page.WebPageComponent;

public class Google1 extends BasePage{

	@WebPageComponent(id="lst-ib")
	private BoxComponent searchBoxComponent ; 
	
	@WebPageComponent(name="btnG")
	private ButtonComponent searchButtonComponent ;   
	
	/*public List<PageComponent> getPageComponents() {
		return googlePageComponents;
	}*/
	
	public void call() throws SecurityException, NoSuchMethodException
  		{
	   		try {
				LocatorAnnoationProcessor.inject(this);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}

	public Google1(String url) throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	@SuppressWarnings("unchecked")
	
	public <P extends BasePage> P submitSearchQuery(String query) throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
			
			for(PageComponent pageComponent : googlePageComponents){
				if(pageComponentClass.isInstance(pageComponent)){
					  return (PC) pageComponent;
				}
			}
			throw new RuntimeException(String.format("Unable to find PageComponent specified by class '%s' in Page class '%s'",
							pageComponentClass.getName(), getClass().getName()));
	}
	
	
	@Override
	public boolean isReady() {
		  
		  boolean isComponentReady= true;
		  
		  for(PageComponent pageComponent : googlePageComponents){
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
		
