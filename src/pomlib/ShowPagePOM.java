package pomlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShowPagePOM {
	public WebElement alertButton;
	
	public ShowPagePOM(WebDriver oDriver) throws Exception {
		
		alertButton = oDriver.findElement(By.xpath("/html/body/button"));
	}
}
