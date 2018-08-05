package ru.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class GoogleSearchTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        // System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        //driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void searchInGoogle() {
        driver.get("https://www.google.com/");
        driver.findElement(By.id("gs_ok0")).click();
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.id("gs_ok0")).click();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
