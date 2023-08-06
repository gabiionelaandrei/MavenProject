package homework;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class ContactPage extends KeyBooksBrowserSetup {
	@Test
	public void contacts() {
        driver.findElement(By.cssSelector("li[id*='72']>a[href*='contacts']")).click();
		driver.findElement(By.cssSelector("input[type='text'][name='your-name']")).sendKeys("Gabi");
		driver.findElement(By.cssSelector("input[type='email'][name='your-email']")).sendKeys("amdrei.gabi.ionela@gmail.com");
		driver.findElement(By.cssSelector("input[type='text'][name='your-s']")).sendKeys("Book availability");
		WebElement message = driver.findElement(By.cssSelector("textarea[name='your-message']"));
		message.sendKeys("Hello,");
		message.sendKeys(Keys.ENTER);
		message.sendKeys(Keys.ENTER);
		message.sendKeys("I am interested in buying It’s a really strange story book. Is it also available in the Bucharest store?");
		message.sendKeys(Keys.ENTER);
		message.sendKeys(Keys.ENTER);
		message.sendKeys("Thanks, Gabi");
		driver.findElement(By.cssSelector("input[type='submit'][value*='Send']")).click();
		WebElement textConfirmation = driver.findElement(By.cssSelector("div[class*='output'][aria-hidden='true']"));
		textConfirmation.click();
		assertTrue(textConfirmation.getText().contains("Thank you for your message. It has been sent."));
	}
}
