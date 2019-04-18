package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.masterClass;

public class TC001_login extends masterClass{
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void doLogin() throws IOException {
		driver.get("https://www.foodpanda.ph/");
		
		keyword.clickButton("login");
		keyword.enterData("login_email", "sachin.jindal1986@gmail.com");
		keyword.enterData("login_pass", "rocknroll");
		keyword.clickButton("login_loginBtn");
	}
	
	@AfterTest
	public void setdown() {
		//driver.close();
	}

}
