package com.tls.liferaylms.test.util;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tls.liferaylms.report.BeanReportContext;
import com.tls.liferaylms.test.SeleniumTestCase;

public class CheckCourse {
	
	public static boolean checkCourse(WebDriver driver,String url){
		GetPage.getPage(driver, url, "");
		CheckPage.check(driver);
		
		SeleniumTestCase stc = new SeleniumTestCase();
		
		try{
			GetPage.getPage(driver, url, "/reto");
			
//			Sleep.sleep(3000);
			Sleep.waitForLoad(driver);
			
			WebElement portlet = driver.findElement(By.id("p_p_id_changeEditingMode_WAR_liferaylmsportlet_"));
			assertNotNull("Not portlet changeEditingMode"+stc.getLineNumber(), portlet);
			
//			WebElement configMenu = portlet.findElement(By.className("portlet-title-default"));
			WebElement configMenu = portlet.findElement(By.tagName("input"));
			assertNotNull("Input button not found in portlet changeEditingMode!"+stc.getLineNumber(), configMenu);
			
			try{
				configMenu.click();
				try{
					configMenu.click();
				}catch(Exception e){}
			}catch(Exception e){
				WebElement menuEdit = driver.findElement(By.id("_145_toggleControls"));
				assertNotNull("menuEdit not found after configMenu!"+stc.getLineNumber(), menuEdit);
				
				WebElement a = menuEdit.findElement(By.tagName("a"));
				assertNotNull("a element not found after configMenu!"+stc.getLineNumber(), a);
				
				a.click();
				if(!configMenu.isDisplayed()){
					a.click();
				}
				configMenu.click();
				try{
					configMenu.click();
				}catch(Exception e1){}
			}
			
//			Sleep.sleep(1000);
			Sleep.waitForLoad(driver);
			
//			WebElement config = driver.findElement(By.id("_changeEditingMode_WAR_liferaylmsportlet_hjzj_menu"));
			WebElement config = driver.findElement(By.id("_changeEditingMode_WAR_liferaylmsportlet_dhec_menu"));
			assertNotNull("dhec_menu not found in changeEditingMode"+stc.getLineNumber(), config);
			
			Actions actions = new Actions(driver);
			actions.moveToElement(config);
			actions.click();
			actions.perform();
//			config.click();
			Sleep.waitForLoad(driver);
			
//			WebElement configBut1 = driver.findElement(By.id("_changeEditingMode_WAR_liferaylmsportlet_hjzj_menuButton"));
			WebElement configBut1 = driver.findElement(By.id("_changeEditingMode_WAR_liferaylmsportlet_dhec_menuButton"));
			assertNotNull("dhec_menuButton not found in changeEditingMode"+stc.getLineNumber(), configBut1);
			
			actions = new Actions(driver);
			actions.moveToElement(configBut1);
			actions.click();
			actions.perform();
//			configBut1.click();
			Sleep.waitForLoad(driver);
	
//			WebElement configBut2 = driver.findElement(By.id("_changeEditingMode_WAR_liferaylmsportlet_hjzj_menu_configuration"));
			WebElement configBut2 = driver.findElement(By.id("_changeEditingMode_WAR_liferaylmsportlet_dhec_menu_configuration"));
			assertNotNull("dhec_menu_configuration not found in changeEditingMode"+stc.getLineNumber(), configBut2);
			
			actions = new Actions(driver);
			actions.moveToElement(configBut2);
			actions.click();
			actions.perform();
//			configBut2.click();
			
//			Sleep.sleep(2000);
			Sleep.waitForLoad(driver);
			
			Sleep.waitForSwitchFrame(driver, 0);
//			driver.switchTo().frame(0);
			Sleep.waitForLoad(driver);
	
			WebElement action = driver.findElement(By.id("courseteacher_ACTION_VIEW"));
			assertNotNull("Teacher check view not found"+stc.getLineNumber(), configBut2);
			action.click();

			action = driver.findElement(By.id("site-member_ACTION_VIEW"));
			assertNotNull("Site Member check view not found!"+stc.getLineNumber(), configBut2);
			action.click();
			
			WebElement submit = driver.findElement(By.className("aui-button-input-submit"));
			assertNotNull("input button configuration not found"+stc.getLineNumber(), configBut2);
			submit.click();
			
			Sleep.waitForLoad(driver);
 
			GetPage.getPage(driver, url, "/reto");
			
			CheckPage.check(driver);
			BeanReportContext.setCourseChecked(true);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
