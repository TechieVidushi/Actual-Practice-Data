package Practice_Data.Practice_Data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTestClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
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
		
		driver.switchTo().frame("mainpanel");
		
		
		String date = "13-September-2019";
		String dateArr[]=date.split("-");
		String day= dateArr[0];
		String month= dateArr[1];
		String year= dateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select.selectByVisibleText(year);
		driver.navigate().refresh();
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[6]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[5]
		
		
		
		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		
		String AfterXpath = "]/td[";
		
		final int totalWeekDays = 7;
		boolean flag = false;
		driver.switchTo().frame(1);
		for(int rowNum=2; rowNum<=7; rowNum++) {
			for(int colNum=1;colNum<=totalWeekDays;colNum++) {
				driver.findElement(By.xpath(beforeXpath+rowNum+AfterXpath+colNum+"]")).click();
				String dayValue = driver.findElement(By.xpath(beforeXpath+rowNum+AfterXpath+colNum+"]")).getText();
				System.out.println(dayValue);
				
				if(dayValue.equals(day)) {
					driver.findElement(By.xpath(beforeXpath+rowNum+AfterXpath+colNum+"]")).click();
					flag=true;
					break;
					
				}
			}
			
			if(flag) {
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
