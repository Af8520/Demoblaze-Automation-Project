package Leasson14;

import org.testng.annotations.Test;

public class GroupsExample2 {
    @Test(groups={"Samsung"})
    public void test01(){
        System.out.println("Samsung - sanity01");
    }
    @Test(groups={"Samsung"})
    public void test02(){
        System.out.println("Samsung - sanity02");
    }
    @Test(groups={"iPhone"})
    public void test03(){
        System.out.println("iPhone - sanity01");
    }
    @Test(groups={"iPhone"})
    public void test04(){
        System.out.println("iPhone - sanity02");
    }
    @Test(groups={"Samsung","iPhone"})
    public void test05(){
        System.out.println("Samsung & iPhone - sanity");
    }

}
