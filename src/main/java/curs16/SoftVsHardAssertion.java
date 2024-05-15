package curs16;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftVsHardAssertion {
/*
 * 1.hard assertion
 * 2.soft assertion
 */
	
	
	//hard assertion - intreruperea executiei mai jos de linia 18 nu se executa adica pica la aasertFalse(true)
	//daca conditia nu este indeplinita, se intrerupe codul
	//daca nu vreau sa rulez o metoda, comentez @Test ul 
	//avem si anotare de ignore
	//@Test
	public void hardAssertExample() {
		System.out.println("Code here ");
		assertFalse(true);
		System.out.println("Some other code here ");
		assertNotNull(null);
		System.out.println("Final code here");
	}
	
	@Test
	public void softAssertExample() {
		System.out.println("Code here ");
		SoftAssert sa = new SoftAssert();
		sa.assertFalse(true);
		System.out.println("Some other code here ");
		sa.assertNotNull(null);
		System.out.println("Final code here");
		sa.assertAll();
		//assertAll ia toate exceptiile care au aparut si le lasa sa ies 
		//la hard iese cand pica 
	}
	
	
}
