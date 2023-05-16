package com.saucelabs.DataProvider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.saucelabs.Utils.*;

public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("credentials");
			// Total Columns
			int column = obj.getColumnCount("credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("credentials", j, i + 2);
				}
			}
			return data;
		}
		
		

}
