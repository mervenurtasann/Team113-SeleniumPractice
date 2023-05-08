package practice.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05_Odev {
     public static void main(String[] args) throws InterruptedException {
          // 1-Driver oluşturalim
          // 2-Java class'imiza chnomedriver. exetyi tanitalim
          WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver();

          // 3-Driver'in tum ekranı kaplamasini sagu ayalim
          driver.manage().window().maximize();

          // 4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim.
          //  Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

          // 5-Navigate to http://www.babayigit.net/murat/testpage.html
          driver.get("http://www.babayigit.net/murat/testpage.html");

          // 6-first name, surname, age, Your Job, Birth Palace,
          //     Last graduated school, Number of Children
          //     alanlarına gerekli bilgileri yazsın
          WebElement name = driver.findElement(By.id("ad"));
          name.sendKeys("Merve");

          WebElement surname = driver.findElement(By.id("soyad"));
          surname.sendKeys("Tasan");

          WebElement age = driver.findElement(By.id("yas"));
          age.sendKeys("26");

          WebElement yourJob = driver.findElement(By.id("meslek"));
          yourJob.sendKeys("Ogrenci");

          WebElement birthPalace = driver.findElement(By.id("dogum_yeri"));
          birthPalace.sendKeys("Ankara");

          WebElement lastGraduatedSchool = driver.findElement(By.id("mezun_okul"));
          lastGraduatedSchool.sendKeys("Gazi Universitesi");

          WebElement numberOfChildren = driver.findElement(By.id("cocuk_sayisi"));
          numberOfChildren.sendKeys("0");

          // 7-Submit tuşuna bassın.
          driver.findElement(By.xpath("//input[@type='submit']")).click();

          // 8- All information was entered correctly.. yazısının göründüğünü test etsin
          String expectedIcerik = "All information was entered correctly..";
          String actual = driver.findElement(By.id("uyari")).getText();

          if (actual.contains(expectedIcerik)){
               System.out.println("Test PASSED");
          } else {
               System.out.println("Test FAILED");
          }


          // 9- Clear butonu ile tüm butonları temizlesin
          driver.findElement(By.xpath("//input[@type='reset']")).click();

          // 10- Manuel olarak temizlendiğini görecek kadar beklesin
          Thread.sleep(3000);

          // 11- Sayfayı kapatsın
          driver.quit();

     }
}
