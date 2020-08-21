package generic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base_Page {

	WebDriver driver;

	public Base_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle(String title, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.titleContains(title));
			System.out.println("valid title");
		} catch (Exception e) {
			System.out.println("invalid title");
			Assert.fail();
		}
	}

	public void verifyElement(WebElement element, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println("element visible");
		} catch (Exception e) {
			System.out.println("element not vissible");
			Assert.fail();
		}
	}

	public void verifyTab(int noOfWindow, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindow));
			System.out.println("child tab is present");
		} catch (Exception e) {
			System.out.println("child tab not present");
			Assert.fail();
		}
	}

	public void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void selectByName(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public List<String> getAllOptionsDropDown(WebElement element) {
		List<String> l1 = new ArrayList<String>();
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement opt : options) {

			l1.add(opt.getText());
		}
		return l1;
	}

	public void scrollToSpecificLocation(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void selectDropdown(WebDriver driver, String xpathExpression, String inputVal) {

		Select sel = new Select(driver.findElement(By.xpath(xpathExpression)));
		sel.selectByVisibleText(inputVal);

		System.out.println("Selected Dropdown - " + xpathExpression + " - " + inputVal);

	}

}
