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

public class WorkingWithTables {
	private WebDriver oDriver;
	private String sUrl= "http://www.seleniumhq.org/download/";
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
		
		WebElement oTable = oDriver.findElement(By.xpath("//*[@id=\"mainContent\"]/table[1]/tbody"));
		
		List<WebElement> rows = oTable.findElements(By.tagName("tr"));
		List<WebElement> cols;
		
		for( WebElement e : rows ) {
			cols = e.findElements(By.tagName("td"));
			for (WebElement  o : cols) {
				System.out.print(o.getText() + "     ");
			}
			System.out.println();
		}
		
	}

}



