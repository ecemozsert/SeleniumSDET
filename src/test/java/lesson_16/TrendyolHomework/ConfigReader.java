package lesson_16.TrendyolHomework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    // 2- Bu class'in amaci configuration.properties dosyasini okumak
    //    ve oraadaki key value ikililerini kullanarak istedigimiz key'e ait value'yu bize getirmek
    //
    static {
        String dosyaYolu="C:\\Users\\ecozsert\\training\\training\\src\\test\\java\\lesson_16\\TrendyolHomework\\configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3- test class'larindan configReader class'ina ulasip yukaridaki islemleri
    //    yapmamizi saglayacak bir method olusturacagiz
    public static String getProperty(String key){

        String value=properties.getProperty(key);
        return value;
    }
}