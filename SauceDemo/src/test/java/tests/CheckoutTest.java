package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {


    @Test (testName = "Негативный тест регистрации",
            description = "Проверка регистрации с пустыми полями")
    public void checkEmptyFieldsError() {

        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.getTitle();
        productsPage.clickAdd();
        productsPage.checkProductInTheCart();
        productsPage.checkout();
        checkoutPage.getTitle();
        checkoutPage.check("", "", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test (testName = "Негативный тест регистрации",
            description = "Проверка регистрации с пустым полем имени")
    public void checkTheFirstNameError() {

        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.getTitle();
        productsPage.clickAdd();
        productsPage.checkProductInTheCart();
        productsPage.checkout();
        checkoutPage.getTitle();
        checkoutPage.check("", "TestTest", "123456789");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test (testName = "Негативный тест регистрации",
            description = "Проверка регистрации с пустым полем фамилии")
    public void checkTheLastNameError() {

        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.getTitle();
        productsPage.clickAdd();
        productsPage.checkProductInTheCart();
        productsPage.checkout();
        checkoutPage.getTitle();
        checkoutPage.check("Test", "", "123456789");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение об ошибке не появилось");
    }

    @Test (testName = "Негативный тест регистрации",
            description = "Проверка регистрации с пустым полем кода")
    public void checkThePostalCodeError() {

        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.getTitle();
        productsPage.clickAdd();
        productsPage.checkProductInTheCart();
        productsPage.checkout();
        checkoutPage.getTitle();
        checkoutPage.check("Test", "TestTest", "");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не появилось");
    }

    @Test (testName = "Положительный тест",
            description = "Проверка регистрации с полностью заполненными полями")
    public void checkCorrectFilling() {

        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.getTitle();
        productsPage.clickAdd();
        productsPage.checkProductInTheCart();
        productsPage.checkout();
        checkoutPage.getTitle();
        checkoutPage.check("Test", "TestTest", "123456789");
        Assert.assertEquals(overviewPage.getTitle(),
                "Checkout: Overview",
                "Заказ не совершен");
    }
}
