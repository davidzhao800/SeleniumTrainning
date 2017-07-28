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

public class WorkingWithWebDriverReusable {
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
		WebDriverLib oWDLib = new WebDriverLib(oDriver);
		Properties oProperties = CommonLib.getProperties("EbayObjectMap.properties");
		
		By oBy;
		oBy = CommonLib.getByObject( oProperties.getProperty("homepage.search.textbox"));
		oWDLib.setTextUsingJS(oBy, "Nikon");
		oBy = CommonLib.getByObject( oProperties.getProperty("homepage.category.listbox"));
		oWDLib.selectItem(oBy, "Cameras & Photo");
		oBy = CommonLib.getByObject( oProperties.getProperty("homepage.search.button"));
		oWDLib.clickElement(oBy);
		Thread.sleep(1000);
		oBy = CommonLib.getByObject( oProperties.getProperty("resultpage.search.count.label"));
		System.out.println(oWDLib.getText(oBy));
	}

}



