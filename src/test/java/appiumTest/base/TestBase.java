package appiumTest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.apache.log4j.Logger;

public class TestBase {
	public static WebDriverWait wait;
	public AndroidDriver<AndroidElement> driver;
	// public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public static AndroidDriver<AndroidElement> Capabilities() throws IOException, InterruptedException {

		/*
		 * Runtime.getRuntime().
		 * exec("cmd /c start C:\\SummitechTest\\appiumTest\\startappium.bat");
		 * Thread.sleep(7000);
		 */

		PropertyConfigurator.configure(
				"C\\Users\\netowsolutions\\Documents\\Parallelscore\\Mobile-Automation\\mc-appium\\src\\test\\resources\\properties\\log4j.properties");

		File appDir = new File("src");
		File app = new File(appDir, "\\test\\resources\\executables\\loopmi.apk");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// wait = new WebDriverWait(driver, 10);
		return driver;

	}

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						"C\\Users\\netowsolutions\\Documents\\Parallelscore\\Mobile-Automation\\mc-appium\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}
	

	@SuppressWarnings("unused")
	public void log4j_demo() {
		Logger log = Logger.getLogger("log4j_demo");
		PropertyConfigurator.configure("C\\Users\\netowsolutions\\Documents\\Parallelscore\\Mobile-Automation\\mc-appium\\src\\test\\resources\\properties\\log4j.properties");

	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
