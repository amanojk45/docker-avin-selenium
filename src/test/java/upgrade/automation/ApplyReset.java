package upgrade.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import upgrade.ConstPath;
import upgrade.helper.AuthHelper;
import upgrade.helper.LocatorHelper;

import java.time.Duration;

/**
 * @author Naveena U S
 */

public class ApplyReset  {





    @Test
    @Parameters({"firmwareVersion","cameraVersion"})
    public static void testApplyRest(String firmwareVersion,String cameraVersion) throws InterruptedException {
        LocatorHelper xpathHelper = new LocatorHelper(ConstPath.applyResSetXpath+firmwareVersion+".properties");
        WebDriver driver = AuthHelper.getInstance().driver();

        //Device TAB- Navigating to Device tab
        driver.findElement(By.xpath(xpathHelper.getValue("Device"))).click();
        Reporter.log("Navigated to device tab");

        //Maintains&Support- to select rest
        driver.findElement(By.xpath(xpathHelper.getValue("Maintenance_Support"))).click();
        Reporter.log("Navigated to Maintenance/Support tab");

        //Reset radio button is selected
        driver.findElement(By.xpath(xpathHelper.getValue("Settings"))).click();;

        //Select apply button
        driver.findElement(By.xpath(xpathHelper.getValue("Apply"))).click();

        //Confirm popup- Apply
        driver.findElement(By.xpath(xpathHelper.getValue("confirm"))).click();
        //Reset delay time
        Thread.sleep(70000);
        Reporter.log("Camera reset is completed");
        driver.close();
    }

}






