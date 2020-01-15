package io.techleadacademy.zz_old.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class OrangeSite {
    @Test
    public void Orange() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/edilaibashov/IdeaProjects/Libraries/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard"));
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        driver.findElement(By.xpath("(//a[@class='login-as'])[2]")).click();
        driver.findElement(By.xpath("//span[.='Admin']")).click();
        driver.findElement(By.xpath("//span[.='Announcements']")).click();
        driver.findElement(By.xpath("//span[.='News']")).click();
        driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));
        List<WebElement> Maping = driver.findElements(By.xpath("//*[@class='dataRaw']"));
        System.out.println(Maping.size());
        Map<String, List<String>> DataMap = new HashMap<>();
        for (WebElement element : Maping) {
            String topic = element.findElement(By.xpath(".//td[2]")).getText();
            List<String> lists = new ArrayList<>();
            String date = element.findElement(By.xpath(".//td[3]")).getText();
            lists.add(date);
            String userName = element.findElement(By.xpath(".//td[6]")).getText();
            lists.add(userName);
            if(element.findElement(By.xpath(".//td[7]//i")).getAttribute("class").contains("disabled")){
                lists.add("Attachment - No");
            }else {
                lists.add("Attachment - Yes");
            }

            //String attachment = element.findElement(By.xpath(".//td[7]")).getText();
           // lists.add(attachment);
            DataMap.put(topic, lists);
        }
//        DataMap.forEach((K, V) -> System.out.println(K + " | " + V));
        for (String topic : DataMap.keySet()){
            System.out.print(topic);
            for (String s : DataMap.get(topic)){
                System.out.print(" | "+s);
            }
            System.out.println("\n");
        }
        driver.findElement(By.id("addItemBtn")).click();
        //WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("news_topic")));
        Thread.sleep(5000);
        driver.findElement(By.id("news_topic")).sendKeys("Congratulations Edil!");
        driver.switchTo().frame(driver.findElement(By.id("news_description_ifr")));
        driver.findElement(By.id("tinymce")).click();
        LocalDate Date = LocalDate.now();
        DateTimeFormatter DateForm = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String today = DateForm.format(Date);
        driver.findElement(By.id("tinymce")).sendKeys("Promotion was awarded to Edil on "+today);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("nextBtn")).click();
        driver.findElement(By.xpath("//*[.='Publish To - All User Roles']")).click();
        driver.findElement(By.xpath("//*[.='Publish']")).click();
       // driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));
        Assert.assertEquals("Congratulations Edil!", driver.findElement(By.xpath("//a[.='Congratulations Edil!']")).getText());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[.='keyboard_arrow_down']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='Logout']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//a[@class='login-as'])[3]")).click();
        Thread.sleep(5000);
        WebElement  newsTable = driver.findElement(By.id("newsOnDashBoard"));
        List<WebElement> newsData = newsTable.findElements(By.xpath(".//a[@class='truncate topic left-space']"));
        for (WebElement element : newsData){
            WebElement topic = element.findElement(By.xpath(".//ancestor::li//div[@class='truncate left-align']"));
            Assert.assertEquals(topic,"Congratulations Edil!");
        }
        //Assert.assertEquals("Congratulations Edil!", driver.findElement(By.xpath("(//a[@class='truncate topic left-space'])[44]")).getText());
        driver.findElement(By.xpath("//i[.='keyboard_arrow_down']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Logout']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        driver.findElement(By.xpath("(//a[@class='login-as'])[2]")).click();
        driver.findElement(By.xpath("//span[.='Admin']")).click();
        driver.findElement(By.xpath("//span[.='Announcements']")).click();
        driver.findElement(By.xpath("//span[.='News']")).click();
        Thread.sleep(4000);
        driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));
        //List<WebElement> edil = driver.findElements(By.xpath("//a[.='Congratulations Edil!']"));
        List<WebElement> edil = driver.findElements(By.xpath("//*[@class='dataRaw']"));
        for (WebElement ed : edil){
           if(ed.findElement(By.xpath(".//td[2]")).getText().equals("Congratulations Edil!")){
               ed.findElement(By.xpath(".//td[1]")).click();
           }
        }
        Thread.sleep(3000);
        WebElement click = driver.findElement(By.xpath("//i[@class='material-icons icons-color handCurser orange-text']"));
        action.moveToElement(click).click(click).perform();
        driver.findElement(By.xpath("//a[@id='newsDelete']")).click();
        driver.findElement(By.xpath("//a[@id='news-delete-button']")).click();
        Thread.sleep(2000);
        Assert.assertEquals("Congratulations Edil!", driver.findElement(By.xpath("(//a[.='Congratulations Edil!']")));
    }
}
