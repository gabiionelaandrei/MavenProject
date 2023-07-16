package homework;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TheForest extends KeyBooksBrowserSetup{
	@Test(priority=1)
public void bookCategories() {
		List<WebElement> bookCategoriesList =  new ArrayList<>();
		
		//prima categorie
			WebElement newReleases =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-controls='sc_tab_1456822345_1_17']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'border:5px solid blue')", newReleases);	
			bookCategoriesList.add(newReleases);
		
		//a doua categorie
			WebElement commingSoon =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-controls='sc_tab_1456822345_2_72']"));
			jse.executeScript("arguments[0].setAttribute('style', 'border:5px solid green')", commingSoon);
			bookCategoriesList.add(commingSoon);
		
		//a treia categorie
			WebElement bestSeller =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-controls='sc_tab_1456822446659_6']"));
			jse.executeScript("arguments[0].setAttribute('style', 'border:5px solid pink')", bestSeller);
			bookCategoriesList.add(bestSeller);
			
		//a patra categorie
			WebElement awardWinners =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-controls='sc_tab_1456822448754_7']"));
			jse.executeScript("arguments[0].setAttribute('style', 'border:5px solid yellow')", awardWinners);
			bookCategoriesList.add(awardWinners);
			
			System.out.println(bookCategoriesList);
			

			for(WebElement category : bookCategoriesList) {
				WebElement forestBook =  driver.findElement(By.cssSelector("h3[class*='sc_title_reg'] a[href='the-forest']"));	
				category.click();
				if(forestBook.isDisplayed()) {
					assertTrue(forestBook.isDisplayed());
					forestBook.click();
					
					if(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-forest/")) {
					    System.out.println("Success");
					}
					else {
					    System.out.println("Failure");
					}
				}	

				else {
					System.out.println(category + " does not contains book " + forestBook + ".");
				}			

			}

}
}