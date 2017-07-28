package day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG08 {
	
	@Test(dataProvider="logindp")
	public void Login(String sUid, String sPwd) {
		System.out.printf("%s \t %s \n", sUid, sPwd);
	}
	
	@DataProvider(name="logindp")
	public Object[][] getData() {
		Object[][] arrData = {
				{"U1","P1"},
				{"21","P2"},
				{"U3","P3"},
				{"U4","P4"}
		};
		return arrData; 
	}
 
}
