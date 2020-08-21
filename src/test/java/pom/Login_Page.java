package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class Login_Page extends Base_Page {

	@FindBy(id = "username")
	private WebElement userNameTextField;

	@FindBy(name = "pwd")
	private WebElement passwordTextFiled;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginButton;

	@FindBy(xpath="//span[@class='errormsg']")
	private WebElement errMessage;

	public Login_Page(WebDriver driver) {
		super(driver);
	}

	public void setUserName(String fn) {
		userNameTextField.sendKeys(fn);
	}

	public void setPassword(String password) {
		passwordTextFiled.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void verifyErrorMessage() {
		verifyElement(errMessage, 15);
	}
}
