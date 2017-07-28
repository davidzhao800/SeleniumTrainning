package commonutils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverLib {
	private WebDriver oDriver;
	
	public WebDriverLib(WebDriver driver) throws Exception {
		this.oDriver = driver;
	}
	
	public void setText(By oBy, String sValue) throws Exception{
		oDriver.findElement(oBy).clear();
		oDriver.findElement(oBy).sendKeys(sValue);
	}
	
	public void setTextUsingJS(By oBy, String sValue) throws Exception{
		
		WebElement oTextBox = oDriver.findElement(oBy);
		JavascriptExecutor oJsEngine = (JavascriptExecutor) oDriver ;
		
		String sCommand = String.format("arguments[0].value='%s'", sValue);
		oJsEngine.executeScript(sCommand, oTextBox);
	}
	
	public void clickElement(By oBy) throws Exception {
		oDriver.findElement(oBy).click();
	}
	
	public void clickElementUsingJS(By oBy) throws Exception {
		WebElement oElemetn = oDriver.findElement(oBy);
		JavascriptExecutor oJsEngine = (JavascriptExecutor) oDriver ;
		oJsEngine.executeScript("arguments[0].click()", oElemetn);
	}
	
	public String getText(By oBy) throws Exception {
		return oDriver.findElement(oBy).getText();
	}
	
	public void selectItem(By oBy, String sVisibleText) throws Exception {
		WebElement oElement = oDriver.findElement(oBy);
		Select oListBox = new Select(oElement);
		oListBox.selectByVisibleText(sVisibleText);
	}
	
	public void moveMouseToElement(By oBy) throws Exception {
		WebElement oElement = oDriver.findElement(oBy);
		Actions oMouse = new Actions (oDriver); 
		oMouse.moveToElement(oElement).perform();
	}
}
