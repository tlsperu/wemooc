package com.tls.liferaylms.test.unit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tls.liferaylms.report.BeanReportContext;
import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.CheckCourse;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.InstancePortlet;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;
import com.tls.liferaylms.test.util.TestProperties;

/**
 * @author Diego Renedo Delgado
 */
public class Ba_AdminCourse extends SeleniumTestCase {

  @Test
  public void testAdminCourse() throws Exception {
	  if(getLog().isInfoEnabled())getLog().info("init");
		Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());
		boolean loged = login.isLogin();
		assertTrue("Error not logued",loged);
		
		if (loged) {
			if(Context.isTest()){
				try{
					Sleep.waitForLoad(driver);
					GetPage.getPage(driver, Context.getTestPage(), "");
//					Sleep.waitForLoad(driver);
					boolean instance = InstancePortlet.createInstance(driver, "administraci\u00f3n de clases", "portlet_courseadmin_WAR_liferaylmsportlet");
					assertTrue("Error instance portlet portlet_courseadmin_WAR_liferaylmsportlet"+getLineNumber(), instance);
					if(instance){
						//Check is visible
						WebElement confMenu = getElement(By.id("portlet-topper-toolbar_courseadmin_WAR_liferaylmsportlet"));
//						WebElement confMenu = getElement(By.id("portlet-borderless-bar"));
						assertNotNull("Not confMenu find", confMenu);
						
						List<WebElement> as = getElements(confMenu, By.tagName("a"));
						assertEquals("Menus have size incorrect"+getLineNumber(), as.size(),7);
						
						as.get(0).click();
						
//						Sleep.waitForLoad(driver);
						
						as.get(0).click();
						
						Sleep.waitForLoad(driver);
						
						WebElement menu = driver.findElement(By.className("lfr-menu-list-overflow"));//getElement(By.className("lfr-menu-list-overflow"));
						assertNotNull("Not menu find"+getLineNumber(), menu);

						as = getElements(menu, By.tagName("a"));
						assertEquals("Option menu have size incorrect"+getLineNumber(), as.size(),3);

						as.get(1).click();
						
//						Sleep.sleep(3000L);
						
						Sleep.waitForLoad(driver);
						Sleep.waitForSwitchFrame(driver, 0);
						
//						driver.switchTo().frame(0);
						
						Sleep.waitFor(By.id("_86_showcatalogCheckbox"), driver);
						
						WebElement check = getElement(By.id("_86_showcatalogCheckbox"));
						assertNotNull("Not showocatalog button"+getLineNumber(), check);
						
						if(check.getAttribute("checked")==null||!check.getAttribute("checked").equals("true")){
							check.click();
							
//							Sleep.waitForLoad(driver);
							
							WebElement butForm = getElement(By.className("aui-button-input-submit")); 
							assertNotNull("submit Search not Find"+getLineNumber(), butForm);
							butForm.click();
							
							Sleep.waitForLoad(driver);
						}
						
						GetPage.getPage(driver, "", Context.getTestPage());
//						Sleep.waitForLoad(driver);
						
						WebElement addCourse = driver.findElement(By.className("newitem2"));//getElement(By.className("newitem2"));
						assertNotNull("Not addCourse find"+getLineNumber(), addCourse);
						WebElement butAddCourse = addCourse.findElement(By.tagName("a"));//getElement(addCourse,By.tagName("a"));
						assertNotNull("Not button for addCourse find"+getLineNumber(), butAddCourse);
						butAddCourse.click();

//						Sleep.sleep(1000);
						Sleep.waitForLoad(driver);
						
						Date date = new Date();
						String courseName = TestProperties.get("course-name")+" "+date.getTime();
						
						WebElement title = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_title_es_ES"));
						assertNotNull("Not title find"+getLineNumber(), title);
						
						title.sendKeys(courseName);//TestProperties.get("course-name")+" "+date.getTime());
						WebElement inputVisible = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_visibleCheckbox"));
						assertNotNull("Not visible find"+getLineNumber(), inputVisible);
						inputVisible.click();
						
						Sleep.waitForLoad(driver);
						
						WebElement summary = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_summary"));
						assertNotNull("Not summary"+getLineNumber(), title);
						summary.sendKeys(courseName);//TestProperties.get("course-name")+" "+date.getTime());
						
						if (driver instanceof JavascriptExecutor) {
//						    ((JavascriptExecutor)driver).executeScript("javascript:CKEDITOR.instances['_courseadmin_WAR_liferaylmsportlet_description'].setData('<p>Test "+date.getTime()+"</p>');");
							((JavascriptExecutor)driver).executeScript("javascript:CKEDITOR.instances['_courseadmin_WAR_liferaylmsportlet_description'].setData('<p>"+courseName+"</p>');");
						}
						
						WebElement butForm1 = driver.findElement(By.className("aui-button-input-submit"));//getElement(By.className("aui-button-input-submit")); 
						assertNotNull("Not save button"+getLineNumber(), butForm1);
						butForm1.click();

//						Sleep.sleep(4000);
						Sleep.waitForLoad(driver);

						WebElement bHolder = driver.findElement(By.className("aui-button-holder"));//getElement(By.className("aui-button-holder"));
						assertNotNull("Not bHolder found"+getLineNumber(), bHolder);
						List<WebElement> inputs = getElements(bHolder,By.tagName("input"));
						assertEquals("Menu inputs have size incorrect"+getLineNumber(), inputs.size(),2);
						
						inputs.get(1).click();
						
//						Sleep.sleep(2000);
						Sleep.waitForLoad(driver);
						
						WebElement freetext = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_freetext"));
						assertNotNull("Freetext not Find"+getLineNumber(), freetext);
						freetext.sendKeys(String.valueOf(date.getTime()));
												
						WebElement formSearch = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_search"));
						assertNotNull("formSearch not Find"+getLineNumber(), formSearch);
						
						WebElement butForm = formSearch.findElement(By.className("aui-button-input-submit"));//getElement(formSearch,By.className("aui-button-input-submit")); 
						assertNotNull("formSearch Button not Find"+getLineNumber(), butForm);
						butForm.click();
						
//						Sleep.sleep(2000);
						Sleep.waitForLoad(driver);
						
						WebElement searchLayout = getElement(By.id("_courseadmin_WAR_liferaylmsportlet_coursesSearchContainerSearchContainer"));
						assertNotNull("Not form Search"+getLineNumber(), searchLayout);
						
						as = getElements(searchLayout, By.tagName("a"));
						WebElement course = null;
						for(WebElement a : as){
							if(a.getText().equals(courseName)){//TestProperties.get("course-name")+" "+date.getTime())){
								course = a;
								break;
							}
						}
						assertNotNull("Course not Find"+getLineNumber(), course);
						
						Context.setCoursePage(course.getAttribute("href"));
						Context.setCourseId(String.valueOf(date.getTime()));
						Context.setCourseName(courseName);//TestProperties.get("course-name")+" "+date.getTime());
						BeanReportContext.setCreateCourse(true);
						
						if(getLog().isInfoEnabled())getLog().info("Course URL::"+Context.getCoursePage());
						
						course.click();
						
//						Sleep.sleep(1000);
						Sleep.waitForLoad(driver);
						
//						assertTrue("Check course not good!"+getLineNumber(),CheckCourse.checkCourse(driver,Context.getCoursePage()));//driver.getCurrentUrl()));
//						assertTrue("Check course not good!"+getLineNumber(),CheckCourse.checkCourse(driver, driver.getCurrentUrl()));
						
//						GetPage.getPage(driver, "", Context.getTestPage());
					}
					else{
						assertTrue("Error instance portlet portlet_courseadmin_WAR_liferaylmsportlet"+getLineNumber(), instance);
					}
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				assertTrue("Error not test"+getLineNumber(),Context.isTest());
			}
		}
		if(getLog().isInfoEnabled())getLog().info("end ok");
  }

}
