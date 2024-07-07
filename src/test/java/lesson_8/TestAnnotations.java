package Lesson_8;

import org.junit.*;

public class TestAnnotations{

    @BeforeClass
    public static void BeforeClass(){
        System.out.println("Before Tests");
    }

    @Before
    public void BeforeTest(){
        System.out.println("Before Test");
    }

    @Test
    public void MyTest(){
        System.out.println("My Tests");
    }

    @After
    public void AfterTest(){
        System.out.println("After Test");
    }

    @AfterClass
    public static void AfterClass(){
        System.out.println("AfterClass");
    }
}
