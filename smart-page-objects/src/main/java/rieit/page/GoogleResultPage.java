package rieit.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoogleResultPage extends BasePage{

	private List<PageComponent> googleResultPageComponents = new ArrayList<PageComponent>();
	
	private List<PageComponent> resultPageComponents = new ArrayList<PageComponent>();
	
	public List<PageComponent> getGoogleResultPageComponents() {
		return googleResultPageComponents;
	}

	public GoogleResultPage(String url, List<PageComponent> pageComponents) {
		super(url);
		this.googleResultPageComponents = pageComponents;

		pageComponents.add(new ResultComponent( resultPageComponents));
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
