package rieit.app;

import java.util.Collections;
import org.openqa.selenium.By;
import rieit.page.PageComponent;
import rieit.page.PageComponentSupport;

public class ResultComponent extends PageComponentSupport{
	
	public ResultComponent( By locator) {
		
		super(locator, Collections.<PageComponent>emptyList());
	}	
}
	