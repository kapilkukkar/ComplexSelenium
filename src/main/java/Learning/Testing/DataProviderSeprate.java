package Learning.Testing;

import org.testng.annotations.DataProvider;

public class DataProviderSeprate 

{
	@DataProvider(name="SearchKey")
	
	public Object[][] searchdata()
	{
		Object[][] search= new Object[3][2];
		
		search[0][0]="india";
		search[0][1]="Qutub Minar";
		search[1][0]="Agra";
		search[1][1]="Taj Mahal";
		search[2][0]="Hydrabad";
		search[2][1]="CharMinar";
		return search;
	}
	
	
	
}
