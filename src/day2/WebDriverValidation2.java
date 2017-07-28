package day2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonutils.BrowserNames;
import commonutils.CommonLib;

public class WebDriverValidation2 {
	private WebDriver oDriver;
	private String sUrl= "http://www.seleniumhq.org";
	private int iBrowserToOpen = BrowserNames.IE;
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
		sExpected = "Selenium automates browsers</i>.";
		sActual = oDriver.getPageSource();
		Assert.assertTrue(sActual.contains (sExpected));
	}

}



