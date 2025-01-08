package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import config.ConfigReader;


public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser").toLowerCase();
            boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        chromeOptions.addArguments("--window-size=1920x1080");
                        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                        chromeOptions.addArguments("--disable-extensions");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--disable-blink-features=AutomationControlled");
                        firefoxOptions.addArguments("--start-maximized");
                        firefoxOptions.addArguments("--disable-gpu");
                        firefoxOptions.addArguments("--no-sandbox");
                        firefoxOptions.addArguments("--disable-dev-shm-usage");
                        firefoxOptions.addArguments("--window-size=1920x1080");
                        firefoxOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                        firefoxOptions.addArguments("--disable-extensions");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) {
                        edgeOptions.addArguments("--headless");
                        edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
                        edgeOptions.addArguments("--start-maximized");
                        edgeOptions.addArguments("--disable-gpu");
                        edgeOptions.addArguments("--no-sandbox");
                        edgeOptions.addArguments("--disable-dev-shm-usage");
                        edgeOptions.addArguments("--window-size=1920x1080");
                        edgeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                        edgeOptions.addArguments("--disable-extensions");
                    }
                    driver = new EdgeDriver(edgeOptions);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    driver.manage().window().maximize();
                    break;
                default:
                    throw new RuntimeException("Navegador não suportado: " + browser);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
