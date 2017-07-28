package pomlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayResultPagePOM {
	public WebElement oSearchBox;
	public WebElement oSearchButton;
	public Select oCategoryListBox;
	
	public WebElement resultCountLabel;
	
	public EbayResultPagePOM(WebDriver oDriver) throws Exception {
		resultCountLabel = oDriver.findElement(By.className("listingscnt"));
	}
}
