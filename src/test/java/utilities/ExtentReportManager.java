package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener{
	
	ExtentSparkReporter spark;
	ExtentReports extent; 
	ExtentTest test;
	
	public void onStart(ITestContext testContext)	{
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.H.m.s");
		String timestamp = date.format(formatter);
		String reportname = "Report-" + timestamp;
		
		spark = new ExtentSparkReporter(".\\reports\\" + reportname);
		spark.config().setDocumentTitle("RestAssuredAutomation_");
		spark.config().setReportName("PetStore Users API");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Application", "PetStore Users API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
	}
	
	public void onTestSuccess(ITestResult result)	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "test passed");
		
	}
	
	public void onTestFailure(ITestResult result)	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "test failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result)	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "test skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();//if you don't call flush, the report will not be generated.
	}
	
}
