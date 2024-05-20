package curs17;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class SeleniumLocators extends BaseTest{
/*
 * tagname
 * linktext
 * partialLinkText
 * class
 * id
 * name
 * css selector
 * Xpath
 */
/*
 * relative locators:
 * toLeftOf()
 * toRightOf()
 * above()
 * below()
 * near() -are o distanta in pixel in forma de cerc
 */
	
	
	@Test(priority=1)
	public void tagNameLocator() {
		
		//driver sau broswer nume al obiectului
		//<em>Discover</em>
		WebElement discoverText =browser.findElement(By.tagName("em"));
		//citire text dintre doua tag uri 
		String text= discoverText.getText();//returneaza textul dintre tagurile HTML
		System.out.println(text);
		
		
	}
	@Test(priority=2)
	public void linkTextLocator() {
		//<a href="https://keybooks.ro/shop/">Books</a>
		
		WebElement shopLink = browser.findElement(By.linkText("BOOKS"));
		shopLink.click();	
		assertEquals(browser.getCurrentUrl(), "https://keybooks.ro/shop/");
		
	}
	
	@Test(priority=3)
	public void partialLinkTextLocator() {
		//<a href="https://keybooks.ro/shop/a-banquet-of-mouse/">A banquet of  mouse</a>
		WebElement book = browser.findElement(By.partialLinkText("banquet"));
		book.click();
		assertEquals(browser.getCurrentUrl(), "https://keybooks.ro/shop/a-banquet-of-mouse/");
	}
	
	@Test(priority=4)
	public void classNameLocator() {
		
		WebElement price = browser.findElement(By.className("price"));
		System.out.println(price.getText());
		
		assertTrue(price.getText().contains("9.99"));
			
	}
	@Test(priority=5)
	public void idLocator() {
		
		WebElement reviewTab = browser.findElement(By.id("tab-title-reviews"));
		reviewTab.click();
		
		WebElement commentBox = browser.findElement(By.id("comment")); 
		assertTrue(commentBox.isDisplayed());
	}
	
	/*
	 * isDisplayed() --> verifica daca un element este vizibil
	 * isEnabled()--> verifica daca un element este enabled
	 * isSelected()--> doar pentru checkbox sau radio button
	 * 
	 */
	
	@Test(priority=6)
	public void nameLocator() throws InterruptedException {
		
		WebElement commentBox = browser.findElement(By.name("comment"));
		
		commentBox.sendKeys("My super message");
		Thread.sleep(3000);
		commentBox.clear();//elimina textul dintr-un element care primeste input
		Thread.sleep(3000);
		commentBox.sendKeys("Alt mesaj");

	}
	
	@Test(priority=7)
	public void cssSelectorLocator() {
		
		browser.findElement(By.cssSelector("input[name='author']")).sendKeys("Test");
		
	}
	
	@Test(priority=7)
	public void xpathLocator() {
		
		browser.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
		
	}
	
	
	
}
