package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_Odev extends TestBase {
    // ilgili kurulumlari tamamlayalim

    @Test
    public void test01() {
        // Kullanici https://www.google.com adresine gider
        driver.get("https://www.google.com");

        // Çıkıyorsa Kullanici cookies i kabul eder
        // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("usd to tl");

        // Para birimlerinin karsilastirmasini alin
        aramaKutusu.submit();
        WebElement sonuc = driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        String actualSonuc = sonuc.getText().replaceAll("\\D", ".");
        double actualSonucc = Double.parseDouble(actualSonuc);
        double expectedSonuc = 1.5;


        // Karsilastirilacak olan para biriminin 1.5 den kUCUk oldygu test edilir
        Assert.assertTrue(actualSonucc < expectedSonuc);
    }
}
