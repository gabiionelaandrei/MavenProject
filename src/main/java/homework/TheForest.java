package homework;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TheForest extends KeyBooksBrowserSetup{
	@Test(priority=1)
public void bookCategories() {
		List<WebElement> bookCategoryList = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));

			
			System.out.println(bookCategoryList);
		
			for(WebElement category : bookCategoryList) {

				//identific cartea The Forest

				WebElement forestBook =  driver.findElement(By.cssSelector("div[aria-hidden='false'] a[href='the-forest']"));
				category.click();                              
				assertTrue(forestBook.isDisplayed());

				}
			WebElement forestBook =  driver.findElement(By.cssSelector("div[aria-hidden='false'] a[href='the-forest']"));
			forestBook.click();
			assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-forest/"));

}
}