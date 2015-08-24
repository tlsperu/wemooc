package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.tls.liferaylms.report.BeanReportContext;
import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.InstancePortlet;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;

/**
 * @author Diego Renedo Delgado
 */
public class Bb_CheckUsers extends SeleniumTestCase {

	  @Test
	  public void testUsers() throws Exception {
		  if(getLog().isInfoEnabled())getLog().info("init");
	
			//Sleep.waitForLoad(driver);
		  
			GetPage.getPage(driver, "", Context.getTestPage());
			
//			Sleep.waitForLoad(driver);

			Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());
			boolean loged = login.isLogin();
			assertTrue("Error not logued"+getLineNumber(),loged);
			
			assertNotEquals("Error not course created"+getLineNumber(),"",Context.getTestPage().equals(""));
			
			boolean instance = InstancePortlet.createInstance(driver, "administraci\u00f3n de clases", "portlet_courseadmin_WAR_liferaylmsportlet");
			assertTrue("Error instance portlet portlet_courseadmin_WAR_liferaylmsportlet"+getLineNumber(), instance);
			if(!instance){
				//Recargamos
				testUsers();
			}
			else{
				try{
					
					//Add Teacher in course
					if(getLog().isInfoEnabled())getLog().info("Starting test");
	
//					Sleep.sleep(4000);
					Sleep.waitForLoad(driver);
					
					WebElement form = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_search"));
					assertNotNull("formSearch not Find"+getLineNumber(), form);
					
					WebElement freetext = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_freetext"));
					assertNotNull("Freetext not Find"+getLineNumber(), freetext);
					if(getLog().isInfoEnabled())getLog().info("CourseId::"+Context.getCourseId());
					if(!freetext.getText().equals(Context.getCourseId())){
						for(int i=0;i<40;i++){
							freetext.sendKeys(Keys.BACK_SPACE);
						}
						if(getLog().isInfoEnabled())getLog().info("Put course::"+Context.getCourseId());
						freetext.sendKeys(String.valueOf(Context.getCourseId()));	
					}
					
					WebElement formSearch = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_search"));
					assertNotNull("formSearch not Find"+getLineNumber(), formSearch);
					
					WebElement butForm = getElement(formSearch,By.className("aui-button-input-submit")); 
					assertNotNull("submit Search not Find"+getLineNumber(), butForm);
					butForm.click();

//					Sleep.sleep(2000);
					Sleep.waitForLoad(driver);
					
					WebElement searchLayout = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainerSearchContainer"));
					assertNotNull("Not form Search"+getLineNumber(), searchLayout);
					
					List<WebElement> as = getElements(searchLayout, By.tagName("tr"));
	
					if(getLog().isInfoEnabled())getLog().info("Course Size::"+as.size());
					
					assertEquals("Course not find"+getLineNumber(), as.size(),3);
					
					WebElement menuButton = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainer_1_menuButton"));
					assertNotNull("Course Admin not Find menuButton"+getLineNumber(), menuButton);
					menuButton.click();
//					Sleep.sleep(2000);
					Sleep.waitFor(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainer_1_menu_assign-member"), driver);
	
					WebElement courseMembers = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainer_1_menu_assign-member"));
					assertNotNull("Course Admin not Find members Button"+getLineNumber(), courseMembers);
					
					courseMembers.click();
//					Sleep.sleep(2000);
					Sleep.waitForLoad(driver);
					
					WebElement tab = getElement(By.className("aui-tabview-list"));
					assertNotNull("Course Users tab not found"+getLineNumber(), tab);
					List<WebElement> lis = getElements(tab,By.tagName("li")); 
					assertEquals("Course Users tab lists not Find"+getLineNumber(), lis.size(),3);
					
					if(getLog().isInfoEnabled())getLog().info("Tab Size::"+lis.size());
					if(lis.size()==3){
						if(getLog().isInfoEnabled())getLog().info("Move to menu");
						WebElement btTab = getElement(lis.get(2),By.tagName("a"));
						btTab.click();

						Sleep.waitForLoad(driver);
						
						addUser(Context.getTeacherUser());
						BeanReportContext.setSubTeacherAsign(true);
					}
					
					tab = getElement(By.className("aui-tabview-list"));
					assertNotNull("Course Users tab not found"+getLineNumber(), tab);
					lis = getElements(tab,By.tagName("li")); 
					assertEquals("formSearch not But not Find"+getLineNumber(), lis.size(),3);
					
					if(getLog().isInfoEnabled())getLog().info("Tab Size::"+lis.size());
					if(lis.size()==3){
						if(getLog().isInfoEnabled())getLog().info("Move to menu");
						WebElement btTab = getElement(lis.get(1),By.tagName("a"));
						btTab.click();

						Sleep.waitForLoad(driver);
						
						addUser(Context.getTeacherUser());
						BeanReportContext.setTeacherAsign(true);
					}
					//Sleep.sleep(2000);
					Sleep.waitForLoad(driver);

					//Add Students in course
					tab = getElement(By.className("aui-tabview-list"));
					assertNotNull("Course Users tab not found"+getLineNumber(), tab);
					lis = getElements(tab,By.tagName("li")); 
					assertEquals("formSearch not But not Find"+getLineNumber(), lis.size(),3);

					if(getLog().isInfoEnabled())getLog().info("Tab Size::"+lis.size());
					if(lis.size()==3){
						if(getLog().isInfoEnabled())getLog().info("Move to menu");
						WebElement btTab = getElement(lis.get(0),By.tagName("a"));
						btTab.click();

//						Sleep.sleep(1000);
						Sleep.waitForLoad(driver);
						
						addUser(Context.getStudentUser());
						BeanReportContext.setStudentAsign(true);
						addUser(Context.getStudentUser2());
						BeanReportContext.setStudent2Asign(true);
					}

					GetPage.getPage(driver, "", Context.getTestPage());
//					Sleep.sleep(2000);
					Sleep.waitForLoad(driver);
					
					menuButton = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainer_1_menuButton"));
					assertNotNull("Course Admin not Find menuButton"+getLineNumber(), menuButton);
					menuButton.click();
//					Sleep.sleep(1000);
					Sleep.waitForLoad(driver);
	
					courseMembers = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainer_1_menu_courseadmin.adminactions.permissions"));
					assertNotNull("Course Admin not Find memebers Button"+getLineNumber(), courseMembers);
					courseMembers.click();
//					Sleep.sleep(2000);
					Sleep.waitForLoad(driver);
					
					WebElement input = getElement(By.id("user_ACTION_ACCESS"));
					assertNotNull("No input found for permissions"+getLineNumber(), input);
					input.click();
					
					WebElement submit = getElement(By.className("aui-button-input-submit"));
					assertNotNull("Not submit found"+getLineNumber(), submit);

					try{
						submit.click();
						submit.click();
					}catch(Exception e){}
					

					GetPage.getPage(driver, "", Context.getTestPage());
					
					//No hace nada
//					form = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_search"));
//					
//					freetext = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_freetext"));
//					assertNotNull("Freetext not Find"+getLineNumber(), freetext);
//					if(freetext.getText().equals(Context.getCourseId())){
//						for(int i=0;i<40;i++){
//							freetext.sendKeys(Keys.BACK_SPACE);
//						}
//						freetext.sendKeys(String.valueOf(Context.getCourseId()));
//					}
//					
//					formSearch = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_search"));
//					assertNotNull("formSearch not Find"+getLineNumber(), formSearch);
//					
//					butForm = getElement(formSearch,By.className("aui-button-input-submit"));
//					assertNotNull("formSearch not But Find"+getLineNumber(), butForm);
//					butForm.click();

//					Sleep.sleep(2000);
//					Sleep.waitForLoad(driver);
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			if(getLog().isInfoEnabled())getLog().info("End");
	  }
	  
	  private void addUser(String email){
//		  	Sleep.sleep(1000);
		  	Sleep.waitForLoad(driver);
		  
			WebElement btNewUser = getElement(By.className("bt_newuser"));
			assertNotNull("User Course Button menu not find"+getLineNumber(), btNewUser);
			WebElement aAddUser = getElement(btNewUser,By.tagName("a")); 
			assertNotNull("User Course Button not find"+getLineNumber(), aAddUser);
			aAddUser.click();

//			Sleep.sleep(2000);
			Sleep.waitForLoad(driver);
			
			WebElement emailAddress = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_emailAddress"));
			assertNotNull("User Course emailAddress not find"+getLineNumber(), emailAddress);
			emailAddress.clear();
			emailAddress.sendKeys(email);
			
			WebElement button = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_searchUsers"));
			assertNotNull("User search course button not find"+getLineNumber(), button);
			button.click();
			
//			Sleep.sleep(1000);
			Sleep.waitForLoad(driver);

			WebElement container = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_usersSearchContainerSearchContainer"));
			assertNotNull("User Course search container not find"+getLineNumber(), container);

//			List<WebElement> las = getElements(container,By.className("newitem2"));
//			List<WebElement> las = getElements(container,By.tagName("a"));
			WebElement td = getElement(container, By.id("_courseadmin_WAR_liferaylmsportlet_usersSearchContainer_col-2_row-1"));
			
			List<WebElement> las = getElements(td,By.tagName("a"));
			
			assertNotNull("No users in te result"+getLineNumber(),las);
			assertEquals("Many users in te result"+getLineNumber(),2, las.size());

			las.get(0).click();

//			Sleep.sleep(2000);
			Sleep.waitForLoad(driver);
			
			List<WebElement> button_content = getElements(By.className("aui-button-content"));
			
			WebElement submit = getElement(button_content.get(1), By.tagName("input"));
			submit.click();
			
			Sleep.waitForLoad(driver);
	  }
}
