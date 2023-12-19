package co.css;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CSSSelector {

    public static void main(String[] args) {
        // Set ChromeDriver options (optional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window

        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dev\\Downloads\\chromedriver.exe");

        // Initialize the WebDriver with ChromeDriver and options
        WebDriver driver = new ChromeDriver(options);

        // Set an implicit wait to handle waiting for elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Navigate to eBay
            driver.get("http://ebay.com");

            // Initialize the JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Find the search box by its CSS selector and send keys
            WebElement searchBox = driver.findElement(By.cssSelector("#gh-ac"));
            searchBox.sendKeys("OnePlus 6T");

            // Find the search button by its CSS selector and click
            WebElement searchButton = driver.findElement(By.cssSelector("#gh-btn"));
            searchButton.click();

            // Scroll down the page
            js.executeScript("window.scrollBy(0, 1000)");

            // Wait for the product element to be clickable
            WebElement productElement = driver.findElement(By.xpath("/html/body/div[4]/div[4]/div[2]/div[1]/div[2]/ul/li[6]/div/div[1]/div/a/div/img"));
            productElement.click();

            // Additional actions can be added here

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

