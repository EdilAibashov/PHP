package io.techleadacademy.zz_old;
import com.github.javafaker.Faker;
import io.techleadacademy.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Test
public class phpPractice {
    public void SiteTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/edilaibashov/IdeaProjects/Libraries/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        //Page navigation
        driver.get(("https://phptravels.net/home"));
        System.out.println(driver.getTitle());
        String expectedTitle="PHPTRAVELS | Travel Technology Partner";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        driver.findElement(By.xpath("(//a[@id='dropdownCurrency'])[2]")).click();
        driver.findElement(By.xpath("//a[.='Sign Up']")).click();
        new SeleniumWaits().sleep(2000);
        Faker faker = new Faker();
        String Pass = "11223344";
        String [] data = {faker.name().firstName(), faker.name().lastName(),faker.phoneNumber().cellPhone(), faker.internet().emailAddress(),Pass, Pass};
        List<WebElement> er = driver.findElements(By.xpath("//*[@class='form-group']/input"));
        for(int i = 0; i< er.size();i++){
            er.get(i).sendKeys(data[i]);
        }
        WebElement submit = driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']"));
        new SeleniumWaits().waitForClickability(driver,submit );
        submit.click();
        //Verifying
        WebElement img = driver.findElement(By.xpath("//img[@class='img-responsive go-right img-thumbnail']"));
        new SeleniumWaits().waitForClickability(driver, img);
        String title = "My Account";
        Assert.assertEquals(driver.getTitle(),title);
        String name = driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText(),name);
        String pattern = "dd MMMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date day = new Date();
        String today = simpleDateFormat.format(day);
        System.out.println(today);
        String date = driver.findElement(By.xpath("//span[@class='h4']")).getText();
        Assert.assertEquals(date,today);
    }
}
