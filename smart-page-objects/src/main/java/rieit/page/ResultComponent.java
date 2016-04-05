package rieit.page;

import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultComponent extends PageComponentSupport{
	
	public ResultComponent( By locator) {
		super(locator, Collections.<PageComponent>emptyList());
		
	}
	
	/**
	 * {@link ResultComponent}{@link #listOfResult(By locator)} examine, the locator contained results
	 *  is present on the page or not.
	 * 
	 * @param locator
	 * 
	 * @return list of results. 
	 */
	/*
public void listOfResult(){
		
	ExpectedConditions.presenceOfElementLocated(getLocator());
	
	}
*/
}