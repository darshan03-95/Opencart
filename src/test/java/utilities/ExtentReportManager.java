package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	String repname;
	public void onStart(ITestContext testContext)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
		repname = "Test-Report" + timestamp+ ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"\\reports"+repname);
		sparkReporter.config().setDocumentTitle("Opencart Automation Report");
		sparkReporter.config().setReportName("Opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("QA-Name", "Darshan");
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedgroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedgroups.isEmpty())
		{
			extent.setSystemInfo("Groups",includedgroups.toString());
		}
	}
 
  public void onTestSuccess(ITestResult result) 
  {
	   test=extent.createTest(result.getTestClass().getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.PASS, result.getName() +"got successfully executed");
  }
  
  public void onTestFailure(ITestResult result) 
  {
	    test=extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() +"got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try {
		String imgpath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		}	
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
    
   }
  
  public void onTestSkipped(ITestResult result)
  {
	  test=extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() +"got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	    
	}
  
  
  public void onFinish(ITestContext testContext) 
  {
	  extent.flush();
	  
	  String ExtentReportPath = System.getProperty("user.dir")+"\\reports\\"+repname;
	  File ExtentReport = new File(ExtentReportPath);
	  
	  try {
		  Desktop.getDesktop().browse(ExtentReport.toURI());
	  }catch(IOException e2)
	  {
		  e2.printStackTrace();
	  }
	    
	  }
}