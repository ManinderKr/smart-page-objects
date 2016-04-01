package rieit.page;

import java.util.List;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class BoxComponent extends PageComponentSupport {

		 static By box;
		
	public BoxComponent( By locator, List<PageComponent> subComponents) {
		super(box, subComponents);	
	
	}

	/**
	 * {@link BoxComponent}{@link #sendText(String text)} send text to a text box or search box. 
	 * @throws InterruptedException 
	 * 
	 */
	public void sendText(By locator, String text){
		
		DriverFactory.getInstance().getDriver().findElement(locator).sendKeys(text);			
	}

	
	
}



