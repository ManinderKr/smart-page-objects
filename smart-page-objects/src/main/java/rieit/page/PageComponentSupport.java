package rieit.page;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import rieit.DriverFactory;

public abstract class PageComponentSupport implements PageComponent {

	private List<PageComponent> subComponents;

	private By locator;

	public PageComponentSupport(By locator, List<PageComponent> subComponents) {
		super();
		this.locator = locator;
		this.subComponents = subComponents;
	}

	public By getLocator() {
		return this.locator;
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
			isComponentVisible = DriverFactory.getInstance().getDriver().findElement(pageComponent.getLocator())
					.isDisplayed();
			if (!isComponentVisible) {
				return isComponentVisible;
			}
		}
		return isComponentVisible;
	}

}
