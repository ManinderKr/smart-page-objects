package rieit.page;

import java.util.List;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class ButtonComponent extends PageComponentSupport {

		 static By button = By.name("btnK");
		 
	public ButtonComponent( List<PageComponent> subComponents) {
		super(button, subComponents);
		
	}

	/**
	 *  {@link ButtonComponent}{@link #click()} emulates a click operation for a button. It takes a 
	 *  locator as an argument.
	 *   
	 */
	
	public void click() {
		DriverFactory.getInstance().getDriver().findElement(button);
	}
}
