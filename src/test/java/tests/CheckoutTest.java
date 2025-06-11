package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {


    @Test
    public void CheckEmptyFieldsError() {

        loginPage.open();
        loginPage.login(user,password);
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.CheckProductInTheCart();
        productsPage.Checkout();
        checkoutPage.getTitle();
        checkoutPage.check("", "", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void CheckTheFirstNameError() {

        loginPage.open();
        loginPage.login(user,password);
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.CheckProductInTheCart();
        productsPage.Checkout();
        checkoutPage.getTitle();
        checkoutPage.check("", "TestTest", "123456789");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void CheckTheLastNameError() {

        loginPage.open();
        loginPage.login(user,password);
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.CheckProductInTheCart();
        productsPage.Checkout();
        checkoutPage.getTitle();
        checkoutPage.check("Test", "", "123456789");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void CheckThePostalCodeError() {

        loginPage.open();
        loginPage.login(user,password);
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.CheckProductInTheCart();
        productsPage.Checkout();
        checkoutPage.getTitle();
        checkoutPage.check("Test", "TestTest", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void CheckCorrectFilling() {

        loginPage.open();
        loginPage.login(user,password);
        productsPage.getTitle();
        productsPage.ClickAdd();
        productsPage.CheckProductInTheCart();
        productsPage.Checkout();
        checkoutPage.getTitle();
        checkoutPage.check("Test", "TestTest", "123456789");
        Assert.assertEquals(overviewPage.getTitle(),
                "Checkout: Overview",
                "Заказ не совершен");
    }
}
