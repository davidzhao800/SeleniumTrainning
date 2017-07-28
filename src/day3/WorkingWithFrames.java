package day3;

import java.util.List;

import org.openqa.selenium.By;
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

public class WorkingWithFrames {
	private WebDriver oDriver;
	private String sUrl= "https://seleniumhq.github.io/selenium/docs/api/java/";
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
		oDriver.switchTo().frame("packageListFrame");
		oDriver.findElement(By.linkText("org.openqa.selenium")).click();
		Thread.sleep(2000);
		
		oDriver.switchTo().defaultContent();
		
		oDriver.switchTo().frame("packageFrame");
		oDriver.findElement(By.linkText("WebDriver")).click();
		Thread.sleep(2000);
		
		oDriver.switchTo().defaultContent();
		
		oDriver.switchTo().frame("classFrame");
		Assert.assertTrue(oDriver.getPageSource().contains("Interface WebDriver"),"Unable to find 'Interface Webdriver' in page source.");
		
	}

}



