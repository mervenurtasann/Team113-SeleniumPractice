package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P12 {
    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin
    // Karsilastirilacak olan para biriminin 25 den kUCUk oldygu test edilir

    static WebDriver driver;

    // ilgili kurulumlari tamamlayalim
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
        driver.get("https://www.google.com");
        WebElement searchbox = driver.findElement(By.xpath("//*[@name='q']"));
        // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
        searchbox.sendKeys("USD TO TL" + Keys.ENTER);

        // Para birimlerinin karsilastirmasini alin
        WebElement resultElement = driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
        String result = resultElement.getText().replace(",",".");
        double resultDouble = Double.parseDouble(result);

        Assert.assertTrue(resultDouble<25);

        if (resultDouble<25){
            System.out.println("Sukur hala 25'in altinda");
        } else {
            System.out.println("Dolar aldi basini gidiyor");
        }

    }
}
