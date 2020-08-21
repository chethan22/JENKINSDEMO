package regressionScripts;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Excel;
import generic.Generic_Test;
import pom.Enter_Time_Track;
import pom.Login_Page;
import pom.ReportBugPage;

public class Regression extends Generic_Test {

	@Test(priority = 1)
	public void validLoginLogout() {

		test = extent.createTest("validLoginLogout");
		test.log(Status.INFO, "validLoginLogout script stated excueting");
		String username = Excel.readData("regression", 1, 0);
		String password = Excel.readData("regression", 1, 1);
		String hp_title = Excel.readData("regression", 1, 3);
		Login_Page lp = new Login_Page(driver);
		lp.setUserName(username);
		test.pass("valid username added successfuly");
		lp.setPassword(password);
		test.pass("valid password added successfuly");
		lp.clickLogin();
		test.pass("login successfuly");
		Enter_Time_Track ett = new Enter_Time_Track(driver);
		ett.verifyTitle(hp_title, 10);
		test.pass("verifyed home page successfully");
		ett.clickLogout();
		test.pass("succucssfully logout");
		test.log(Status.INFO, "validLoginLogout script ended excueting");
	}

	@Test(priority = 2)
	public void InvalidLogin() {
		test = extent.createTest("InvalidLogin");
		test.log(Status.INFO, "InvalidLogin script stated excueting ");
		String username = Excel.readData("regression", 2, 0);
		String password = Excel.readData("regression", 2, 1);
		String lp_title = Excel.readData("regression", 2, 2);
		Login_Page lp = new Login_Page(driver);
		lp.setUserName(username);
		test.pass("invalid username added successfuly");
		lp.setPassword(password);
		test.pass("invalid password added successfuly");
		lp.clickLogin();
		test.pass("click on successfuly");
		// lp.verifyErrorMessage();
		lp.verifyTitle(lp_title, 20);
		test.pass("title page addedd successfully");

	}

	@Test(priority = 3)
	public void verifyActimeVersion() {
		test = extent.createTest("verifyActimeVersion");
		test.log(Status.INFO, "verifyActimeVersion script stated excueting ");
		String username = Excel.readData("regression", 3, 0);
		String password = Excel.readData("regression", 3, 1);
		String eVersion = Excel.readData("regression", 3, 4);
		Login_Page lp = new Login_Page(driver);
		lp.setUserName(username);
		test.pass("valid username added successfuly");
		lp.setPassword(password);
		test.pass("valid password added successfuly");
		lp.clickLogin();
		test.pass("login successfuly");
		Enter_Time_Track ep = new Enter_Time_Track(driver);
		ep.clickHelp();
		test.pass("successfuly clicked help");
		ep.clickAboutActime();
		String aversion = ep.getActtitimeVersion();
		Assert.assertEquals(aversion, eVersion);
		test.pass("successfuly shown acttime version");
		ep.clickClose();
		test.pass("succucssfully closed");
		ep.clickLogout();
		test.pass("succucssfully logout");
		test.log(Status.INFO, "verifyActimeVersion script ended excueting ");
	}

	@Test(priority = 4)
	public void sendBugReport() {
		test = extent.createTest("sendBugReport");
		test.log(Status.INFO, "sendBugReport script stated excueting ");
		String username = Excel.readData("regression", 4, 0);
		String password = Excel.readData("regression", 4, 1);
		String bugSummary = Excel.readData("regression", 4, 5);
		String fn = Excel.readData("regression", 4, 6);
		String ln = Excel.readData("regression", 4, 7);
		String email = Excel.readData("regression", 4, 8);
		String company = Excel.readData("regression", 4, 9);

		Login_Page lp = new Login_Page(driver);
		lp.setUserName(username);
		test.pass("valid username added successfuly");
		lp.setPassword(password);
		test.pass("valid password added successfuly");
		lp.clickLogin();
		test.pass("login successfuly");
		Enter_Time_Track ep = new Enter_Time_Track(driver);
		ep.clickHelp();
		test.pass("successfuly clicked help");
		ep.ClickReportBug();
		test.pass("succucssfully clicked bug report");
		// ep.verifyTab(2, 20);
		Set<String> allWindow = driver.getWindowHandles();
		for (String win : allWindow) {
			driver.switchTo().window(win);
		}
		ReportBugPage rbp = new ReportBugPage(driver);
		rbp.enterBugDescription(bugSummary);
		test.pass("succucssfully entered description on bug summary");
		rbp.enterFirstName(fn);
		test.pass("first name added successfuly");
		rbp.enterLastName(ln);
		test.pass("last name added successfuly");
		rbp.enterEmail(email);
		test.pass("email added successfuly");
		rbp.enterCompany(company);
		test.pass("comapny added successfuly");
		rbp.clickSend();
		test.pass("sent  successfuly");
		test.log(Status.INFO, "verifyActimeVersion script ended excueting ");

	}

}
