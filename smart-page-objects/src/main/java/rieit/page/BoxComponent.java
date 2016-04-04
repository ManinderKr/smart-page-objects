package rieit.page;

import java.util.Collections;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class BoxComponent extends PageComponentSupport {

	public BoxComponent(By locator) {
		super(locator, Collections.<PageComponent>emptyList());
	}

	/**
	 * 
	 * @param query
	 */
	public void type(String query) {
		DriverFactory.getInstance().getDriver().findElement(getLocator()).sendKeys(query);
	}

}
