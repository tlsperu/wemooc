package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import javax.swing.event.ChangeEvent;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.CourseActivityMenu;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;
import com.tls.liferaylms.test.util.TestProperties;

/**
 * @author Diego Renedo Delgado
 */
public class Bf_CheckActivityRestrictions extends SeleniumTestCase {
	String test = TestProperties.get("act.test");
	String scorm = TestProperties.get("act.scorm");

	@Test
	public void CheckRestrictions(){
		
		//TODO quitar!!**********************************************************
//		Context.setCoursePage("http://localhost:8080/es/web//test-1435047943668");
//		Context.setCourseId("1435047943668");
//		Context.setTestPage("http://localhost:8080/web/guest/test");
//		HashMap<String, String> activities = new HashMap<String, String>();
//		activities.put("Actividad de test 1435047943668","");
//		activities.put("Actividad r externo 1435047943668","");
//		activities.put("P2P 1435047943668","");
//		activities.put("Encuesta 1435047943668","");
//		activities.put("T Present 1435047943668","");
//		activities.put("Act desa 1435047943668","");
//		activities.put("R media 1435047943668","");
//		activities.put("Eval 1435047943668","");
//		activities.put("SCORM 1435047943668","");
//		Context.setActivities(activities);
		//QUITAR******************************************************************
		
		
//		Login login = new Login(driver, Context.getTeacherUser(), Context.getTeacherPass(), Context.getBaseUrl());
		Login login = new Login(driver, Context.getTeacherName(), Context.getTeacherPass(), Context.getBaseUrl());
		
		if(login.isLogin())
			login.logout();
		
		boolean teacherLogin = login.login();
		assertTrue("Error login teacher"+getLineNumber(),teacherLogin);
		
		Sleep.waitForLoad(driver);

		if(teacherLogin){
			GetPage.getPage(driver, Context.getCoursePage(), "/reto");
			
			Sleep.waitForLoad(driver);
			
			changeEditMode();
			
			Sleep.waitForLoad(driver);//sleep(2000);
			for(String id : Context.getActivities().keySet()){
				if(id.length()>test.length()&&id.substring(0, test.length()).equals(test)){
					  WebElement a = CourseActivityMenu.findElementActivityMenuEdit(driver,id);
					  assertNotNull("Edit link for Test not found"+getLineNumber(), a);

					  a.click();
					  Sleep.waitForLoad(driver);//sleep(2000);
						
//					  driver.switchTo().frame(0);
					  Sleep.waitForSwitchFrame(driver, 0);
					  
					  Sleep.waitForLoad(driver);
					  
					  openColapsables();
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement checkStart = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_startdate-enabledCheckbox"));
					  											
					  checkStart.click();
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement startYear = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_startYear"));
					  startYear.sendKeys("2019");
					  
					  Sleep.waitForLoad(driver);

					  WebElement bHolder = getElement(By.className("aui-button-holder"));
					  assertNotNull("Not bHolder found"+getLineNumber(), bHolder);
					  List<WebElement> inputs = getElements(bHolder,By.tagName("input"));
					  assertEquals("Menu inputs have size incorrect"+getLineNumber(), inputs.size(),2);

					  //Doubleclick
					  try{
						  inputs.get(0).click();
						  inputs.get(0).click();
						  
						  Sleep.waitForLoad(driver);
					  }catch(Exception e){}
				}
			}
			GetPage.getPage(driver, Context.getCoursePage(), "/reto");

			Sleep.waitForLoad(driver);

			changeEditMode();

			Sleep.waitForLoad(driver);//sleep(2000);
			
			WebElement newactivity = getElement(By.className("newactivity"));
			assertNotNull("Not newactivity button"+getLineNumber(), newactivity);

			WebElement aNew = getElement(newactivity,By.tagName("a"));
			assertNotNull("Not aNewnewactivity button"+getLineNumber(), aNew);
			aNew.click();

			Sleep.waitForLoad(driver);//sleep(2000);
			
//			driver.switchTo().frame(0);
			Sleep.waitForSwitchFrame(driver, 0);
			
			Sleep.waitForLoad(driver);

			WebElement activityList = getElement(By.className("activity-list"));
			assertNotNull("Not Activity list find"+getLineNumber(), activityList);

			List<WebElement> lis = getElements(activityList, By.tagName("li"));
			
			WebElement a = getElement(lis.get(1),By.tagName("a"));
			a.click();

			Sleep.waitForLoad(driver);//sleep(2000);
			
			WebElement titleAct = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_title_es_ES"));
			assertNotNull("Title activity not find"+getLineNumber(), titleAct);
			
			titleAct.sendKeys(TestProperties.get("act.test.pre")+" "+Context.getCourseId());
			sendCkEditorJS(driver,"act.test.pre");
			
			Sleep.waitForLoad(driver);
			
			WebElement form = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_fm"));
			assertNotNull("Not form activity found"+getLineNumber(), form);
			form.submit();
			
			Sleep.waitForLoad(driver);
			
			GetPage.getPage(driver, Context.getCoursePage(), "/reto");
			
			Sleep.waitForLoad(driver);
			
			changeEditMode();
			
			Sleep.waitForLoad(driver);

			for(String id : Context.getActivities().keySet()){
				if(id.length()>scorm.length()&&id.substring(0, scorm.length()).equals(scorm)){
					
					getLog().info("id!!!!!!!!-->"+id);
					
					a = CourseActivityMenu.findElementActivityMenuEdit(driver,id);
					assertNotNull("Edit link for Test not found"+getLineNumber(), a);

					a.click();
					Sleep.waitForLoad(driver);//sleep(2000);
						
//					driver.switchTo().frame(0);
					Sleep.waitForSwitchFrame(driver, 0);
					
					Sleep.waitForLoad(driver);
					  
					openColapsables();
					
					Sleep.waitForLoad(driver);
					
					WebElement precedence = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_precedence"));
					assertNotNull("Not precedence combo found"+getLineNumber(), precedence);
					
					precedence.sendKeys(TestProperties.get("act.test.pre"));

					WebElement bHolder = getElement(By.className("aui-button-holder"));
					  assertNotNull("Not bHolder found"+getLineNumber(), bHolder);
					  List<WebElement> inputs = getElements(bHolder,By.tagName("input"));
					  assertEquals("Menu inputs have size incorrect"+getLineNumber(), inputs.size(),2);
					  
					  //Doubleclick
					  try{
						  inputs.get(0).click();
						  inputs.get(0).click();
					  }catch(Exception e){}
	
					  Sleep.waitForLoad(driver);//sleep(2000);
					
					break;
				}
			}
		}
		
		GetPage.getPage(driver, Context.getCoursePage(), "/reto");
		
		Sleep.waitForLoad(driver);//sleep(2000);
		
//		login = new Login(driver, Context.getStudentUser(), Context.getStudentPass(), Context.getBaseUrl());
		login = new Login(driver, Context.getStudentName(), Context.getStudentPass(), Context.getBaseUrl());
		
		if(login.isLogin()){
			System.out.println("logout");
			login.logout();
		}
		
		boolean studentLogin = login.login();
		assertTrue("Error login student"+getLineNumber(),studentLogin);
		
		Sleep.waitForLoad(driver);

		if(studentLogin){
			GetPage.getPage(driver, Context.getCoursePage(), "/reto");
			
			Sleep.waitForLoad(driver);

			for(String id : Context.getActivities().keySet()){
				if(id.length()>scorm.length()&&id.substring(0, scorm.length()).equals(scorm)){
					WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
					assertNull("SCORM Activity should not be available"+getLineNumber(), a);
				}else if(id.length()>test.length()&&id.substring(0, test.length()).equals(test)){
					WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
					assertNull("Test Activity should not be available"+getLineNumber(), a);
				}
			}
			
			Sleep.waitForLoad(driver);//sleep(2000);
			
			WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,TestProperties.get("act.test.pre"));
			assertNotNull("Pre Activity not found"+getLineNumber(), a);
			a.click();

			Sleep.waitForLoad(driver);//sleep(2000);
			
			GetPage.getPage(driver, Context.getCoursePage(), "/reto");
			
			Sleep.waitForLoad(driver);

			for(String id : Context.getActivities().keySet()){
				if(id.length()>scorm.length()&&id.substring(0, scorm.length()).equals(scorm)){
					a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
					assertNotNull("SCORM Activity should be available"+getLineNumber(), a);
					
//					Sleep.waitForLoad(driver);
				}
			}
		}
	}
	
	private void changeEditMode(){
		WebElement editPortlet = getElement(By.id("p_p_id_changeEditingMode_WAR_liferaylmsportlet_"));
		assertNotNull("Not Edit portlet found"+getLineNumber(), editPortlet);
		
		List<WebElement> inputs = getElements(editPortlet,By.tagName("input"));
		assertEquals("Not Edit portlet found"+getLineNumber(), 1,inputs.size());
		inputs.get(0).click();
	}
	
	private void openColapsables(){
		List<WebElement> pcontainer = getElements(By.className("lfr-panel-titlebar"));
		assertNotNull("Not found pcontainer"+getLineNumber(), pcontainer);
		
		for(WebElement we : pcontainer){
			if(getLog().isInfoEnabled())getLog().info("Click::"+we.getText());
			try{
				we.click();
			}catch(Exception e){}
			List<WebElement> spans = getElements(we,By.tagName("span"));
			if(spans!=null){
				for(WebElement span : spans){
					try{
						span.click();
					}catch(Exception e){}
				}
			}
			List<WebElement> divs = getElements(we,By.tagName("div"));
			if(spans!=null){
				for(WebElement div : divs){
					try{
						div.click();
					}catch(Exception e){}
				}
			}
			Sleep.waitForLoad(driver);//sleep(1000);
		}
	}

	private void sendCkEditorJS(WebDriver driver,String prop){
		if (driver instanceof JavascriptExecutor) {
			StringBuilder sb = new StringBuilder("javascript:CKEDITOR.instances['_lmsactivitieslist_WAR_liferaylmsportlet_description'].setData('<p>");
			sb.append(TestProperties.get(prop));
			sb.append(" ");
			sb.append(Context.getCourseId());
			sb.append("</p>');");
		    ((JavascriptExecutor)driver).executeScript(sb.toString());
		}
	}
}
