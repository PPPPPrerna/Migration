package Rest.Assured;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sm {

	
	@Test
	
	public void start() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prerna Pandey\\Desktop\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		
		driver.get("https://www.travolook.in/?gclid=Cj0KCQjwlvT8BRDeARIsAACRFiUcI8iEjZyjRUi-qu3ZHOpCOvMvCsZ302P4Bxdk_XPjXQb9Qts0_2EaAm3LEALw_wcB");
		
		driver.findElement(By.xpath("//strong/i")).click();
		
		//WebElement w1=driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last'] //span[@class='ui-datepicker-month']"));
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//WebElement w1=(WebElement) js.executeScript("return document.getElementByClassName('ui-datepicker-month')");
		
		
		while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last'] //span[@class='ui-datepicker-month']")).getText().contains("March")) {
			
	driver.findElement(By.xpath("//i[@class='fa fa-chevron-right']")).click();
			
		}
		
		System.out.println("cool");
		
	}	
	
}
	
