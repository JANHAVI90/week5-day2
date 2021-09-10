package Week5.day1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week5.day2.ServiceNowExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewIncident extends BaseClassForSerivceNow {
	@Test(dataProvider="sendData")
	public  void runNewInc(String shortdescription,String caller){
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);		
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident no : "+incidentNumber);
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(caller,Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(shortdescription);
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    WebElement tableRow = driver.findElement(By.xpath("//table[@id='incident_table']//tr[6]"));
	    String text2 = tableRow.getText();
	    System.out.println("The selected row:"+text2);
	    WebElement tablecolumn = driver.findElement(By.xpath("//table[@id='incident_table']//tr[6]|td[2]"));
		String text = tablecolumn.getText();
		System.out.println("The incident value is "+ text);
	}	
	
	@DataProvider 
	public String[][] sendData() throws IOException   {
	return ServiceNowExcel.readData("NewInc");

		
		
		
		
		
		
		// TODO Auto-generated method stub
	}
	}


