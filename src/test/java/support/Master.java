package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.BrowserCreation.getDriver;


public class Master {
	protected static WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	public static Properties p = new Properties();




	public String getConfigProperty(String propertyName) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(projectPath + "/Config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		String element = p.getProperty(propertyName);
		return element;
	}

	public void closeBrowser(){
		driver.close();
	}

	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}



	public static void javaScriptExecutorClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public WebDriver getWebDriver() throws IOException {
		String browserName=getConfigProperty("browser");
		return getDriver(browserName);
	}

	public static  Select selectByMethod(WebElement webElement){
		Select select= new Select(webElement);
		return select;
	}


	public static boolean isWebElementExist(List<WebElement> element) throws InterruptedException {
		boolean elementPresent = false;
		for (int i = 0; i < 100; i++) {
			Thread.sleep(500);
			if (element.size() > 0) {
				elementPresent = true;
				break;
			} else {
				System.out.println("looping:"+element);
			}
		}
		return elementPresent;
	}

	public static void veryShortSleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void shortSleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
