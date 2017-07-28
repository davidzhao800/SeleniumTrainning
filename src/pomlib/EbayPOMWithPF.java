package pomlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EbayPOMWithPF {
	
	@FindBy(id="gh-ac")
	public WebElement oSearchBox;
	
	@FindBy(id="gh-btn")
	public WebElement oSearchButton;
	
	@FindBy(id="gh-cat")
	private WebElement oCategory;
	
	@FindBy(className="listingscnt")
	public WebElement oResultCountLabel;
	
	public Select oCategoryListBox;
	
	public EbayPOMWithPF(WebDriver oDriver) throws Exception {
		PageFactory.initElements(oDriver, this);
		
		oCategoryListBox = new Select (oCategory);
	
	}
}
