package upgrade.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import upgrade.ConstPath;
import upgrade.helper.AuthHelper;
import upgrade.helper.LocatorHelper;

/**
 * @author Naveena U S
 */
public class AddCredentials {

    @Test
    @Parameters({"firmwareVersion","cameraVersion"})
    public static void testAddCredentials(String firmwareVersion,String cameraVersion) throws InterruptedException {
		LocatorHelper xpathHelper = new LocatorHelper(ConstPath.addCredentialsXpath+firmwareVersion+".properties");
        WebDriver driver =  AuthHelper.getInstance().driver();

		//Adding username
        WebElement userWebElement = driver.findElement(By.xpath(xpathHelper.getValue("Username")));
		userWebElement.sendKeys(System.getenv("camera_user_name"));
		Reporter.log("Added new username");

        //Adding password
        WebElement pswWebElement = driver.findElement(By.xpath(xpathHelper.getValue("Password")));
		pswWebElement.sendKeys(System.getenv("camera_password"));
		Reporter.log("Added new password");

        //Adding confirmpassword
		WebElement cnfrmPsw = driver.findElement(By.xpath(xpathHelper.getValue("Confirmpassword")));
		cnfrmPsw.sendKeys(System.getenv("camera_password"));
	    Reporter.log("Added new confirmpassword");

        //Selecting setpassword
		driver.findElement(By.xpath(xpathHelper.getValue("Setpassword"))).click();
	    Reporter.log("Password is set");

        //Selecting login
		driver.findElement(By.xpath(xpathHelper.getValue("Login"))).click();
		Reporter.log("New Credentials are added");
		driver.close();
}
}

