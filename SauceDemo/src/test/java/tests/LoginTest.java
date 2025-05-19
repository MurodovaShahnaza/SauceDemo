package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{



    @Epic("Заполнение поля логин")
    @Feature("Поля входа")
    @Story("Ввод данных с пустым полем пароль")
    @Description("Проверка логина в систему с пустым полем пароль")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-001")
    @Issue("SD-BUG-001")
    @Flaky
    @Test (testName = "Негативный тест логина",
            description = "Проверка логина в систему с пустым полем пароль")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
    }

    @Epic("Заполнение поля логин")
    @Feature("Поля входа")
    @Story("Ввод ошибочных данных в поле пароль")
    @Description("Проверка логина в системе с ложным паролем")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-002")
    @Issue("SD-BUG-002")
    @Flaky
    @Test (testName = "Негативный тест логин",
            description = "Проверка логина в системе с ложным паролем")
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123456");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Epic("Заполнение поля логин")
    @Feature("Поля входа")
    @Story("Ввод данных с пустым полем логин")
    @Description("роверка логина в системе с пустым полем логин")
    @Severity(SeverityLevel.MINOR)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-003")
    @Issue("SD-BUG-003")
    @Flaky
    @Test (testName = "Негативный тест логин",
            description = "Проверка логина в системе с пустым полем логин")
    public void checkLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

    @Epic("Заполнение информации о покупателе")
    @Feature("Форма регистрации")
    @Story("Ввод данных в пустые поля")
    @Description("Проверка олностью верного заполнения")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Shahnoza Murodova")
    @TmsLink("SD-BUG-004")
    @Issue("SD-BUG-004")
    @Flaky
    @Test (testName = "Положительный тест",
            description = "Полностью верное заполнение")
    public void checkLoginWithPositiveCred(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }
}