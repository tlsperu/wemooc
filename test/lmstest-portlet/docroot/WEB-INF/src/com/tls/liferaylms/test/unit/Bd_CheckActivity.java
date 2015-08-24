package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.CheckPage;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.CourseActivityMenu;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.InstancePortlet;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;
import com.tls.liferaylms.test.util.TestProperties;

/**
 * @author Diego Renedo Delgado
 */
public class Bd_CheckActivity extends SeleniumTestCase {
	  
	
	String test = TestProperties.get("act.test");
	String ext = TestProperties.get("act.ext");
	String p2p = TestProperties.get("act.p2p");
	String enc = TestProperties.get("act.enc");
	String pres = TestProperties.get("act.pres");
	String scorm = TestProperties.get("act.scorm");
	String desa = TestProperties.get("act.desa");
	String eval = TestProperties.get("act.eval");

	  @Test
	  public void checkActivities() throws Exception {
		  
		//TODO quitar!!
//		Context.setCoursePage("http://localhost:8080/es/web//test-1434468190081");
//		Context.setCourseId("1434468190081");
//		Context.setTestPage("http://localhost:8080/web/guest/test");
			
		  if(getLog().isInfoEnabled())getLog().info("init");
		  GetPage.getPage(driver, "", Context.getTestPage());
		  
		  Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());
		  
		  Sleep.waitForLoad(driver);

		  if(login.isLogin())
			  login.logout();
		  
		  Sleep.waitForLoad(driver);

		  boolean testLogin = login.login();
		  assertTrue("Error not logued test!"+getLineNumber(),testLogin);

		  if(testLogin){
			  configureP2P();
		  }
		  

//		  login = new Login(driver, Context.getStudentUser2(), Context.getStudentPass2(), Context.getBaseUrl());
		  login = new Login(driver, Context.getStudentName2(), Context.getStudentPass2(), Context.getBaseUrl());

		  if(login.isLogin())
			  login.logout();

		  boolean student2Login = login.login();
		  assertTrue("Error not logued Student2"+getLineNumber(),student2Login);

		  Sleep.waitForLoad(driver);
		  
		  if(student2Login){
			  fillBadActivities();
		  }
		  
//		  login = new Login(driver, Context.getStudentUser(), Context.getStudentPass(), Context.getBaseUrl());
		  login = new Login(driver, Context.getStudentName(), Context.getStudentPass2(), Context.getBaseUrl());
		  
		  if(login.isLogin())
			  login.logout();
			
		  boolean studentLogin = login.login();
		  assertTrue("Error not logued"+getLineNumber(),studentLogin);
		  
		  Sleep.waitForLoad(driver);

		  if(studentLogin){
			  fillActivities();
		  }
		  
//		  login = new Login(driver, Context.getTeacherUser(), Context.getTeacherPass(), Context.getBaseUrl());
		  login = new Login(driver, Context.getTeacherName(), Context.getTeacherPass(), Context.getBaseUrl());

		  if(login.isLogin())
			  login.logout();

		  boolean teacherLogin = login.login();
		  assertTrue("Error not logued"+getLineNumber(),teacherLogin);
		  
		  Sleep.waitForLoad(driver);
		  
		  if(teacherLogin){
			  teacherActivities();
		  }

		  login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());

		  if(login.isLogin())
			  login.logout();

		  testLogin = login.login();
		  
		  Sleep.waitForLoad(driver);

		  if(testLogin){
			  testActivities();
		  }

		  //Login login = new Login(driver, Context.getStudentUser(), Context.getStudentPass(), Context.getBaseUrl());
//		  login = new Login(driver, Context.getStudentUser(), Context.getStudentPass(), Context.getBaseUrl());
		  login = new Login(driver, Context.getStudentName(), Context.getStudentPass(), Context.getBaseUrl());

		  if(login.isLogin())
			  login.logout();
		  
		  //boolean studentLogin = login.login();
		  studentLogin = login.login();
		  
		  Sleep.waitForLoad(driver);

		  if(studentLogin){
			  fillP2PActivity();
		  }

		  //Login login = new Login(driver, Context.getStudentUser2(), Context.getStudentPass2(), Context.getBaseUrl());
//		  login = new Login(driver, Context.getStudentUser2(), Context.getStudentPass2(), Context.getBaseUrl());
		  login = new Login(driver, Context.getStudentName2(), Context.getStudentPass2(), Context.getBaseUrl());

		  if(login.isLogin())
			  login.logout();
		  
		  //boolean studentLogin = login.login();
		  studentLogin = login.login();
		  
		  Sleep.waitForLoad(driver);

		  if(studentLogin){
			  fillP2PActivity();
		  }
		  
		  //Login login = new Login(driver, Context.getTeacherUser(), Context.getTeacherPass(), Context.getBaseUrl());
