import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KhanSignInUsingGoogleAccount {
	public AndroidDriver driver;
  @Test
  public void signInUsingGoogle() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Google\")")).click();
	  Thread.sleep(10000);
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"gunjit k\")")).click();
	  /*driver.findElement(MobileBy.className("android.view.View")).sendKeys("gunjit878@gmail.com");
	  driver.hideKeyboard();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"NEXT\")")).click();
	  driver.findElement(MobileBy.className("android.view.View")).sendKeys("dummy@1234");
	  driver.hideKeyboard();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"NEXT\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"I agree\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"MORE\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ACCEPT\")")).click();
*/
	  
	  String expected="Join class";
	  String actual = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Join class\")")).getText();
	  System.out.println(actual);
	        
      Assert.assertEquals(actual, expected);
  }
@BeforeClass
  public void beforeClass() throws MalformedURLException {
	DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Gunjit");
    capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    capability.setCapability(MobileCapabilityType.NO_RESET,true);
    capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
    capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
    driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
    
    }
  @AfterClass
  public void afterClass() {
      System.out.println("Test passed");
  }

  }

