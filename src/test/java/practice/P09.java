package practice;

import org.junit.*;

public class P09 {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class calisti");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class calisti");
    }

    @Before
    public void before(){
        System.out.println("Yeni bir test calistiriliyor");
    }
    @After
    public void after(){
        System.out.println("Calistirilan test sonlandiriliyor");
        System.out.println("=================================");
    }
    @Test
    public void test01(){
        System.out.println("Test Case 01 Calistirildi");
    }
    @Test
    public void test02(){
        System.out.println("Test Case 02 Calistirildi");
    }
    @Test
    public void test03(){
        System.out.println("Test Case 03 Calistirildi");
    }
}
