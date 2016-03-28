package rieit.page;

import org.openqa.selenium.By;

public interface PageComponent {

	/**
	 * {@link PageComponent}{@link #getLocator()} returns the unique locator
	 * ({@link By}) to the caller. The caller can then use the returned locator
	 * to locate this specific {@link PageComponent} within the Page.
	 * 
	 * @return
	 */
	public By getLocator();

	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean isEnabled();

	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean isVisible();

}
