package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.apache.camel.component.dataset.DataSetEndpoint.assertEquals;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */

    public static void main(String[] args) throws InterruptedException {
        Selenium selenium = new Selenium();
        selenium.printUrl();
        System.out.println("First three tasks done.\n\n\n");
        Thread.sleep(5000);

        WebElement usrname = selenium.getDriver().findElement(By.name("userName"));
        usrname.sendKeys("pera");
        WebElement password = selenium.getDriver().findElement(By.name("password"));
        password.sendKeys("pera");
        WebElement login =selenium.getDriver().findElement(By.name("submit"));
        login.click();
        String expectedUrl="https://demo.guru99.com/test/newtours/login_sucess.php";
        selenium.setUrl(selenium.getDriver().getCurrentUrl());
        String actualUrl= selenium.getUrl();
        assertEquals(actualUrl, expectedUrl);
        Thread.sleep(5000);

        System.out.println("fourth and fifth tasks done.\n\n\n");
        WebElement link= selenium.getDriver().findElement(By.linkText("Destinations"));
        link.click();
        selenium.setUrl(selenium.getDriver().getCurrentUrl());
        actualUrl= selenium.getUrl();
        assertEquals(actualUrl, "https://demo.guru99.com/test/newtours/destination.php");
        selenium.printUrl();
        Thread.sleep(10000);

        System.out.println("sixth and seventh tasks done.\n\n\n");
        selenium.getDriver().findElement(By.xpath("//img[@ src='images/home.gif']")).click();
        selenium.setUrl(selenium.getDriver().getCurrentUrl());
        actualUrl= selenium.getUrl();
        assertEquals(actualUrl, "https://demo.guru99.com/test/newtours/index.php");
        selenium.printUrl();
        Thread.sleep(5000);
        System.out.println("sixth and seventh tasks done.\n\n\n");
        
        try {
            link= selenium.getDriver().findElement(By.linkText("SIGN-OFF"));
            link.click();
            selenium.setUrl(selenium.getDriver().getCurrentUrl());
            actualUrl= selenium.getUrl();
            assertEquals(actualUrl, "https://demo.guru99.com/test/newtours/index.php");
            selenium.printUrl();
            Thread.sleep(5000);
            System.out.println("sixth and seventh tasks done.\n\n\n");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            selenium.getDriver().quit();
        }





    }

    private static void assertEquals(String actualUrl, String expectedUrl) {
        if (actualUrl.contentEquals(expectedUrl)){
            System.out.println("Test Passed!");
            System.out.println("expected url is "+expectedUrl);
            System.out.println("actual url is "+actualUrl);
        } else {
            System.out.println("Test Failed");
            System.out.println("expected url is "+expectedUrl);
            System.out.println("actual url is "+actualUrl);
        }
    }

}

