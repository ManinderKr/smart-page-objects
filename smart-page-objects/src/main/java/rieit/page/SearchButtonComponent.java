package rieit.page;

import java.util.List;

import org.openqa.selenium.By;


public class SearchButtonComponent extends PageComponentSupport{

	
	
	public SearchButtonComponent(List<PageComponent> subComponents) {
		super(subComponents);
		// TODO Auto-generated constructor stub
	}

	public By getLocator() {
		By searchbutton = By.name("btnK");
		return searchbutton;
	}
	
}
