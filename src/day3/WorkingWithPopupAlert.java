package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class WorkingWithPopupAlert {
	private WebDriver oDriver;
	private String sUrl= "https://www.w3schools.com/js/js_popup.asp";
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
		
		Object[] allHandlers;
		String sParentHandler, sChildHandler;
		
		oDriver.findElement(By.xpath("//*[@id='main']/div[4]/a")).click();
		Thread.sleep(2000);

		allHandlers = oDriver.getWindowHandles().toArray();
		
		
		sParentHandler = allHandlers[0].toString();
		sChildHandler = allHandlers[1].toString();
		
		System.out.println("Parent handler is " + sParentHandler);
		System.out.println("Child handler is " + sChildHandler);
		
		oDriver.switchTo().window(sChildHandler);
		oDriver.switchTo().frame("iframeResult");
		oDriver.findElement(By.tagName("button")).click();
		
		String sAlertText = oDriver.switchTo().alert().getText();
		
		oDriver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println("Alert ="+sAlertText);
		oDriver.switchTo().defaultContent();
		oDriver.close();
		
		Thread.sleep(2000);
		
		oDriver.switchTo().window(sParentHandler);
		}

}



