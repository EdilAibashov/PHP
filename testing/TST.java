package io.techleadacademy.zz_old.testing;
import io.techleadacademy.SeleniumWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TST {
    @Test
    public void Project() throws InterruptedException, FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "/Users/edilaibashov/IdeaProjects/Libraries/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(("http://practice.cybertekschool.com/"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[.='A/B Testing']")).click();
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[starts-with(.,'Add/Remove')]")).click();
        WebElement click = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0;i < 5;i++) {
            click.click();
        }

        List<WebElement> delete = driver.findElements(By.className("added-manually"));
        for (WebElement d:delete){
            d.click();
        }
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.id("myCountryautocomplete-list")).click();
        driver.findElement(By.xpath("//input[@type='button']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Basic Auth']")).click();

        driver.get("http://admin:admin@practice.cybertekschool.com/basic_auth");
        String getMessage = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(getMessage);
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Broken Images']")).click();

        List<WebElement> image = driver.findElements(By.tagName("img"));
        System.out.println("Images :"+image.size());

        for (WebElement imga : image) {
            try {
                HttpURLConnection con = (HttpURLConnection) new URL(imga.getAttribute("src")).openConnection();
                con.setRequestMethod("GET");
                int resCode = con.getResponseCode();
                if (resCode != 200) {
                    System.out.println("Broken image :" + imga.getAttribute("src"));
                } else {
                    System.out.println("Fine Image :" + imga.getAttribute("src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        new SeleniumWaits().sleep(2000);
        driver.navigate().back();
        new SeleniumWaits().sleep(2000);
        driver.findElement(By.xpath("//a[.='Checkboxes']")).click();
        List<WebElement> chk = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement c:chk){
            c.click();
        }
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Disappearing Elements']")).click();
        driver.findElement(By.xpath("(//a[starts-with(@href,'/')])[2]")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='About']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Contact Us']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Portfolio']")).click();
        driver.navigate().back();
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Drag and Drop']")).click();
        String BoxA ="column-a";
        WebElement box1 = driver.findElement(By.id(BoxA));
        String BoxB ="column-b";
        WebElement box2 = driver.findElement(By.id(BoxB));
        action.dragAndDrop(box1, box2).perform();
        driver.navigate().back();
        new SeleniumWaits().sleep(2000);
        driver.findElement(By.xpath("//a[.='Dropdown']")).click();
        Select drop = new Select(driver.findElement(By.id("dropdown")));
        drop.selectByValue("1");
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByValue("1988");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("1");
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByValue("28");
        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByValue("VA");
        Select languages = new Select(driver.findElement(By.name("Languages")));
        languages.selectByValue("java");
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.xpath("//a[.='Amazon']")).click();
        driver.navigate().back();
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Dynamic Content']")).click();
        driver.navigate().refresh();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Dynamic Loading']")).click();
        driver.findElement(By.xpath("//a[.='Example 1: Element on page that is hidden and become visible after trigger']")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        new SeleniumWaits().sleep(2000);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='Example 2: Element on the page that is rendered after the trigger']")).click();
        new SeleniumWaits().sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        new SeleniumWaits().sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
        new SeleniumWaits().sleep(3000);
        driver.navigate().back();
        new SeleniumWaits().sleep(2000);
        driver.findElement(By.className("nav-link")).click();
//        new SeleniumWaits().sleep(2000);
//        driver.findElement(By.xpath("//a[.='File Download']")).click();
//        List<WebElement> file =  driver.findElements(By.xpath("//div[@id='content']//a"));
//        for(WebElement fl : file) {
//            fl.click();
//        }
        //driver.findElement(By.className("nav-link")).click();
        new SeleniumWaits().sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//a[.='Form Authentication']"))).perform();
        driver.findElement(By.xpath("//a[.='Form Authentication']")).click();
        WebElement name = driver.findElement(By.name("username"));
        name.click();
        name.sendKeys("tomsmith");
        WebElement psswrd = driver.findElement(By.name("password"));
        psswrd.click();
        psswrd.sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        new SeleniumWaits().sleep(1000);
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Frames']")).click();
        driver.findElement(By.xpath("//a[.='iFrame']")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        driver.findElement(By.id("tinymce")).click();
        driver.findElement(By.id("tinymce")).sendKeys("It is the my first letter to Cybertech!");
        driver.switchTo().parentFrame();
        List<WebElement> format = driver.findElements(By.xpath("//div[@id='mceu_24-body']/div"));
        for (int k = 0; k < format.size(); k++){
            format.get(k).click();
        }
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Horizontal Slider']")).click();
        new SeleniumWaits().sleep(2000);
        WebElement slider = driver.findElement(By.xpath("//div[@class='sliderContainer']/input"));
        for(int l = 0; l <= 10;l++) {
            slider.sendKeys(Keys.ARROW_RIGHT);

        }
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Hovers']")).click();
        List<WebElement> elem = driver.findElements(By.xpath("//div[@class='figure']"));
        for (WebElement el : elem){
            action.moveToElement(el).perform();
        }
        driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//a[.='Infinite Scroll']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-5000)");
        driver.findElement(By.className("nav-link")).click();





    }
}
