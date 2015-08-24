package com.tls.liferaylms.test.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.liferay.portal.kernel.log.Log;
import com.tls.liferaylms.report.BeanReportContext;
import com.tls.liferaylms.test.SeleniumTestCase;
import com.tls.liferaylms.test.util.Context;
import com.tls.liferaylms.test.util.Login;

public class Aa_LoginTest extends SeleniumTestCase {
	private Log log = null;

	@Test
	public void testLogin() throws Exception {
		if(getLog().isInfoEnabled())getLog().info("init");

		Login login = new Login(driver, Context.getUser(), Context.getPass(), Context.getBaseUrl());

		if (login.isLogin()) {
			if(log.isInfoEnabled())log.info("isLogin::true");
			BeanReportContext.setHasLogin(true);
			validateEditControl(driver);
		}else{
			assertTrue("Error login"+getLineNumber(),login.login());
			assertTrue("Error validate login"+getLineNumber(),login.isLogin());
		}
	}

	/**
	 * Método que valida que se pueda "Editar Controles"
	 * 
	 * @param driver
	 */
	private void validateEditControl(WebDriver driver) {
		
		
		
	}
}
