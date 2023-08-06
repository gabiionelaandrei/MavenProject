package homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class Review {

	
	public class BookReview extends KeyBooksBrowserSetup {
		@Test
		public void review() throws InterruptedException {

			WebElement book = driver.findElement(By.cssSelector("div[class*='column_item_5']>h3[class*='sc_title'][style*='margin-top']>a[href*='really']"));
			book.click();
			driver.findElement(By.cssSelector("a[href*='tab-reviews']")).click();
	

			
			WebElement consentBox = driver.findElement(By.cssSelector("input[id*='cookies-consent']"));
			assertFalse(consentBox.isSelected());
			consentBox.click();

			WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
			submitButton.click();
			
			driver.switchTo().alert().accept();
			
			driver.findElement(By.cssSelector("a[class='star-5']")).click();
			WebElement reviewText = driver.findElement(By.cssSelector("textarea[id='comment']"));
			reviewText.sendKeys("It is an interesting book");
			reviewText.sendKeys(Keys.ENTER);
			reviewText.sendKeys(":)");
			
			driver.findElement(By.cssSelector("input[id='author']")).sendKeys("Gabi");
			driver.findElement(By.cssSelector("input[id='email']")).sendKeys("andrei.gabi.ionela@gmail.com");
			
			assertTrue(consentBox.isSelected());
			submitButton.click();
			WebElement reviewApproval = driver.findElement(By.tagName("em"));
			assertTrue(reviewApproval.getText().contains("Your review is awaiting approval"));
		}
	}
}
