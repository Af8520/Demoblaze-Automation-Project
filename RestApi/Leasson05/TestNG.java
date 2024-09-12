package Leasson05;


import org.testng.annotations.*;

public class  TestNG {

    @BeforeClass
    public static void BeforeClass()
    {
        System.out.println("BeforeClass");
    }
    @Test
    public void test01(){
        System.out.println("test01");
    }
    @Test
    public void test02()
    {
        System.out.println("Test02");
    }
    @BeforeMethod
    public static void beforeMethod()
    {
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public static void afterMethod()
    {
        System.out.println("AfterMethod");
    }
    @AfterClass
    public static void afterClass()
    {
        System.out.println("AfterClass");
    }

}




