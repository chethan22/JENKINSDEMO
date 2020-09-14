package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class Enter_Time_Track extends Base_Page {

	@FindBy(id = "logoutLink")
	private WebElement logOutbutton;

	@FindBy(xpath = "(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;

	@FindBy(xpath = "//a[contains(.,'About actiTIME')]")
	private WebElement aboutActime;

	@FindBy(xpath = "//span[@class='productVersion']")
	private WebElement aVersion;

	@FindBy(xpath = "//td[@class='close-button']//img")
	private WebElement close;

	@FindBy(xpath = "//a[contains(.,'Report a Bug to Vendor')]")
	private WebElement repotBugToVendor;

	public Enter_Time_Track(WebDriver driver) {
		super(driver);
	}

	public void clickHelp() {
		help.click();
	}

	public void clickAboutActime() {
		aboutActime.click();
	}

	public String getActtitimeVersion() {
		return aVersion.getText();
	}

	public void clickClose() {
		close.click();

	}

	public void ClickReportBug() {
		repotBugToVendor.click();
	}

	public void clickLogout() {
		logOutbutton.click();
	}

}
