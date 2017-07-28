package pomlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TryPagePOM {
	
	public TryPagePOM(WebDriver oDriver) throws Exception {
		if ( !oDriver.getCurrentUrl().equals("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert")) {
			throw new Exception("This is not the js alert try age!");
		}
	}
}
