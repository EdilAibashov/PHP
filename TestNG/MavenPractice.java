package io.techleadacademy.zz_old.TestNG;

import io.techleadacademy.TestData;
import org.testng.annotations.Test;
@Test
public class MavenPractice {
    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");

        TestData test = new TestData();
        System.out.println(TestData.RndmName());
        System.out.println(TestData.RndmFName());
        System.out.println(TestData.PhnNumber());
        System.out.println(TestData.RndmAddress());
    }
}
