package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test

    public void AddProductsToTheCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        /*явное ожидание*/
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.getText();
        Assert.assertEquals(productsPage.getText(),
                "Remove",
                "Товар не в корзине");
        productsPage.CheckProductInTheCart();
        Assert.assertEquals(productsPage.getNameProducts(),
                "Checkout: Your Information",
                "Товар нет в козине");
        productsPage.Checkout();
    }
}
