package Week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForSerivceNow {
	ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public  void preCondition(String url,String userName,String pwd) {
		
		
		WebDriverManager.chromedriver().setup();
	     driver=  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		// TODO Auto-generated method stub

	}
@AfterMethod
public void postCondition() {
	driver.close();
	
}

}
