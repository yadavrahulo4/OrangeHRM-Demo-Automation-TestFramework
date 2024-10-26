package com.yadavrahulo4.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;

public class Reusable extends ExtReportListener {

    private static Properties props;
    private static WebDriver driver;
    private static Reusable reusable;

    private Reusable() {
    }

    public static Reusable getReusableInstance() {
        return Objects.isNull(reusable) ? new Reusable() : reusable;
    }

    public static String getCurrentTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");
        return now.format(formatter);
    }

    public static String getPropertyValue(String key) {
        try {
            props = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
                props.load(fileInputStream);
            } catch (FileNotFoundException e) {
                System.err.println("Properties File Not Found.>>>" + e.getMessage());
            } catch (IOException e) {
                System.err.println("Interrupted I/O Operation.>>>" + e.getMessage());
            }
            return props.getProperty(key);
        } catch (Exception e) {
            System.err.println("Properties File Not Found.>>>" + e.getMessage());
        }
        return null;
    }

    public static String randomStringGenerator(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$&*_";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public WebDriver getDriver() {
        return Objects.isNull(driver) ? launchBrowser() : driver;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getLogger() {
        return getExtTest();
    }

    public WebDriver launchBrowser() {
        try {
            String browserType = getPropertyValue("browser");
            switch (browserType) {
                case "Chrome":
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;
                case "InternetExplorer":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.err.println("Invalid Browser Type " + browserType + " not recognized.");
                    //test.log(Status.WARNING, "Invalid Browser Type " + browserType + " not recognized.");
                    break;
            }
            if (Objects.nonNull(driver)) {
                System.out.println(browserType + "Browser Launched Successfully.");
                //test.log(Status.INFO, browserType + "Browser Launched Successfully.");
                return driver;
            } else {
                System.out.println(browserType + "Unable to launch browser.");
                //test.log(Status.WARNING, browserType + "Unable to launch browser.");
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Exception Occurred." + e.getMessage() + "/n Launching Default Browser Type " + BrowserType.Edge);
            //test.log(Status.INFO, "Launching Default Browser Type -" + BrowserType.Edge)
            driver = new EdgeDriver();
            if (Objects.nonNull(driver)) {
                System.out.println(" Default Browser Edge Launched Successfully.");
                //test.log(Status.INFO, " Default Browser Edge Launched Successfully.");
                return driver;
            } else {
                System.out.println("Default Browser Edge Unable to launch.");
                //test.log(Status.WARNING, "Default Browser Edge Unable to launch.");
            }
        }
        return driver;
    }

    public void hitURL() {
        String url = getPropertyValue("url");
        // assert url != null;
        try {
            getDriver().get(url);
            System.out.println("URL <" + url + "> Launched Successfully.");
            test.log(Status.INFO, "URL <" + url + "> Launched Successfully.");
        } catch (Exception e) {
            System.err.println("unable to launch URL <" + url + "> Launch.  >> " + e.getMessage());
            test.log(Status.WARNING, "unable to launch URL <" + url + "> Launch.  >> " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            driver.close();
            System.out.println(driver);
            if (Objects.isNull(driver)) {
                System.out.println("Browser Window closed Successfully.");
                test.log(Status.INFO, "Browser Window closed Successfully.");
            } else throw new Exception();
        } catch (Exception e) {
            System.err.println("Unable to close Browser Window opened Previously.");
            test.log(Status.WARNING, "Unable to close Browser Window opened Previously.");
            e.printStackTrace();
        }
    }

    public void quit() {
        try {
            driver.quit();
            if (Objects.isNull(driver)) {
                System.out.println("All Browser's closed Successfully.");
                test.log(Status.INFO, "All Browser's closed Successfully.");
            } else throw new Exception();
        } catch (Exception e) {
            System.err.println("Unable to close Browser's opened Previously.");
            test.log(Status.WARNING, "Unable to close Browser's opened Previously.");
            e.printStackTrace();
        }
    }

    public boolean sendKeys(WebElement we, String elementName, String text) {
        try {
            we.sendKeys(text);
            System.out.println("<" + text + "> entered in " + elementName + ".");
            test.log(Status.INFO, "<" + text + "> entered in " + elementName + ".");
            return true;
        } catch (ElementNotInteractableException e) {
            //js implementation
        } catch (Exception e) {
            System.err.println("Unable to type <" + text + "> in " + elementName + ".>> " + e.getMessage());
            test.log(Status.WARNING, "Unable to type <" + text + "> in " + elementName + ".>> " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean click(WebElement we, String elementName) {
        try {
            we.click();
            System.out.println("Clicked on " + elementName + ".");
            test.log(Status.INFO, "Clicked on " + elementName + ".");
            return true;
        } catch (ElementNotInteractableException e) {
            //js implementation
        } catch (Exception e) {
            System.err.println("Unable to click on " + elementName + ".>> " + e.getMessage());
            test.log(Status.WARNING, "Unable to click on " + elementName + ".>> " + e.getMessage());
        }
        return false;
    }

    public String getCurrentURL() {
        try {
            String currentURL = driver.getCurrentUrl();
            if (Objects.nonNull(currentURL))
                test.log(Status.INFO, "Fetched current URL <" + currentURL + "> Successfully.");
            return currentURL;
        } catch (Exception e) {
            System.err.println("Unable to fetch current URL. >> " + e.getMessage());
            test.log(Status.WARNING, "Unable to fetch current URL. >> " + e.getMessage());
        }
        return null;
    }

    public void ValidateURL() {

    }

    public boolean isDisplayed(WebElement we, String elementName) {
        try {
            Wait.untilVisibilityOF(we, 25);
            if (we.isDisplayed()) {
                System.out.println(elementName + " is Visible.");
                test.log(Status.PASS, elementName + " is Visible.");
                return true;
            } else {
                System.out.println(elementName + " isn't  Visible.");
                test.log(Status.FAIL, elementName + " isn't  Visible.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Unable to check " + elementName + "'s Visibility. >> " + e.getMessage());
            test.log(Status.WARNING, "Unable to check " + elementName + "'s Visibility. >> " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public class Wait {
        //implicitWait
        public static void setImplicitWait(int seconds) {
            try {
                WebDriver.Timeouts saf = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
                System.out.println(saf);
                System.out.println("setting implicit wait for " + seconds + " Seconds.>>>");
            } catch (Exception e) {
                System.err.println("Exception occurred while setting implicit wait.>>>" + e.getMessage());
            }
        }

        //         WebDriverWait
        public static void
        untilVisibilityOF(WebElement we, int seconds) {
            new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(we));
        }

        public static void untilAlertIsPresent(WebElement we, int seconds) {
            new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.alertIsPresent());
        }
    }
}