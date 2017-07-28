package pomlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayHomePagePOM {
	public WebElement oSearchBox;
	public WebElement oSearchButton;
	public Select oCategoryListBox;
	
	
	public EbayHomePagePOM(WebDriver oDriver) throws Exception {
		oSearchBox = oDriver.findElement(By.id("gh-ac"));
		oSearchButton = oDriver.findElement(By.id("gh-btn"));
		oCategoryListBox = new Select (oDriver.findElement(By.id("gh-cat")));
	}
}
