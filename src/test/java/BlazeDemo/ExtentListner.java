package BlazeDemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListner implements ITestListener
{
	ExtentSparkReporter htmlReporter;
	ExtentReports reporter;
	ExtentTest test;
	public void configureReport()
	{
		htmlReporter= new ExtentSparkReporter("Reports.html");
		reporter= new ExtentReports() ;
		reporter.attachReporter(htmlReporter);
		
		//Add System Info For future reference
		reporter.setSystemInfo("Machine", "Sahab");
		reporter.setSystemInfo("OS", "Window 11");
		reporter.setSystemInfo("browser", "Chrome");
		reporter.setSystemInfo("Username", "Kapil_6911");
		
		//Configure appearance of Report.
		
		htmlReporter.config().setDocumentTitle("Report Demo");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Demo Report");
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test passed: " + result.getName());
		test= reporter.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of Test passed is : "+result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		

		test= reporter.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed Test case is : "+result.getName(),ExtentColor.RED));
		Object testClass = result.getInstance();
        WebDriver driver = ((PracticeTable) testClass).driver; 
        String screenshotPath = null;
        
		try 
		{
			screenshotPath= ((PracticeTable) testClass).get_Screenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        test.fail("Screenshot of failure", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test skipped: " + result.getName());
		test= reporter.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of Skipped Test is: "+result.getName(),ExtentColor.YELLOW));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		//System.out.println("Test failed but within success percentage: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		configureReport();
		System.out.println("Test started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println("Test finished: " + context.getName());
		reporter.flush();
	}


}
