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

public class WorkingWithAjax_SuggestionList {
	private WebDriver oDriver;
	private String sUrl= "http://www.bing.com";
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
		WebElement oTextBox, oAjaxResultList;
		
		List<WebElement> oAllAjaxListElements;
		oTextBox = oDriver.findElement(By.id("sa_5017"));
		oTextBox.sendKeys("ipad");
		Thread.sleep(2000);
		
		oAjaxResultList = oDriver.findElement(By.id("suggestions"));
		oAllAjaxListElements = oAjaxResultList.findElements(By.tagName("div"));
		
		for( WebElement e : oAllAjaxListElements) {
			System.out.println(e.getText());
		}
	}

}



