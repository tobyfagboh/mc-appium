package appiumTest.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import appiumTest.base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class loginTest extends TestBase {

	
	@Test
	public void LoginTest() throws IOException, InterruptedException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		log.info("App opened");
		driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(OR.getProperty("email_TEXT"));
		log.info("user email passed into text box");
		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys(OR.getProperty("password_TEXT"));
		log.info("user password passed into text box");
		driver.findElement(By.xpath(OR.getProperty("loginBtn_XPATH"))).click();
		log.info("login button clicked");
		AndroidElement myAccount = driver.findElement(By.xpath(OR.getProperty("AdminTxt_XPATH")));
		Assert.assertTrue(myAccount.isDisplayed());
		log.info("Login is successful");
		System.out.println("Either Pop Up is displayed or it is Timed Out");
		log.debug("Log in successfully executed");
	}
}
