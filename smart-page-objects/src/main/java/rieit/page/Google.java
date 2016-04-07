package rieit.page;

import java.util.Collections;
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
	

	/**
	 * {@link Google}{@link #click()} enumlates a click operation for a button..
	 * 
	 * @return A self reference.
	 */
	
	@SuppressWarnings("unchecked")
	
	public Google click() {
		locate(ButtonComponent.class).click();

		return new Google("url", Collections.EMPTY_LIST);
	}

	/**
	 * {@link Google}{@link #boxComponent()} locate the {@link BoxComponent}.
	 * 
	 * 
	 * @return text
	 */
	
	@SuppressWarnings("unchecked")
	
	public GoogleResult boxComponent() {
		locate(BoxComponent.class);

		return new GoogleResult("Url",  Collections.EMPTY_LIST);
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
	
	public GoogleResult submitSearchQuery(String query) {
		locate(BoxComponent.class).type(query);
		//locate(ButtonComponent.class).click();

		return new GoogleResult("Url",  Collections.EMPTY_LIST);
	}
	
	/**
	 * {@link Google}{@link #clearSearchQuery()} clear the query or text present in {@link BoxComponent}.
	 * 
	 * @return empty {@link BoxComponent}.
	 */
	
	@SuppressWarnings("unchecked")
	
	public GoogleResult clearSearchQuery() {
		locate(BoxComponent.class).clearQuery();
		
		return new GoogleResult("Url",  Collections.EMPTY_LIST);
	}
	

	@SuppressWarnings("unchecked")

	private <PC extends PageComponent> PC locate(Class<PC> pageComponentClass) {
		for (Iterator<PageComponent> itr = googlePageComponents.iterator(); itr.hasNext();) {
			PageComponent pageComponent = (PageComponent) itr.next();
			if (pageComponentClass.isInstance(pageComponent)) {
				// XXX: Review!! Do we need this cast?
				return (PC) pageComponent;
			}
		}
		throw new RuntimeException(
				String.format("Unable to find PageComponent specified by class '%s' in Page class '%s'",
						pageComponentClass.getName(), getClass().getName()));
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
