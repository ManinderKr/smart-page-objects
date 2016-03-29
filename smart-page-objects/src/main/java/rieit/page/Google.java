package rieit.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Google extends BasePage {

	private List<PageComponent> googlePageComponents = new ArrayList<PageComponent>();
		
	private List<PageComponent> searchBoxComponents = new ArrayList<PageComponent>();
				
	private List<PageComponent> searchButtonComponents = new ArrayList<PageComponent>();
				
	public List<PageComponent> getGooglePageComponents() {
		return googlePageComponents;
	}

	public Google(String url, List<PageComponent> pageComponents) {
		super(url);
		this.googlePageComponents = pageComponents;

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
