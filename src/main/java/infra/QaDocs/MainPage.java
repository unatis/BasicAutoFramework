package infra.QaDocs;

import infra.Common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "section_1")
    WebElement mainPage;

    @FindBy(linkText = "Let's begin")
    WebElement letsBeginButton;

    private Common common = null;

    public MainPage(Common commonObj) {
        common = commonObj;
        PageFactory.initElements(common.getDriver(), this);
    }

    public void verifyMainPage() {

        try {

            common.isElementPresent(By.id("content"));

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

    public void clickLetsBeginButton() {
        try {

            letsBeginButton.click();

        } catch (Exception e) {
            common.Report(e.getMessage(), Common.MessageColor.RED);
        }
    }

}
