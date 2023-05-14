package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String ht = "https://";
        driver.get(ht + "google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to(ht + "amazon.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        String handle = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle()); // 1317D53431F75094971AC11B22B37966
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ht + "wisequarter.com");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(handle);
        // driver.close(); // acik olan son browser'i kapatir, Tum sekmeleriyle...
        driver.quit(); // birden fazla acilmis browser'larin tumunu kapatir

    }
}
