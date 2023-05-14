package practice;

import org.junit.*;

public class P08 {

    /*
      @BeforeClass // Sadece 1 kere calisiyor
      @Before // Her testten once 1 kere calisir
      @AfterClass // Tum testlerden sonra 1 kere calisir
      @After // her testten sonra 1 kere calisir
      @Test // Yapacagımız test kodlarinin yer aldigi kisim
     */
    @Test
    public void test01(){
        System.out.println("test 01");
    }
    @Test
    public void test02(){
        System.out.println("test 02");
    }
    @Test
    public void test03(){
        System.out.println("test 03");
    }
}
