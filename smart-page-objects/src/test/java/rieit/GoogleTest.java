package rieit;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import junit.framework.Assert;
import rieit.page.Google;
import rieit.page.GoogleResult;
import rieit.page.ButtonComponent;
import rieit.page.PageComponent;
import rieit.page.ResultComponent;
import rieit.page.BoxComponent;
import org.junit.After;
import org.junit.Before;

@SuppressWarnings("deprecation")

public class GoogleTest {

	String Url = "https://www.google.co.in";

	List<PageComponent> googleHomePageComponents = new ArrayList<PageComponent>(); // googlePageComponents

	List<PageComponent> googleSearchResultPageComponents = new ArrayList<PageComponent>(); // googleResultPageComponents

	@SuppressWarnings("unchecked")
	List<PageComponent> emptyComponents = Collections.EMPTY_LIST;

	@Before
	public void beforeTest() {

		googleHomePageComponents.add(new BoxComponent(By.id("lst-ib")));

		googleHomePageComponents.add(new ButtonComponent(By.name("btnG")));
		
		googleSearchResultPageComponents.add(new ResultComponent(By.id("rso")));

	}

	// @Test
	public void should_Return_Url() {
		Google googlePage = new Google(Url, null);

		googlePage.open(); // should able to open the correct Url.

		CharSequence testUrl = Url;
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);

	}

	// @Test
	public void should_Return_Page_Is_Ready() {

		Google googlePage = new Google(Url, googleHomePageComponents);

		googlePage.open();

		assertEquals(true, googlePage.isReady());

	}

	@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() {

		Google googlePage = new Google(Url, googleHomePageComponents);

		googlePage.open();

		googlePage.click();
		
		CharSequence testUrl = Url;           // checks the Url accepted by the driver should contains the Url passed by the user.
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);

	}

	//@Test
	public void should_Be_Able_To_Enter_Text() {

		Google googlePage = new Google(Url, googleHomePageComponents);
		
		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");
		
		assertEquals(true, googlePage.submitSearchQuery("Hello Java World!").isReady());

	}

	//@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() {

		Google googlePage = new Google(Url, googleHomePageComponents);
		GoogleResult googleResult = new GoogleResult(Url, googleSearchResultPageComponents);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");
		
		assertEquals(true, googleResult.result().isReady());

	}

	@After
	public void afterTest() {
		DriverFactory.getInstance().removeDriver();
	}
}
