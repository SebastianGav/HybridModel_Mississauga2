package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.masterClass;

public class keyWords extends masterClass{
	
	//method to get the element object xpath from the or.properties file
	public String getXpath(String objName) throws IOException {
		String text = or.getProperty(objName);
		return text;
	}
	
	//method to check element visibility	
	public WebElement getWhenVisible(String objName) throws IOException {
        String xPath = getXpath(objName);
		WebElement element = driver.findElement(By.xpath(xPath));
		WebDriverWait wait = new WebDriverWait(driver,2);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	//method to take screenshots
	public void takeScreenShot(String fileName) throws IOException {
		//get the filePath from path.properties file
		String filePath = path.getProperty(fileName);
		
		//convert driver object to TakesScreenshot who is a driver that can take screenshots
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create an image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File(filePath);
        
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
	
	//method to enter the data in any edit box
	public void enterData(String objName,String value) throws IOException {
		WebElement el = getWhenVisible(objName);
		el.sendKeys(value);
	}
	
	//method to click on a button
	public void clickButton(String objName) throws IOException {
		WebElement el = getWhenVisible(objName);
		el.click();
	}
	
	//method to select the value from drop down box
	public void selectValue(String objName,String value) throws IOException {
		
		WebElement el = getWhenVisible(objName);
		Select sl = new Select(el);
		sl.selectByVisibleText(value);
	}
	
	//method to check the error message displayed when you try to create an account with the credentials of an existing account
	public String getTest(String objName) throws IOException {
		String text;
		String xPath = getXpath(objName);
		text = driver.findElement(By.xpath(xPath)).getText();		
		return text;
	}
	
}
