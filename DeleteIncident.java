package Week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class DeleteIncident extends BaseClassForSerivceNow {

	public void runDelteInc() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@name='gsft_main']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();	
		WebElement searchInc = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchInc.sendKeys("INC001");
		Actions builder = new Actions(driver);
		builder.moveToElement(searchInc).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[3]")).click();
		//driver.findElement(By.xpath("(//div[@class='modal-content'])[2]"));
		//driver.findElement(By.id("ok_button")).click();
				
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

	}

