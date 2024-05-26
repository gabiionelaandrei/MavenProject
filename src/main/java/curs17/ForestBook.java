package curs17;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class ForestBook extends BaseTest{

	@Test
public void checkForestBook(){
		
		List<WebElement> bookCategories = browser.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		System.out.println(bookCategories.size());
		WebElement forestBook = browser.findElement(By.cssSelector("a[href='the-forest']"));
	      for (WebElement element : bookCategories)
	    	  element.click();
	      assertTrue(forestBook.isDisplayed());
	      forestBook.click();
	      assertTrue(browser.getCurrentUrl().equals("https://keybooks.ro/shop/the-forest/"));


	}
}