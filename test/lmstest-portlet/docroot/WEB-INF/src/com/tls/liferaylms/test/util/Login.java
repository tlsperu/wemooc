package com.tls.liferaylms.test.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.tls.liferaylms.report.BeanReportContext;

public class Login {
	private static Log log = LogFactoryUtil.getLog(Login.class);
	private static String b = Keys.BACK_SPACE.toString();
	
	WebDriver driver = null;
	String user = null;
	String pass = null;
	String path = null;

	public Login(WebDriver driver,String user,String pass,String path) {
		super();
		this.driver = driver;
		this.user = user;
		this.pass = pass;
		this.path = path;
	}

	public boolean login(){
		try{
//			GetPage.getPage(driver,path,"");
			
//			WebElement singin =getElement(By.id("sign-in"));
//			if(singin!=null) {
//				log.info("singin::"+singin);
//				singin.click();
//			}else{
//				GetPage.getPage(driver,path,"/c/portal/login");
				GetPage.getPage(driver,path,"/login");
//			}
//			Sleep.sleep(1000);
//			Sleep.waitForLoad(driver);
			
			try{
				WebElement login = getElement(By.id("_58_login"));
	
				login.clear();
				login.sendKeys(user);
				driver.findElement(By.id("_58_password")).sendKeys(pass);
				driver.findElement(By.id("_58_fm")).submit();
//				Sleep.sleep(2000);
				Sleep.waitForLoad(driver);
			}catch(NoSuchElementException e){
				return false;
			}catch(NullPointerException e){
				return false;
			}
			
			boolean changePass =false;
			try{
				WebElement portlet = driver.findElement(By.id("portlet_terms-of-use"));
				WebElement submit = portlet.findElement(By.className("aui-button-input-submit"));
				submit.click();
				
//				Sleep.sleep(1000);
				Sleep.waitForLoad(driver);

			}catch(NoSuchElementException nsee){
				//nsee.printStackTrace();
			}
			
			try{
				WebElement password1 = driver.findElement(By.id("password1"));
				password1.sendKeys(pass+1);

				WebElement password2 = driver.findElement(By.id("password2"));
				password2.sendKeys(pass+1);

				WebElement fm = driver.findElement(By.id("fm"));
				if(fm!=null){
					fm.submit();
				}
				Sleep.waitForLoad(driver);
				changePass=true;
			}catch(NoSuchElementException nsee){
				
			}
//			Sleep.sleep(2000);
			try{
				WebElement portletReminder = driver.findElement(By.id("portlet_password-reminder"));
				if(portletReminder!=null){
					WebElement input = portletReminder.findElement(By.className("aui-button-input-submit"));
					if(input!=null){
						WebElement reminderQ = portletReminder.findElement(By.id("reminderQueryAnswer"));
						if(reminderQ!=null){
							reminderQ.sendKeys(pass);
						}
						input.click();
						changePass=true;
						Sleep.waitForLoad(driver);
					}
				}
				
			}catch(NoSuchElementException nsee){
				//nsee.printStackTrace();
			}

			try{
				if(changePass){
//					WebElement avatar = driver.findElement(By.id("_145_userAvatar"));
//					
//					List<WebElement> imgs = avatar.findElements(By.tagName("a"));
//					if(imgs.size()>1){
//						imgs.get(0).click();
//						Sleep.waitForLoad(driver);
//					}
////					Sleep.sleep(3000);
//					Sleep.waitForSwitchFrame(driver, 0);
//					
////					Sleep.waitFor(By.id("_2_passwordLink"), driver);
//					
//					WebElement passLink = driver.findElement(By.id("_2_passwordLink"));
//					passLink.click();
					
					//En vez de hacerlo desde el "Avatar", se hará desde "Mi página"
					GetPage.getPage(driver, Context.getBaseUrl(), "/mi-pagina");
					
					WebElement container = getElement(By.id("changebuttons"));
					List<WebElement> links = container.findElements(By.tagName("a"));
					
					links.get(1).click();
					
					Sleep.waitForLoad(driver);
	
//					WebElement pass0 = driver.findElement(By.id("_2_password0"));
					WebElement pass0 = driver.findElement(By.id("_miprofile_WAR_socialnetworkingportlet_passwordactual"));
					pass0.sendKeys(pass+1);
					
//					WebElement pass1 = driver.findElement(By.id("_2_password1"));
					WebElement pass1 = driver.findElement(By.id("_miprofile_WAR_socialnetworkingportlet_password"));
					pass1.sendKeys(pass);
	
//					WebElement pass2 = driver.findElement(By.id("_2_password2"));
					WebElement pass2 = driver.findElement(By.id("_miprofile_WAR_socialnetworkingportlet_password2"));
					pass2.sendKeys(pass);
					
					WebElement submitPass = driver.findElement(By.className("aui-button-input-submit"));
					submitPass.click();
					
					Sleep.waitForLoad(driver);
				}
			}catch(NoSuchElementException nsee){
//				nsee.printStackTrace();
				return false;
			}
			
		}catch(Exception e){
//			e.printStackTrace();
			return false;
		}
		WebElement webElement = null;
		try{
//			webElement = driver.findElement(By.className("sign-out"));
			webElement = driver.findElement(By.id("userName"));
		}catch(Exception e){
			
		}
		if(webElement==null){
			if(log.isInfoEnabled())log.info("login:false");
			return false;
		}else{
			if(log.isInfoEnabled())log.info("login:true");
			BeanReportContext.setHasLogin(true);
			return true;
		}
	}
	
	public boolean isLogin(){
		try{
//			WebElement span = getElement(By.id("p_145"));
			WebElement span = getElement(By.id("userName"));
			if(span==null){
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

	public boolean logout(){
		/*WebElement we = getElement(By.className("sign-out"));
		if(we!=null){
			we.click();
			if(isLogin()){
				return true;
			}else{
				return false;
			}
		}*/
		
		GetPage.getPage(driver, path, "/c/portal/logout");
		Sleep.waitForLoad(driver);
		return true;
	}
	
	private WebElement getElement(By by){
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		} catch (ElementNotFoundException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}
}
