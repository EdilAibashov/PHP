package io.techleadacademy.zz_old.TestNG;

import io.techleadacademy.SeleniumWaits;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

public class TestTags {
    @Test
    public void add(){
        int actualValue = 6;
        Assert.assertTrue(actualValue ==6);

    }
    @Test
    public void add2(){
        int actualValue = -5;
        Assert.assertTrue(actualValue==-10+5);

    }
    @Test
    public void subtract(){
        int actualValue = 3;
        Assert.assertEquals(actualValue, 6-3);
    }
    @Test(enabled = false) //to hide or ignore the method!
    public void multiply(){

    }
    @Test (expectedExceptions = ArithmeticException.class)
    public void divided(){
        Assert.assertEquals(4/0, 0);

    }
    @Test(description = "Adding positive numbers")
    public void add1(Method method){
        int actual = 6;
        Assert.assertTrue(actual == 6);
        Test test = method.getAnnotation(Test.class);
        System.out.println(test.description());
    }
    @Test(description = "Testing negative numbers")
    public void add22(){
        int actual = -5;
        Assert.assertTrue(actual == -10+5);
    }
    @Test(priority = -1)
    public void subtract1(){
        int actual = 3;
        Assert.assertEquals(actual, 6-3);
    }
    @Test(priority = -2)
    public void subtract2(){
        int actual = -2;
        Assert.assertEquals(actual, -1-1);
    }
    @Test
    public void multiply1(){
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void divide1(){
        Assert.assertEquals(4/0, 0);
    }
    @Test(expectedExceptions = {NoSuchElementException.class, ArithmeticException.class,
            ElementNotVisibleException.class, ElementNotInteractableException.class})
    public void divide2(){
        Assert.assertEquals(4/0, 0);
    }
    @Test(enabled = false)
    public void signUpTest(){
        String invalidPassword = "  ";
        String validPassword = "123456";
        Assert.assertTrue(invalidPassword.equals(validPassword));
    }
    @Test(invocationCount = 10)
    public void logInPerformanceTest1(){
        System.out.println("Checking log in time");
    }
    @Test(invocationCount = 2, invocationTimeOut = 3000)
    public void logInPerformanceTest2(){
        System.out.println("Checking log in time");
        new SeleniumWaits().sleep(1000);
    }
    @Test(invocationCount = 10, skipFailedInvocations = true)
    public void logInPerformanceTest3(){
       // Assert.fail();
    }
    @Test(timeOut = 4000)
    public void methodTimeOut(){
        Assert.assertTrue(true);
    }

}
