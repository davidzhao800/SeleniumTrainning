package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import commonutils.CommonConstants;
import commonutils.CommonLib;
import commonutils.MyWDListener;

public class WorkWithEventFiringWebDriver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EventFiringWebDriver oDriver;
		WebDriver oTmpDriver;
		
		//System.setProperty("webdriver.ie.driver", CommonConstants.sIEDriverPath);
		//oTmpDriver = new InternetExplorerDriver(CommonLib.getCapability());
		
		System.setProperty("webdriver.chrome.driver", CommonConstants.sChromeDriverPath);
		oTmpDriver = new ChromeDriver(CommonLib.getCapability());
		
		oDriver = new EventFiringWebDriver(oTmpDriver);
		oDriver.register(new MyWDListener());
		oDriver.get("http://seleniumhq.org");
		
		Thread.sleep(2000);
		
		oDriver.findElement(By.linkText("Download")).click();
		Thread.sleep(2000);
		
		oDriver.findElement(By.linkText("login")).click();
	}

}
