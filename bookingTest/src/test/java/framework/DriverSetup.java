package framework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * WebDriver setup class Implements methods to read settings from property file
 * and setup WebDriver instance based on them
 * 
 * @author y.pernerovskyy
 *
 */
public class DriverSetup {

    private String url;
    private Browser browser;
    private WebDriver driver;

    /**
     * Put here supported browsers enumerator and implement necessary branch in
     * launchDriver() method
     */
    private enum Browser {
	FF, GC, IE, OP
    }

    /**
     * Read settings from pom.xml and setup the Driver
     * 
     * @return configured WebDriver instance
     * 
     */
    public WebDriver setUp() {

	String URL = "http://oxogamestudio.com/passwd.%s.htm";

	if (System.getProperty("siteURL") != null)
	    setUrl(String.format(URL, System.getProperty("siteURL")));
	else {
	    System.out
		    .println("Not able to read URL from config, set defauld to current2");
	    setUrl(String.format(URL, "current2"));
	}

	setBrowser(System.getProperty("targetBrowser"));

	return launchDriver();

    }

    /**
     * Setup the Driver with given URL and browser
     * 
     * @param url
     *            browser
     * 
     * @return configured WebDriver instance
     * 
     */
    public WebDriver setUp(String url, String browser) {
	setUrl(url);
	setBrowser(browser);
	return launchDriver();
    }

    /**
     * Setup and run browser
     * 
     * @return WebDriver instance
     * @throws MalformedURLException
     */
    private WebDriver launchDriver() {

	switch (browser) {
	case GC:
	    ChromeDriverManager.getInstance().setup();
	    driver = new ChromeDriver();
	    System.out.println("Chrome is set as browser");
	    break;
	case FF:
	    driver = new FirefoxDriver();
	    System.out.println("FireFox is set as browser");
	    break;
	case IE:
	    InternetExplorerDriverManager.getInstance().setup();
	    driver = new InternetExplorerDriver();
	    System.out.println("IE is set as browser");
	    break;
	case OP:
	    OperaDriverManager.getInstance().setup();
	    driver = new OperaDriver();
	    System.out.println("Opera is set as browser");
	    break;

	default:
	    driver = null;
	    break;
	}

	driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get(getUrl());
	driver.manage().window().maximize();

	System.out.println("URL is set to: " + getUrl());

	return driver;

    }

    /**
     * Set value of desired browser based on input string
     * 
     * @param String
     *            browserName
     * 
     */
    private void setBrowser(String browserName) {

	try {
	    browser = Browser.valueOf(browserName.toUpperCase());
	} catch (Exception e) {
	    System.out
		    .println("Unknown browser in config file. FireFox will be used instead.");
	    browser = Browser.FF;
	}
    }

    /**
     * Get current URL value
     * 
     * @return String
     */
    public String getUrl() {
	return url;
    }

    /**
     * Set current Url parameter
     */
    public void setUrl(String url) {
	this.url = url;
    }

    /**
     * Close Browser
     */
    public void shutDown() {
	driver.quit();
    }

    public WebDriver getDriver()
    {
	return driver;
    }

}