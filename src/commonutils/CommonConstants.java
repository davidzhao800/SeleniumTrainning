package commonutils;

public class CommonConstants {
	public static String sIEDriverPath = "C:\\Work\\DriverExes\\IEDriverServer.exe";
	public static String sChromeDriverPath = "C:\\Work\\DriverExes\\chromedriver.exe";
	public static String sFirefoxDriverPath = "C:\\Work\\DriverExes\\geckodriver.exe";
	
	public static boolean bUseProxy = false;
	public static String sProxyHost = "proxy.server.com";
	public static int iPort = 8080;
	
	public static long lngPageLoadTimeout = 60L;
	public static long lngImplictWaitTimeout = 30L;
	
	public static String sSnapshotFolderName = "C:\\Work\\Snapshots";
	
}
