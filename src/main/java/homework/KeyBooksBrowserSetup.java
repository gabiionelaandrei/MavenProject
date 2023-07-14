package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class KeyBooksBrowserSetup {


public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		String url = "https://keybooks.ro/";
		driver = new ChromeDriver();
		driver.manage().window().maximize();//maximizeaza fereastra browserului
		driver.get(url);
		
		
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);//bad practice
		
		driver.quit();//inchide tot browserul cu toate taburile
	}
}