package rieit.test;

import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import rieit.app.Google;
import rieit.app.GoogleResult;
import rieit.config.ConfigurationClass;
import org.junit.After;

public class GoogleTest {

	ConfigurationClass config= new ConfigurationClass();
	String Url = config.getUrl();
	
	//@Test
	public void should_Return_Url() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Google googlePage = new Google(Url);

		googlePage.open(); // should able to open the correct Url.

		CharSequence testUrl = Url;
		
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);

	}

	//@Test
	public void should_Return_Page_Is_Ready() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google googlePage = new Google( Url);

		googlePage.open();

		assertEquals(true, googlePage.isReady());

	}
	

	//@Test
	public void should_Be_Able_To_Enter_Text_In_BoxComponent() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google googlePage = new Google( Url);

		googlePage.open();
		
		googlePage.submitSearchQuery("Hello Java World!");
			
		assertEquals(true, googlePage.boxComponent().isReady());
			
	}

	@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google googlePage = new Google(Url);
			
		GoogleResult googleResult = new GoogleResult(Url);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		assertEquals(true, googleResult.isReady());
			
	}

	//@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google googlePage = new Google(Url);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		googlePage.clearSearchQuery();
			
		googlePage.submitSearchQuery("");
		
		CharSequence testUrl = Url;
		
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);
	
	}
	
	
	@After
	public void afterTest() {
		
		DriverFactory.getInstance().removeDriver();
	}
}

