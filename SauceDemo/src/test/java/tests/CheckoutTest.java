package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {


    @Epic("Заполнение информации о покупателе")
    @Feature("Форма регистрации")
    @Story("Ввод пустого имени в форме")
    @Description("проверка регистрации покупателя с пустыми полями")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-04")
    @Issue("SD-BUG-04")
    @Flaky
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


    @Epic("Заполнение информации о покупателе")
    @Feature("Форма регистрации")
    @Story("Ввод пустого имени в форме")
    @Description("проверка регистрации покупателя с пустым полем для имени")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-01")
    @Issue("SD-BUG-01")
    @Flaky
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

    @Epic("Заполнение информации о покупателе")
    @Feature("Форма регистрации")
    @Story("Ввод пустого имени в форме")
    @Description("проверка регистрации покупателя с пустым полем для фамилии")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-02")
    @Issue("SD-BUG-02")
    @Flaky
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

    @Epic("Заполнение информации о покупателе")
    @Feature("Форма регистрации")
    @Story("Ввод пустого имени в форме")
    @Description("проверка регистрации покупателя с пустым полем для кода")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-03")
    @Issue("SD-BUG-03")
    @Flaky
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

    @Epic("Заполнение информации о покупателе")
    @Feature("Форма регистрации")
    @Story("Ввод данных в пустые поля")
    @Description("проверка регистрации покупателя с верно заполненными полями")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-05")
    @Issue("SD-BUG-05")
    @Flaky
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
