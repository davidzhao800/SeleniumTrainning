package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonutils.BrowserNames;
import commonutils.CommonLib;

public class WebDriverValidation5 {
	private WebDriver oDriver;
	private String sUrl= "http://www.ebay.com.sg";
	private int iBrowserToOpen = BrowserNames.Chrome;
	@AfterClass
	public void automationStop() throws Exception {
		oDriver.quit();
	}

	@BeforeClass
	public void automationStart() throws Exception {
		oDriver = CommonLib.getDriver(iBrowserToOpen);
		oDriver.get(sUrl);
		Thread.sleep(2000);
	}
	
	@Test
	public void validation() throws Exception {
		String sExpected, sActual;
		
		WebElement oElement = oDriver.findElement(By.id("gh-cat"));
		Select s = new Select (oElement);
		
		sExpected = "All Categories";
		sActual = s.getFirstSelectedOption().getText(); 
		Assert.assertEquals(sActual, sExpected);
		
		Assert.assertTrue( s.getOptions().size() >= 10 );
		
		
		Assert.assertTrue( oElement.getText().contains("Art"));
	}

}



