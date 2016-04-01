package rieit;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import junit.framework.Assert;
import rieit.page.Google;
import rieit.page.GoogleResult;
import rieit.page.PageComponent;
import rieit.page.ResultComponent;
import rieit.page.BoxComponent;
import rieit.page.ButtonComponent;
import org.junit.After;
import org.junit.Before;

@SuppressWarnings("deprecation")

public class GoogleTest {
	
	String Url= "https://www.google.co.in";
	
	List<PageComponent> pageComponents = new ArrayList<PageComponent>() ;       //googlePageComponents
	
	List<PageComponent> pageComponents0 = new ArrayList<PageComponent>() ;     //googleResultPageComponents
	
	List<PageComponent> subComponents= new ArrayList<PageComponent>();     //empty array list

	@Before
	public void beforeTest(){
		
	pageComponents.add(new BoxComponent(By.id("lst-ib"),subComponents));
		
	pageComponents.add(new ButtonComponent(By.name("btnK"),subComponents));
	
	pageComponents0.add(new ResultComponent(By.id("rso"),subComponents));
	
	}
	
	//@Test
	public void should_Return_Url(){
		Google googlePage=	new Google(Url, null);
	
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
		
		ButtonComponent buttonComponent =  (ButtonComponent) googlePage.getGooglePageComponents().get(1);
				
		googlePage.open();
			
		googlePage.isReady();
		
		buttonComponent.click(By.name("btnK"));     //checks the search button is able to run the text that is entered in search box.
		
		CharSequence testUrl = Url;      //checks the Url accepted by the driver should contains the Url passed by the user.
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);
		
	}
	
	//@Test
	public void should_Be_Able_To_Enter_Text() {

		Google googlePage = new Google(Url, pageComponents);	
					
		BoxComponent boxComponent = (BoxComponent) googlePage.getGooglePageComponents().get(0);
		ButtonComponent buttonComponent =  (ButtonComponent) googlePage.getGooglePageComponents().get(1);
		
		googlePage.open();
					
		googlePage.isReady();
				
		boxComponent.sendText(By.id("lst-ib"),"selenium");     //send the text to the box whose locator is defined here.
			
		buttonComponent.click(By.name("btnG"));    // button to be clicked
					
		assertEquals(true,boxComponent.isEnabled());
		assertEquals(true,buttonComponent.isEnabled());
		
	}
		
		
	@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() {

		Google googlePage = new Google(Url, pageComponents);	
		GoogleResult googleResult = new GoogleResult(Url, pageComponents0);
				
		BoxComponent boxComponent = (BoxComponent) googlePage.getGooglePageComponents().get(0);
		ButtonComponent buttonComponent =  (ButtonComponent) googlePage.getGooglePageComponents().get(1);
		ResultComponent resultComponent =  (ResultComponent) googleResult.getGoogleResultPageComponents().get(0);
			
		googlePage.open();
				
		googlePage.isReady();
			
		boxComponent.sendText(By.id("lst-ib"),"RIEIT");    //send the text to the box whose locator is defined here.
			
		buttonComponent.click(By.name("btnG"));     //button to be clicked
			
		resultComponent.listOfResult( By.id("rso"));    //open the locator which contain the list of results.
						
		assertEquals(true,resultComponent.isVisible());
			
	}

		
	@After
	public void afterTest(){ 
		 DriverFactory.getInstance().removeDriver();
		}	
}	
