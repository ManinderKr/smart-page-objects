package rieit.page;


import java.util.List;

import org.openqa.selenium.By;


public class SearchBoxComponent extends PageComponentSupport {

	public SearchBoxComponent(List<PageComponent> subComponents) {
		super(subComponents);
		
	}

	public By getLocator() {
		By searchbox = By.id("lst-ib");
		return searchbox;
	}



}



