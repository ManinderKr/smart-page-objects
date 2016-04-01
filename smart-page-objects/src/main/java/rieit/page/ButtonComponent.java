package rieit.page;

import java.util.List;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class ButtonComponent extends PageComponentSupport {

		 static By button ;
		 
	public ButtonComponent( By locator, List<PageComponent> subComponents) {
		super(button, subComponents);
		
	}

	/**
	 *  {@link ButtonComponent}{@link #click()} emulates a click operation for a button. It takes a 
	 *  locator as an argument.
	 *   
	 *   @return A self reference.
	 */
	
	public void click(By locator) {
	
		DriverFactory.getInstance().getDriver().findElement(locator).click();
	}

	
}
