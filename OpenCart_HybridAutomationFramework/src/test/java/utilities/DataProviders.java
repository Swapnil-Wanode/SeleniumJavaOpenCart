package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "loginData")
	public String [][] getdata() throws IOException{
		
		// taking excel file from testData
		String filepath = ".\\testData\\opencart.xlsx";
		
		// create object for utility 
		ExcelUtility utility = new ExcelUtility(filepath);
		
		int totalrows = utility.getRowCount("Sheet1");
		int totalcolumns = utility.getCellCount("Sheet1", 1);
		
		// create 2D array to store login data from excel 
		String[][] logindata = new String[totalrows][totalcolumns]	;
		
		// read the data from excel to store in array
		for(int i=1; i<totalrows; i++) {
			for(int j=0; j<totalcolumns; j++) {
				logindata[i-1][j] = utility.getCellData("Sheet1", i, j); 
			}
		}
		
		return logindata;
		
	}
}
