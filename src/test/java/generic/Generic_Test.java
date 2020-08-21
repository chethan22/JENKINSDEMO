package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Generic_Test {

	FileManger fm = new FileManger();
	public WebDriver driver;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setUP() {
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/index.html");
		reporter.config().setDocumentTitle("version peacock 312.02");
		reporter.config().setReportName("Regrression test cases");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@AfterSuite
	public void tearDown() {
		extent.setSystemInfo("windows", "10");
		test.assignAuthor("chethan");
		test.assignCategory("web automation on chrome");
		test.assignDevice("desktop");
		extent.flush();
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void openApplication(@Optional("chrome") String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(fm.getQatUrl());

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(fm.getQatUrl());
		}

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fm.getimplicitlyWait(), TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown(ITestResult res) {
		// System.out.println(res.getStatus());
		String testName = res.getName();
		if (ITestResult.FAILURE == res.getStatus()) {
			test.fail(
					MediaEntityBuilder.createScreenCaptureFromPath(new ScreenShot().capture(driver, testName)).build());
			// new ScreenShot().capture(driver, testName);
		}
		driver.quit();
	}
}
