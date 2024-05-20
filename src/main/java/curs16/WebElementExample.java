package curs16;
import org.openqa.selenium.By;
//selenium stie sa controleze aplicatii web
//nu stie sa faca assertion
//nu stie sa rulese
//nu stie sa scoata rapoarte
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WebElementExample {

	WebDriver browser;
	
	@BeforeClass
	public void setup() {
		
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://keyfood.ro");
	}
	
	//@AfterClass
	public void tearDown() {
		browser.quit();
	}
	
	@Test
	public void login() {
		
		browser.findElement(By.linkText("My account")).click();
		
	}
	
	
}