package homework;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class TheStoryAboutMe extends KeyBooksBrowserSetup {
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void findBook() {
		//click pe search
		WebElement searchMenu = driver.findElement(By.cssSelector("button[type='submit'][title='Open search']"));
		searchMenu.click();	
		//introduc ce vreau sa caut
	    searchMenu.sendKeys("The story about me");
	    searchMenu.click();
	    
	    
	    List<WebElement> books = driver.findElements(By.className("h4[class='post_title']"));
	    
	   for(WebElement element : books) {
		   JavascriptExecutor jse = (JavascriptExecutor) driver;
		   WebElement book =driver.findElement(By.cssSelector("article[class*='post_item']>h4[class='post_title']>a[href*='https://keybooks.ro/shop/the-story-about-me']")); 
		   if(element.getTagName().equals(book)) {
			   book.click();
		   }
		   else{
		   WebElement loadButton = driver.findElement(By.cssSelector("span[class='viewmore_text_1']"));
		   jse.executeScript("arguments[0].scrollIntoView", loadButton);
				loadButton.click();
				}
}
}
}