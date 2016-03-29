package rieit.page;

import org.openqa.selenium.By;

public interface PageComponent {

	/**
	 * {@link PageComponent}{@link #getLocator()} returns the unique locator
	 * ({@link By}) to the caller. The caller can then use the returned locator
	 * to locate this specific {@link PageComponent} within the Page.
	 * 
	 * @return an instance of {@link By} locator that uniquely identifies this
	 *         components in a page.
	 */
	public By getLocator();

	/**
	 * {@link PageComponent}{@link #isEnabled()} checks the locator or component
	 * on page is enabled or not.
	 * 
	 * @return <code>true</code> if this component is enabled on a page, else
	 *         returns <code>false</code>.
	 */
	public boolean isEnabled();

	/**
	 * {@link PageComponent}{@link #isVisible()} checks the locator or component
	 * on page is visible on page or not.
	 * 
	 * @return <code>true</code> if this component is visible on a page, else return <code>false</code>.
	 */
	public boolean isVisible();

}
