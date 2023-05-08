package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    /*
           . .Exercise2...
      1-Driver oluşturalim
      2-Java class'imiza chnomedriver. exetyi tanitalim
      3-Driver'in tum ekranı kaplamasini sagu ayalim
      4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sqyfq Yüklenirse, beklemeyi bıraksın.
      5-"https://www.otta.de" adresine gidelim
      6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
      7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
      8-Ardindan "https://wisequarter.com/" adresine gidip
      9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
      10-Bir onceki web sayfamiza geri donelim
      11-Sayfayı yenileyelim
      12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
      13- En son adim olarak butun sayfalarimizi kapatmis olalim
    */
    public static void main(String[] args) throws InterruptedException {
        // 1-Java class'imiza chnomedriver. exe'yi tanitalim
        WebDriverManager.chromedriver().setup();

        // Driver oluşturalim
        WebDriver driver = new ChromeDriver();

        // 3-Driver'in tum ekranı kaplamasini sagu ayalim
        driver.manage().window().maximize();

        // 4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye)
        // boyunca beklesini söyleyelim. Egen oncesinde sqyfq Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        // 5-"https://www.otta.de" adresine gidelim
        driver.get("https://www.otta.de");

        // 6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // 7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        String expectedIcerik= "0TT0";
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title testi FAILED");
        }

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("URL testi PASSED");
        } else {
            System.out.println("URL testi FAILED");
        }

        // 8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");

        // 9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        String actualBaslik = driver.getTitle();
        boolean isTrue = actualBaslik.contains("Quarter"); // true-false

        if (isTrue){
            System.out.println("Quarter testi PASSED");
        } else {
            System.out.println("Quarter testi FAILED");
        }

        // 10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(2000);

        // 11-Sayfayı yenileyelim
        driver.navigate().refresh();

        // 12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().forward();

        // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
