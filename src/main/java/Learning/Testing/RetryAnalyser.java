package Learning.Testing;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer 
{
	int count=0;
	int max=3;


	public boolean retry(ITestResult result) 
	{
		if(result.isSuccess())
		{
			if(count<max)
			{
				count++;
				result.setStatus(result.FAILURE);				
				return true;
			}
		}
		else 
		{
			result.setStatus(result.FAILURE); 
		}
		return false;
	}

}
