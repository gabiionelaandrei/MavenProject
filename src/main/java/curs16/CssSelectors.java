package curs16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectors extends BaseTest{
	
	
	@Test
	
	public void cssSelectorExample() {
		

		WebElement selectedOption = driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-selected='true']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'backgroud:green; border:10px solid blue')", selectedOption);
		
		//NOT
		
		List <WebElement> menuEntries =driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		
		for(WebElement element : menuEntries) {
				
			
		}
			
		
	
		
	}

}
