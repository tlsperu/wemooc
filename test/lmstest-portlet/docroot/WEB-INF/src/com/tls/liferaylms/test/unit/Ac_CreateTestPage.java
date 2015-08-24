package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tls.liferaylms.report.BeanReportContext;
import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.CheckPage;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;

/**
 * @author Diego Renedo Delgado
 */
public class Ac_CreateTestPage extends SeleniumTestCase {

	@Test
	public void testCreatePage() throws Exception {
		if(getLog().isInfoEnabled())getLog().info("init");
		try{
//			Sleep.sleep(2000);
			Sleep.waitForLoad(driver);
			GetPage.getPage(driver, Context.getBaseUrl(), "/");
			
			WebElement navigationPre = getElement(By.id("navigation"));			
			List<WebElement> ahrefsPre = getElements(navigationPre, By.tagName("a"));
			for(WebElement a : ahrefsPre){
				if(getLog().isInfoEnabled())getLog().info("Check::"+a.getText());
				if(a.getText().equalsIgnoreCase("test")){
					Context.setTestPage(a.getAttribute("href"));
					break;
				}
			}
			if(!Context.getTestPage().isEmpty()){
				GetPage.getPage(driver, "", Context.getTestPage());
				assertEquals("Errors in page"+getLineNumber(),0,CheckPage.checkForErrors(driver));
				Context.setTest(true);
				return;
			}
			
			Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());
			boolean loged = login.isLogin();
			assertTrue("Error not logued"+getLineNumber(),loged);
			if (loged) {
				if(getLog().isInfoEnabled())getLog().info("Add page...");
				
				//Sleep.waitFor(By.id("_145_addContent"), driver);
				WebElement menu = getElement(By.id("_145_addContent"));
				assertNotNull("Not Admin Menu"+getLineNumber(), menu);
				
				Actions actions = new Actions(driver);
				actions.doubleClick(menu);

				WebElement addPage = getElement(By.id("addPage"));
				assertNotNull("Not Add page Menu"+getLineNumber(), addPage);
				
				actions.moveToElement(addPage);
				actions.click();
				actions.perform();
				
				WebElement navigation = getElement(By.id("navigation"));
				WebElement addPageTextLayout = getElement(navigation,By.className("add-page"));
				
//				if(addPageTextLayout==null){
//					List<WebElement> ahrefs = getElements(navigation, By.tagName("a"));
//					List<String> aNames = new ArrayList<String>();
//					for(WebElement a : ahrefs){
//						if(getLog().isInfoEnabled())getLog().info("href::"+a.getAttribute("href"));
//						aNames.add(a.getAttribute("href"));
//					}
//					for(String a : aNames){
//						GetPage.getPage(driver, "", a);
//						Sleep.sleep(3000);
//						Sleep.waitForLoad(driver);
//						addPageTextLayout = getAddPageElement();
//						if(addPageTextLayout!=null){
//							break;
//						}
//					}
//				}
				assertNotNull("Not Add page text layout"+getLineNumber(), addPageTextLayout);
				
//				WebElement addPageText = getElement(addPageTextLayout,By.tagName("input"));
				WebElement addPageText = addPageTextLayout.findElement(By.tagName("input"));
				assertNotNull("Not Add page text"+getLineNumber(), addPageText);
				
				addPageText.sendKeys("test");
				
				WebElement saveButton = getElement(addPageTextLayout,By.id("save"));
				assertNotNull("Not Add page save button"+getLineNumber(), saveButton);
				//addPageText.sendKeys(Keys.RETURN);
				//addPageText.sendKeys(Keys.ENTER);
				saveButton.click();
				
				Sleep.waitForLoad(driver);
				Sleep.sleep(1000);
				
				GetPage.getPage(driver, Context.getBaseUrl(), "/");
				
//				Sleep.waitForLoad(driver);
				
				navigation = getElement(By.id("navigation"));
				List<WebElement> ahrefs = getElements(navigation, By.tagName("a"));
				for(WebElement a : ahrefs){
					if(getLog().isInfoEnabled())getLog().info("Check::"+a.getText());
					if(a.getText().equals("test")){
						Context.setTestPage(a.getAttribute("href"));
						BeanReportContext.setCreateTestPage(true);
						break;
					}
				}
				
				GetPage.getPage(driver, "", Context.getTestPage());
				
//				Sleep.waitForLoad(driver);
				
				assertEquals("Errors in page"+getLineNumber(),0,CheckPage.checkForErrors(driver));
				
				Context.setTest(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(getLog().isInfoEnabled())getLog().info("end ok");
	}
	
	private WebElement getAddPageElement(){
		WebElement menu = getElement(By.id("_145_addContent"));
		assertNotNull("Not Admin Menu"+getLineNumber(), menu);
		
		menu.click();
		menu.click();
		
		Sleep.waitForLoad(driver);
		
		WebElement addPage = getElement(By.id("addPage"));
		
		if(getLog().isInfoEnabled())getLog().info("addPage::"+addPage);
		assertNotNull("Not Add page Menu"+addPage+getLineNumber(), addPage);
		if(getLog().isInfoEnabled())getLog().info("clicking::");
		addPage.click();
		if(getLog().isInfoEnabled())getLog().info("clicked::");
		
		Sleep.waitForLoad(driver);
		
		WebElement navigation = getElement(By.id("navigation"));
		assertNotNull("Not Found navigation"+getLineNumber(), navigation);
		
		WebElement addPageTextLayout = getElement(navigation,By.className("add-page"));
		
		if(getLog().isInfoEnabled())getLog().info("returnPage::"+addPageTextLayout);
		return addPageTextLayout;
	}
}
