package curs16;

import org.testng.annotations.Test;

//@Test 
//marcheaza ca toate metodele din clasa sa fie de test-daca met e privata nu o poate rula
public class TestAnnotationExample {
	@Test 	
	public void test1() {
		System.out.println("Test1");
	}
	@Test 
	public void test2() {
		System.out.println("Test2");
	}
	@Test 
	//o ruleaza indiferent-punem @Testul la nivelul metodei de obicei - putem adauga si prioritate
	private void test3() {
		System.out.println("Test3");
	}

}
