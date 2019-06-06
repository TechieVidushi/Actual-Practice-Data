package Practice_Data.Practice_Data;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandler {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[2]")).click();
		Thread.sleep(2000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		System.out.println("parentWindow Id is :"+parentWindowId);
		String childWindowId = it.next();
		System.out.println("childWindow Id is :"+childWindowId);
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		System.out.println("child pop up title :"+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent title :"+driver.getTitle());
		driver.close();
		driver.switchTo().window(childWindowId);
		

	}

}
