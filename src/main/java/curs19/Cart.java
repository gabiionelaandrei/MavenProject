package curs19;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class Cart extends BaseTest {

	@Test
	public void addToCart() throws InterruptedException {
		// caut cartea
		WebElement searchIcon = browser.findElement(By.cssSelector("button[type='submit']"));
		searchIcon.click();
		WebElement searchButton = browser.findElement(By.cssSelector("input[class='search_field']"));
		searchButton.sendKeys("The story about me");
		searchButton.sendKeys(Keys.ENTER);
		WebElement loadMoreButton = browser.findElement(By.cssSelector("span[class='viewmore_text_1']"));
		loadMoreButton.click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) browser;
		js.executeScript("arguments[0].scrollIntoView();", loadMoreButton);
		js.executeScript("arguments[0].click();", loadMoreButton);
		Thread.sleep(5000);
//gasesc cartea si verific URL ul
		WebElement bookStoryAboutMe = browser
				.findElement(By.cssSelector("a[href='https://keybooks.ro/shop/the-story-about-me/']"));
		js.executeScript("arguments[0].click();", bookStoryAboutMe);
		assertTrue(browser.getCurrentUrl().equals("https://keybooks.ro/shop/the-story-about-me/"));
//adaug cartea in cos
		WebElement addToCartButton = browser.findElement(By.cssSelector("button[name='add-to-cart'"));
		js.executeScript("arguments[0].click();", addToCartButton);
		WebElement textSuccessMessage = browser.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(textSuccessMessage.getText().contains("“The story about me” has been added to your cart."));
//modific cantitatea		
		WebElement viewCart = browser.findElement(By.cssSelector("div[class='woocommerce-message']>a"));
		js.executeScript("arguments[0].click();", viewCart);
		WebElement addMore = browser.findElement(By.cssSelector("span[class='q_inc']"));
		js.executeScript("arguments[0].click();", addMore);
		WebElement updateCart = browser.findElement(By.cssSelector("button[name='update_cart']"));
		js.executeScript("arguments[0].click();", updateCart);
		Thread.sleep(5000);
		WebElement messageCartUpdated = browser.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(messageCartUpdated.getText().contains("Cart updated."));
		WebElement checkOut = browser.findElement(By.cssSelector("a[href='https://keybooks.ro/checkout/']"));
		js.executeScript("arguments[0].click();", checkOut);
//verificam checkout ul
		assertTrue(browser.getCurrentUrl().equals("https://keybooks.ro/checkout/"));
		WebElement textBilling = browser.findElement(By.cssSelector("div[class='woocommerce-billing-fields']>h3"));
		assertTrue(textBilling.getText().equals("Billing details"));
		WebElement additionalInfo = browser
				.findElement(By.cssSelector("div[class='woocommerce-additional-fields']>h3"));
		assertTrue(additionalInfo.getText().equals("Additional information"));
	}

}
