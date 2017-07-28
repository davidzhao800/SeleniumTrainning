package commonutils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CommonLib {
	
	//---------------------------------------------------------------------
	
	public static WebDriver getDriver(int iBrowserType ) throws Exception {
		if (iBrowserType<1 || iBrowserType >4) {
			throw new Exception("Invalid BrowserType="+ iBrowserType);
		}
		
		WebDriver oDriver;
		
		updateCommonConstants();
		
		switch (iBrowserType) {
			case BrowserNames.IE: //ie
				System.setProperty("webdriver.ie.driver", CommonConstants.sIEDriverPath);
				oDriver = new InternetExplorerDriver(getCapability());
				break;
				
			case BrowserNames.Chrome:  //chrome
				System.setProperty("webdriver.chrome.driver", CommonConstants.sChromeDriverPath);
				oDriver = new ChromeDriver(getCapability());
				break;
			case BrowserNames.Firefox:  //firefox
				System.setProperty("webdriver.gecko.driver", CommonConstants.sFirefoxDriverPath);
				oDriver = new FirefoxDriver(getProfile());
				break;
	
			default:   //htmlunit
				//oDriver = new HtmlUnitDriver(getCapability());
				DesiredCapabilities oHtmlCap;
				oHtmlCap=getCapability();
				oHtmlCap.setBrowserName("htmlunit");
				oDriver = new HtmlUnitDriver(oHtmlCap);
				break;
		}
		
		if (iBrowserType != 4) {
			oDriver.manage().window().maximize();
		}
		
		oDriver.manage().timeouts().pageLoadTimeout(CommonConstants.lngPageLoadTimeout, TimeUnit.SECONDS);
		oDriver.manage().timeouts().implicitlyWait(CommonConstants.lngImplictWaitTimeout, TimeUnit.SECONDS);
		
		return oDriver;
	}
	
	//---------------------------------------------------------------------
	public static FirefoxProfile getProfile() throws Exception {
		FirefoxProfile oProfile = new FirefoxProfile();
		if (CommonConstants.bUseProxy) {
			oProfile.setPreference("network.proxy.type", 1);
			
			oProfile.setPreference("network.proxy.http", CommonConstants.sProxyHost);
			oProfile.setPreference("network.proxy.http_port", CommonConstants.iPort);
			
			oProfile.setPreference("network.proxy.ftp", CommonConstants.sProxyHost);
			oProfile.setPreference("network.proxy.ftp_port", CommonConstants.iPort);
			
			oProfile.setPreference("network.proxy.ssl", CommonConstants.sProxyHost);
			oProfile.setPreference("network.proxy.ssl_port", CommonConstants.iPort);

		} else {
			oProfile.setPreference("network.proxy.type", 0);
		}
		return oProfile;
	}
	//---------------------------------------------------------------------
	public static DesiredCapabilities getCapability() throws Exception {
		String sProxyString;
		DesiredCapabilities oCapability = new DesiredCapabilities();
		Proxy oProxy = new Proxy();
		
		sProxyString = CommonConstants.sProxyHost + ":" + CommonConstants.iPort;
		
		if (CommonConstants.bUseProxy) {
			oProxy.setProxyType(ProxyType.MANUAL);
			oProxy.setHttpProxy(sProxyString);
			oProxy.setFtpProxy(sProxyString);
			oProxy.setSslProxy(sProxyString);
		} else {
			
			oProxy.setProxyType(ProxyType.DIRECT);
		}
		oCapability.setCapability("proxy", oProxy);
		return oCapability;
	}
	//---------------------------------------------------------------------
	public static boolean isElementExists(WebDriver oDriver, By oBy) {
		oDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean bElementFound = false;
		
		try {
			oDriver.findElement(oBy);
			bElementFound = true;
		} catch (NoSuchElementException e) {
			bElementFound = false;
		} catch (Exception e) {
			bElementFound = false;
			e.printStackTrace();
		}
		
		oDriver.manage().timeouts().implicitlyWait(CommonConstants.lngImplictWaitTimeout, TimeUnit.SECONDS);
		return bElementFound;
	}
	//---------------------------------------------------------------------
	private static void updateCommonConstants() throws Exception {
		Properties oProperties = getProperties("AutomationInputs.properties");
		CommonConstants.sIEDriverPath = oProperties.getProperty("ie.driver.path").trim();
		CommonConstants.sChromeDriverPath = oProperties.getProperty("chrome.driver.path").trim();
		CommonConstants.sFirefoxDriverPath = oProperties.getProperty("gecko.driver.path").trim();
		
		CommonConstants.sProxyHost = oProperties.getProperty("proxy.host.name").trim();
		CommonConstants.iPort = Integer.valueOf(oProperties.getProperty("proxy.port").trim());
		CommonConstants.bUseProxy = Boolean.valueOf(oProperties.getProperty("proxy.use").trim());
		
		CommonConstants.lngPageLoadTimeout = Long.valueOf(oProperties.getProperty("page.load.timeout").trim());
		CommonConstants.lngImplictWaitTimeout = Long.valueOf(oProperties.getProperty("implicit.wait.timeout").trim());
		
		CommonConstants.sSnapshotFolderName = oProperties.getProperty("snapshot.folder.name").trim();
	}
	//---------------------------------------------------------------------
	
	public static Properties getProperties(String sPropertyFileName) throws Exception{
		Properties oProperties = new Properties();
		InputStream oFileReader = new FileInputStream(sPropertyFileName);
		
		oProperties.load(oFileReader);
		return oProperties;
	}
	
	public static By getByObject (String sLocatorString) throws Exception {
		String[] arrLocatorParts;
		String sLocatorType, sLocatorValue;
		
		if(! sLocatorString.contains(":=")) {
			System.err.print("Missing delimeter ':=' in Locator = " + sLocatorString);
		}
		
		arrLocatorParts= sLocatorString.split(":=");
		sLocatorType = arrLocatorParts[0].trim();
		sLocatorValue = arrLocatorParts[1].trim();
		
		if (sLocatorType.equalsIgnoreCase("id")) {
			return By.id(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("name")) {
			return By.name(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("link")) {
			return By.linkText(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("xpath")) {
			return By.xpath(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("css")) {
			return By.cssSelector(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("class")) {
			return By.className(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("tagname")) {
			return By.tagName(sLocatorValue);
		}
		if (sLocatorType.equalsIgnoreCase("partiallink")) {
			return By.partialLinkText(sLocatorValue);
		}
		
		System.err.println("Invalid locator type = " + sLocatorType);
		return null;
		
	}
	
	public static String getDateTimeStamp() {
		return new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
	}
	
}
