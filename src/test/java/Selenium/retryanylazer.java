package Selenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryanylazer implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int MAX_RETRY_COUNT = 3;

	public boolean retry(ITestResult result) 
	{
		if(!(result.isSuccess()) && retryCount<MAX_RETRY_COUNT)
		{
			retryCount++;
			return true;
		}
		
		return false;
	}

}
