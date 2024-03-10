package sampleCases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class test01 {
    static WebDriver driver;
    static Select select;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01() {
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement droplist = driver.findElement(By.id("dropdown"));
        selectByIndexTest(droplist, 1);
        selectByValueTest(droplist, "2");
        selectByVisibleTextTest(droplist, "Option 1");
        printAllTest();
        printFirstSelectedOptionTest();

    }

    /*
   Go to URL: https://the-internet.herokuapp.com/dropdown
   Create method selectByIndexTest and Select Option 1 using index .
   Create method selectByValueTest Select Option 2 by value.
   Create method selectByVisibleTextTest Select Option 1  visible text.
   Create method printAllTest Print all dropdown value.
   Create method printFirstSelectedOptionTest Print first selected option.
   Find the size of the dropdown and print.
    */
    public void selectByIndexTest(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByValueTest(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByVisibleTextTest(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void printAllTest() {
        List<WebElement> allOpt = select.getOptions();

        for (WebElement each : allOpt) {
            System.out.println("each.getText() = " + each.getText());
            int size = allOpt.size();
            System.out.println("size = " + size);
        }
    }

    public void printFirstSelectedOptionTest(){
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    }



}
