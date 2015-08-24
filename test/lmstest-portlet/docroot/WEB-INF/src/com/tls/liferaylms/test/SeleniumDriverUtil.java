package com.tls.liferaylms.test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.JdkAugmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.internal.ApacheHttpClient;
import org.openqa.selenium.remote.service.DriverService;

public class SeleniumDriverUtil 
{
	 private static WebDriver driver;
	 public static WebDriver  getDriver() throws Exception 
	 {
		 if(driver==null)
		 {
		    try {
		    	//CONFIGURACIÓN LOCAL
//		    	// Optional, if not specified, WebDriver will search your path for chromedriver.
//		    	File f = new File(File.separator+"ChromeDriver"+File.separator+"chromedriver.exe");
//		    	File f = new File(".."+File.separator+"webapps"+File.separator+"lmstest-portlet"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"chromedriver.exe");
//
//		    	System.setProperty("webdriver.chrome.driver", f.getCanonicalPath());
//		    	driver = new ChromeDriver();
//				driver = new FirefoxDriver();
		    	
		    	//CONFIGURACIÓN REMOTA
//		    	String PROXY = "10.99.244.5:8080";
//		    	Proxy proxy = new Proxy();
//		    	
//		    	proxy.setHttpProxy		(PROXY)
//		    	     .setFtpProxy		(PROXY)
//		    	     .setSslProxy		(PROXY)
//		    	     .setSocksProxy		(PROXY)
//		    	     .setSocksUsername	("educaterra@educaterra")
//		    	     .setSocksPassword	("educaterra");
		    	     
//		    	Authenticator authenticator = new Authenticator() {
//
//		    	      public PasswordAuthentication getPasswordAuthentication() {
//		    	       return (new PasswordAuthentication("educaterra@educaterra", "educaterra".toCharArray()));
//		    	      }
//		    	     };
//		    	Authenticator.setDefault(authenticator);
		    	//proxy.
//		    	File f = new File(File.separator+"ChromeDriver"+File.separator+"chromedriver.exe");
//		    	System.setProperty("webdriver.chrome.driver", f.getCanonicalPath());
		    	
		    	final DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		    	capabilities.setCapability(CapabilityType.PAGE_LOADING_STRATEGY, value);
		    	
//		    	capabilities.setCapability(CapabilityType.PROXY, proxy);
		    	
//		    	driver = new RemoteWebDriver(new URL("http://"+myHostAddress+":4444/wd/hub") ,capabilities);
		    	driver = new RemoteWebDriver(new URL("http://10.102.226.84:4444/wd/hub") ,capabilities);
		    	
		    	ApacheHttpClient j = new ApacheHttpClient(null, null);
		    	
//		    	capabilities.
		    	
		    	driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		    	driver.manage().timeouts().setScriptTimeout(2000, TimeUnit.SECONDS);
		    	
//		    	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") ,capabilities);
//		    	driver = new HtmlUnitDriver(BrowserVersion.CHROME);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		 }
		 return driver;
	 }
	 public static void closeDriver()
	 {
//		 driver.close();
		 driver.quit();
		 driver=null;
	 }
}
