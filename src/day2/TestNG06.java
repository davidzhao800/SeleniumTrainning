package day2;

import org.testng.annotations.Test;

public class TestNG06 {
	
	@Test
	public void t1() {
		System.out.println("From T1...");
	}
	
	@Test(expectedExceptions=ArithmeticException.class)
	public void t2() {
		System.out.println(10/0);
	}

}
