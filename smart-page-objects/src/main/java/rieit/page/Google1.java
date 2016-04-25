package rieit.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class Google1 extends BasePage{

	@Locator(id="lst-ib")
	private BoxComponent searchBoxComponent ; 
	
	@Locator(name="btnG")
	private ButtonComponent searchButtonComponent ;
	/*
	  public void call()
  		{
	   		LocatorAnnoationProcessor.inject(this);
	   		this.searchBoxComponent= new BoxComponent(By.id(searchBoxComponent.getLocator()));
	   		System.out.println("searchBoxComponent : "+ searchBoxComponent.toString());
	   		this.searchButtonComponent= new ButtonComponent(By.name(searchButtonComponent));
  		}
*/
	public Google1(String url ) {
		super(url);
//		call();
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
			return (P) new Google1("http://www.google.com/");

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
		System.out.printf("pageComponent= "+searchBoxComponent , searchButtonComponent);
			 
		/*List<PageComponent> list = new ArrayList<>();
			  list.add(searchBoxComponent);
			  list.add(searchButtonComponent);*/
			
			ButtonComponent pc1 = searchButtonComponent ;
			BoxComponent pc=searchBoxComponent ; 
			
		int counter = 0;
	
			 if (pageComponentClass.isInstance(searchBoxComponent)) {
				 		counter=1;
				 		return (PC)pc;
				 				
					}
			 else if(pageComponentClass.isInstance(searchButtonComponent)){
				 		counter=1;
				 		return (PC) pc1;
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
		
				if(pc != null)
					{
						isComponentReady = pc.isEnabled() && pc.isVisible();
					}
				else if(pc1 !=null){
						isComponentReady= pc1.isEnabled() && pc1.isVisible();
					}
			
				if (!isComponentReady) {
						return isComponentReady;
					}
				
		return isComponentReady;
	}	
}		
		

	
		
		
		
		
		
		
