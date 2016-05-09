package rieit.test;

import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import rieit.app.Google1;
import rieit.app.GoogleResult1;
import rieit.config.ConfigurationClass;
import rieit.page.BasePage;
import org.junit.After;

public class GoogleTest1 {

	ConfigurationClass config= new ConfigurationClass();
	String Url = config.getUrl();
	
	//@Test
	public void should_Return_Url() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		BasePage googlePage = new Google1(Url);

		googlePage.open(); // should able to open the correct Url.

		CharSequence testUrl = Url;
		
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);

	}

	//@Test
	public void should_Return_Page_Is_Ready() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		BasePage googlePage = new Google1( Url);

		googlePage.open();

		assertEquals(true, googlePage.isReady());

	}
	

	@Test
	public void should_Be_Able_To_Enter_Text_In_BoxComponent() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google1 googlePage = new Google1( Url);

		googlePage.open();
		
		googlePage.submitSearchQuery("Hello Java World!");
			
		assertEquals(true, googlePage.boxComponent().isReady());

	}

	//@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google1 googlePage = new Google1(Url);
			
		GoogleResult1 googleResult = new GoogleResult1(Url);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		assertEquals(true, googleResult.isReady());
			
	}

	//@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Google1 googlePage = new Google1(Url);

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

