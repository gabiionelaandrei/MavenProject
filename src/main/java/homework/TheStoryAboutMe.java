package homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TheStoryAboutMe extends KeyBooksBrowserSetup {
	

	@Test(priority=1)
	public void findBook() {
		/**
		 * Prima problema : cand faci search iti cauta doar dupa textul : "about me"
		 * Pentru ca sunt 2 elemente la search. Cel in care faci prima data click si cel in care scrii.
		 * Sunt diferite
		 */
		//click pe search
		WebElement searchMenu = driver.findElement(By.cssSelector("button[type='submit'][title='Open search']"));
		searchMenu.click();	
		WebElement inputSearch = driver.findElement(By.cssSelector("input[class='search_field']"));
		//introduc ce vreau sa caut
		inputSearch.sendKeys("the story about me");
	    //driver.findElement(By.cssSelector("a[href='#'][class='post_more search_more']")).click();
		searchMenu.click();	

	    //identific load button
	    WebElement loadButton = driver.findElement(By.cssSelector("a[href='#'][id='viewmore_link']"));
	    
	    /**
	     * La bucla nu aveai nevoie sa iei toate cartile. Este suficient sa deschizi toate paginile cu
	     * load more 
	     * 
	     */
	    while(loadButton.isDisplayed()) {
		    	//am pus in try catch pentru ca atunci cand ajunge la ultima pagina si nu mai exista butonul
	    	//sa nu crape, ci sa prinda exceptia pe catch si sa treaca mai departe 
	    		try{
		    		loadButton.click();
			    	WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		    	  	wait.until(ExpectedConditions.elementToBeClickable(loadButton));
	    		}catch(Exception e) {
	    			
	    		}
	    }

	    /**
	     * Dupa continui cu logica pusa de tine ca este ok
	     */
	    WebElement myBook = driver.findElement(By.cssSelector("article[class*='item_masonry']>h4[class*='title']>a[href*='story-about-me']")); 
	    myBook.click();
	    assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-story-about-me/"));
	    
			driver.findElement(By.cssSelector("button[type='submit'][name='add-to-cart']")).click();
			//verificare mesaj ...has been added to your cart
			//WebElement message = driver.findElement(By.ByXPath.xpath("/html/body/div[1]/div/div[4]/div/div/article/div[1]/div/text()"));
	    	WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='woocommerce-message']")));
			WebElement message = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
			assertTrue(message.getText().contains("“The story about me” has been added to your cart."));
			
			
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
				WebElement textBilling = driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields']>h3"));
				assertTrue(textBilling.getText().equals("Billing details"));
				
				WebElement additionalInfo = driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields']>h3"));
				assertTrue(additionalInfo.getText().equals("Additional information"));
				
		
	  }

}