package Learning.Testing;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class InvocationCnt 

{
	@Test(invocationCount =2,threadPoolSize=5)
	public void testmethod1()
	{
		System.out.println("Test Method 1  Thread Id=" + Thread.currentThread().getId());
	}
	
	@Test(invocationCount =0)
	public void testmethod2(ITestContext context)
	{
		int count=context.getAllTestMethods()[0].getCurrentInvocationCount();

		//System.out.println("Executing = " + count  );
		System.out.println("Test method 2  Executing = " + count );
	}
	
	



}
