package youtube.com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import youtube.com.utility.ExtentManager;
import youtube.com.actiondriver.Action;

public class baseClass {

    // WebDriver instance
    public static WebDriver driver;

    // Properties instance to load the configuration
    public static Properties properties;

    // Declare the logger at the class level
    public static final Logger logger = LogManager.getLogger(baseClass.class.getName());

    // Extent Reports
    public ExtentReports extent;
    public ExtentSparkReporter sparkReporter;

    // Constructor to initialize WebDriver and read config file
    public void launchApp()  {
        initializeDriver(); // Call this to initialize WebDriver
    }

    @BeforeSuite
    public void loadConfigProperties() throws Exception {
        // Initialize Extent Reports
        ExtentManager.setExtent(); 

        properties = new Properties();
        try {
            // Load the properties from the config file
            FileInputStream configFile = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\youtube.com\\Configuration\\Config.properties");
            properties.load(configFile);
            logger.info("Config file loaded successfully.");
        } catch (IOException e) {
            logger.error("Failed to load config file.", e);
            throw new Exception("Config file loading failed.", e);
        }
    }

    // Method to initialize WebDriver based on the browser type from config
    private void initializeDriver() {
        logger.info("Initializing WebDriver...");

        String browser = properties.getProperty("browser").toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized"); // Example option
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                logger.error("Unsupported browser: " + browser);
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        // Set implicit wait and launch the URL from properties file
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));
        Action.initializeDriver(driver);

        logger.info("Driver initialized and navigated to URL: " + properties.getProperty("url"));
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        ExtentManager.endReport();  // Close the extent report at the end of the suite
        if (driver != null) {
            driver.quit(); // Ensure the driver is quit after the suite
        }
        logger.info("Test execution completed and resources cleaned up.");
    }
}
