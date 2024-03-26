package de.brenner.it;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Logger;

public class MainTest {

    private static final Logger LOGGER = Logger.getLogger(MainTest.class.getName());

    @Test
    public void testSelenium() {
        LOGGER.info("Starting Selenium test");
        //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        LOGGER.info("Initialize Driver");
        WebDriver firefoxWebDriver = new ChromeDriver();
        firefoxWebDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5_000));

        try {
            LOGGER.info("Execute GET");
            firefoxWebDriver.get("https://google.de");

            var title = firefoxWebDriver.getTitle();
            LOGGER.info("Hello world with selenium from=" + title);
            WebElement acceptButton = firefoxWebDriver.findElement(By.id("W0wltc"));
            LOGGER.info("Click accept " + acceptButton.toString());
            acceptButton.click();

            WebElement textBox = firefoxWebDriver.findElement(By.id("APjFqb"));
            textBox.sendKeys(Keys.ENTER);
            textBox.click();
            LOGGER.info("Textbox " + textBox.toString());

            WebElement submitButton = firefoxWebDriver.findElement(By.cssSelector("input"));
            LOGGER.info("Click submit " + submitButton.toString());

            textBox.sendKeys("Selenium");
            submitButton.click();

            WebElement results = firefoxWebDriver.findElement(By.id("result-stats"));
            LOGGER.info("Results " + results.getText());

        } finally {
            firefoxWebDriver.quit();
        }
    }

}
