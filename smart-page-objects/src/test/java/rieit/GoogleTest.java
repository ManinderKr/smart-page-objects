package rieit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import rieit.page.Google;
import rieit.page.PageComponent;
import rieit.page.ResultComponent;
import rieit.page.SearchBoxComponent;
import rieit.page.SearchButtonComponent;

import org.junit.After;

@SuppressWarnings("deprecation")

public class GoogleTest {
	
	String Url= "https://www.google.co.in";
	List<PageComponent> pageComponents = new ArrayList<PageComponent>() ;
	
	//@Test
	public void should_Return_Url(){
		Google googlePage=	new Google(Url, pageComponents);
	
		googlePage.open(); //should able to open the correct Url.
	
		CharSequence testUrl = Url;
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);
	
	} 
	
	
	//@Test
	public void should_Return_Page_Is_Ready(){

		Google googlePage = new Google(Url, pageComponents);
		
		googlePage.open();
		
		googlePage.isReady();   //checks the page is ready to open or not.

		assertEquals(true , googlePage.isReady());

	}

	
	//@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() {

		Google googlePage = new Google(Url, pageComponents);
		
		SearchButtonComponent searchButtonComponent = new SearchButtonComponent (pageComponents);
				
		googlePage.open();
			
		googlePage.isReady();
		
		searchButtonComponent.click();   
		
		CharSequence testUrl = Url;              //checks the Url accepted by the driver should contains the Url passed by the user.
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void should_Be_Able_To_Enter_Text() {

			Google googlePage = new Google(Url, pageComponents);
				
			SearchBoxComponent searchBoxComponent = new SearchBoxComponent (pageComponents);
			
			SearchButtonComponent searchButtonComponent = new SearchButtonComponent (pageComponents);
			
			ResultComponent resultComponent = new ResultComponent (pageComponents);
			
			googlePage.open();
				
			googlePage.isReady();
			
			searchBoxComponent.sendText("text");     //checks the search box is able to enter the text.
			
			searchButtonComponent.click();    //checks the search button is able to run the text that is entered in search box.
			
			resultComponent.showResult();       //show the expected results of the entered text.
		
			System.out.println("true");
			
	//		assertEquals(resultComponent.showResult(), searchBoxComponent.sendText("text"));
			
		}

		
	//@After
	public void afterTest(){ 
		 DriverFactory.getInstance().removeDriver();
		}
	
}	
