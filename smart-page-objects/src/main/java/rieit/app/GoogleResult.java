package rieit.app;

import java.util.Iterator;
import java.util.List;

import rieit.page.BasePage;
import rieit.page.PageComponent;

public class GoogleResult extends BasePage{

	private List<PageComponent> googleResultPageComponents;
	
	public List<PageComponent> getGoogleResultPageComponents() {
		return googleResultPageComponents;
	}
		
	public GoogleResult(String url, List<PageComponent> pageComponents0) {
	super(url);
	this.googleResultPageComponents = pageComponents0;			
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

