package homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Mytest extends KeyBooksBrowserSetup {

	
	@Test(priority=1)
	public void test() {
		driver.get("https://keybooks.ro/shop/the-story-about-me/");
		driver.findElement(By.cssSelector("button[type='submit'][name='add-to-cart']")).click();
		
		//verificare mesaj ...has been added to your cart
		//WebElement message = driver.findElement(By.ByXPath.xpath("/html/body/div[1]/div/div[4]/div/div/article/div[1]/div/text()"));
		//assertTrue(message.getText().equals("\"The story about me” has been added to your cart.\""));

		//accesam cart ul
		WebElement cart = driver.findElement(By.cssSelector(("div[class='woocommerce-message']>a[href='https://keybooks.ro/cart/'][class='button wc-forward']")));
		cart.click();
		driver.findElement(By.cssSelector("span[class='q_inc']")).click();
		
		
		//crestem cantitatea
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
