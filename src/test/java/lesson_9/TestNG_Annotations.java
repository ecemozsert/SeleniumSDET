package lesson_9;

import org.testng.annotations.*;

public class TestNG_Annotations {

    @BeforeSuite     public void test1(){   System.out.println("1");     }
    @BeforeTest      public void test2(){   System.out.println("2");     }
    @BeforeClass     public void test3(){   System.out.println("3");     }
    @BeforeGroups    public void test4(){   System.out.println("4");     }
    @BeforeMethod    public void test5(){   System.out.println("5");     }
    @Test            public void test6(){   System.out.println("6");     }
    @Test            public void test8(){
        System.out.println("6");
    }
    @Test            public void test9(){
        System.out.println("6");
    }

    @AfterSuite      public void test1TearDown(){
        System.out.println("test1 içerisindeki suite'i sonlandır");
    }
}
