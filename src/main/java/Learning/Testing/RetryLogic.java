package Learning.Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogic 
{	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void testcase01()
	{
		Assert.assertTrue(false);
	}
	@Test
	public void testcase02()
	{
		Assert.assertTrue(false);
	}
	@Test
	public void testcase03()
	{
		Assert.assertTrue(true);
	}

	
	
}
