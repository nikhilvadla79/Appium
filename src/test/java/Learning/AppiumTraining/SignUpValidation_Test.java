package Learning.AppiumTraining;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.taskdefs.optional.XSLTTraceSupport;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.DependsOn;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SignUpValidation_Test {
	AndroidDriver driver;
  @Test
  public void navigateToSignUp() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	  driver.findElementByAccessibilityId("Sign up with email").click();
	  Assert.assertTrue(driver.findElementByAccessibilityId("First name").isDisplayed(),"Navigated to SignUp Page Successfully");
  }
  @Test(dependsOnMethods= {"navigateToSignUp"})
  public void EnterDetails()
  {
	 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElementByAccessibilityId("First name").sendKeys("Nikhil");
	  driver.findElementByAccessibilityId("Last name").sendKeys("Vadla");
	  driver.findElementByAccessibilityId("Birthday").click();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"OK\")")).click();
	  driver.findElementByAccessibilityId("Email address").sendKeys("Nikhil");
	  driver.findElementByAccessibilityId("Password").sendKeys("Password");
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"CREATE\")")).click();
	  String Errmsg=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"unexpected error\")")).getText();
	  Assert.assertTrue(driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"unexpected error\")")).isDisplayed(), "Getting Error Message for Entering invald details and the error message is "+Errmsg);
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities Capability=new DesiredCapabilities();
	  //Capability.setCapability(MobileCapabilityType.NO_RESET, "true");
		Capability.setCapability("deviceName", "Nikhil");
		Capability.setCapability("platformName", "Android");
		Capability.setCapability("appPackage","org.khanacademy.android");
		Capability.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),Capability);
  }
  
	  
	  
	  
  

}
