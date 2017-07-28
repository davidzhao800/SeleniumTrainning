package day2;

import org.testng.annotations.Test;

public class TestNG05 {
	
	@Test
	public void t1() {
		System.out.println("From T1...");
	}
	
	@Test(enabled=false)
	public void t2() {
		System.out.println("From T2...");
	}
	
	@Test(invocationCount=5)
	public void t3() {
		System.out.println("From T3...");
	}
	
	@Test
	public void t4() {
		System.out.println("From T4...");
	}
	

}
