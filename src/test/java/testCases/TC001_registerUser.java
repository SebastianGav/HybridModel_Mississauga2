package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.masterClass;

public class TC001_registerUser extends masterClass{
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.foodpanda.ph/");
	}
	
	@Test(dataProvider="getData")
	public void sample(Map<String, String> mp1) throws IOException, InterruptedException {
		
		keyword.clickButton("login");
		
		//click sign up with a 2 seconds delay
		Thread.sleep(2000);
		keyword.clickButton("signUp");
		
		//enter the details
		keyword.enterData("firstName",mp1.get("firstName"));
		keyword.enterData("lastName", mp1.get("lastName"));
		keyword.enterData("email", mp1.get("email"));
		keyword.enterData("mobile", mp1.get("mobile"));
		keyword.enterData("passWord", mp1.get("passWord"));
				
		keyword.clickButton("register");
		
		System.out.println(keyword.getTest("alreadyReg_ErrorMessage"));
		Assert.assertEquals(keyword.getTest("alreadyReg_ErrorMessage"), "A customer with these credentials already exists.");
		
		//take a screenshot
		//keyword.takeScreenShot("screenShots1");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		//create a java abstract representation file from a non java file
		File file = new File("C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\testData\\foodpanda.xlsx");
		
		//read row bytes from an java abstract file
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis); //workbook	
		XSSFSheet ws = wb.getSheet("register"); //worksheet

		int rowCnt = ws.getLastRowNum();
		int colCnt = ws.getRow(0).getLastCellNum();
		
		Object[][] obj1 = new Object[rowCnt][1];
		
		for(int i=0; i<rowCnt; i++) {
			Map<String, String> mp = new HashMap<String, String>();
		
			for(int j=0; j<colCnt; j++) {
				String colName = ws.getRow(0).getCell(j).getStringCellValue();
				String value = ws.getRow(i+1).getCell(j).getStringCellValue();
				
				mp.put(colName, value);
			}
			obj1[i][0] = mp;
		}
		return obj1;
	}
}
