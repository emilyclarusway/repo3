package sampleCases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DummyForm {
    static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void dummytest(){
        driver.navigate().to("https://clarusway.getlearnworlds.com/sda-test-registration-form");
        WebElement frame= driver.findElement(By.xpath("//iframe[@aria-label='SDA Iframe Test']"));
        driver.switchTo().frame(frame);

        WebElement name= driver.findElement(By.name("Name"));
        name.sendKeys("Emıly");

        WebElement lname= driver.findElement(By.xpath("//input[@elname='Last']"));
        lname.sendKeys("Cway");

        driver.findElement(By.xpath("//label[@for='Radio_3']")).click();
        driver.findElement(By.xpath("//div[.='-Select-']")).click();


        WebElement dropitem= driver.findElement(By.id("Dropdown-arialabel"));
        Select select = new Select(dropitem);
        select.selectByValue("Second Choice");





    }


//iframe[@aria-label='SDA Iframe Test']
}
