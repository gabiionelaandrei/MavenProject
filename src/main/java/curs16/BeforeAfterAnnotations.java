package curs16;

import org.testng.annotations.*;

public class BeforeAfterAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");	
	}
	//@Test este singura care are se poate rula pt ca face legatura cu main
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");	
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After test");	
	}

	//before si after test se refera la un tag dintr un XML de cnf
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");	
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");	
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");	
	}
	
	@AfterMethod
	public void afterMethid() {
		System.out.println("After method");	
	}
@Test
	public void test1() {
		System.out.println("Test 1");	
	}
@Test
public void test2() {
	System.out.println("Test 2");	
}

@Test
public void test3() {
	System.out.println("Test 3");	
}


}
