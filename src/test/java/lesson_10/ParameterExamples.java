package lesson_10;

import org.testng.annotations.Test;

public class ParameterExamples {
    //@Parameters({"browser","baseURL"})
    // @Parameters({"messaging","numbers"})
//    @Test
//    public void method(String browser, String baseURL){
//        System.out.println(browser);
//        System.out.println(baseURL);


    @Test
    public void messagingMethod(String messaging,String numbers){
        System.out.println(messaging);
        System.out.println(numbers);

    }
}
