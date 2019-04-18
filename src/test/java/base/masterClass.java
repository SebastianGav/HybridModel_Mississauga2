package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utility.keyWords;

public class masterClass {
	
	public static WebDriver driver;
	
	public static Properties or;
	public static Properties path;
	
	public static File file1;
	public static File file2;
	
	public static FileInputStream fis1;
	public static FileInputStream fis2;
	
	public static keyWords keyword;
	
	static {
		
		keyword = new keyWords();
		
		or = new Properties();
		path = new Properties();
		
		//create a java abstract representation file from a non java file
		file1 = new File("C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\properties\\or.properties");
		file2 = new File("C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\properties\\path.properties");
		
		//read row bytes from an abstract java file
		try {
			fis1 = new FileInputStream(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis2 = new FileInputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read key and corresponding value from a FileInputStream file
		try {
			or.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			path.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
