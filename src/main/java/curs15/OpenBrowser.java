package curs15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
	
	@Test
	public void openBrowser() {
		//FirefoxDriver()
		//EdgeDriver()
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.emag.ro");
		
	}
	
	

}