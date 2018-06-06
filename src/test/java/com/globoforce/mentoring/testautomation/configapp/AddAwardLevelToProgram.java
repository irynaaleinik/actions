package com.globoforce.mentoring.testautomation.configapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddAwardLevelToProgram {

    private WebDriver driver;
    private static final String URL = "https://test-sandbox-17.corp.globoforce.com/iaf-login-app/home?target=config-app";
    private static final String URL2 = "https://test-sandbox-17.corp.globoforce.com/iaf-config-app/manageAwardProgramsOpen?client=5005&menuid=6_1";
    private String userName = "asimk";
    private String password = "asimk1";

    private String myDashboardMenuLocator = "//div[@id='navBar']//a[@href='/microsites/t/dashboard/MyActivity?client=recipientbased']";
    private String homeMenuLocator = "//div[@id='navBar']/descendant::a[@href='/microsites/t/home?client=recipientbased']";


    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "d:\\Test Automation\\SeleniumDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.findElement(By.name("j_username")).sendKeys(userName);
        driver.findElement(By.name("j_password")).sendKeys(password);
        driver.findElement(By.className("button")).click();
        driver.navigate().to(URL2);

        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//tr[@id='yui-rec0']/td[@headers='yui-dt0-th-manageLevel ']//a[contains(.,'Add/Remove/Sort')]")).click();
        actions.dragAndDrop(driver.findElement(By.id("63040_true")), driver.findElement(By.id("current_items"))).build().perform();
        driver.quit();
    }
}
