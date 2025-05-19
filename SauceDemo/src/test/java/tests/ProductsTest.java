package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Epic("Добавление товара в корзину")
    @Feature("Форма корзины")
    @Story("проверка наличия в корзине")
    @Description("проверка добавления товара и его наличие")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-0001")
    @Issue("SD-BUG-0001")
    @Flaky
    @Test(testName = "Проверка добавления товара в корзину",
            description = "Добавляем товар и проверяем его наличие")

    public void addProductsToTheCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        /*явное ожидание*/
        productsPage.getTitle();
        productsPage.clickAdd();
        productsPage.getText();
        Assert.assertEquals(productsPage.getText(),
                "Remove",
                "Товар не в корзине");
        productsPage.checkProductInTheCart();
        Assert.assertEquals(productsPage.getNameProducts(),
                "Sauce Labs Backpack",
                "Товар нет в козине");
        productsPage.checkout();
        Assert.assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Вы не перешли на страницу регистрации");
    }
}
