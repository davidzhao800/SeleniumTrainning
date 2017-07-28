package day2;

import org.testng.annotations.Test;

public class TestNG03 {
	
	@Test(priority=123)
	public void t1() {
		System.out.println("From T1...");
	}
	
	@Test(priority=10)
	public void t2() {
		System.out.println("From T2...");
	}
	
	@Test
	public void t3() {
		System.out.println("From T3...");
	}
	
	@Test(priority=-10)
	public void t4() {
		System.out.println("From T4...");
	}
	

}
