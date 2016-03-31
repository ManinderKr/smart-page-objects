package rieit.page;

//import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Google extends BasePage {

	private List<PageComponent> googlePageComponents;
		
	
				
	public List<PageComponent> getGooglePageComponents() {
		return googlePageComponents;
	}

	public Google(String url, List<PageComponent> pageComponents) {
	super(url);
	this.googlePageComponents = pageComponents;			
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
