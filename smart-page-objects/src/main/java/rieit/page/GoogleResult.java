package rieit.page;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GoogleResult extends BasePage{

	private List<PageComponent> googleResultPageComponents;
	
	public List<PageComponent> getGoogleResultPageComponents() {
		return googleResultPageComponents;
	}
	public GoogleResult(String url, List<PageComponent> pageComponents0) {
	super(url);
	this.googleResultPageComponents = pageComponents0;			
	}
	
	    
	/**
	 * {@link GoogleResult}{@link #result()} shows the result.
	 * 
	 * @return list of results. 
	 */
	
	@SuppressWarnings("unchecked")
	
	public GoogleResult result(){
		locate(ResultComponent.class).listOfResult();
		
		return new GoogleResult("url", Collections.EMPTY_LIST);
	}

	@SuppressWarnings("unchecked")
	
	private <PC extends PageComponent> PC locate(Class<PC> pageComponentClass) {
		for (Iterator<PageComponent> itr = googleResultPageComponents.iterator(); itr.hasNext();) {
			PageComponent pageComponent = (PageComponent) itr.next();
			if (pageComponentClass.isInstance(pageComponent)) {
				return (PC) pageComponent;
			}
		}
		throw new RuntimeException(
				String.format("Unable to find PageComponent specified by class '%s' in Page class '%s'",
						pageComponentClass.getName(), getClass().getName()));
	}
	
	
	@Override
	public boolean isReady() {
		Iterator<PageComponent> componentIterator = googleResultPageComponents.iterator();
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

