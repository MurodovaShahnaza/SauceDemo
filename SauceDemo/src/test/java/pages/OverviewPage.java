package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage{

    private static final By TITLE = By.xpath("//*[@data-test='title']");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }
}
