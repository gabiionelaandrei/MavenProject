package curs17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class ForestBook extends BaseTest{

	@Test
public void checkForestBook(){
		//WebElement forestBook = browser.findElement(By.cssSelector("img[src*=https://keybooks.ro/wp-content/uploads/2016/04/book2.jpg\"]"));
		List<WebElement> bookCategories = browser.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		System.out.println(bookCategories.size());
		
	      for (WebElement element : bookCategories) 
	    	  element.click();
	
	}
}
