package curs16;

import static org.testng.Assert.assertEquals;

import org.testng.TestException;
import org.testng.annotations.Test;

public class AssertionExample {
	
	
	//assertion este o validare, validam ca un expected result == un actual result
	
	String actualResult = "Test";
	String expectedResult = "Masina";
@Test
	public void checkEquality() {
		if(expectedResult.equals(actualResult)) {
			System.out.println("Test is passed");
		}
		else {
			System.out.println("Test is failed");
			throw new TestException("Expected:" 
			+ expectedResult + " but got " + actualResult);
		}
	}

@Test	
public void checkEquality2() {
	assertEquals(expectedResult, actualResult);
	
}
}
