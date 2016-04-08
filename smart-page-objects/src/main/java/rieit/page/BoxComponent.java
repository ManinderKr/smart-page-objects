package rieit.page;

import java.util.Collections;

import org.openqa.selenium.By;

import rieit.DriverFactory;


@Locator(id="lst-ib")
public class BoxComponent extends PageComponentSupport {

	public BoxComponent(By locator) {
		super(locator, Collections.<PageComponent>emptyList());
	}

	/**
	 * {@link BoxComponent}{@link #type(String)} able the user to enter the text or query to be searched.
	 * 
	 * @param query
	 * 
	 * @return results.
	 */
	public void type(String query) {
		DriverFactory.getInstance().getDriver().findElement(getLocator()).sendKeys(query);
	}


	/**
	 * {@link BoxComponent}{@link #clearQuery(String)} clear the query or text present in {@link BoxComponent}.
	 * 
	 * @return empty {@link BoxComponent}.
	 */
	
	public void clearQuery(){

		DriverFactory.getInstance().getDriver().findElement(getLocator()).clear();
	}
}
