package rieit.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultComponent extends PageComponentSupport{

	static By result;
	
	public ResultComponent( By locator, List<PageComponent> subComponents) {
		super(result, subComponents);
		
	}
	
	/**
	 * {@link ResultComponent}{@link #listOfResult(By locator)} examine, the locator contained results
	 *  is present on the page or not.
	 * 
	 * @param locator
	 * 
	 * @return list of results. 
	 */
public void listOfResult(By locator){
		
		ExpectedConditions.presenceOfElementLocated(locator);			
	}

}