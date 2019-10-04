package appiumTest.TestCase;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import appiumTest.base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class sanityTest extends TestBase {

@Test
public void SanityTest () throws IOException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("App opened");
		driver.findElement(By.className(OR.getProperty("Email Address"))).sendKeys(OR.getProperty("TestTXT"));
		driver.findElement(By.className(OR.getProperty("Email Address"))).sendKeys(OR.getProperty("TestTXT"));
		driver.findElement(By.xpath(OR.getProperty("TestXpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("Test2Xpath"))).click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElement(By.className(OR.getProperty("Test3Xpath"))).sendKeys(OR.getProperty("TestTXT"));
		//driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		log.info("Test complete");
	}


}
