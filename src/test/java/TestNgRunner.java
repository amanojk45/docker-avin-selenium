import org.testng.TestNG;
import org.testng.xml.Parameters;
import upgrade.automation.AddCredentials;
import upgrade.automation.ApplyReset;
import upgrade.automation.UpgradeTo;

/**
 * @author Naveena U S
 */
public class TestNgRunner {

    static TestNG testNG;

    public static void main(String[] args){
        testNG = new TestNG();
        testNG.setDefaultTestName("firmwareUpgrade");
        testNG.setPreserveOrder(true);
        Parameters parameters = new Parameters();
        parameters.addLocalParameter("username","admin");
        parameters.addLocalParameter("password","Admin@86");
        parameters.addLocalParameter("url","192.168.4.86/index.html");
        parameters.addLocalParameter("firmwareVersion","1.0.2");
        parameters.addLocalParameter("cameraVersion","12");

        parameters.addAllParameter("username","admin");
        parameters.addAllParameter("password","Admin@86");
        parameters.addAllParameter("url","192.168.4.86/index.html");
        parameters.addAllParameter("firmwareVersion","1.0.2");
        parameters.addAllParameter("cameraVersion","12");

        testNG.setThreadCount(10);
        testNG.setTestClasses(new Class[]{ApplyReset.class, AddCredentials.class, UpgradeTo.class});
        testNG.run();

    }
}
