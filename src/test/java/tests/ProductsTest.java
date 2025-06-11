package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test

    public void AddProductsToTheCart(){
        loginPage.open();
        loginPage.login(user, password);
        /*явное ожидание*/
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.getText();
        Assert.assertEquals(productsPage.getText(),
                "Remove",
                "Товар не в корзине");
        productsPage.CheckProductInTheCart();
        Assert.assertEquals(productsPage.getNameProducts(),
                "Sauce Labs Backpack",
                "Товар нет в козине");
        productsPage.Checkout();
    }
}
