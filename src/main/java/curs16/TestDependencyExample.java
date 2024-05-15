package curs16;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestDependencyExample {


	@Test(priority=1)
	public void method1() {
		//assertTrue(false);
		System.out.println("Method1");
	}
	
	@Test(priority=2, dependsOnMethods = "method1" )
	public void method2() {
		System.out.println("Method2");
	}
	
	@Test(priority=3, dependsOnMethods = "method2", alwaysRun = true)
	public void method3() {
		System.out.println("Method3");
	}
//daca prima metoda pica, a doua metoda iese pe skipped cand avem dependsOnMethod	
//alwaysRun forteaza o metoda sa fie rulata indiferent de dependsOnMethod si are prioritate in fata altor setari
//CTRL + space ne aduce optiunile
//invocationCount iti ruleaza de mai multe ori aceeasi metoda, cu aceleasi date
	
	@Test(invocationCount = 5 )
	public void method4() {
		System.out.println("Method4");
	}
}
