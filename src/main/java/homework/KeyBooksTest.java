package homework;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KeyBooksTest extends KeyBooksBrowserSetup{
	
	@Test(priority=1)
    public void elementeVizibile() {
		
		WebElement login =  driver.findElement(By.className("menu_user_login"));
		//isDisplayed() --> verifica daca elementul este displayed
		assertTrue(login.isDisplayed());
	}

}
