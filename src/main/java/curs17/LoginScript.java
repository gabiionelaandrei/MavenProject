package curs17;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class LoginScript extends BaseTest{


	
	@Test(priority=1)
	public void checkLoginElements() {

		//a[@href='#popup_login']
		WebElement loginMenu = browser.findElement(By.xpath("//a[@href='#popup_login']"));
		//<div class="popup_form_field login_field iconed_field icon-user"><input type="text" id="log" name="log" value="" placeholder="Login or Email"></div>
		WebElement emailField = browser.findElement(By.xpath("//input[@id='log']"));
		//<div class="popup_form_field password_field iconed_field icon-lock"><input type="password" id="password" name="pwd" value="" placeholder="Password"></div>
		WebElement passwordField = browser.findElement(By.xpath("//input[@id='password']"));
		//<li class="menu_user_login"><a href="#popup_login" class="popup_link popup_login_link icon-user inited" title="">Login</a><div id="popup_login" class="popup_wrap popup_login bg_tint_light animated fast fadeIn" style="display: block;">
		WebElement loginPopup = browser.findElement(By.xpath("//div[@id='popup_login']"));
		loginMenu.click(); 
		loginPopup.click();
		assertTrue(emailField.isDisplayed() && passwordField.isDisplayed()); 
 
		
		
	}
}
