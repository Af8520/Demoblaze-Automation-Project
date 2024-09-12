package Leasson14;

import org.testng.annotations.Test;

    public class TestNGex {
        @Test (groups = {"sanity"})
        public void Test01() {
            System.out.println("MyTestNG2_Test01");
        }

        @Test (groups = {"regression"})
        public void Test02() {
            System.out.println("MyTestNG2_Test02");
        }

        @Test (groups = {"sanity"})
        public void Test03() {
            System.out.println("MyTestNG2_Test03");
        }
    }



