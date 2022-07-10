package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
        System.out.println("fourth task done.\n\n\n");

        WebElement link = selenium.getDriver().findElement(By.linkText("Home"));
        link.click();
        selenium.setUrl(selenium.getDriver().getCurrentUrl());
        Thread.sleep(10000);

        WebElement i = selenium.getDriver().findElement(By.xpath("//img[@ src='images/hdr_tips.gif']"));
        Boolean p =(Boolean) ((JavascriptExecutor)selenium.getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
        verify(p);
        Thread.sleep(5000);
        System.out.println("Fifth task done.\n\n\n");


        link= selenium.getDriver().findElement(By.linkText("Destinations"));
        link.click();
        selenium.setUrl(selenium.getDriver().getCurrentUrl());
        actualUrl= selenium.getUrl();
        assertEquals(actualUrl, "https://demo.guru99.com/test/newtours/destination.php");
        selenium.printUrl();

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
            System.out.println("eighth and nineth tasks done.\n\n\n");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            selenium.getDriver().quit();
            System.out.println("Tenth tasks done.\n\n\n");
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
    private static void verify(Boolean b){
        if (b){
            System.out.println("Image is on display");
        }
        else {
            System.out.println("Image isn't on display");
        }
    }

}

