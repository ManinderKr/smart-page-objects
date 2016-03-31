package rieit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import rieit.page.Google;
import rieit.page.PageComponent;
import rieit.page.ResultComponent;
import rieit.page.BoxComponent;
import rieit.page.ButtonComponent;

import org.junit.After;
import org.junit.Before;

@SuppressWarnings("deprecation")

public class GoogleTest {
	
	String Url= "https://www.google.co.in";
	List<PageComponent> pageComponents = new ArrayList<PageComponent>() ;
	
	List<PageComponent> boxComponents = new ArrayList<PageComponent>();
	
	List<PageComponent> buttonComponents = new ArrayList<PageComponent>();
	
	List<PageComponent> resultPageComponents = new ArrayList<PageComponent>();
	
	@Before
	public void beforeTest(){
		
	pageComponents.add(new BoxComponent(boxComponents));
	pageComponents.add(new ButtonComponent(buttonComponents));
	pageComponents.add(new ResultComponent( resultPageComponents));
	
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
		
		buttonComponent.click();     //checks the search button is able to run the text that is entered in search box.
		
		CharSequence testUrl = Url;      //checks the Url accepted by the driver should contains the Url passed by the user.
		boolean flag = googlePage.getUrl().contains(testUrl);
		Assert.assertTrue(flag);
		
	}
	
	//@Test
		public void should_Be_Able_To_Enter_Text() {

				Google googlePage = new Google(Url, pageComponents);	
					
				BoxComponent boxComponent = (BoxComponent) googlePage.getGooglePageComponents().get(0);
				ButtonComponent buttonComponent =  (ButtonComponent) googlePage.getGooglePageComponents().get(1);
				ResultComponent resultComponent =  (ResultComponent) googlePage.getGooglePageComponents().get(2);
				
				googlePage.open();
					
				googlePage.isReady();
				
				boxComponent.sendText("text");     //checks the search box is able to enter the text.
				
				buttonComponent.click();   
					
				assertEquals(true,boxComponent.isVisible());
				assertEquals(true,resultComponent.isEnabled());
				
			}
		
		
	@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() {

			Google googlePage = new Google(Url, pageComponents);	
				
			BoxComponent boxComponent = (BoxComponent) googlePage.getGooglePageComponents().get(0);
			ButtonComponent buttonComponent =  (ButtonComponent) googlePage.getGooglePageComponents().get(1);
			ResultComponent resultComponent =  (ResultComponent) googlePage.getGooglePageComponents().get(2);
			
			googlePage.open();
				
			googlePage.isReady();
			
			boxComponent.sendText("text");     //checks the search box is able to enter the text.
			
			buttonComponent.click();   
			
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),15);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rso")));
			
			resultComponent.showResult();       //show the expected results of the entered text.
					
			assertEquals(true,resultComponent.isVisible());
			assertEquals(true,resultComponent.isEnabled());
			
		}

		
	//@After
	public void afterTest(){ 
		 DriverFactory.getInstance().removeDriver();
		}
	
}	
