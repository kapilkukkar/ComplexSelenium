package Learning.Testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class configeproperty {

	@Test(enabled = false)
	public void test() throws InterruptedException, IOException
	{
		WebDriver driver = new ChromeDriver();
		Readconfig configfile = new Readconfig();		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get(configfile.getURl());
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(configfile.getusername());
		driver.findElement(By.name("password")).sendKeys(configfile.getpswrd());
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		driver.close();

	}
	@Test
	public void main()
	{
		class Solution {
		    public int longestSemiAlternatingSubstring(String s) {
		        if (s == null || s.length() == 0) {
		            return 0;
		        }

		        int maxLen = 1; // Minimum length is 1 for a non-empty string

		        int count = 1; // Count of consecutive repeating characters
		        for (int i = 1; i < s.length(); i++) {
		            if (s.charAt(i) == s.charAt(i - 1)) {
		                count++;
		            } else {
		                count = 1; // Reset count for a different character
		            }

		            if (count <= 2) {
		                maxLen = Math.max(maxLen, i + 1); // Update maxLen for valid substring
		            }
		        }

		        return maxLen;
		    }

		    public void main(String[] args) {
		        // Test the function with an example string
		        String input = "abbaaac";  
		        int result = longestSemiAlternatingSubstring(input);
		        System.out.println("Length of longest semi-alternating substring: " + result);
		    }
		}

	}

}
