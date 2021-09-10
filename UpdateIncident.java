package Week5.day1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week5.day2.ServiceNowExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class UpdateIncident extends BaseClassForSerivceNow {

	public  void runUpdateInc () {
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);	
    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010015",Keys.ENTER);
    driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
    WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
    Select drpDwn = new Select(urgency);
    drpDwn.selectByValue("1");
    WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
    Select drpDwn1= new Select(state);
    drpDwn1.selectByVisibleText("In Progress");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,600)", "");
    driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']")).click();
    
    

}
	
}