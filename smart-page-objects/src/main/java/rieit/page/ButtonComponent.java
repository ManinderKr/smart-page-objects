package rieit.page;

import java.util.Collections;
import org.openqa.selenium.By;
import rieit.DriverFactory;

public class ButtonComponent extends PageComponentSupport {

	public ButtonComponent(By locator) {
		
		super(locator, Collections.<PageComponent>emptyList());

	}

	/**
	 * {@link ButtonComponent}{@link #click()} emulates a click operation for a
	 * button. It takes a locator as an argument.
	 * 
	 * @return A self reference.
	 */
	
	public void click() {
		DriverFactory.getInstance().getDriver().findElement(getLocator()).click();
	}

}
