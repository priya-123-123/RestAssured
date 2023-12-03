package com;



import org.testng.annotations.DataProvider;


public class TestDataProviderClass {
	@DataProvider(name = "DataForPost")
	public Object[][] dataforPost() {
		/*
		 * Object[][] data = new Object[2][3]; data[0][0]="Albert";
		 * data[0][1]="Einstein"; data[0][2]=2;
		 * 
		 * data[1][0]="Thomas"; data[1][1]="Edision"; data[1][2]=1;
		 * 
		 * return data;
		 */
		
		return new Object[][] {
			{"Graham", "Bell", 1},
			{"Henry", "Ford", 2}
		};
		
	}
	
	@DataProvider(name = "DataForDelete")
	public Object[] dataforDelete() {
		/*
		 * Object[][] data = new Object[2][3]; data[0][0]="Albert";
		 * data[0][1]="Einstein"; data[0][2]=2;
		 * 
		 * data[1][0]="Thomas"; data[1][1]="Edision"; data[1][2]=1;
		 * 
		 * return data;
		 */
		
		return new Object[] {
			4,5,6
		};
		
	}
	
}
	
	
