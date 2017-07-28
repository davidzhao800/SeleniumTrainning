package day4;

import java.util.List;
import java.util.Properties;

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
import commonutils.WebDriverLib;
import pomlib.EbayPOMWithPF;
import pomlib.EbayResultPagePOM;
import pomlib.ShowPagePOM;
import pomlib.TryPagePOM;
import pomlib.TutorialPagePOM;

public class WorkingWithPOMHome {
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
		
		TutorialPagePOM tutorialPage = new TutorialPagePOM(oDriver);
		tutorialPage.tryButton.click();
		
		allHandlers = oDriver.getWindowHandles().toArray();
		
		
		sParentHandler = allHandlers[0].toString();
		sChildHandler = allHandlers[1].toString();
		
		System.out.println("Parent handler is " + sParentHandler);
		System.out.println("Child handler is " + sChildHandler);
		
		oDriver.switchTo().window(sChildHandler);
		TryPagePOM tryPage = new TryPagePOM(oDriver);
		
		oDriver.switchTo().frame("iframeResult");
		ShowPagePOM show = new ShowPagePOM(oDriver);
		
		show.alertButton.click();
		
		String sAlertText = oDriver.switchTo().alert().getText();
		
		oDriver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println("Alert ="+sAlertText);
		oDriver.switchTo().defaultContent();
		oDriver.close();
		
		Thread.sleep(2000);
		
	
	}

}



