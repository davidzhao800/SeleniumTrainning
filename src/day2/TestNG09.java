package day2;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG09 {
	
	@Test
	public void t1() {
		System.out.println("\t\tFrom T1...");
		Reporter.log("<b>From T1</b>");
	}
	
	@Test
	public void t2() {
		System.out.println("\t\tFrom T2...");
		Reporter.log("<b>From T2</b>");
	}
	
	@Test
	public void t3() {
		System.out.println("\t\tFrom T3...");
		Reporter.log("<b>From T3</b>");
	}
	
	@Test
	public void t4() {
		System.out.println("\t\tFrom T4...");
	}
	
	@BeforeMethod
	public void MethodSetup() {
		System.out.println("setup");
	}
	
	@AfterMethod
	public void MethodTearDown() {
		System.out.println("teardown");
	}
	
	@BeforeClass
	public void ClassSetup() {
		System.out.println("class setup");
	}
	
	@AfterClass
	public void ClassTearDown() {
		System.out.println("class tear down");
	}
}
