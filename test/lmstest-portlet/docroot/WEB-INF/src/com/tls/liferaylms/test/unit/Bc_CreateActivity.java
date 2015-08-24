package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tls.liferaylms.report.BeanReportContext;
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
public class Bc_CreateActivity extends SeleniumTestCase {

	@Test
	public void createActivity() throws Exception {
		
		if(getLog().isInfoEnabled())getLog().info("init");
		
//		Login login = new Login(driver, Context.getTeacherUser(), Context.getTeacherPass(), Context.getBaseUrl());
		Login login = new Login(driver, Context.getTeacherName(), Context.getTeacherPass(), Context.getBaseUrl());

		//TODO quitar!!
//		Context.setCoursePage("https://wecorpsepedes.telefonicalearningservices.com/es/web//test-1437137792965");
//		Context.setCourseId("1437137792965");
				
		if(login.isLogin())
			login.logout();
		
		Sleep.waitForLoad(driver);
		
		//login = new Login(driver, Context.getTeacherUser(), Context.getTeacherPass(), Context.getBaseUrl());
		
		boolean teacherLogin = login.login();
		assertTrue("Error login teacher"+getLineNumber(),teacherLogin);
		
		if(teacherLogin){
			try{
				GetPage.getPage(driver, Context.getCoursePage(), "/reto");
				
				changeEditMode();
				
//				Sleep.waitForLoad(driver);//sleep(2000);
				Sleep.waitForLoad(driver);
	
				WebElement activityPortlet = getElement(By.id("p_p_id_moduleportlet_WAR_liferaylmsportlet_"));
				assertNotNull("Not Activity portlet found"+getLineNumber(), activityPortlet);
				
				WebDriver driverAux = driver;
				
				if (driverAux instanceof JavascriptExecutor) {
					JavascriptExecutor js = (JavascriptExecutor) driverAux;
					js.executeScript("javascript:_moduleportlet_WAR_liferaylmsportlet_openPopup();", "");
				}else{
					WebElement newActivity 	= getElement(activityPortlet, By.className("newitem"));
					WebElement tagLib 		= getElement(newActivity, By.className("taglib-icon"));
					
					tagLib.click();
				}

//				Sleep.waitForLoad(driver);//sleep(2000);
//				Sleep.waitForLoad(driverAux);
	
//				driverAux.switchTo().frame(0);
//				Sleep.waitForLoad(driverAux);
				
				Sleep.waitForSwitchFrame(driverAux, 0);
				
				WebElement title = driverAux.findElement(By.id("_moduleportlet_WAR_liferaylmsportlet_title_es_ES"));
				assertNotNull("Not Activity title found"+getLineNumber(), title);
				title.sendKeys("Module "+Context.getCourseId());
				
				WebElement endAno = driverAux.findElement(By.id("_moduleportlet_WAR_liferaylmsportlet_endDateAno"));
				assertNotNull("Not endAno found"+getLineNumber(), endAno);
				Calendar calendar = Calendar.getInstance();
				endAno.sendKeys(String.valueOf(calendar.get(Calendar.YEAR)+1));
	
				WebElement form = driverAux.findElement(By.id("_moduleportlet_WAR_liferaylmsportlet_addmodule"));
				assertNotNull("Not form activity found"+getLineNumber(), form);
				
				form.submit();
				BeanReportContext.setModule(true);

//				Sleep.waitForLoad(driver);//sleep(2000);
				Sleep.waitForLoad(driverAux);
				
				driver.switchTo().parentFrame();

				GetPage.getPage(driver, Context.getCoursePage(), "/reto");
				
				changeEditMode();
				
//				Sleep.waitForLoad(driver);//sleep(2000);
				Sleep.waitForLoad(driver);
				
				//Add activities
				WebElement newactivity = getElement(By.className("newactivity"));
				assertNotNull("No newactivity found"+getLineNumber(), newactivity);
				
				WebElement aNew = getElement(newactivity,By.tagName("a"));
				assertNotNull("Not aNewnewactivity button"+getLineNumber(), aNew);
				aNew.click();

				Sleep.waitForLoad(driver);//sleep(2000);
				
//				driver.switchTo().frame(0);
				Sleep.waitForSwitchFrame(driver, 0);
				
				Sleep.waitForLoad(driver);

				WebElement activityList = getElement(By.className("activity-list"));
				assertNotNull("Not Activity list find"+getLineNumber(), activityList);
				
				List<WebElement> lis = getElements(activityList, By.tagName("li"));
				
				assertTrue("Poor activities... "+getLineNumber(),lis.size()>6);
				
				for(int i=0;i<lis.size();i++){
					
					GetPage.getPage(driver, Context.getCoursePage(), "/reto");
					
					changeEditMode();

//					Sleep.waitForLoad(driver);//sleep(2000);
					Sleep.waitForLoad(driver);
					
					newactivity = getElement(By.className("newactivity"));
					assertNotNull("Not newactivity button"+getLineNumber(), newactivity);

					aNew = getElement(newactivity,By.tagName("a"));
					assertNotNull("Not aNewnewactivity button"+getLineNumber(), aNew);
					aNew.click();

//					Sleep.waitForLoad(driver);//sleep(2000);
					Sleep.waitForLoad(driver);
					
					Sleep.waitForSwitchFrame(driver, 0);
//					driver.switchTo().frame(0);
					
//					Sleep.waitForLoad(driver);
					Sleep.waitFor(By.className("activity-list"), driver);
					activityList = getElement(By.className("activity-list"));
					assertNotNull("Not Activity list find"+getLineNumber(), activityList);
					
					lis = getElements(activityList, By.tagName("li"));
					
					assertTrue("Poor activities... "+getLineNumber(),lis.size()>6);

					WebElement a = getElement(lis.get(i),By.tagName("a"));
					a.click();

//					Sleep.waitForLoad(driver);//sleep(2000);
					Sleep.waitForLoad(driver);
					
					WebElement titleAct = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_title_es_ES"));
					assertNotNull("Title activity not find"+getLineNumber(), titleAct);
					String prop = null;
					switch(i){
						case 0:
							prop = "act.test";
							break;
						case 1:
							prop = "act.ext";
							break;
						case 2:
							prop = "act.p2p";
							break;
						case 3:
							prop = "act.enc";
							break;
						case 4:
							prop = "act.pres";
							break;
						case 5:
							prop = "act.desa";
							break;
						case 6:
							prop = "act.media";
							break;
						case 7:
							prop = "act.eval";
							break;
						case 8:
							prop = "act.scorm";
							break;
					}
					
					titleAct.sendKeys(TestProperties.get(prop)+" "+Context.getCourseId());
					sendCkEditorJS(driver,prop);
					
					Sleep.waitForLoad(driver);
					
					if(i==8){
						boolean result = createScorm();
						assertTrue("Error creating SCORM to SCORM activity"+getLineNumber(),result);
						BeanReportContext.setSCORMActivity(result);
					}else if(i==2){
						WebElement numVal = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_numValidaciones"));
						numVal.clear();
						numVal.sendKeys("1");
					}
					
					Sleep.waitFor(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_fm"), driver);
					form = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_fm"));
					assertNotNull("Not form activity found"+getLineNumber(), form);
					form.submit();

//					Sleep.waitForLoad(driver);//sleep(3000);
					Sleep.waitForLoad(driver);

					GetPage.getPage(driver, Context.getCoursePage(), "/reto");
					
					//Chequeamos el estado de la actividad
					String param = TestProperties.get(prop);					
					WebElement liActive = CourseActivityMenu.findElementActivityMenu(driver,param);
					assertNotNull("Not found activity created"+getLineNumber(), liActive);
					
					List<WebElement> asActive = getElements(liActive, By.tagName("a"));
					assertEquals("Not Edit portlet found"+getLineNumber(), 1,asActive.size());
					
					//Put activity in context
					String idenfier = asActive.get(0).getText();

					Context.getActivities().put(idenfier, driver.getCurrentUrl());
					
					//Editamos la actividad
					changeEditMode();
					
//					Sleep.waitForLoad(driver);//sleep(2000);
					Sleep.waitForLoad(driver);
					
					liActive =  CourseActivityMenu.findElementActivityMenu(driver,param);
					assertNotNull("Not found activity created"+getLineNumber(), liActive);

					asActive = getElements(liActive, By.tagName("a"));
					assertEquals("Not Edit portlet found"+getLineNumber(), 8,asActive.size());
					if(getLog().isInfoEnabled())getLog().info("Enlaces::"+asActive.size());

					asActive.get(1).click();
//					Sleep.waitForLoad(driver);//sleep(2000);
					Sleep.waitForLoad(driver);

					switch(i){
						case 0:  //Test
							boolean resultTest = createTest();
							assertTrue("Error creating test"+getLineNumber(),resultTest);
							BeanReportContext.setTestActivity(resultTest);
							break;
						case 1:	 //Recurso Externo
							boolean resultExt = createExt();
							assertTrue("Error creating specific data to Ext activity"+getLineNumber(),resultExt);
							BeanReportContext.setExtResourceActivity(resultExt);
							break;
						case 2:	 //P2P
							BeanReportContext.setP2PActivity(true);
							break;
						case 3:	 //Encuesta
							boolean resultPoll = createPoll();
							assertTrue("Error creating data to Poll activity"+getLineNumber(),resultPoll);
							BeanReportContext.setPollActivity(resultPoll);
							break;
						case 4:	 //Tarea Presencial
							BeanReportContext.setClassWorkActivity(true);
							break;
						case 5:	 //Actividad Desarrollo
							BeanReportContext.setDevelopActivity(true);
							break;
						case 6:	 //Recurso Mediateca
							BeanReportContext.setMultimediaResource(true);
							break;
						case 7:	 //Evaluación
							BeanReportContext.setEvalueActivity(true);
							break;
					}
					GetPage.getPage(driver, Context.getCoursePage(), "/reto");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void changeEditMode(){
		
		WebElement editPortlet = getElement(By.id("p_p_id_changeEditingMode_WAR_liferaylmsportlet_"));
		
		assertNotNull("Not Edit portlet found"+getLineNumber(), editPortlet);
		
		List<WebElement> inputs = getElements(editPortlet,By.tagName("input"));
		assertEquals("Not input found on Edit portlet"+getLineNumber(), 1,inputs.size());
		inputs.get(0).click();
	}
	
	private void sendCkEditorJS(WebDriver driver,String prop){
		
		Sleep.waitForLoad(driver);
		
		if (driver instanceof JavascriptExecutor) {
			StringBuilder sb = new StringBuilder("javascript:CKEDITOR.instances['_lmsactivitieslist_WAR_liferaylmsportlet_description'].setData('<p>");
			sb.append(TestProperties.get(prop));
			sb.append(" ");
			sb.append(Context.getCourseId());
			sb.append("</p>');");
		    ((JavascriptExecutor)driver).executeScript(sb.toString());
		}
	}
	
	private void sendCkEditorJSId(WebDriver driver,String msg,String id){
		try{
			
			Sleep.waitForLoad(driver);
			
			if (driver instanceof JavascriptExecutor) {
				StringBuilder sb = new StringBuilder("javascript:CKEDITOR.instances['");
				sb.append(id);
				sb.append("'].setData('<p>");
				sb.append(msg);
				sb.append(" ");
				sb.append(Context.getCourseId());
				sb.append("</p>');");
			    ((JavascriptExecutor)driver).executeScript(sb.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void executeJS(String script){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(script);
		}
	}
	
	private boolean createTest(){
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
		
//		Sleep.waitForLoad(driver);

		//Ordenable
		WebElement botonera = getElement(By.className("acticons"));
		assertNotNull("Not found botonera"+getLineNumber(), botonera);
		
		List<WebElement> aHrefs = getElements(botonera,By.tagName("a"));
		assertTrue("Not menu actions finds"+getLineNumber(),aHrefs.size()>0);
		aHrefs.get(0).click();
		
		Sleep.waitForLoad(driver);
		
		driver.switchTo().defaultContent();
//		Sleep.waitForLoad(driver);
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
//		Sleep.waitForLoad(driver);
		
		WebElement bt_new = getElement(By.className("bt_new"));
		assertNotNull("Not found button bt_new"+getLineNumber(), bt_new);
		WebElement aNew = getElement(bt_new,By.tagName("a"));
		assertNotNull("Not found button aNew"+getLineNumber(), aNew);
		aNew.click();
		
//		Sleep.waitForLoad(driver);//sleep(1000);
		Sleep.waitForLoad(driver);
				
		executeJS("javascript:_execactivity_WAR_liferaylmsportlet_newQuestion(5);");

//		Sleep.waitForLoad(driver);//sleep(4000);
		Sleep.waitForLoad(driver);
		
		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_text"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.5"),"_execactivity_WAR_liferaylmsportlet_text");

		Sleep.waitForLoad(driver);//sleep(4000);
		try{
			for(int i=0;i<10;i++){
				if(i>1){
					executeJS("_execactivity_WAR_liferaylmsportlet_addNode();");
					Sleep.waitForLoad(driver);//sleep(3000);
				}
				Sleep.sleep(100);
				
				sendCkEditorJSId(driver,TestProperties.get("act.test.5.text")+" "+i,"_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1));
				
//				Sleep.waitForLoad(driver);//sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		WebElement submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		//Doubleclick
		try{
			submit.click();
			submit.click();
			
			BeanReportContext.setTestActivitySort(true);
		}catch(Exception e){}
		
//		Sleep.waitForLoad(driver);//sleep(1000);
		Sleep.waitForLoad(driver);
		
		WebElement breturn = getElement(By.id("_execactivity_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not breturn found"+getLineNumber(), breturn);
		breturn.click();
		try{
			breturn.click();
		}catch(Exception e){}

		Sleep.waitForLoad(driver);//sleep(1000);
		
		//Arrastrar
		
		//Button edit
		bt_new = getElement(By.className("bt_new"));
		assertNotNull("Not found button bt_new"+getLineNumber(), bt_new);
		aNew = getElement(bt_new,By.tagName("a"));
		assertNotNull("Not found button aNew"+getLineNumber(), aNew);
		aNew.click();

		Sleep.waitForLoad(driver);//sleep(1000);

		executeJS("javascript:_execactivity_WAR_liferaylmsportlet_newQuestion(4);");
		
		Sleep.waitForLoad(driver);//sleep(4000);

		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_text"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.4"),"_execactivity_WAR_liferaylmsportlet_text");

		Sleep.waitForLoad(driver);//sleep(4000);

		WebElement check = getElement(By.id("_execactivity_WAR_liferaylmsportlet_correct_new1Checkbox"));
		check.click();
		
		for(int i=0;i<10;i++){
			if(i>1){
				executeJS("_execactivity_WAR_liferaylmsportlet_addNode();");
//				Sleep.waitForLoad(driver);
			}

//			Sleep.waitForLoad(driver);//sleep(3000);
			
			Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1)), driver);
			sendCkEditorJSId(driver,TestProperties.get("act.test.4.text")+" "+i,"_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1));
			
			if(i==0){
			}
			
			Sleep.waitForLoad(driver);//sleep(2000);
		}

		submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		//Doubleclick
		try{
			submit.click();
			submit.click();
			
			BeanReportContext.setTestActivityDrag(true);
		}catch(Exception e){}
		
		Sleep.waitForLoad(driver);
		
		breturn = getElement(By.id("_execactivity_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not breturn found"+getLineNumber(), breturn);
		breturn.click();

		Sleep.waitForLoad(driver);//sleep(1000);
		//Fill space
		bt_new = getElement(By.className("bt_new"));
		assertNotNull("Not found button bt_new"+getLineNumber(), bt_new);
		aNew = getElement(bt_new,By.tagName("a"));
		assertNotNull("Not found button aNew"+getLineNumber(), aNew);
		aNew.click();

		Sleep.waitForLoad(driver);//sleep(1000);

		executeJS("javascript:_execactivity_WAR_liferaylmsportlet_newQuestion(3);");

		Sleep.waitForLoad(driver);//sleep(4000);

		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_text"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.3"),"_execactivity_WAR_liferaylmsportlet_text");

		Sleep.waitForLoad(driver);//sleep(4000);
		
		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_answer_new1"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.3.text"),"_execactivity_WAR_liferaylmsportlet_answer_new1");

		Sleep.waitForLoad(driver);//sleep(3000);
		
		submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		//Doubleclick
		try{
			submit.click();
			submit.click();
			
			BeanReportContext.setTestActivityFill(true);
		}catch(Exception e){}

		Sleep.waitForLoad(driver);//sleep(3000);
		
		breturn = getElement(By.id("_execactivity_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not breturn found"+getLineNumber(), breturn);
		breturn.click();
		
		//Free text
		Sleep.waitForLoad(driver);
		
		executeJS("javascript:_execactivity_WAR_liferaylmsportlet_newQuestion(2);");

		Sleep.waitForLoad(driver);//sleep(4000);

		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_text"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.2"),"_execactivity_WAR_liferaylmsportlet_text");

		bt_new = getElement(By.id("_execactivity_WAR_liferaylmsportlet_includeSolution"));
		assertNotNull("Not found button bt_new"+getLineNumber(), bt_new);
		bt_new.click();
		
		Sleep.waitForLoad(driver);//sleep(4000);
		
		WebElement tac =getElement(By.className("container-textarea"));
		assertNotNull("Not found textarea container"+getLineNumber(), tac);
		
		WebElement ta =getElement(tac,By.tagName("textarea"));
		assertNotNull("Not found textarea container"+getLineNumber(), ta);
		
		ta.clear();
		ta.sendKeys(TestProperties.get("act.test.3.answer"));

		
		submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		//Doubleclick
		try{
			submit.click();
			submit.click();
			
			BeanReportContext.setTestActivityFree(true);
		}catch(Exception e){}

		
		Sleep.waitForLoad(driver);//sleep(1000);

		breturn = getElement(By.id("_execactivity_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not breturn found"+getLineNumber(), breturn);
		breturn.click();

		//Multiple
		Sleep.waitForLoad(driver);//sleep(4000);
		
		executeJS("javascript:_execactivity_WAR_liferaylmsportlet_newQuestion(1);");
		
		Sleep.waitForLoad(driver);//sleep(4000);

		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_text"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.1"),"_execactivity_WAR_liferaylmsportlet_text");

		Sleep.waitForLoad(driver);//sleep(1000);

		//executeJS("javascript:_execactivity_WAR_liferaylmsportlet_divVisibility('addNewQuestion', this);");

		for(int i=0;i<10;i++){
			if(i>1){
				executeJS("_execactivity_WAR_liferaylmsportlet_addNode();");
//				Sleep.waitForLoad(driver);
			}
			
//			Sleep.waitForLoad(driver);//sleep(3000);
		
			Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1)), driver);
			sendCkEditorJSId(driver,TestProperties.get("act.test.1.text")+" "+i,"_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1));
			Sleep.waitForLoad(driver);//sleep(1000);
			
			if(i==0){
				check = getElement(By.id("_execactivity_WAR_liferaylmsportlet_correct_new1Checkbox"));
				assertNotNull("Not found correct check"+getLineNumber(), check);
				check.click();
				Sleep.waitForLoad(driver);
			}
		}

		submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		//Doubleclick
		try{
			submit.click();
			submit.click();
			
			BeanReportContext.setTestActivityMulti(true);
		}catch(Exception e){}

		Sleep.waitForLoad(driver);//sleep(2000);

		breturn = getElement(By.id("_execactivity_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not breturn found"+getLineNumber(), breturn);
		breturn.click();
		
		Sleep.waitForLoad(driver);
		
		//Options
		bt_new = getElement(By.className("bt_new"));
		assertNotNull("Not found button bt_new"+getLineNumber(), bt_new);
		aNew = getElement(bt_new,By.tagName("a"));
		assertNotNull("Not found button aNew"+getLineNumber(), aNew);
		aNew.click();

		Sleep.waitForLoad(driver);//sleep(1000);
		
		executeJS("javascript:_execactivity_WAR_liferaylmsportlet_newQuestion(0);");

		Sleep.waitForLoad(driver);//sleep(4000);

		Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_text"), driver);
		sendCkEditorJSId(driver,TestProperties.get("act.test.0"),"_execactivity_WAR_liferaylmsportlet_text");

		Sleep.waitForLoad(driver);//sleep(4000);

		//executeJS("javascript:_execactivity_WAR_liferaylmsportlet_divVisibility('addNewQuestion', this);");

		for(int i=0;i<10;i++){
			if(i>1){
				executeJS("_execactivity_WAR_liferaylmsportlet_addNode();");
//				Sleep.waitForLoad(driver);
			}

//			Sleep.waitForLoad(driver);//sleep(3000);
			
			Sleep.waitFor(By.id("_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1)), driver);
			sendCkEditorJSId(driver,TestProperties.get("act.test.0.text")+" "+i,"_execactivity_WAR_liferaylmsportlet_answer_new"+(i+1));
			
			if(i==0){
				check = getElement(By.id("_execactivity_WAR_liferaylmsportlet_correct_new1Checkbox"));
				assertNotNull("Not found correct check"+getLineNumber(), check);
				check.click();
				Sleep.waitForLoad(driver);
			}
		}

		submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		//Doubleclick
		try{
			submit.click();
			submit.click();
			
			BeanReportContext.setTestActivityOption(true);
		}catch(Exception e){}

		Sleep.waitForLoad(driver);//.sleep(2000);

		breturn = getElement(By.id("_execactivity_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not breturn found"+getLineNumber(), breturn);
		breturn.click();
		
		Sleep.waitForLoad(driver);
		
		return true;
	}
	
	private boolean createExt(){
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
		
//		Sleep.waitForLoad(driver);

		openColapsables();
		
		try{
			WebElement youtube = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_youtubecode"));
			assertNotNull("Not youtube code found"+getLineNumber(), youtube);
			Sleep.waitForLoad(driver);
			youtube.sendKeys(TestProperties.get("act.ext.youtube"));
		}catch(ElementNotVisibleException e){
			WebElement youtube = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_youtubecode"));
			assertNotNull("Not youtube code found"+getLineNumber(), youtube);
			youtube.sendKeys(TestProperties.get("act.ext.youtube"));
		}
		
		WebElement form = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_fm"));
		form.submit();
		
		Sleep.waitForLoad(driver);
		
		return true;
	}
	
	private boolean createPoll(){
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
		
//		Sleep.waitForLoad(driver);
		
		WebElement botonera = getElement(By.className("acticons"));
		assertNotNull("Not found botonera"+getLineNumber(), botonera);
		
		List<WebElement> aHrefs = getElements(botonera,By.tagName("a"));
		assertTrue("Not menu actions finds"+getLineNumber(),aHrefs.size()>0);
		aHrefs.get(0).click();
		
		Sleep.waitForLoad(driver);
		
		driver.switchTo().defaultContent();
		Sleep.waitForLoad(driver);
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
		Sleep.waitForLoad(driver);
		
		//3th a
		WebElement menuimport = getElement(By.id("_surveyactivity_WAR_liferaylmsportlet_tiym_menuButton"));
		assertNotNull("Not found menuimport in Poll edit"+getLineNumber(), menuimport);
		
		menuimport.click();
		
		Sleep.waitForLoad(driver);//sleep(2000);
		
		menuimport = getElement(By.id("_surveyactivity_WAR_liferaylmsportlet_tiym_menu_surveyactivity.editquestions.importquestions"));
		
		assertNotNull("Not found menu button in Poll edit"+getLineNumber(), menuimport);
		menuimport.click();
		
		Sleep.waitForLoad(driver);//sleep(2000);

		driver.switchTo().defaultContent();
		Sleep.waitForLoad(driver);
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
		Sleep.waitForLoad(driver);

		//File f = new File("resources"+File.separator+"encuesta.csv");
		File f = new File("docroot"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
		WebElement upload = getElement(By.id("_surveyactivity_WAR_liferaylmsportlet_fileName"));
		upload.sendKeys(f.getAbsolutePath());
		
		WebElement submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		
		//Doubleclick
		try{
			submit.click();
		}catch(Exception e){}

		Sleep.waitForLoad(driver);//sleep(2000);
		
		return true;
	}
	
	private boolean createScorm(){
		WebElement scromSearch= getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_searchEntry"));
		assertNotNull("Not scorm button search found"+getLineNumber(), scromSearch);
		scromSearch.click();

		Sleep.waitForLoad(driver);//sleep(1000);
		
		driver.switchTo().defaultContent();
		Sleep.waitForLoad(driver);
//		driver.switchTo().frame(0);
		Sleep.waitForSwitchFrame(driver, 0);
		Sleep.waitForLoad(driver);
		
		driver.switchTo().frame(driver.findElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_finder")));
		Sleep.waitForLoad(driver);

		WebElement submit = getElement(By.className("aui-button-input-submit"));
		assertNotNull("Not submit found"+getLineNumber(), submit);
		submit.click();
		
		Sleep.waitForLoad(driver);
		
		WebElement scorm = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_assetEntriesSearchContainer_col-2_row-1"));
		if(scorm!=null){
			WebElement a = getElement(scorm,By.tagName("a"));
			a.click();
		}else{
			if(getLog().isInfoEnabled())getLog().info("Error no SCORM found");
		}

//		driver.switchTo().defaultContent();
//		Sleep.waitForLoad(driver);
//		driver.switchTo().frame(0);
//		Sleep.waitForLoad(driver);
		
		return true;
	}
	
	private static void setClipboardData(String string) {
	      StringSelection stringSelection = new StringSelection(string);
	      java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);      
	}
	
	private void openColapsables(){
		List<WebElement> pcontainer = getElements(By.className("lfr-panel-titlebar"));
		assertNotNull("Not found pcontainer"+getLineNumber(), pcontainer);
		
		for(WebElement we : pcontainer){
			if(getLog().isInfoEnabled())getLog().info("Click::"+we.getText());
			try{
				we.click();
				Sleep.waitForLoad(driver);
			}catch(Exception e){}
			List<WebElement> spans = getElements(we,By.tagName("span"));
			if(spans!=null){
				for(WebElement span : spans){
					try{
						span.click();
						Sleep.waitForLoad(driver);
					}catch(Exception e){}
				}
			}
			List<WebElement> divs = getElements(we,By.tagName("div"));
			if(spans!=null){
				for(WebElement div : divs){
					try{
						div.click();
						Sleep.waitForLoad(driver);
					}catch(Exception e){}
				}
			}
			//Sleep.waitForLoad(driver);//sleep(1000);
		}
	}
}
