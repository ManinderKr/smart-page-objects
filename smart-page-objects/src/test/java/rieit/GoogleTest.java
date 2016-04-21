package rieit;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import rieit.page.Google1;
import rieit.page.GoogleResult1;
import rieit.page.Locator;
import rieit.page.ButtonComponent;
import rieit.page.PageComponent;
import rieit.page.ResultComponent;
import rieit.page.BoxComponent;
import org.junit.After;
//import org.junit.Before;

public class GoogleTest<buttonComponent> {

	String Url = "https://www.google.co.in";

	@SuppressWarnings("rawtypes")
	Class<GoogleTest> obj = GoogleTest.class;

	Annotation annotation = obj.getAnnotation(Locator.class);
	Locator locator = (Locator) annotation;

	@Locator(id = "lst-ib")
	String id;
	PageComponent BoxComponent = new BoxComponent(By.id(id));

	@Locator(name = "btnG")
	String name;
	PageComponent ButtonComponent = new ButtonComponent(By.name(name));

	@Locator(id = "rso")
	String id1 ;
	PageComponent ResultComponent = new ResultComponent(By.id(id1));

	PageComponent[] googleHomePageComponents = { BoxComponent, ButtonComponent };
	PageComponent[] googleSearchResultPageComponents = { ResultComponent };

	/*
	 * List<PageComponent> googleHomePageComponents = new
	 * ArrayList<PageComponent>(); // googlePageComponents
	 * 
	 * List<PageComponent> googleSearchResultPageComponents = new
	 * ArrayList<PageComponent>(); // googleResultPageComponents
	 * 
	 * @SuppressWarnings("unchecked") List<PageComponent> emptyComponents =
	 * Collections.EMPTY_LIST;
	 * 
	 * @Before public void beforeTest() {
	 * 
	 * googleHomePageComponents.add(new BoxComponent(By.id("lst-ib")));
	 * 
	 * googleHomePageComponents.add(new ButtonComponent(By.name("btnG")));
	 * 
	 * googleSearchResultPageComponents.add(new ResultComponent(By.id("rso")));
	 * 
	 * }
	 */
	// @Test
	public void should_Return_Url() {
		Google1 googlePage = new Google1(Url, googleHomePageComponents);

		googlePage.open(); // should able to open the correct Url.

		CharSequence testUrl = Url;
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);

	}

	// @Test
	public void should_Return_Page_Is_Ready() {

		Google1 googlePage = new Google1(Url, googleHomePageComponents);

		googlePage.open();

		assertEquals(true, googlePage.isReady());

	}

	@Test
	public void should_Be_Able_To_Enter_Text_In_BoxComponent() {

		Google1 googlePage = new Google1(Url, googleHomePageComponents);

		googlePage.open();
		System.out.println("pageComponent : " + googleHomePageComponents);
		googlePage.submitSearchQuery("Hello Java World!");

		assertEquals(true, googlePage.boxComponent().isReady());

	}

	// @Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() {

		Google1 googlePage = new Google1(Url, googleHomePageComponents);
		GoogleResult1 googleResult = new GoogleResult1(Url, googleSearchResultPageComponents);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		googlePage.click();

		assertEquals(true, googleResult.isReady());

	}

	//@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() {

		Google1 googlePage = new Google1(Url, googleHomePageComponents);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		googlePage.click();

		googlePage.clearSearchQuery();

		googlePage.click();

		CharSequence testUrl = Url;
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);

	}

	@After
	public void afterTest() {
		DriverFactory.getInstance().removeDriver();
	}
}
