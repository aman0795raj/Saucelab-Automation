package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public Properties configProp;

	public Base() {
		configProp = new Properties();
		FileInputStream configFis = null ;
		try {
			configFis = new FileInputStream(utils.Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			configProp.load(configFis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void initialize(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("--------STARTING IN CHROME BROWSER--------");
			driver = WebDriverManager.chromedriver().create();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.out.println("--------STARTING IN FIREFOX BROWSER--------");
			driver = WebDriverManager.firefoxdriver().create();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.out.println("--------STARTING IN EDGE BROWSER--------");
			driver = WebDriverManager.edgedriver().create();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			System.out.println("--------STARTING IN SAFARI BROWSER--------");
			driver = WebDriverManager.safaridriver().create();
		}
		else {
			System.out.println("--------STARTING IN DEFAULT CHROME BROWSER--------");
			driver = WebDriverManager.chromedriver().create();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utils.Constants.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utils.Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().window().maximize();
		driver.get(configProp.getProperty("url"));
		System.out.println("--------OPENING TEST URL--------");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("--------CLOSING THE BROWSER INSTANCE--------");
		driver.quit();
	}
}
