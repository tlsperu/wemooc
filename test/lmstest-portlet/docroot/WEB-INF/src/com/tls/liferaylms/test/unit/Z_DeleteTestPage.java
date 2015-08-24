package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.CheckPage;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;

/**
 * @author Diego Renedo Delgado
 */
public class Z_DeleteTestPage extends SeleniumTestCase {

	  @Test
	  public void testDeletePage() throws Exception {
		  try{
			if(getLog().isInfoEnabled())getLog().info("init");
			Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());
			boolean loged = login.login();
			assertTrue("Error not logued"+getLineNumber(),loged);
			
			Sleep.waitForLoad(driver);
			
			if (loged) {
				GetPage.getPage(driver, "", Context.getTestPage());
				Sleep.waitForLoad(driver);//sleep(1000);
				
				if(getLog().isInfoEnabled())getLog().info("Delete page...");
				WebElement menu = getElement(By.id("_145_manageContent"));
				assertNotNull("Not Admin Menu"+getLineNumber(), menu);

//				menu.click();
//				menu.click();
				Actions actions = new Actions(driver);
				actions.doubleClick(menu);
				
//				Sleep.waitForLoad(driver);
				
				WebElement managePage = getElement(By.id("_145_manageContentContainer"));
				assertNotNull("Not manage page Menu"+getLineNumber(), managePage);
				WebElement aHref = getElement(managePage, By.tagName("a"));
			//	aHref.click();
				
				actions.moveToElement(aHref);
				actions.click();
				actions.perform();

				Sleep.waitForLoad(driver);//sleep(3000);

				if(getLog().isInfoEnabled())getLog().info("Switch frame");
//				driver.switchTo().frame(0);
				Sleep.waitForSwitchFrame(driver, 0);
				
				Sleep.waitFor(By.className("aui-icon-delete"), driver);

				if(getLog().isInfoEnabled())getLog().info("Try delete");
				WebElement iconDelete = getElement(By.className("aui-icon-delete"));
				assertNotNull("Not delete page Menu"+getLineNumber(), iconDelete);
				iconDelete.click();
				
//				Sleep.waitForLoad(driver);
				
				Alert confirm =driver.switchTo().alert();
				Sleep.waitForLoad(driver);
				confirm.accept();
				Sleep.waitForLoad(driver);
				
				GetPage.getPage(driver, "", Context.getTestPage());
				Sleep.waitForLoad(driver);
				
				assertNotEquals("Errors in page"+getLineNumber(),0,CheckPage.checkForErrors(driver));
			}
		  }catch(Exception e){
			  e.printStackTrace();
		  }
			
		  if(getLog().isInfoEnabled())getLog().info("end ok");
	  }
}
