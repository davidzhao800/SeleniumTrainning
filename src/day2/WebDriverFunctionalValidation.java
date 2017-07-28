package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonutils.BrowserNames;
import commonutils.CommonLib;

public class WebDriverFunctionalValidation {
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
		
		//WebElement oElement2 = oDriver.findElement(By.id("gh-ac"));
		//oElement2.sendKeys("iphone");
		
		JavascriptExecutor oJsEngine;
		oJsEngine = (JavascriptExecutor) oDriver;
		String command = "document.getElementById('gh-ac').value='iPhone'";
		oJsEngine.executeScript(command);
		
		s.selectByVisibleText("Cell Phones & Accessories");
		
		WebElement oButtonElement = oDriver.findElement(By.id("gh-btn"));
		oButtonElement.click();
	
		Thread.sleep(5000);
		
		String sResult = oDriver.findElement(By.className("listingscnt")).getText();
		System.out.println("Result = " + sResult);
		//Assert.assertEquals(sExpectedBgColor, sActualBgClor)
		long lngResult = Long.valueOf(sResult.split(" ")[0].replace(",",""));
		Assert.assertTrue(lngResult>=100, "Min 100 RESULTS NOT FOUND.");
	}

}



