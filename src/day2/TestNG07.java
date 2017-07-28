package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG07 {
	
	@Test
	public void t1() {
		System.out.println("From T1...");
		Assert.assertEquals("Equals", "Equals");
	}
	
	@Test(dependsOnMethods="t1")
	public void t2() {
		System.out.println("From T2...");
		Assert.assertEquals(123.123, 123123);
	}
	
	@Test(dependsOnMethods="t2")
	public void t3() {
		System.out.println("From T3...");
		Assert.assertTrue(10>20,"Invalid condition 10>20");
	}
	
	@Test(dependsOnMethods={"t1","t3"})
	public void t4() {
		System.out.println("From T4...");
		Assert.fail("force to fail.");
	}
	

}