//		  login = new Login(driver, Context.getTeacherUser(), Context.getTeacherPass(), Context.getBaseUrl());
		  login = new Login(driver, Context.getTeacherName(), Context.getTeacherPass(), Context.getBaseUrl());

		  if(login.isLogin())
			  login.logout();

		  //boolean teacherLogin = login.login();
		  teacherLogin = login.login();
		  
		  Sleep.waitForLoad(driver);
		  
		  if(teacherLogin){
			  teacherEval();
		  }
		  
		  if(getLog().isInfoEnabled())getLog().info("end!");
	  }
	  
	  private void teacherEval(){
		  try{
			  GetPage.getPage(driver, Context.getCoursePage(),"/reto");

			  for(String id : Context.getActivities().keySet()){

				  if(id.length()>eval.length()&&id.substring(0, eval.length()).equals(eval)){
					  WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
					  assertNotNull("Not activity found:"+id+getLineNumber(), a);
					  
					  if(getLog().isInfoEnabled())getLog().info("Click!");
					  //double click
					  a.click();
					  try{
						  a.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);

					  String url = driver.getCurrentUrl();
					  
					  WebElement evaluation = getElement(By.id("p_p_id_evaluationtaskactivity_WAR_liferaylmsportlet_"));
					  assertNotNull("Portlet evaluation not found"+getLineNumber(), evaluation);
					  WebElement conta = getElement(evaluation, By.className("newitem2"));
					  assertNotNull("Container for new item button not found"+getLineNumber(), conta);
					  WebElement newitem = getElement(conta, By.tagName("a"));
					  assertNotNull("link for new item button not found"+getLineNumber(), conta);
					  newitem.click();
					  
					  Sleep.waitForLoad(driver);//sleep(1000);
					  
					  WebElement popup = getElement(By.id("_evaluationtaskactivity_WAR_liferaylmsportlet_showPopupActivities"));
					  assertNotNull("Popup for config Eval not found"+getLineNumber(), popup);
					  
					  List<WebElement> inputText = getElements(popup,By.className("aui-field-input-text"));
					  assertEquals("Number of inputs not match"+getLineNumber(),5, inputText.size());
					  for(WebElement input: inputText){
						  input.clear();
						  input.sendKeys("20");
					  }

					  ((JavascriptExecutor)driver).executeScript("_evaluationtaskactivity_WAR_liferaylmsportlet_doSaveActivities();");
					  
					  Sleep.waitForLoad(driver);//sleep(1000);

					  ((JavascriptExecutor)driver).executeScript("_evaluationtaskactivity_WAR_liferaylmsportlet_doClosePopupActivities();");
					  
					  Sleep.waitForLoad(driver);
					  
					  driver.get(url);
					  
					  evaluation = getElement(By.id("p_p_id_evaluationtaskactivity_WAR_liferaylmsportlet_"));
					  assertNotNull("Portlet evaluation not found"+getLineNumber(), evaluation);
					  
					  WebElement butcontainer = getElement(evaluation, By.className("evaluationAvg"));
					  assertNotNull("Container for new item button not found"+getLineNumber(), butcontainer);
					  
					  WebElement button = getElement(butcontainer,By.tagName("button"));
					  assertNotNull("calculate button not found"+getLineNumber(), button);
					  
					  button.click();
					  try{
						  button.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement submit = getElement(By.id("_evaluationtaskactivity_WAR_liferaylmsportlet_calculate"));
					  assertNotNull("No submit button found"+getLineNumber(), submit);

					  submit.click();
					  try{
						  submit.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);//sleep(6000);

					  driver.get(url);
					  
					  Sleep.waitForLoad(driver);
					  
					  List<WebElement> results = getElements(By.className("floatl"));
					  assertEquals("Number of results not match"+getLineNumber(),2, results.size());
					  
					  assertTrue("Number of text length not correct"+getLineNumber(),results.get(0).getText().length()>2);
					  assertEquals("Number of result for student not match"+getLineNumber(),"97", results.get(0).getText().substring(0,2));
					  assertTrue("Number of text length not correct"+getLineNumber(),results.get(1).getText().length()>2);
					  assertEquals("Number of result for student2 not match"+getLineNumber(),"77", results.get(1).getText().substring(0,2));
					  
					  butcontainer = getElement(evaluation, By.className("evaluationAvg"));
					  assertNotNull("Container for new item button not found"+getLineNumber(), butcontainer);
					  
					  button = getElement(butcontainer,By.tagName("button"));
					  assertNotNull("calculate button not found"+getLineNumber(), button);
					  
					  button.click();
					  try{
						  button.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement publish = getElement(By.id("_evaluationtaskactivity_WAR_liferaylmsportlet_publish"));
					  publish.click();
					  try{
						  publish.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);
				  }
			  }
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	  private void fillP2PActivity(){
		  try{
			  GetPage.getPage(driver, Context.getCoursePage(),"/reto");
			  
			  for(String id : Context.getActivities().keySet()){
				  if(getLog().isInfoEnabled())getLog().info("Check activity::"+id);

				  assertEquals("Errors in activity "+id+getLineNumber(), 0, CheckPage.check(driver));

				  if(id.length()>p2p.length()&&id.substring(0, p2p.length()).equals(p2p)){
					  WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
					  assertNotNull("Not activity found:"+id+getLineNumber(), a);

					  if(getLog().isInfoEnabled())getLog().info("Click!");
					  //double click
					  a.click();
					  try{
						  a.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);

					  WebElement portlet = getElement(By.id("p_p_id_p2ptaskactivity_WAR_liferaylmsportlet_"));
					  assertNotNull("Not P2P portlet found"+getLineNumber(), portlet);
					  					  
					  WebElement optionless = getElement(portlet, By.className("option-more"));
					  
					  //if(getLog().isInfoEnabled())getLog().info("HTML::"+portlet.getAttribute("innerHTML"));
					  
					  
					  assertNotNull("Not P2P activity found"+getLineNumber(), optionless);
					  WebElement labelcol = getElement(portlet, By.className("label-col"));
					  assertNotNull("Not P2P activity span for click found"+getLineNumber(), labelcol);
					  
					  optionless.click();
					  Sleep.waitForLoad(driver);
					  labelcol.click();
					  Sleep.waitForLoad(driver);//sleep(4000);
					  
					  WebElement textarea = getElement(optionless,By.tagName("textarea"));
					  assertNotNull("No textarea activity found"+getLineNumber(), textarea);
					  textarea.clear();
					  textarea.sendKeys(TestProperties.get("act.test.3.answer"));

					  WebElement fileName = getElement(optionless,By.id("_p2ptaskactivity_WAR_liferaylmsportlet_fileName"));
					  assertNotNull("No file activity found"+getLineNumber(), fileName);
//					  File f = new File("docroot"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
					  File f = new File(File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
					  fileName.sendKeys(f.getAbsolutePath());

					  WebElement resultuser = getElement(optionless,By.id("_p2ptaskactivity_WAR_liferaylmsportlet_resultuser"));
					  assertNotNull("No result activity found"+getLineNumber(), resultuser);
					  resultuser.sendKeys("70");

					  WebElement button = getElement(optionless,By.className("button"));
					  assertNotNull("No button activity found"+getLineNumber(), button);
					  button.click();
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement correc = getElement(By.id("_p2ptaskactivity_WAR_liferaylmsportlet_showp2pconfrmCorrec"));
					  assertNotNull("No window activity found"+getLineNumber(), button);
					  
					  WebElement submitCorrec = getElement(correc,By.id("submitCorrec"));
					  assertNotNull("No submit in window activity found"+getLineNumber(), submitCorrec);
					  submitCorrec.click();
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement completed = getElement(By.id("_p2ptaskactivity_WAR_liferaylmsportlet_completed"));
					  assertNotNull("Response in P2P not correct"+getLineNumber(), completed);
					  completed.click();
					  
					  Sleep.waitForLoad(driver);//sleep(1000);
					  
					  WebElement buttonClose = getElement(By.id("buttonClose"));
					  assertNotNull("Response in P2P not correct"+getLineNumber(), buttonClose);
					  buttonClose.click();
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement resultFather =getElement(By.id("capa3"));
					  assertNotNull("Not resultFather for P2P found"+getLineNumber(), resultFather);
					  WebElement result =getElement(resultFather,By.className("color_tercero"));
					  assertNotNull("Not result for P2P found"+getLineNumber(), result);
					  String text = result.getText();
					  assertTrue("Not result lenght expeted"+getLineNumber(),result.getText().length()>=2);
					  String rText = text.substring(text.length()-2, text.length());
					  assertTrue("Result not expected, needed 85 or 50:"+rText+getLineNumber(),rText.equals("50")||rText.equals("85"));
				  }
			  }
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	  
	  private void configureP2P(){

		  try{
			  GetPage.getPage(driver, Context.getCoursePage(),"/reto");
			  changeEditMode();
			  
			  Sleep.waitForLoad(driver);//sleep(2000);
			  for(String id : Context.getActivities().keySet()){
				  if(id.length()>p2p.length()&&id.substring(0, p2p.length()).equals(p2p)){
					  WebElement a = CourseActivityMenu.findElementActivityMenuEdit(driver,id);
					  assertNotNull("Edit link for P2P not found"+getLineNumber(), a);
					  
					  a.click();
					  Sleep.waitForLoad(driver);//sleep(2000);
						
//					  driver.switchTo().frame(0);
					  Sleep.waitForSwitchFrame(driver, 0);
					  
					  Sleep.waitForLoad(driver);
					  
					  openColapsables();
					  
					  WebElement numVal = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_numValidaciones"));
					  assertNotNull("Not value found for P2P Activity"+getLineNumber(), a);
					  numVal.clear();
					  numVal.sendKeys("1");

					  WebElement checkbox = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_resultCheckbox"));
					  assertNotNull("Not result input found for P2P Activity"+getLineNumber(), checkbox);
					  checkbox.click();
					  
					  Sleep.waitForLoad(driver);

					  WebElement anon = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_anonimousCheckbox"));
					  assertNotNull("Not anon input found for P2P Activity"+getLineNumber(), anon);
					  anon.click();
					  
					  Sleep.waitForLoad(driver);

					  WebElement uploadYear = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_uploadYear"));
					  assertNotNull("Not uploadYear input found for P2P Activity"+getLineNumber(), uploadYear);
					  Calendar calendar = Calendar.getInstance();
					  uploadYear.sendKeys(String.valueOf(calendar.get(Calendar.YEAR)));
					  
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
	
					  numVal = getElement(By.id("_lmsactivitieslist_WAR_liferaylmsportlet_numValidaciones"));
					  assertEquals("Not valid P2P Num Validation"+getLineNumber(),"1", numVal.getAttribute("value"));
					  
					  GetPage.getPage(driver, Context.getCoursePage(),"/reto");
				  }
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	  private void testActivities(){
		  try{
			  GetPage.getPage(driver, Context.getTestPage(),"");
			  
			  Sleep.waitForLoad(driver);
			  			  
			  InstancePortlet.createInstance(driver, "Administraci\u00f3n de portal", "portlet_portaladmin_WAR_liferaylmsportlet");
			  
			  Sleep.waitForLoad(driver);
			  
			  WebElement portaladmin = getElement(By.id("portlet_portaladmin_WAR_liferaylmsportlet"));
			  assertNotNull("Not portaladmin portlet found"+getLineNumber(), portaladmin);
			  WebElement actions = getElement(portaladmin,By.className("actions"));
			  assertNotNull("Not actions portaladmin portlet found"+getLineNumber(), actions);
			  WebElement p2pAct = getElement(actions,By.className("taglib-icon"));
			  p2pAct.click();
			  
			  Sleep.waitForLoad(driver);//sleep(2000);
			  
			  boolean destroy = InstancePortlet.destroyInstance(driver, "portlet_portaladmin_WAR_liferaylmsportlet");
			  assertEquals("Portlet not destroy"+getLineNumber(),true, destroy);
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	  
	  private void teacherActivities(){

		  try{
			  GetPage.getPage(driver, Context.getCoursePage(),"/reto");

			  for(String id : Context.getActivities().keySet()){
				  if(getLog().isInfoEnabled())getLog().info("Check activity::"+id);
				  WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
				  assertNotNull("Not activity found:"+id+getLineNumber(), a);

				  //double click
				  a.click();
				  try{
					  a.click();
				  }catch(Exception e){}
				  
				  Sleep.waitForLoad(driver);

				  assertEquals("Errors in activity "+id+getLineNumber(), 0, CheckPage.check(driver));
				  
				  if((id.length()>pres.length()&&id.substring(0, pres.length()).equals(pres))||(id.length()>desa.length()&&id.substring(0, desa.length()).equals(desa))){
					  WebElement container = getElement(By.id("_offlinetaskactivity_WAR_liferaylmsportlet_usersSearchContainerSearchContainer"));
					  if(container==null)
						  container = getElement(By.id("_onlinetaskactivity_WAR_liferaylmsportlet_usersSearchContainerSearchContainer"));
					  
					  assertNotNull("Not container for table of Desa activities"+getLineNumber(), container);
					  List<WebElement> cols2 = getElements(container,By.className("col-2"));
					  assertNotNull("Not col in table found"+getLineNumber(), cols2);
					  
					  for(int i =0;i<cols2.size();i++){
						  if(i==0)
							  continue;
						  
						  if(getLog().isInfoEnabled())getLog().info("col2:"+cols2.get(i).getText());
						  WebElement al = getElement(cols2.get(i),By.tagName("a"));
						  assertNotNull("Not link for check activity"+getLineNumber(), al);
						  al.click();
						  
						  Sleep.waitForLoad(driver);//sleep(2000);
						  
						  //WebElement showppg = getElement(By.id("_offlinetaskactivity_WAR_liferaylmsportlet_showPopupGrades"));
						  WebElement showppg = getElement(By.id("_offlinetaskactivity_WAR_liferaylmsportlet_result"));
						  if(showppg==null)
							  showppg = getElement(By.id("_onlinetaskactivity_WAR_liferaylmsportlet_result"));
						  
						  assertNotNull("Not found note textarea"+getLineNumber(), showppg);
						  showppg.clear();
						  showppg.sendKeys("100");
						  
						  showppg = getElement(By.id("_offlinetaskactivity_WAR_liferaylmsportlet_comments"));
						  if(showppg==null)
							  showppg = getElement(By.id("_onlinetaskactivity_WAR_liferaylmsportlet_comments"));
						  
						  assertNotNull("Not found comments for note textarea"+getLineNumber(), showppg);
						  showppg.clear();
						  showppg.sendKeys(TestProperties.get("act.test.3.answer"));
						  
						  try{
							  ((JavascriptExecutor)driver).executeScript("_offlinetaskactivity_WAR_liferaylmsportlet_doSaveGrades()");
						  }catch(Exception e){
							  ((JavascriptExecutor)driver).executeScript("_onlinetaskactivity_WAR_liferaylmsportlet_doSaveGrades()");
						  }

						  Sleep.waitForLoad(driver);//sleep(2000);
						  
						  WebElement close = getElement(By.id("closethick"));
						  close.click();

						  Sleep.waitForLoad(driver);//sleep(2000);
						  
						  //reload DOM
						  container = getElement(By.id("_offlinetaskactivity_WAR_liferaylmsportlet_usersSearchContainerSearchContainer"));
						  if(container==null)
							  container = getElement(By.id("_onlinetaskactivity_WAR_liferaylmsportlet_usersSearchContainerSearchContainer"));
						  
						  assertNotNull("Not container for table of Desa activities"+getLineNumber(), a);
						  cols2 = getElements(container,By.className("col-2"));
						  
					  }				  					  
					  
					  //SCORM
				  }else if(id.length()>scorm.length()&&id.substring(0, scorm.length()).equals(scorm)){
					  checkAndCloseScorm();
				  }
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	  

	  private boolean fillBadActivities(){
		  try{
			  GetPage.getPage(driver, Context.getCoursePage(),"/reto");

			  Sleep.waitForLoad(driver);
			  
			  for(String id : Context.getActivities().keySet()){
				  if(getLog().isInfoEnabled())getLog().info("Check activity::"+id);
				  WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
				  assertNotNull("Not activity found:"+id+getLineNumber(), a);

				  if(getLog().isInfoEnabled())getLog().info("Click!");
				  //double click
				  a.click();
				  try{
					  a.click();
					  Sleep.waitForLoad(driver);
				  }catch(Exception e){}

				  assertEquals("Errors in activity "+id+getLineNumber(), 0, CheckPage.check(driver));

				  	  //Test
				  if(id.length()>test.length()&&id.substring(0, test.length()).equals(test)){
					  WebElement submit = driver.findElement(By.className("aui-button-input-submit"));
					  submit.click();
					  
					  Sleep.waitForLoad(driver);//sleep(1000);
					  
					  WebElement popup = getElement(By.className("aui-dialog-content"));
					  assertNotNull("Not found popup container"+getLineNumber(), popup);
					  WebElement submitIframe = getElement(popup,By.className("aui-buttonitem-label-only"));
					  assertNotNull("Not submit found in popup"+getLineNumber(), submitIframe);
					  submitIframe.click();
					  
					  Sleep.waitForLoad(driver);//sleep(2000);
					  
					  WebElement portletContainer = getElement(By.id("p_p_id_execactivity_WAR_liferaylmsportlet_"));
					  assertNotNull("Not found portlet container"+getLineNumber(), portletContainer);
					  
					  List<WebElement> pes = getElements(portletContainer,By.tagName("p"));
					  
					  String percent = pes.get(1).getText();
					  
					  assertNotEquals("Check test note fail"+getLineNumber(), "100%", percent.substring(percent.length()-4,percent.length()));
					  assertEquals("Check test note fail"+getLineNumber(), "0%", percent.substring(percent.length()-2,percent.length()));

					  //Scorm
				  }else if(id.length()>scorm.length()&&id.substring(0, scorm.length()).equals(scorm)){
					  checkAndCloseScorm();
					  Sleep.waitForLoad(driver);
					  //Enc
				  }else if(id.length()>enc.length()&&id.substring(0, enc.length()).equals(enc)){
					  checkEnc();
					  Sleep.waitForLoad(driver);
					  
					  //P2P
				  }else if(id.length()>p2p.length()&&id.substring(0, p2p.length()).equals(p2p)){
					  WebElement capa1 = getElement(By.id("capa1"));
					  WebElement ta = getElement(capa1,By.tagName("textarea"));
					  ta.clear();
					  ta.sendKeys(TestProperties.get("act.p2p.text"));
					  
					  Sleep.waitForLoad(driver);

					  WebElement fileName = getElement(By.id("_p2ptaskactivity_WAR_liferaylmsportlet_fileName"));
//					  File f = new File("docroot"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
					  File f = new File(File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
					  fileName.sendKeys(f.getAbsolutePath());
					  
					  Sleep.waitForLoad(driver);
					  
					  WebElement cb = getElement(capa1,By.className("container-buttons"));
					  WebElement input = getElement(cb,By.tagName("input"));
					  
					  input.click();
					  try{
						  input.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);//sleep(1000);
					  
					  WebElement but = getElement(By.id("buttonSendP2P"));
					  assertNotNull("Not found Button for submit p2p"+getLineNumber(), but);
					  but.click();
					  Sleep.waitForLoad(driver);
					  try{
						  input.click();
						  Sleep.waitForLoad(driver);
					  }catch(Exception e){}
					  
					  //Desa
				  }else if(id.length()>desa.length()&&id.substring(0, desa.length()).equals(desa)){
					  fillDesa();
					  Sleep.waitForLoad(driver);
				  }
				  
			  }
		  }catch(Exception e){
			  e.printStackTrace();
			  return false;
		  }
		  
		  return true;
	  }
	  
	  private boolean fillActivities(){
		  try{
			  GetPage.getPage(driver, Context.getCoursePage(),"/reto");
			  
			  Sleep.waitForLoad(driver);
			  
			  for(String id : Context.getActivities().keySet()){
				  if(getLog().isInfoEnabled())getLog().info("Check activity::"+id);

				  WebElement a = CourseActivityMenu.findElementActivityMenuTotal(driver,id);
				  assertNotNull("Not activity found:"+id+getLineNumber(), a);

				  if(getLog().isInfoEnabled())getLog().info("Click!");
				  //double click
				  a.click();
				  try{
					  a.click();
					  Sleep.waitForLoad(driver);
				  }catch(Exception e){}
				  
				  assertEquals("Errors in activity "+id+getLineNumber(), 0, CheckPage.check(driver));
				  
				  //Test
				  if(id.length()>test.length()&&id.substring(0, test.length()).equals(test)){
					  if(getLog().isInfoEnabled())getLog().info("Test activity");
					  WebElement we = getElement(By.className("questiontype_1"));
					  assertNotNull("Not found Multiple Question container"+getLineNumber(), we);
					  List<WebElement> options = getElements(we,By.className("answer"));
					  assertNotNull("Not found options", options);
					  WebElement input = getElement(options.get(0),By.tagName("input"));
					  assertNotNull("Not correct input"+getLineNumber(), input);
					  input.click();
					  
					  Sleep.waitForLoad(driver);

					  we = getElement(By.className("questiontype_0"));
					  assertNotNull("Not found Option Question container"+getLineNumber(), we);
					  options = getElements(we,By.className("answer"));
					  assertNotNull("Not found options"+getLineNumber(), options);
					  input = getElement(options.get(0),By.tagName("input"));
					  assertNotNull("Not correct input"+getLineNumber(), input);
					  input.click();
					  
					  Sleep.waitForLoad(driver);

					  we = getElement(By.className("questiontype_3"));
					  assertNotNull("Not found Option Question container"+getLineNumber(), we);
					  WebElement ge = getElement(we,By.className("answer-fillblank"));
					  assertNotNull("Not found Father for input fillblank"+getLineNumber(), ge);
					  input = getElement(ge,By.tagName("input"));
					  input.clear();
					  input.sendKeys(TestProperties.get("act.test.3.answer"));
					  
					  Sleep.waitForLoad(driver);

					  we = getElement(By.className("questiontype_2"));
					  assertNotNull("Not found Option Question container"+getLineNumber(), we);
					  WebElement textarea = getElement(we,By.tagName("textarea"));
					  textarea.sendKeys(TestProperties.get("act.test.3.answer"));
					  
					  Sleep.waitForLoad(driver);

					  we = getElement(By.className("ui-droppable"));
					  assertNotNull("Not found Dropable container"+getLineNumber(), we);
					  //first element
					  WebElement divDropable = null;
					  List<WebElement> divsDropable = getElements(we,By.tagName("div"));
					  
					  for(WebElement div: divsDropable){
						  
						  String[] etext = div.getText().split(" ");
						  if(etext.length>2&&etext[1].equals("0")){
							 divDropable = div;
							 break;
						  }
					  }
					  assertNotNull("Not found Dropable option"+getLineNumber(), divDropable);
					  
					  ((JavascriptExecutor)driver).executeScript("javascript:document.getElementsByClassName(\"drop\")[0].getElementsByTagName(\"input\")[0].value = '"+divDropable.getAttribute("id")+"';");

					  Sleep.waitForLoad(driver);
					  
					  we = getElement(By.className("questiontype_sortable"));
					  assertNotNull("Not found Question sortable container"+getLineNumber(), we);
					  
					  List<WebElement> inputSort = getElements(we, By.tagName("input"));
					  assertNotNull("Not found input for sort destination"+getLineNumber(), inputSort);
					  assertEquals("Not found correct inputs number for sort"+getLineNumber(),11, inputSort.size());

					  WebElement sorts = getElement(By.className("question_sortable"));
					  List<WebElement> lis = getElements(sorts, By.tagName("li"));
					  
					  List<Integer> orden = new ArrayList<Integer>(); 
					  
					  for(int i=0;i<10;i++){
						  for(WebElement li : lis){
							  String text = li.getText();
							  String[] te = text.split(" ");
							  if(getLog().isInfoEnabled())getLog().info("text!"+li.getText());
							  if(te.length==3){;
								  if(te[1].equals(String.valueOf(i))){
									  orden.add(Integer.valueOf(li.getAttribute("id")));
									  break;
								  }
							  }
						  }
					  }

					  for(int i=0;i<10;i++){
						  WebElement li = lis.get(i);
						  Integer ord = orden.get(i);
						  assertNotNull("Not li element for "+i+getLineNumber(), li);
						  WebElement inputt = getElement(li,By.tagName("input"));
						  assertNotNull("Not input element for "+i+getLineNumber(), inputt);
						  ((JavascriptExecutor)driver).executeScript("javascript:document.getElementById("+li.getAttribute("id")+").id= '"+ord+"'");
						  Sleep.waitForLoad(driver);
						  ((JavascriptExecutor)driver).executeScript("javascript:document.getElementById("+li.getAttribute("id")+").getElementsByTagName('input')[0].value= '"+ord+"'");
						  //inputt.clear();
						  //inputt.sendKeys(String.valueOf(i));
					  }
					  
					  Sleep.waitForLoad(driver);//sleep(20000);
					  
					  /*String value = inputSort.get(1).getAttribute("value");
					  String[] values = value.split("&");
					  
					  StringBuilder result = new StringBuilder();
					  int sum = 0;
					  for(String valuet:values){
						  String[] ident =valuet.split("=");
						  assertEquals("Not found correct parts in sort input",2, ident.length);
						  result.append(ident[0]);
						  result.append("=");
						  
						  WebElement sorts = getElement(By.className("question_sortable"));
						  List<WebElement> lis = getElements(sorts, By.tagName("li"));
						  boolean find = false;
						  while(!find){
							  for(WebElement li : lis){
								  String text = li.getText();
								  String[] te = text.split(" ");
								  if(getLog().isInfoEnabled())getLog().info("text!"+li.getText());
								  if(te.length==3){
									  String num = ident[0].substring(ident[0].length()-2, ident[0].length()-1);
									  Integer onum = Integer.valueOf(num)+sum;
									  if(te[1].equals(String.valueOf(onum))){
										  result.append(li.getAttribute("id"));
										  find = true;
										  break;
									  }
								  }
							  }
							  if(!find){
								  sum++;
							  }
						  }
						  result.append("&");
					  }*/
					  
					  //((JavascriptExecutor)driver).executeScript("javascript:document.getElementsByClassName(\"questiontype_sortable\")[0].getElementsByTagName(\"input\")[1].value = '"+result.toString()+"';");

					  
					  WebElement submit = driver.findElement(By.className("aui-button-input-submit"));
					  submit.click();
					  
					  Sleep.waitForLoad(driver);//sleep(1000);
					  
					  WebElement portletContainer = getElement(By.id("p_p_id_execactivity_WAR_liferaylmsportlet_"));
					  assertNotNull("Not found portlet container"+getLineNumber(), portletContainer);
					  
					  List<WebElement> pes = getElements(portletContainer,By.tagName("p"));
					  
					  String percent = pes.get(1).getText();
					  
					  assertEquals("Check test note fail"+getLineNumber(), "100%", percent.substring(percent.length()-4,percent.length()));
					  
					  //Recurso externo
				  }else if(id.length()>ext.length()&&id.substring(0, ext.length()).equals(ext)){
					  WebElement video = getElement(By.className("video"));
					  WebElement iframe = getElement(video,By.tagName("iframe"));
					  assertNotNull("No iframe for video"+getLineNumber(), iframe);
					  
					  //P2P
				  }else if(id.length()>p2p.length()&&id.substring(0, p2p.length()).equals(p2p)){
					  WebElement capa1 = getElement(By.id("capa1"));
					  WebElement ta = getElement(capa1,By.tagName("textarea"));
					  ta.clear();
					  ta.sendKeys(TestProperties.get("act.p2p.text"));
					  
					  Sleep.waitForLoad(driver);

					  WebElement fileName = getElement(By.id("_p2ptaskactivity_WAR_liferaylmsportlet_fileName"));
//					  File f = new File("docroot"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
					  File f = new File(File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
					  fileName.sendKeys(f.getAbsolutePath());
					  
					  WebElement cb = getElement(capa1,By.className("container-buttons"));
					  WebElement input = getElement(cb,By.tagName("input"));
					  
					  input.click();
					  try{
						  input.click();
					  }catch(Exception e){}
					  
					  Sleep.waitForLoad(driver);//sleep(1000);

					  //driver.switchTo().frame(0);
					  
					  WebElement but = getElement(By.id("buttonSendP2P"));
					  assertNotNull("Not found Button for submit p2p"+getLineNumber(), but);
					  but.click();
					  try{
						  input.click();
					  }catch(Exception e){}

					  Sleep.waitForLoad(driver);
					  //driver.switchTo().activeElement();
					  
					  //SCORM scorm
				  }else if(id.length()>scorm.length()&&id.substring(0, scorm.length()).equals(scorm)){
					  checkAndCloseScorm();
					  Sleep.waitForLoad(driver);
					  //Encuesta
				  }else if(id.length()>enc.length()&&id.substring(0, enc.length()).equals(enc)){
					  checkEnc();
					  Sleep.waitForLoad(driver);
					  //Desa
				  }else if(id.length()>desa.length()&&id.substring(0, desa.length()).equals(desa)){
					  fillDesa();
					  Sleep.waitForLoad(driver);
				  }
			  }
		  }catch(Exception e){
			  e.printStackTrace();
			  return false;
		  }
		  
		  return true;
	  }
	  
	  
	  private String readFile(File file){
		  BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			if(br==null)
				return null;
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = null;
				try {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

		        while (line != null) {
		            sb.append(line);
		            sb.append('\n');
		            try {
						line = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		        return sb.toString();
		    } finally {
		        try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
	  }
	  
	  private boolean checkAndCloseScorm(){
		  Set<String> windows = driver.getWindowHandles();
		  assertEquals("SCORM Activity not found"+getLineNumber(), 1, windows.size());
		  
		  if(getLog().isInfoEnabled())getLog().info("do!"+windows.size());
		  
		  boolean present = false;
		  for(String window:windows){
			  driver.switchTo().window(window);
			  Sleep.waitForLoad(driver);
			  if (driver.getTitle().contains("SCORM Activity")) {
				  try{
					  Alert confirm =driver.switchTo().alert();
					  Sleep.waitForLoad(driver);
					  confirm.accept();
					  Sleep.waitForLoad(driver);
				  }catch(Exception e){}
				  present = true;
				  driver.close();
			  }
			  Sleep.waitForLoad(driver);
		  }
		  assertEquals("SCORM Activity not found"+getLineNumber(), true, present);
		  
		  windows = driver.getWindowHandles();
		  assertEquals("SCORM Activity not close"+getLineNumber(), 1, windows.size());

		  for(String window:windows){
			  driver.switchTo().window(window);
			  Sleep.waitForLoad(driver);
		  }
		  
		  WebElement webElement = getElement(By.className("description-title"));
		  String title = webElement.getText();
		  
		  assertEquals("Not correct Window"+getLineNumber(), true,title.length()>scorm.length()&&title.substring(0, scorm.length()).equals(scorm));
		  
		  return true;
	  }
	  
	  private void checkEnc(){
		  List<WebElement> questions = getElements(By.className("question"));
		  
//		  File f = new File("docroot"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
		  File f = new File(File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"resources"+File.separator+"encuesta.csv");
		  String text = readFile(f);
		  StringBuilder sb = new StringBuilder();
		  sb.append("Pregunta;Respuesta\n");
		  for(WebElement question : questions){
			  List<WebElement> answers = getElements(question,By.className("answer"));
			  WebElement questiontext = getElement(question,By.className("questiontext"));
			  sb.append(questiontext.getText());
			  sb.append(";");
			  for(int i=0;i<answers.size();i++){
				  sb.append(answers.get(i).getText());
				  if(i+1!=answers.size())
					  sb.append(",");
			  }
			  sb.append("\n");
		  }
		  if(getLog().isInfoEnabled())getLog().info("Una!"+text);
		  if(getLog().isInfoEnabled())getLog().info("Otra!"+sb.toString());
		  
		  assertEquals("CSV not match whit questions"+getLineNumber(),text, sb.toString());

		  for(WebElement question : questions){
			  WebElement answer = getElement(question,By.className("answer"));
			  WebElement input = getElement(answer,By.tagName("input"));
			  input.click();
			  Sleep.waitForLoad(driver);
		  }
		  
		  WebElement submit = driver.findElement(By.className("aui-button-input-submit"));
		  
		  submit.click();
		  try{
			  submit.click();
		  }catch(Exception e){}
		  
		  Sleep.waitForLoad(driver);
	  }
	  
	  private void fillDesa(){
		  WebElement text = getElement(By.id("_onlinetaskactivity_WAR_liferaylmsportlet_text"));
		  text.clear();
		  text.sendKeys(TestProperties.get("act.test.3.answer"));
		  
		  Sleep.waitForLoad(driver);

		  WebElement submit = driver.findElement(By.className("aui-button-input-submit"));
		  submit.click();
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
				Sleep.waitForLoad(driver);//sleep(1000);
			}
		}
}
