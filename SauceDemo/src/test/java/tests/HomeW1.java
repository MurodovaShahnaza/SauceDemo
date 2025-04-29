import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

    public class HomeW1 {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    /*не поняла суть написания class1.class2 и .class1 .class2, через tagname смогла в случае css, есть несколько вопросов*/
    @Test
    public void test() {
        driver.get("https://www.saucedemo.com/");
        /*driver.findElement(By.id("username")).sendKeys(""); /*это самы простой и быстрый способ найти по id, это самый точный способ, так как имя может совпадать, а id нет*/
        /*driver.findElement(By.name("password")).sendKeys("");/*по имени можно или по тэгу, но надо чтоб тэг был уникальным*/

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");/*через id - #, через класс - .  ^ - начинается с какого то слова, $ - заканчивается  на что то*/
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.className("inventory_item_name")).click();
        driver.findElement(By.linkText("Twitter")); /*работает только нам, где есть <a>*/
        driver.findElement(By.partialLinkText("Face"));/*по частичному слову найдет, как поняла, тоже где есть <a> */
        driver.findElement(By.xpath("//div/button [@class='btn btn_secondary back btn_large inventory_details_back_button']"));
        driver.findElement(By.xpath("//a[text()='LinkedIn']"));
        driver.findElement(By.xpath("//img[contains(@alt,'Sauce')]"));/*по атрибуду нашли*/
        driver.findElement(By.xpath("//a[contains(text(),'Twi')]"));/*а работает только с а???, я пробовала и иное, но не работает */
        driver.findElement(By.xpath("//button[@id='add-to-cart']/parent::div"));
        driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']/following::div"));
        driver.findElement(By.xpath("//nav[@class='bm-item-list']/descendant::a"));
        driver.findElement(By.xpath("//nav[@class='bm-item-list']/preceding::div"));
        driver.findElement(By.xpath("//nav[@class='bm-item-list']/ancestor::div"));
        driver.findElement(By.xpath("//img[@class='bm-icon' and @alt='Open Menu']"));
        driver.findElement(By.cssSelector(".primary_header"));
        driver.findElement(By.cssSelector("[data-test='open-menu']"));
        driver.findElement(By.cssSelector("[data-test^='open']"));
        driver.findElement(By.cssSelector("[data-test$='menu']"));
        driver.findElement(By.cssSelector("[data-test|='menu']"));
        driver.findElement(By.cssSelector("div.primary_header"));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}