package curs18;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.utils.BaseTest;

public class ContactPage extends BaseTest{
	

	
@Test
	public void sendMessageMethod() throws InterruptedException {
	//locatori
	
	WebElement contactPage =browser.findElement(By.cssSelector("a[href='https://keybooks.ro/contacts/']"));
	contactPage.click();
	WebElement nameField =browser.findElement(By.cssSelector("input[name='your-name']"));
	WebElement emailField =browser.findElement(By.cssSelector("input[name='your-email']"));
	WebElement subjectField =browser.findElement(By.cssSelector("input[name='your-s']"));
	WebElement messageField =browser.findElement(By.cssSelector("textarea[name='your-message']"));
	WebElement sendMessageField =browser.findElement(By.cssSelector("input[value='Send Message']"));
	WebElement textSuccessMessage =browser.findElement(By.cssSelector("div[class='wpcf7-response-output']"));
			
		nameField.sendKeys("Gabi");
		emailField.sendKeys("test@gmail.com");
		subjectField.sendKeys("Test 02");
		messageField.sendKeys("This is the second test");
		sendMessageField.click();
		Thread.sleep(5000);
		assertTrue(textSuccessMessage.getText().equals("Thank you for your message. It has been sent.")); 
		
	}

}
