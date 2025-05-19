package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AllureUtils;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    private static final By REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");
    private static final By SHOPPING_CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-badge']");
    private static final By INVENTORY_ITEM_NAME = By.xpath("//*[@data-test='inventory-item-name']");
    private static final By CHECKOUT = By.xpath("//*[@id='checkout']");



    public ProductsPage(WebDriver driver) {
        super(driver);
    }



    public String getTitle(){
       return driver.findElement(TITLE).getText();

    }

    @Step("Добавление товара в корзину")
    public void clickAdd(){
        driver.findElement(ADD_TO_CART_BUTTON).click();

    }

    public String getText(){
        return driver.findElement(REMOVE_BUTTON).getText();
    }

    public void checkProductInTheCart(){
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }


    @Step("Нажатие на кнопку CHECKOUT")
    public void checkout(){
        driver.findElement(CHECKOUT).click();

    }
    public String getNameProducts(){
        return  driver.findElement(INVENTORY_ITEM_NAME).getText();
    }
}



