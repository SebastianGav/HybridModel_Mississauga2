package personalPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\sebas\\Downloads\\Mississauga_Batch_Workspace\\Mississauga_Batch_Workspace\\brampton_Hybrid\\src\\test\\resources\\testData\\foodpanda.xlsx");
		
		FileInputStream file1 = new FileInputStream(file);

		//workbook
		XSSFWorkbook wb = new XSSFWorkbook(file1);
		
		//worksheet
		XSSFSheet ws = wb.getSheet("register");
		
		int rowCnt = ws.getLastRowNum();
		int colCnt = ws.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCnt][1];
		//System.out.println("row number = " + rowCnt);
		//System.out.println("col number = " + colCnt);
		
		for(int i = 0;i< rowCnt; i++) {
			Map<String, String> mp = new HashMap<String, String>();
			
			for(int j = 0;j<colCnt; j++) {
				String colName = ws.getRow(0).getCell(j).getStringCellValue();
				String value = ws.getRow(i+1).getCell(j).getStringCellValue();
				
				mp.put(colName, value);
			}
			
			obj[i][0] = mp;
		}
		
		
		for(int k = 0; k<obj.length;k++) {
			
			Map<String, String> map1 = (Map<String, String>) obj[k][0];
			System.out.println(map1.get("firstName"));
		}
	}

}
