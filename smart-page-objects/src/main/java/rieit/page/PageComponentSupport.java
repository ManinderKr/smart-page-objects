package rieit.page;

import java.util.Iterator;
import java.util.List;

import rieit.DriverFactory;

public abstract class PageComponentSupport implements PageComponent {

	private List<PageComponent> subComponents;

	public PageComponentSupport(List<PageComponent> subComponents) {
		super();
		this.subComponents = subComponents;
	}

	public boolean isEnabled() {
		Iterator<PageComponent> componentIterator = subComponents.iterator();
		boolean isComponentEnabled = true;

		while (componentIterator.hasNext()) {
			PageComponent pageComponent = (PageComponent) componentIterator.next();
			// FIXME: Chain of wreck follows!
			isComponentEnabled = DriverFactory.getInstance().getDriver().findElement(pageComponent.getLocator())
					.isEnabled();
			if (!isComponentEnabled) {
				return isComponentEnabled;
			}
		}

		return isComponentEnabled;
	}

	public boolean isVisible() {
		Iterator<PageComponent> componentIterator = subComponents.iterator();
		boolean isComponentVisible = true;

		while (componentIterator.hasNext()) {
			PageComponent pageComponent = (PageComponent) componentIterator.next();
			isComponentVisible = DriverFactory.getInstance().getDriver().findElement(pageComponent.getLocator()).isDisplayed();
			if (!isComponentVisible) {
				return isComponentVisible;
			}
		}
		return isComponentVisible;
	}

}
