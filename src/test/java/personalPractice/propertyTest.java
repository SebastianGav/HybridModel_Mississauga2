package personalPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class propertyTest {
	FileInputStream fso;
	String continueExecution = "Yes";
	
	@Test
	public void testProperty(){
		
		Properties prop = new Properties();
		File file = new File("C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\properties\\test.properties");
		
		
		try {
			fso = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println( "file not found");
			continueExecution = "no";
		}
		
		if(continueExecution.equalsIgnoreCase("YES")) {
		
			try {
				prop.load(fso);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		System.out.println(prop.getProperty("seba"));
		
	}

}
