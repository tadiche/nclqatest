import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.*;

public class TestScenario2 {
	public static void main(String[] args) {
		// objects and variables instantiation
		//System.setProperty("webdriver.gecko.driver", "/home/sridhar/Software/Selenium/libs/geckodriver");

		WebDriver driver = new FirefoxDriver();
		String appUrl = "https://www.ncl.com";

		//launch the firefox browser and open the application url
		driver.get(appUrl);

		// maximize the browser window
		driver.manage().window().maximize();

		WebElement exploremenu = driver.findElement(By.linkText("EXPLORE"));
		String xpathExpression = "//a[@href='/excursions']";


		HoverToElement(driver,exploremenu);
		HoverToElement(driver,driver.findElement(By.xpath(xpathExpression)));

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"search_destinations_chosen\"]")).click();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"search_destinations_chosen\"]/div/div/input")).sendKeys("Alaska Cruises");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//input Alaska Cruises in to search
		String searchStr = "Alaska Cruises";
		driver.findElement(By.xpath("//*[@id=\"search_destinations_chosen\"]/div/ul/li")).click();;

	}

	private static void HoverAndClick(WebDriver driver, WebElement exploremenu, WebElement shoremenu) {
		// TODO Auto-generated method stub
		Actions actions = new Actions(driver);
		actions.moveToElement(exploremenu).click(shoremenu).build().perform();
	}

	public static void HoverToElement(WebDriver driver , WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
}
