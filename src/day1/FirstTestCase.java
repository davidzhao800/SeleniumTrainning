package day1;

import org.openqa.selenium.WebDriver;
import commonutils.BrowserNames;
import commonutils.CommonLib;

public class FirstTestCase {

	public static void main (String[] args) throws Exception {
		WebDriver oDriver;
		
		oDriver = CommonLib.getDriver(BrowserNames.HtmlUnit);
		oDriver.get("http://www.seleniumhq.org");
		Thread.sleep(3000);
		System.out.println(oDriver.getTitle());
		oDriver.quit();
	}
}
