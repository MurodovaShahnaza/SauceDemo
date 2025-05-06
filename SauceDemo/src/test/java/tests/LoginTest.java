package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{




    @Test (testName = "Негативный тест логина",
            description = "Проверка логина в систему с пустым полем пароль")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
    }

    @Test (testName = "Негативный тест логин",
            description = "Проверка логина в системе с ложным паролем")
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123456");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Test (testName = "Негативный тест логин",
            description = "Проверка логина в системе с пустым полем логин")
    public void checkLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
    }

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