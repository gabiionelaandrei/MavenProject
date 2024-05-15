package curs16;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TestPriorityExample {

@Test(priority = 1)
public void one() {
	System.out.println("First");
}

@Test(priority = 2)
public void two() {
	System.out.println("Second");
}

@Test(priority = 3)
//cel mai mic numar reprezinta prioritatea cea mai mare
//daca au aceeasi prioritate le ordoneaza alfabetic

public void three() {
	System.out.println("Third");
}

@Test
public void four() {
	System.out.println("Fourth");
}

@Test
public void five() {
	System.out.println("Fifth");
}

//daca avem si cu prioritate si fara prioritate, le ia pe cele fara prioritate ordonate alfabetica si ulterior le ia pe cele cu prioritate


}
