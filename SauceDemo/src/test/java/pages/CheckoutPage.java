package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AllureUtils;

public class CheckoutPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By FIRSTNAME = By.xpath("//*[@data-test='firstName']");
    private static final By LASTNAME = By.xpath("//*[@data-test='lastName']");
    private static final By POSTALCODE = By.xpath("//*[@data-test='postalCode']");
    private static final By CONTINUE = By.xpath("//*[@data-test='continue']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }

    @Step("Заполнение вормы покупателя с именем:{firstName} ,фамилией:{lastName} и  индексом: {postalCode}")
    public void check (String name, String lname, String Code) {
        driver.findElement(FIRSTNAME).sendKeys(name);
        driver.findElement(LASTNAME).sendKeys(lname);
        driver.findElement(POSTALCODE).sendKeys(Code);
        driver.findElement(CONTINUE).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
