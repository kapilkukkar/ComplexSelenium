package Learning.Testing;
import org.testng.Assert;
import org.testng.annotations.*;

public class Current1 
{
	//@Test(enabled = false)
	@Test(groups="current account")

	public void currentacc1()
	{
		System.out.println("class 1 test 1");
	}
	//@Test(dependsOnMethods="savingacc")
	@Test(groups="current account")
	public void currentacc2()
	{
		System.out.println("class 1 test 2");
	}
	@Test(groups="saving account")
	public void savingacc1() throws InterruptedException
	{

		System.out.println("saving 1");
		//Assert.assertTrue(false);
	}

	@Test(groups="saving account")
	public void savingacc2() 
	{

		System.out.println("saving 02 ");
		//Assert.assertTrue(false);
	}}

