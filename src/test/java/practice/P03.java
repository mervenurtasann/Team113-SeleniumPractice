package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03 {
    /*
            ...Exercise3...
        Navigate to  https://testpages.herokuapp.com/styled/index.html
        Click on  Calculater under Micro Apps
        Type any number in the first input
        Type any number in the second input
        Click on Calculate
        Get the result
        Print the result
    */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculater under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        Thread.sleep(2000);

        // Type any number in the first input
        WebElement firstInput = driver.findElement(By.id("number1"));
        firstInput.sendKeys("50");
        Thread.sleep(2000);

        // Type any number in the second input
        WebElement secondInput = driver.findElement(By.id("number2"));
        secondInput.sendKeys("55");
        Thread.sleep(2000);

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(2000);

        // Get the result
        WebElement result = driver.findElement(By.id("answer"));

        // Print the result
        System.out.println(result.getText());

        Thread.sleep(2000);
        driver.quit();

    }
}
