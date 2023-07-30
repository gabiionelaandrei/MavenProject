package homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TheStoryAboutMe extends KeyBooksBrowserSetup {
	

	@Test(priority=1)
	public void findBook() {
		//click pe search
		WebElement searchMenu = driver.findElement(By.cssSelector("button[type='submit'][title='Open search']"));
		searchMenu.click();	
		//introduc ce vreau sa caut
	    searchMenu.sendKeys("The story about me");
	    driver.findElement(By.cssSelector("a[href='#'][class='post_more search_more']")).click();
	    
	    //identific load button
	    WebElement loadButton = driver.findElement(By.cssSelector("a[href='#'][id='viewmore_link']"));

	    //incarc toate cartile si sunt pe ultima pagina
	    do {
		    loadButton.click();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    
	   }while(loadButton.isDisplayed());
	    
	  //creez o lista cu toate cartile
	  		List<WebElement> bookList = driver.findElements(By.cssSelector("article[class*='item_masonry']>h4[class='post_title']")); 	 
	  		 //iterez prin lista si caut cartea mea
	  			for(WebElement book : bookList) {
	  				//identific cartea
	  				WebElement myBook = driver.findElement(By.cssSelector("article[class*='item_masonry']>h4[class*='title']>a[href*='story-about-me']"));
	  				assertTrue(myBook.isDisplayed());
	  				}
	        WebElement myBook = driver.findElement(By.cssSelector("article[class*='item_masonry']>h4[class*='title']>a[href*='story-about-me']")); 
	        myBook.click();
	        assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-story-about-me/"));
	 
			
			driver.findElement(By.cssSelector("button[type='submit'][name='add-to-cart']")).click();
			//verificare mesaj ...has been added to your cart
			//WebElement message = driver.findElement(By.ByXPath.xpath("/html/body/div[1]/div/div[4]/div/div/article/div[1]/div/text()"));
			//assertTrue(message.getText().equals("\"The story about me” has been added to your cart.\""));
			
			
			//accesam cart ul
			WebElement cart = driver.findElement(By.cssSelector(("div[class='woocommerce-message']>a[href='https://keybooks.ro/cart/'][class='button wc-forward']")));
			cart.click();
			assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/cart/"));
	  }

	@Test(priority=2)
	public void updateCart() {
				
				//crestem cantitatea
				driver.findElement(By.cssSelector("span[class='q_inc']")).click();
				driver.findElement(By.cssSelector("button[type='submit'][class='button'][value='Update cart']")).click();
				WebElement message = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
				assertEquals(message.getText(), "Cart updated.");
				
				//verificam URL ul
				driver.findElement(By.cssSelector("a[href='https://keybooks.ro/checkout/'][class*=checkout]")).click();
				assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/checkout/"));
				
				//verificam texte
				WebElement textBilling = driver.findElement(By.ByXPath.xpath("/html/body/div[1]/div/div[4]/div/div/article/section/div/form[3]/div[1]/div[1]/div[1]/h3"));
				assertTrue(textBilling.getText().equals("Billing details"));
				
				WebElement additionalInfo = driver.findElement(By.ByXPath.xpath("/html/body/div[1]/div/div[4]/div/div/article/section/div/form[3]/div[1]/div[2]/div[2]/h3"));
				assertTrue(additionalInfo.getText().equals("Additional information"));
				
		
	  }

}