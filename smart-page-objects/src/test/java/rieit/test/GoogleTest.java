package rieit.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;

import rieit.app.BoxComponent;
import rieit.app.ButtonComponent;
import rieit.app.Google;
import rieit.app.GoogleResult;
import rieit.app.ResultComponent;
import rieit.config.ConfigurationClass;
import rieit.page.PageComponent;

import org.junit.After;
import org.junit.Before;

public class GoogleTest<buttonComponent> {
	
	 ConfigurationClass config= new ConfigurationClass();
	 String Url = config.getUrl();
	
	 List<PageComponent> googleHomePageComponents = new ArrayList<PageComponent>(); // googlePageComponents
	  
	 List<PageComponent> googleSearchResultPageComponents = new ArrayList<PageComponent>(); // googleResultPageComponents
	  
	 @SuppressWarnings("unchecked") 
	 List<PageComponent> emptyComponents =Collections.EMPTY_LIST;
	  
	 @Before 
	 public void beforeTest() {
		  
		  googleHomePageComponents.add(new BoxComponent(By.id("lst-ib")));
	  
		  googleHomePageComponents.add(new ButtonComponent(By.name("btnG")));
	  
		  googleSearchResultPageComponents.add(new ResultComponent(By.id("rso")));
	  
	  }
	 
	//@Test
	public void should_Return_Url() {
		
		Google googlePage = new Google(Url, googleHomePageComponents);

		googlePage.open(); // should able to open the correct Url.

		CharSequence testUrl = Url;
		
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);

	}

	//@Test
	public void should_Return_Page_Is_Ready() {

		Google googlePage = new Google(Url, googleHomePageComponents);

		googlePage.open();

		assertEquals(true, googlePage.isReady());

	}

	//@Test
	public void should_Be_Able_To_Enter_Text_In_BoxComponent() {

		Google googlePage = new Google(Url, googleHomePageComponents);

		googlePage.open();
	
		googlePage.submitSearchQuery("Hello Java World!");

		assertEquals(true, googlePage.boxComponent().isReady());

	}

	//@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() {

		Google googlePage = new Google(Url, googleHomePageComponents);
		
		GoogleResult googleResult = new GoogleResult(Url, googleSearchResultPageComponents);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		assertEquals(true, googleResult.isReady());

	}

	@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() {

		Google googlePage = new Google(Url, googleHomePageComponents);

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