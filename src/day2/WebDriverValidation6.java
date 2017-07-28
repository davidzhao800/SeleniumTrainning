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

public class WebDriverValidation6 {
	private WebDriver oDriver;
	private String sUrl= "http://www.amazon.com";
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
		String sExpectedBgColor, sActualBgClor;
		
		WebElement oElement = oDriver.findElement(By.xpath("//input[@value='Go']/.."));
		
		sExpectedBgColor = "rgba(254, 189, 105, 1)";
		sActualBgClor = oElement.getCssValue("background-color"); 
		Assert.assertEquals(sExpectedBgColor, sActualBgClor);
		
	}

}



