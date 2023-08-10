package homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



	public class Author extends KeyBooksBrowserSetup{

		@Test
		public void AuthorSkills() throws InterruptedException{
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			driver.findElement(By.cssSelector("li[id='menu-item-695']>a[href*='margaret']")).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			WebElement firstSkill = driver.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_label']")).above(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd first inited']")));
			jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid pink')", firstSkill);
			
			WebElement secondSkill = driver.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_label']")).above(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 even inited']")));
			jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid green')", secondSkill);
			
			WebElement thirdSkill = driver.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_label']")).above(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd inited']")));
			jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid blue')", thirdSkill);
			
			

			WebElement firstSkillValue =driver.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_total'][data-stop='95']")).near(firstSkill));
			//WebElement firstSkillValue =driver.findElement(By.cssSelector("div[class='sc_skills_item sc_skills_style_1 odd first inited']"));
			assertEquals(firstSkillValue.getText(),"95%");
			
			WebElement secondSkillValue =driver.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_total'][data-stop='75']")).near(secondSkill));
			assertEquals(secondSkillValue.getText(),"75%");
			
			WebElement thirdSkillValue =driver.findElement(RelativeLocator.with(By.cssSelector("div[class='sc_skills_total'][data-stop='82']")).near(thirdSkill));
			assertEquals(thirdSkillValue.getText(),"82%%");

		}
	}


