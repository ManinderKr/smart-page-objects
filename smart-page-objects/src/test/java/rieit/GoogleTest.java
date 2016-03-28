package rieit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import rieit.page.Google;
import rieit.page.PageComponent;

import org.junit.After;


@SuppressWarnings("deprecation")

public class GoogleTest {
	
	List<PageComponent> pageComponents = new ArrayList<PageComponent>() ;
	
	
	
	//@Test
	public void shouldReturnUrl(){
	Google googlePage=	new Google("https://www.google.co.in", null);
	
	googlePage.open();
	
	CharSequence testUrl = "https://www.google.co.in";
	boolean flag = googlePage.getUrl().contains(testUrl);
	Assert.assertTrue(flag);
	
	//assertEquals(googlePage.getUrl(), "https://www.google.co.in");
	} 
	
	
	@Test
	public void shouldReturnPageIsReady(){

		Google googlePage = new Google("https://www.google.co.in", pageComponents);
		
		googlePage.open();
		
		googlePage.isReady();

		assertEquals(true , googlePage.isReady());

	}
	 
	//@Test
	public void shouldBeAbleToEnterText(){
	
		Google googlePage = new Google("https://www.google.co.in", pageComponents);
	
	
	}
	
	 @After
	 public void afterTest() { 
		 DriverFactory.getInstance().removeDriver();
		}
	 
}	
