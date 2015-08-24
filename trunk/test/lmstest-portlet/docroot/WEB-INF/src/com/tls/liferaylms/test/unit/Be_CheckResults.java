package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.GetPage;
import com.tls.liferaylms.test.util.Login;
import com.tls.liferaylms.test.util.Sleep;

/**
 * @author Diego Renedo Delgado
 */
public class Be_CheckResults extends SeleniumTestCase {

	@Test
	public void checkResults() throws Exception {
		try{
			
			//TODO quitar!!
//			Context.setCoursePage("http://localhost:8080/es/web//test-1435047943668");
//			Context.setCourseId("1435047943668");
//			Context.setTestPage("http://localhost:8080/web/guest/test");
			
			if(getLog().isInfoEnabled())getLog().info("init");
			GetPage.getPage(driver, "", Context.getTestPage());
		  
			Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());

			if(login.isLogin())
				login.logout();
		  
//			Sleep.waitForLoad(driver);
			
			boolean testLogin = login.login();
			assertTrue("Error not logued test"+getLineNumber(),testLogin);
			
			Sleep.waitForLoad(driver);

			if(testLogin){
				GetPage.getPage(driver, Context.getCoursePage(),"/estudiantes1");
				
//				Sleep.waitForLoad(driver);
			  
//				WebElement menu = getElement(By.id("navigation"));
//				assertNotNull("Not navigation found:"+getLineNumber(), menu);
//				
//				List<WebElement> lis = getElements(menu,By.tagName("li"));
//				assertEquals("Navigation menu not has options expected"+getLineNumber(),16, lis.size());
//				
//				WebElement adminMenu = lis.get(9);
//				assertNotNull("Not menu admin found:"+getLineNumber(), adminMenu);
//				
//				adminMenu.click();
//				Sleep.sleep(100);
//				adminMenu.click();
//				
//				WebElement ul = getElement(adminMenu, By.tagName("ul"));
//				assertNotNull("Administrator menu not found"+getLineNumber(), ul);
//				
//				List<WebElement> a = getElements(ul,By.tagName("a"));
//				assertEquals("No link to admin students found"+getLineNumber(),7, a.size());
//				
//				a.get(0).click();
//			  
//				Sleep.waitForLoad(driver);//sleep(1000);
			  
				WebElement portlet = getElement(By.id("_studentmanage_WAR_liferaylmsportlet_usersSearchContainer"));
				assertNotNull("Not Admin students portlet found"+getLineNumber(), portlet);
			  
				List<WebElement> trs = getElements(portlet,By.className("results-row"));
				assertNotNull("Not results for students"+getLineNumber(), trs);
			  
				for(int i=0;i<trs.size();i++){
					if(i>0){
						portlet = getElement(By.id("_studentmanage_WAR_liferaylmsportlet_usersSearchContainer"));
						assertNotNull("Not Admin students portlet found"+getLineNumber(), portlet);
						
						trs = getElements(portlet,By.className("results-row"));
						assertNotNull("Not results for students"+getLineNumber(), trs);
					}
					assertNotNull("Not students"+getLineNumber(), trs);
					WebElement tr = trs.get(i);
					String text = null;
					try{
						text = tr.getText().toLowerCase().split(" ")[0];
					}catch(Exception e){}
					if(text!=null&&!text.equals("")){
						if(text.equals(Context.getStudentName())){
							assertEquals("Result for student not match"+getLineNumber(),"10010085100100100100970", goTolink(tr));
						}else if(text.equals(Context.getStudentName2())){
							assertEquals("Result for student2 not match"+getLineNumber(),"010085100100100100770", goTolink(tr));
						}
					} 
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		if(getLog().isInfoEnabled())getLog().info("end!");
	}
	
	private String goTolink(WebElement tr){
		List<WebElement> tds = getElements(tr,By.tagName("td"));
		assertNotNull("Not students"+getLineNumber(), tds);
		assertEquals("Size of tr not correct"+getLineNumber(), 3, tds.size());
		WebElement td = tds.get(2);
		assertNotNull("Not td for results"+getLineNumber(), td);
		WebElement a = getElement(td,By.tagName("a"));
		assertNotNull("Not link for results"+getLineNumber(), a);
		
		a.click();
		
		Sleep.waitForLoad(driver);//sleep(1000);
				
		WebElement select = getElement(By.className("aui-helper-unselectable"));
		WebElement rollOut = getElement(select,By.tagName("a"));
		rollOut.click();
		
		Sleep.waitForLoad(driver);

		WebElement portlet = getElement(By.id("_studentmanage_WAR_liferaylmsportlet_learningActivitiesSearchContainerSearchContainer"));
		assertNotNull("Not td for results"+getLineNumber(), portlet);
		
		List<WebElement> trs = getElements(portlet,By.tagName("tr"));
		
		StringBuilder sb = new StringBuilder();
		
		for(WebElement ter : trs){
			List<WebElement> teds = getElements(ter,By.tagName("td"));
			if(teds.size()>1){
				WebElement ted = teds.get(1);
				sb.append(ted.getText());
			}
		}
		
		WebElement breturn = getElement(By.id("_studentmanage_WAR_liferaylmsportlet_TabsBack"));
		assertNotNull("Not return button"+getLineNumber(), breturn);
		breturn.click();
		
		Sleep.waitForLoad(driver);//sleep(2000);
		
		return sb.toString();
	}
}
