package Practice_Data.Practice_Data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class launch_test {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("window-size=1400,800");
		//options.addArguments("headless");
		
		//WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new HtmlUnitDriver();
		
		System.setProperty("phantomjs.binary.path", "C:\\Users\\user\\Downloads\\phantomjs-2.1.1-windows (1)\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("vidushi");
		driver.findElement(By.name("password")).sendKeys("Right@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		
		//driver.switchTo().frame("mainpanel");
		//Thread.sleep(2000);
		
		
		
		//driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//driver.findElement(By.xpath("//a[text()='Test contact']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();

	}

}
