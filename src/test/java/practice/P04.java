package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04 {
    /*
        Navigate to website https://testpages.herokuapp.com/styled/index.html
        Under the ORIGINAL CONTENTS
        click on Alerts
        print the URL
        navigate back
        print the URL
        Click on Basic Ajax
        print the URL
        enter value 20 and ENTER
        and then verify Submitted Values is displayed open page
        close driver
    */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Under the ORIGINAL CONTENTS click on Alerts
        driver.findElement(By.xpath("//a[@id='alerts']")).click();

        // print the URL
        System.out.println("URL : " + driver.getCurrentUrl());

        // navigate back
        driver.navigate().back();

        // print the URL
        System.out.println("URL : " + driver.getCurrentUrl());

        // Click on Basic Ajax
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();

        // print the URL
        System.out.println("URL : " + driver.getCurrentUrl());

        // enter value 20 and ENTER
        WebElement value = driver.findElement(By.id("lteq30"));
        value.sendKeys("20");
        value.submit();

        // and then verify Submitted Values is displayed open page
        String expectedIcerik="Submitted Values";
        String actualResult= driver.findElement(By.xpath("//*[text()='Submitted Values']")).getText();

        if (actualResult.equals(actualResult)){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        driver.quit();


    }
}
