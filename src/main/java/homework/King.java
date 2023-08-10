package homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class King extends KeyBooksBrowserSetup{

	@Test
	public void searchBook() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement searchMenu = driver.findElement(By.cssSelector("button[type='submit'][title='Open search']"));
		searchMenu.click();	
		WebElement inputSearch = driver.findElement(By.cssSelector("input[class='search_field']"));
		inputSearch.sendKeys("king");
		WebElement bookKing = driver.findElement(By.cssSelector("h6[class='post_title']>a[href*='the-wicked-king']"));
		bookKing.click();
		
		WebElement category = driver.findElement(By.cssSelector("a[href*='new-releases'][rel='tag']"));
		assertTrue(category.getText().equals("New releases"));
		
		WebElement productId = driver.findElement(RelativeLocator.with(By.tagName("span")).below(category));
        assertTrue(productId.getText().equals("1709"));


        WebElement picture1 = driver.findElement(By.cssSelector("a[href*='TheWickedKing1.png'][class='inited']"));
        assertTrue(picture1.getAttribute("href").contains("TheWickedKing1.png"));
        
        
        WebElement picture2 = driver.findElement(By.cssSelector("a[href*='TheWickedKing2.png'][class='inited']"));
        assertTrue(picture2.getAttribute("href").contains("TheWickedKing2.png"));
        
       WebElement picture3 = driver.findElement(By.cssSelector("a[href*='TheWickedKing3.png'][class='inited']"));
       assertTrue(picture3.getAttribute("href").contains("TheWickedKing3.png"));
       
       WebElement picture4 = driver.findElement(By.cssSelector("a[href*='TheWickedKing4.png'][class='inited']"));
       assertTrue(picture4.getAttribute("href").contains("TheWickedKing4.png"));


	}
}
