package rieit.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.openqa.selenium.By;


public class Google extends BasePage {

	private List<PageComponent> googlePageComponents = new ArrayList<PageComponent>();
		
	private List<PageComponent> searchBoxComponents = new ArrayList<PageComponent>();
		
	//private By searchboxs[] = {By.id("lst-ib")};
				
	private List<PageComponent> searchButtonComponents = new ArrayList<PageComponent>();
	
	//private By searchbuttons[] = {By.name("btnK")};
				
	public List<PageComponent> getGooglePageComponents() {
		return googlePageComponents;
	}

	public Google(String url, List<PageComponent> pageComponents) {
		super(url);
		this.googlePageComponents = pageComponents;
	/*
		for(int i=0;i<searchboxs.length;i++){
			searchBoxComponents.add(searchboxs[i]);			
		}		
		
		for(int i=0;i<searchbuttons.length;i++){
			searchButtonComponents.add(searchbuttons[i]);			
		}	
		*/
		pageComponents.add(new SearchBoxComponent(searchBoxComponents));	
		pageComponents.add(new SearchButtonComponent(searchButtonComponents));	
	}
	    
	@Override
	public boolean isReady() {
		Iterator<PageComponent> componentIterator = googlePageComponents.iterator();
		boolean isComponentReady = true;

		while (componentIterator.hasNext()) {
			PageComponent component = (PageComponent) componentIterator.next();
			isComponentReady = component.isEnabled() && component.isVisible();

			if (!isComponentReady) {
				return isComponentReady;
			}
		}

		return isComponentReady;
	}

}
