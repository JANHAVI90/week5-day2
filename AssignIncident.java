package Week5.day1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week5.day2.ReadExcel;
import Week5.day2.ServiceNowExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClassForSerivceNow{
	@Test
	public void runAssignIncident() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@name='gsft_main']"));
		driver.switchTo().frame(frame1);			 
	    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010015",Keys.ENTER);
	    driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	    WebElement assign = driver.findElement(By.id("sys_display.incident.assignment_group"));
	    assign.clear();
	    assign.sendKeys("software");
	    assign.click();	    
	    Thread.sleep(1000);	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)", "");
	    driver.findElement(By.id("activity-stream-textarea")).sendKeys("To be resolved with urgency");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	  	driver.switchTo().frame(frame2);
	  	
	    
	    
	    
		// TODO Auto-generated method stub

	}


}
