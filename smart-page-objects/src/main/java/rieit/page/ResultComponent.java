package rieit.page;

import java.util.List;

import org.openqa.selenium.By;

import rieit.DriverFactory;

public class ResultComponent extends PageComponentSupport{

	static By result=  By.className("big");
	
	public ResultComponent( List<PageComponent> subComponents) {
		super(result, subComponents);
		
	}
		
	/**
	 * {@link Result}{@link #showResult()} show the expected results of the text which are entered in search box.
	 */
	
	public void showResult(){
		
		DriverFactory.getInstance().getDriver().findElement(result);			
	}

}