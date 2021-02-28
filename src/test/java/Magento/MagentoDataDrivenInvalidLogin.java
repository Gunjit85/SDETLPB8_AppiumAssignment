package Magento;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class MagentoDataDrivenInvalidLogin {
	public AndroidDriver driver;
  @Test
  public void MagentoInvalidLoginCredentials() throws IOException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElementByXPath("//header/button[1]").click();
	  driver.findElementByXPath("//span[contains(text(),'My Account')]").click();
	  	  
	  File file= new File("D:\\SDETLPB8\\AppiumAssignmentSET1\\Test data.xls");
      FileInputStream fis= new FileInputStream(file);
      HSSFWorkbook wb= new HSSFWorkbook(fis);
      HSSFSheet sheet=wb.getSheetAt(0);
      int rc= sheet.getLastRowNum();
      System.out.println(rc);
      for (int i=1;i<=rc;i++) {
          String username=sheet.getRow(i).getCell(0).getStringCellValue();
          String password=sheet.getRow(i).getCell(1).getStringCellValue();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.findElementByXPath("//input[@id='email']").sendKeys(username);
          driver.findElementByXPath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[2]/div[1]/input[1]").sendKeys(password);
          driver.hideKeyboard();
          driver.findElementByXPath("//body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[3]/button[1]").click();
	  
	  String expected = "Invalid login or password.";
	  String actual = driver.findElementByXPath("//div[contains(text(),'Invalid login or password.')]").getText();
	  System.out.println(actual);
	        
      Assert.assertEquals(actual, expected);
      }
	  
  }
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	    DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Gunjit");
		capability.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.get("http://magento.com");
		  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
