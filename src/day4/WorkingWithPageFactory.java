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
import pomlib.EbayHomePagePOM;
import pomlib.EbayResultPagePOM;

public class WorkingWithPageFactory {
	private WebDriver oDriver;
	private String sUrl= "https://ebay.com.sg";
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
		EbayPOMWithPF oEbayPage = new EbayPOMWithPF(oDriver);
		oEbayPage.oSearchBox.sendKeys("Sony");
		oEbayPage.oCategoryListBox.selectByVisibleText("Cameras & Photo");
		oEbayPage.oSearchButton.click();
		
		Thread.sleep(1000);
		
		System.out.println(oEbayPage.oResultCountLabel.getText());
		
	}

}



