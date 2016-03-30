package rieit.page;

import java.util.List;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class SearchButtonComponent extends PageComponentSupport {

		 static By searchbutton = By.name("btnK");
		 
	public SearchButtonComponent( List<PageComponent> subComponents) {
		super(searchbutton, subComponents);
		
	}

	/**
	 *  {@link SearchButtonComponent}{@link #click()} emulates a click operation for a button. It takes a 
	 *  locator as an argument.
	 *   
	 */
	
	public void click() {
		DriverFactory.getInstance().getDriver().findElement(searchbutton);
	}
}
