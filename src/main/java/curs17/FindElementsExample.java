package curs17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class FindElementsExample extends BaseTest{

	@Test
	public void findElementsExample() {
		
		List<WebElement> menuTabs = browser.findElements(By.cssSelector("li[role='tab']"));
		
		System.out.println(menuTabs.size());
	
		menuTabs.get(2).click();
		
	}
	
	
}