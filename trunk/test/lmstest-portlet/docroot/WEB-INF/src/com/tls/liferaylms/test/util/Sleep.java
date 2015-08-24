package com.tls.liferaylms.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sleep {
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForLoad(WebDriver driver) {
		try{
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(pageLoadCondition);
		}catch (Exception e) {
			return;
		}
	}
	
	public static void waitFor(final By by, WebDriver driver) {
		try{
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return driver.findElement(by).isDisplayed();
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(pageLoadCondition);
		}catch (Exception e) {
			try{
				ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return driver.findElement(by).isEnabled();
					}
				};
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(pageLoadCondition);
			}catch (Exception ex) {
				//sleep(1000);
				waitForLoad(driver);
				return;
			}
		}
	}
	
	public static void waitForSwitchFrame(WebDriver driver, int index) {
		try{
			driver.switchTo().frame(index);
		}catch (WebDriverException e) {
			waitForSwitchFrame(driver, index);
		}
	}
}
