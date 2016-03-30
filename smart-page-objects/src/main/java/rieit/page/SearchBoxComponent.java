package rieit.page;

import java.util.List;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class SearchBoxComponent extends PageComponentSupport {

		static By searchbox=  By.id("lst-ib");
		
	public SearchBoxComponent( List<PageComponent> subComponents) {
		super(searchbox, subComponents);	
	
	}

	/**
	 * {@link SearchBoxComponent}{@link #sendText(String text)} send text to a text box or search box. 
	 * @throws InterruptedException 
	 * 
	 */
	public void sendText(String text){
		
		DriverFactory.getInstance().getDriver().findElement(searchbox).sendKeys(text);			
	}

	
	
}



