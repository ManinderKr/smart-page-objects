package rieit.app;

import java.lang.reflect.InvocationTargetException;
import rieit.page.BasePage;
import rieit.page.LocatorAnnotationProcessor;
import rieit.page.PageComponent;
import rieit.page.WebPageComponent;

public class Google extends BasePage{

	@WebPageComponent(id="lst-ib")
	private BoxComponent searchBoxComponent ; 
	
	@WebPageComponent(name="btnG")
	private ButtonComponent searchButtonComponent ;  
	
	public void call() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException {
  		
	   		LocatorAnnotationProcessor.inject(this);
  		}

	public Google(String url) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException, SecurityException, NoSuchMethodException {
			super(url);
			call();
		}
	
	
	/**
	 * {@link Google1} {@link #boxComponent()} locate the {@link BoxComponent}.
	 *  
	 * @return text
	 * 
	 * @throws InvocationTargetException- checked exception that wraps an exception thrown by an invoked method or constructor.
	 * @throws IllegalArgumentException- indicate that a method has been passed an illegal or inappropriate argument.
	 * @throws IllegalAccessException- thrown when an application tries to reflectively create an instance (other than an array), set or get a field, or invoke a method, but the currently executing method 
	 * 									does not have access to the definition of the specified class, field, method or constructor.
	 * @throws InstantiationException- thrown when an application tries to create an instance of a class using the newInstance method in class Class, but the specified class object cannot be instantiated.  
	 * @throws NoSuchFieldException- signals that the class doesn't have a field of a specified name.
	 * @throws SecurityException- thrown by the security manager to indicate a security violation.
	 * @throws NoSuchMethodException- thrown when a particular method cannot be found.

	 */
	
	public GoogleResult boxComponent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException  {
		locate(BoxComponent.class);			
		return new GoogleResult("http://www.google.com/");
	}
	
		
	/**
	 * {@link Google1} {@link #submitSearchQuery(String)} able the user to enter
	 * the text or query.
	 * 	
	 * @param query
	 * 
	 * @return text	
	 * 
	 * @throws InvocationTargetException- checked exception that wraps an exception thrown by an invoked method or constructor.
	 * @throws IllegalArgumentException- indicate that a method has been passed an illegal or inappropriate argument.
	 * @throws IllegalAccessException- thrown when an application tries to reflectively create an instance (other than an array), set or get a field, or invoke a method, but the currently executing method 
	 * 									does not have access to the definition of the specified class, field, method or constructor.
	 * @throws InstantiationException- thrown when an application tries to create an instance of a class using the newInstance method in class Class, but the specified class object cannot be instantiated.  
	 * @throws NoSuchFieldException- signals that the class doesn't have a field of a specified name.
	 * @throws SecurityException- thrown by the security manager to indicate a security violation.
	 * @throws NoSuchMethodException- thrown when a particular method cannot be found.

	 */

	@SuppressWarnings("unchecked")
	public <P extends BasePage> P submitSearchQuery(String query) throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		locate(BoxComponent.class).type(query);
		locate(ButtonComponent.class).click();
				
		if (query.trim().equals(""))
		return (P) new Google( "http://www.google.com/" );

		return (P) new GoogleResult("http://www.google.com/");
	}
	
	
	/**
	 * {@link Google1} {@link #clearSearchQuery()} clear the query or text present in {@link BoxComponent}.
	 * 
	 * @return empty {@link BoxComponent}
	 * 
	 * @throws InvocationTargetException- checked exception that wraps an exception thrown by an invoked method or constructor.
	 * @throws IllegalArgumentException- indicate that a method has been passed an illegal or inappropriate argument.
	 * @throws IllegalAccessException- thrown when an application tries to reflectively create an instance (other than an array), set or get a field, or invoke a method, but the currently executing method 
	 * 									does not have access to the definition of the specified class, field, method or constructor.
	 * @throws InstantiationException- thrown when an application tries to create an instance of a class using the newInstance method in class Class, but the specified class object cannot be instantiated.  
	 * @throws NoSuchFieldException- signals that the class doesn't have a field of a specified name.
	 * @throws SecurityException- thrown by the security manager to indicate a security violation.
	 * @throws NoSuchMethodException- thrown when a particular method cannot be found.

	 */
	
	public GoogleResult clearSearchQuery() throws NoSuchMethodException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		locate(BoxComponent.class).clearQuery();
		
		return new GoogleResult("http://www.google.com/");
	}
	
	
	@SuppressWarnings("unchecked")
	private <PC extends PageComponent> PC locate(Class<PC> pageComponentClass) {
			
			for(PageComponent pageComponent : pageComponents){
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
		
