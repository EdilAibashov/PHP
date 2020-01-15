package io.techleadacademy.zz_old.Jan12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {
    @DataProvider(name = "dataName")
    public Object[][] testData(){
        Object[][] data = new Object[3][2];
        data[0][0] = 4;
        data[0][1] = 2 + 2;
        data[1][0] = 200 + 50;
        data[1][1] = 250;
        data[2][0] = 300 + 20;
        data[2][1] = 320;
        return data;
    }
//    @DataProvider(name = "str")
//    public Object[] Str(){
//        Object dt = new Object();
//        dt = "Java";
//        dt = "Java";
//        return (Object[]) dt;
//    }
//    @Test(dataProvider = "str")
//    public void Name(String actual, String expected){
//        System.out.println("Actual: "+actual+"Expected: "+expected);
//        Assert.assertEquals(actual,expected);
//    }


    @Test(dataProvider = "dataName")
    public void AdditionalTest(int actual, int expected) {
//        int actual = a + b;
//        int expected = 4;
        System.out.println("Actual: " + actual + " | Expected: " + expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void AdditionalTest1() {
        int actual = 2000 + 200;
        int expected = 2200;
        System.out.println("Actual: " + actual + " | Expected: " + expected);
        Assert.assertEquals(actual, expected);
    }
}