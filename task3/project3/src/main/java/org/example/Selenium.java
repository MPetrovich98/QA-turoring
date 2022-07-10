package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * A Camel Java DSL Router
 */
public class Selenium   {

    private WebDriver driver;

    private String url;

    public Selenium() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\milannp\\Downloads\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
        url= driver.getCurrentUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void printUrl(){
        System.out.println("actual web page is "+driver.getCurrentUrl());
    }
}
