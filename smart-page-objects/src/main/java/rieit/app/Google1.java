package rieit.app;

import java.lang.reflect.InvocationTargetException;
import rieit.page.BasePage;
import rieit.page.LocatorAnnoationProcessor;
import rieit.page.PageComponent;
import rieit.page.WebPageComponent;

public class Google1 extends BasePage{

	@WebPageComponent(id="lst-ib")
	private BoxComponent searchBoxComponent ; 
	
	@WebPageComponent(name="btnG")
	private ButtonComponent searchButtonComponent ;   
	
	public void call() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException {
  		
	   		LocatorAnnoationProcessor.inject(this);
  		}

	public Google1(String url) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException {
			super(url);
			call();
		}
	
	
	/**
	 * {@link Google1} {@link #boxComponent()} locate the {@link BoxComponent}.
	 *  
	 * @return text
	 * 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	
	public GoogleResult1 boxComponent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException  {
		locate(BoxComponent.class);			
		return new GoogleResult1("http://www.google.com/");
	}
		
		
	/**
	 * {@link Google1} {@link #submitSearchQuery(String)} able the user to enter
	 * the text or query.
	 * 	
	 * @param query
	 * 
	 * @return text	
	 * 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws ClassNotFoundException 
	 */

	@SuppressWarnings("unchecked")
	public <P extends BasePage> P submitSearchQuery(String query) throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		locate(BoxComponent.class).type(query);
		locate(ButtonComponent.class).click();
				
		if (query.trim().equals(""))
		return (P) new Google1( "http://www.google.com/" );

		return (P) new GoogleResult1("http://www.google.com/");
	}
	
	
	/**
	 * {@link Google1} {@link #clearSearchQuery()} clear the query or text present in {@link BoxComponent}.
	 * 
	 * @return empty {@link BoxComponent}
	 * 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	
	public GoogleResult1 clearSearchQuery() throws NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		locate(BoxComponent.class).clearQuery();
		
		return new GoogleResult1("http://www.google.com/");
	}
	
	
	@SuppressWarnings("unchecked")
	private <PC extends PageComponent> PC locate(Class<PC> pageComponentClass) {
			
			for(PageComponent pageComponent : pageComponents){
				if(pageComponentClass.isInstance(pageComponent)){
					
					System.out.println("pageComponents1*: " + pageComponent);
					
					  return (PC) pageComponent;
					
				}
			}
			throw new RuntimeException(String.format("Unable to find PageComponent specified by class '%s' in Page class '%s'",
							pageComponentClass.getName(), getClass().getName()));
	}
	
	
	@Override
	public boolean isReady() {
		  
		  boolean isComponentReady= true;
		  
		  for(PageComponent pageComponent : pageComponents){
			  
			  System.out.println("pageComponents2*: " + pageComponent);
			  
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
		
