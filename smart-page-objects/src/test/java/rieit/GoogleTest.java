package rieit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import rieit.page.Google;
import rieit.page.PageComponent;
import rieit.page.SearchBoxComponent;
import rieit.page.SearchButtonComponent;

import org.junit.After;

@SuppressWarnings("deprecation")

public class GoogleTest {
	
	List<PageComponent> pageComponents = new ArrayList<PageComponent>() ;
	
	//@Test
	public void shouldReturnUrl(){
		Google googlePage=	new Google("https://www.google.co.in", null);
	
		googlePage.open(); //should able to open the correct Url.
	
		CharSequence testUrl = "https://www.google.co.in";
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);
	
	} 
	
	
	//@Test
	public void shouldReturnPageIsReady(){

		Google googlePage = new Google("https://www.google.co.in", pageComponents);
		
		googlePage.open();
		
		googlePage.isReady();   //checks the page is ready to open or not.

		assertEquals(true , googlePage.isReady());

	}
	 

	@Test
	public void shouldBeAbleToEnterText() {

		Google googlePage = new Google("https://www.google.co.in", pageComponents);
			
		SearchBoxComponent searchBoxComponent = new SearchBoxComponent (pageComponents);
		
		SearchButtonComponent searchButtonComponent = new SearchButtonComponent (pageComponents);
				
		googlePage.open();
			
		googlePage.isReady();
		
		searchBoxComponent.sendText("Text");
	
		CharSequence sendtext = "Text";
		boolean flag = googlePage.getUrl().contains(sendtext);
		Assert.assertTrue(flag);
		
		searchButtonComponent.click();
		
		//assertEquals("related results", searchBoxComponent.sendText("Text"));
	}


	@After
	 public void afterTest() { 
		 DriverFactory.getInstance().removeDriver();
		}
	 
}	
