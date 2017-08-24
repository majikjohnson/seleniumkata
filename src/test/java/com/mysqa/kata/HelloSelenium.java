package com.mysqa.kata;

//Add 6 import statements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

//Class definition
public class HelloSelenium {
    //Java main method
    public static void main(String args[]) {
        //Tell webdriver where your gecko driver is installed on your local machine
        System.setProperty("webdriver.gecko.driver", "C:\\dev\\selenium\\drivers\\geckodriver.exe");

        //Create WebDriver instance
        WebDriver driver = new FirefoxDriver();

        //Open www.google.com
        driver.get("http://www.google.com");

        //Find the search box (name="q")
        WebElement searchBox = driver.findElement(By.name("q"));

        //Enter the search term "Hello, World" in the search box
        searchBox.sendKeys("Hello, World!");

        //Submit the search term to Google
        searchBox.submit();

        //Wait for the search results page to render
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Hello, World!");
            }
        });

        //Print out the page title
        System.out.println("Page Title: " + driver.getTitle());

        //Close web driver
        driver.quit();
    }
}
