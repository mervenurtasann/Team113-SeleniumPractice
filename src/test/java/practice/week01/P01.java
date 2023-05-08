package practice.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01 {
    // ....Exercise-1:...
    // Create a new class with main method
    // Set Path
    // Create a chrome driver
    // Maximize window
    // Open google home page https://www.google.com
    // On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
    // Wait about 4 sn
    // Navigate forward to amazon
    // Refresh page
    // Close/quit the browser
    // And Last step print "All is well" on console

    //   Create a new class with main method
    public static void main(String[] args) throws InterruptedException {

        // Set Path
        WebDriverManager.chromedriver().setup();
        // Bu satirda driver'imizi tanittik ve yolunu gosterdik

        // Create a chrome driver
        WebDriver driver = new ChromeDriver();
        // Calisacagimiz tarayiciyi belirledik

        // Maximize window
        driver.manage().window().maximize();
        // Bu satirda acilan pencerimizi maximum boyuta ulastirdik (fullscreen degil)

        // Open google home page https://www.google.com
        driver.get("https://www.google.com");
        // Gidecegimiz adresi belirledik
        // Get ile navigate komutlarin kullanirken get komutu daha hizli calistigi icin tercih edilir
        // navigate komutu is daha cok bagimli durumlarda tercih edilir

        // On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);
        // and navigate back to google
        driver.navigate().back();

        // Wait about 4 sn
        Thread.sleep(4000);

        // Navigate forward to amazon
        driver.navigate().forward();

        // Refresh page
        driver.navigate().refresh();
        Thread.sleep(2000);

        // Close/quit the browser
        // Close son acik sayfayi kapatir
        // quit ise tum sayfalari kapatir
        driver.quit();

        // And Last step print "All is well" on console
        System.out.println("All is wel");
    }
}
