package Practice_Data.Practice_Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		WebElement Victim = driver.findElement(By.cssSelector(".context-menu-one"));
		action.contextClick(Victim).build().perform();
		WebElement option = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		String optionText = option.getText();
		System.out.println(optionText);
		option.click();
		

	}

}
