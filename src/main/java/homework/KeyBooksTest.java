package homework;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KeyBooksTest extends KeyBooksBrowserSetup{
	
	@Test(priority=1)
    public void elementeVizibile() {
		
		String title = "Booklovers – Your Favorite Bookshelf!";
		
		
		if(driver.getTitle() != null && driver.getTitle().contains(title)){
			
			WebElement loginMenu = driver.findElement(By.cssSelector("li[class='menu_user_login']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid pink')", loginMenu);
			
			
			
			WebElement loginPopup =  driver.findElement(By.cssSelector("input[id='log'][name='log'][placeholder='Login or Email']"));
			
			WebElement passwordPopup =  driver.findElement(By.cssSelector("input[type='password'],[name='pwd']"));
			
			
			if(!(loginPopup.isDisplayed() &&passwordPopup.isDisplayed())) {
				loginMenu.click();	
			assertTrue(loginPopup.isDisplayed());
			assertTrue(passwordPopup.isDisplayed());
			}
			else{
				System.out.println("Login user and passwords are not available");
			}
			
			}
		
			else{
			  System.out.println("Web page is not opened.");
			}
				
		
	}

}
