package Lesson_8;

import org.junit.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest {
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"Jane","Kevin","Tom"})
    public void test(String names){
        System.out.println(names);

    }
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {7,11,4})
    public void test2(int numbers){
        System.out.println(numbers);
    }


}
