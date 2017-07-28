package day3;

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

public class WorkingWithDragadnDrop {
	private WebDriver oDriver;
	private String sUrl= "http://jqueryui.com/slider";
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
		
		WebElement oSliderButton;
		Actions oMouse;
		oDriver.switchTo().frame(0);
		oMouse = new Actions(oDriver);
		
		
		oSliderButton = oDriver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		oMouse.clickAndHold(oSliderButton).moveByOffset(200, 0).release(oSliderButton).build().perform();
		Thread.sleep(3000);
		
		
	}

}



