package rieit.page;

import java.util.Collections;
import org.openqa.selenium.By;

@Locator(id="rso")
public class ResultComponent extends PageComponentSupport{
	
	public ResultComponent( By locator) {
		super(locator, Collections.<PageComponent>emptyList());
		
	}
	
	
}
	