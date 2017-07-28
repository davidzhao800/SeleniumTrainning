package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonutils.BrowserNames;
import commonutils.CommonLib;

public class WebDriverFunctionalMouseMove {
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
		WebElement oElement;
		Actions oMouse;
		
		oMouse = new Actions(oDriver);
		
		oElement = oDriver.findElement(By.linkText("Cameras"));
		oMouse.moveToElement(oElement).perform();
		Thread.sleep(2000);
		
		oDriver.findElement(By.linkText("Camcorders")).click();
		Thread.sleep(2000);
		
		
	}

}



