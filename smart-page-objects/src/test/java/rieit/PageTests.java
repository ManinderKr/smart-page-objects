package rieit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rieit.model.Page;

public class PageTests {

	@Test
	public void should_open_in_browser_with_correct_url() {
		final WebDriver driver = new FirefoxDriver();

		Page page = new Page() {

			public String getUrl() {
				return "http://www.google.com/";
			}

			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			public void open() {
				driver.get(getUrl());
			}

			public void reload() {
				// TODO Auto-generated method stub

			}
		};

		page.open(); // should open the browser with that page

		assertEquals(page.getUrl(), driver.getCurrentUrl());
	}

}
