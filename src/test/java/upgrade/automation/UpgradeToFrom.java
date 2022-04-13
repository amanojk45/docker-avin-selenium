package upgrade.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import upgrade.ConstPath;
import upgrade.helper.AuthHelper;
import upgrade.helper.LocatorHelper;

/**
 * @author Naveena U S
 */
public class UpgradeToFrom {

    @Test
    @Parameters({"firmwareVersion", "cameraVersion"})
    public static void testUpgradeToFrom(String firmwareVersion, String cameraVersion) throws InterruptedException {
        LocatorHelper xpathHelper = new LocatorHelper(ConstPath.upgradeToFromXpath + firmwareVersion + ".properties");
        WebDriver driver = AuthHelper.getInstance().driver();


        //Expert mode on
        Thread.sleep(2000);
        WebElement exp = driver.findElement(By.xpath("(//input[@class='mat-slide-toggle-input cdk-visually-hidden'])[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        WebElement expLable = wait.until(ExpectedConditions.elementToBeClickable(exp.findElement(By.xpath(".."))));
        expLable.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Device TAB- Navigating to Device tab
        driver.findElement(By.xpath(xpathHelper.getValue("Device"))).click();
        Reporter.log("Navigated to device tab");

        //DeviceInformation- adding new name
        WebElement cameraName= driver.findElement(By.xpath(xpathHelper.getValue("FriendlyName")));
        cameraName.clear();
        cameraName.sendKeys(cameraVersion);
        Reporter.log("Camera name is changed");

        //Enable EVO-12 ONVIF Emulation
       // JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emuMode = driver.findElement(By.xpath(xpathHelper.getValue("EmulationMode")));
        js.executeScript("arguments[0].scrollIntoView();", emuMode);
        emuMode.click();
        driver.findElement(By.xpath(xpathHelper.getValue("Save"))).click();
        Reporter.log("Emulation mode is enabled");

        //Date&Time- selecting new timezone
        driver.findElement(By.xpath(xpathHelper.getValue("DateAndTime"))).click();
        WebElement timeWebElement = driver.findElement(By.id(xpathHelper.getValue("Timezone")));
        timeWebElement.sendKeys("HST");
        Reporter.log("date/time is changed");

        //Date&Time- Selecting NTP
        driver.findElement(By.xpath(xpathHelper.getValue("NTP"))).click();
        Reporter.log("Changed Date and time - NTP");

        //save the changes
        WebElement saveDevice = driver.findElement(By.xpath(xpathHelper.getValue("Save")));
        js.executeScript("arguments[0].scrollIntoView();", saveDevice);
        saveDevice.click();

        //Video/Audio Image Settings
        driver.findElement(By.xpath(xpathHelper.getValue("VideoAudio"))).click();
        Reporter.log("Navigated to video/audio tab");
        driver.findElement(By.xpath(xpathHelper.getValue("ImageSettings"))).click();
        Reporter.log("Navigated to ImageSettings tab");
        driver.findElement(By.xpath(xpathHelper.getValue("PwdLineFreq"))).click();
        Reporter.log("Selected 50Hz ");
        WebElement hdrOff= driver.findElement(By.xpath(xpathHelper.getValue("TrueDetailHDR")));
        hdrOff.click();
        js.executeScript("arguments[0].scrollIntoView();", hdrOff);
        Reporter.log("HDR is off");

        //Advanced Light Management Technology setting
        driver.findElement(By.xpath(xpathHelper.getValue("FrameRate"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("Balanced"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("Motion"))).click();
        Reporter.log("Selected Motion");

        // Exposure Setting
        WebElement ExpComp= driver.findElement(By.xpath(xpathHelper.getValue("ExposureComp")));
        ExpComp.clear();
        ExpComp.sendKeys("7");
        Reporter.log("Selected Exposure Setting");

        //Brightness Setting
        WebElement Brightness= driver.findElement(By.xpath(xpathHelper.getValue("Brightness")));
        Brightness.clear();
        Brightness.sendKeys("50");
        Reporter.log("Selected brightness- 50");

        //Contrast Setting
        WebElement Contrast= driver.findElement(By.xpath(xpathHelper.getValue("Contrast")));
        Contrast.clear();
        Contrast.sendKeys("9");
        Reporter.log("Selected contrast- 9");

        //Sharpness Setting
        WebElement Sharpness= driver.findElement(By.xpath(xpathHelper.getValue("Sharpness")));
        Sharpness.clear();
        Sharpness.sendKeys("10");
        Reporter.log("Selected Sharpness- 10");

        //Saturation Setting
        WebElement Saturation= driver.findElement(By.xpath(xpathHelper.getValue("Saturation")));
        Saturation.clear();
        Saturation.sendKeys("8");
        Reporter.log("Selected saturation- 8");

        //Enable Wide Dynamic Range
        WebElement Wdr= driver.findElement(By.xpath(xpathHelper.getValue("WideDynamicRange")));
        Wdr.click();
        Reporter.log("Enable Wide Dynamic Range");
        js.executeScript("arguments[0].scrollIntoView();",Wdr);

        //WdrValue Setting
        WebElement WdrValue= driver.findElement(By.xpath(xpathHelper.getValue("Wdr")));
        WdrValue.clear();
        WdrValue.sendKeys("50");
        Reporter.log("WdrValue- 50");

        //Camera mount position setting
        WebElement mount = driver.findElement(By.xpath(xpathHelper.getValue("CameraMountPosition")));
        mount.click();
        driver.findElement(By.xpath(xpathHelper.getValue("CameraTable"))).click();
        Reporter.log("Camera mount position is set to Table");
        js.executeScript("arguments[0].scrollIntoView();", mount);
        Thread.sleep(2000);

        //Rotate camera setting
        WebElement Rotate=driver.findElement(By.xpath(xpathHelper.getValue("RotateCamera")));
        Rotate.click();
        Reporter.log("Rotate camera setting set to Invert");

        //IR Cut Filter setting
        WebElement Filter=driver.findElement(By.xpath(xpathHelper.getValue("IrCutFilter")));
        Filter.click();
        driver.findElement(By.xpath(xpathHelper.getValue("IrNightMode"))).click();
        Reporter.log("IR Cut Filter setting set to Night Mode");

        //colour space setting
        driver.findElement(By.xpath(xpathHelper.getValue("ColourSpace"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("ColourFS"))).click();
        Reporter.log("colour space setting set to BT709 FS");

        //Save the changes
        WebElement saveImg = driver.findElement(By.xpath(xpathHelper.getValue("SaveChanges")));
        saveImg.click();
        Thread.sleep(70000);

        //Overlays Tab
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpathHelper.getValue("VideoAudio"))).click();
        Reporter.log("Navigated to video/audio tab");
        driver.findElement(By.xpath(xpathHelper.getValue("Overlays"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("Add"))).click();
        WebElement CaptionName= driver.findElement(By.xpath(xpathHelper.getValue("CaptionName")));
        CaptionName.click();
        CaptionName.sendKeys("Testing");
        Reporter.log("Added ScreeCaptionName");
        driver.findElement(By.xpath(xpathHelper.getValue("TimeRadiobtn"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("TimeFormat"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("SelectTimeFormat"))).click();
        Reporter.log("Added timeFormat");
        driver.findElement(By.xpath(xpathHelper.getValue("DateDropdwnlist"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpathHelper.getValue("DateFormat"))).click();
        Reporter.log("Added dateFormat");
        Thread.sleep(2000);

        WebElement PositionDropdwnlist= driver.findElement(By.xpath(xpathHelper.getValue("PositionDropdwnlist")));
        js.executeScript("arguments[0].scrollIntoView();", PositionDropdwnlist);
        PositionDropdwnlist.click();
        WebElement Position= driver.findElement(By.xpath(xpathHelper.getValue("PositionType")));
        js.executeScript("arguments[0].scrollIntoView();", Position);
        Position.click();
        WebElement FontSize=driver.findElement(By.xpath(xpathHelper.getValue("Size")));
        FontSize.clear();
        FontSize.sendKeys("24");
        Reporter.log("Added FontSize");
        driver.findElement(By.xpath(xpathHelper.getValue("TextColor"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("Yellow"))).click();
        Reporter.log("Added Text Colour");
        driver.findElement(By.xpath(xpathHelper.getValue("AddCaption"))).click();
        Reporter.log("Added new overlay");
        Thread.sleep(1000);

        //Global StreamLite Compression
        driver.findElement(By.xpath(xpathHelper.getValue("VideoAudio"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("GlobalStream"))).click();
        Reporter.log("Navigated to Global StreamLite Compression Settings tab");
        WebElement ColourMap = driver.findElement(By.xpath(xpathHelper.getValue("ColourMap")));
        Reporter.log("selected ColourMap");
        ColourMap.click();
        driver.findElement(By.xpath(xpathHelper.getValue("MotionDetection"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("TrackObject"))).click();
        Reporter.log("selected tracked objects");
        WebElement RegionSize= driver.findElement(By.xpath(xpathHelper.getValue("RectPercentage")));
        RegionSize.clear();
        RegionSize.sendKeys("50");
        Reporter.log("RectPercentage set to 50 ");
        WebElement RegionPersistance=driver.findElement(By.xpath(xpathHelper.getValue("RectPersistence")));
        RegionPersistance.clear();
        RegionPersistance.sendKeys("30");
        Reporter.log("RectPersistence set to 30 ");
        WebElement MergeCenterDistance = driver.findElement(By.xpath(xpathHelper.getValue("CenterDistance")));
        js.executeScript("arguments[0].scrollIntoView();", MergeCenterDistance);
        MergeCenterDistance.clear();
        MergeCenterDistance.sendKeys("15");
        Reporter.log("CenterDistance set to 15 ");
        driver.findElement(By.xpath(xpathHelper.getValue("MotionAlgorithm"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("MotionTrigger"))).click();
        WebElement ThresholdToMotion = driver.findElement(By.xpath(xpathHelper.getValue("ThresholdToMotion")));
        ThresholdToMotion.clear();
        ThresholdToMotion.sendKeys("15");
        Reporter.log("ThresholdToMotion set to 15 ");
        WebElement ThresholdToNoMotion = driver.findElement(By.xpath(xpathHelper.getValue("ThresholdToNoMotion")));
        ThresholdToNoMotion.clear();
        ThresholdToNoMotion.sendKeys("15");
        Reporter.log("ThresholdToNoMotion set to 15 ");
        WebElement Delay = driver.findElement(By.xpath(xpathHelper.getValue("Delay")));
        Delay.clear();
        Delay.sendKeys("15");
        Reporter.log("Delay set to 15 ");

        //Save the changes
        WebElement savevideo = driver.findElement(By.xpath(xpathHelper.getValue("Save")));
        js.executeScript("arguments[0].scrollIntoView();", savevideo);
        savevideo.click();

        //Motion/Analytics
        Thread.sleep(2000);
        WebElement motionanalytics= driver.findElement(By.xpath(xpathHelper.getValue("SearchmotionTab")));
        motionanalytics.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement Motionsettings= driver.findElement(By.xpath(xpathHelper.getValue("MotioAnalytics")));
        Motionsettings.sendKeys(Keys.ENTER);
        Reporter.log("Navigated to Global Settings tab");
        WebElement sensitivity = driver.findElement(By.xpath(xpathHelper.getValue("Sensitivity")));
        sensitivity.clear();
        sensitivity.sendKeys("15");
        Reporter.log("sensitivity set to 15 ");
        WebElement threshold = driver.findElement(By.xpath(xpathHelper.getValue("Threshold")));
        threshold.clear();
        threshold.sendKeys("15");
        Reporter.log("threshold set to 15 ");
        WebElement latency = driver.findElement(By.xpath(xpathHelper.getValue("Latency")));
        latency.clear();
        latency.sendKeys("400");
        Reporter.log("latency set to 15 ");
        WebElement persistance = driver.findElement(By.xpath(xpathHelper.getValue("Persistance")));
        persistance.clear();
        persistance.sendKeys("1000");
        Reporter.log("persistance set to 1000 ");
        WebElement height = driver.findElement(By.xpath(xpathHelper.getValue("Height")));
        height.clear();
        height.sendKeys("15");
        Reporter.log("height set to 15 ");

        //Save the changes
        WebElement save = driver.findElement(By.xpath(xpathHelper.getValue("SaveMotionSettings")));
        js.executeScript("arguments[0].scrollIntoView();", save);
        save.click();

        //Users	 Profile
        WebElement user= driver.findElement(By.xpath(xpathHelper.getValue("SearchUser")));
        user.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(xpathHelper.getValue("NewUser"))).click();
        WebElement un= driver.findElement(By.xpath(xpathHelper.getValue("UserName")));
        un.sendKeys("admin1");
        WebElement pwd= driver.findElement(By.xpath(xpathHelper.getValue("Password")));
        pwd.sendKeys("Admin@121");
        WebElement cnpwd= driver.findElement(By.xpath(xpathHelper.getValue("Confirmpassword")));
        cnpwd.click();
        cnpwd.sendKeys("Admin@121");
        WebElement accesslevel= driver.findElement(By.xpath(xpathHelper.getValue("Level")));
        js.executeScript("arguments[0].scrollIntoView();", accesslevel);
        accesslevel.click();
        driver.findElement(By.xpath(xpathHelper.getValue("User"))).click();
        driver.findElement(By.xpath(xpathHelper.getValue("AddNewUser"))).click();
        Reporter.log("New user is added");

        //Device TAB- Navigating to Device tab
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpathHelper.getValue("Device"))).click();
        Reporter.log("Navigatied to Device tab");

        //Firmware upgrade code//

    }
}