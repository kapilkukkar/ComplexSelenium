package Learning.Testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class Current2
{
	@Test(enabled=true)
 public void currentacc11() 
 
 {
	 System.out.println("current 2 test 1");
 }
 @Test
 public void currentacc12() 
 
 {
	 System.out.println("current 2 test 2");
 }
 
 @Test(enabled= false)
 public void test1()
 {
	
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.google.com/");
	 String title = driver.getTitle();
	 System.out.println(title);
	 //Assert.assertEquals("Google", title);
	 Assert.assertEquals("Google", title, "title Exsisted");
	 driver.close();
	 
	
	 
	 
 }
}
