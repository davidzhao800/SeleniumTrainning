package pomlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TutorialPagePOM {
	public WebElement tryButton;
	
	public TutorialPagePOM(WebDriver oDriver) throws Exception {
		if ( !oDriver.getCurrentUrl().equals("https://www.w3schools.com/js/js_popup.asp")) {
			throw new Exception("This is not the js alert page!");
		}
		
		tryButton = oDriver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/a"));
	}
}
