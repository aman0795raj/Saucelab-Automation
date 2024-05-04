package listeners;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listener implements ITestListener{
	String methodName;
	WebDriver driver;
	ExtentReports report;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("--------STARTING TEST EXECUTION--------");
		//Cleaning Up Screenshot folder from previous run
		File screenshotDir = new File(utils.Constants.SCREESHOT_FOLDER);
		if(!screenshotDir.exists()) {
			screenshotDir.getAbsoluteFile().mkdir();
		}
		File[] files = screenshotDir.listFiles();
		for(File file : files) {
			file.delete();
		}
		System.out.println("--------CLEANED SCREENSHOT FOLDER--------");
		report = utils.Reports.generateReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		methodName = result.getName();
		extentTest = report.createTest(methodName);
		System.out.println("--------EXECUTION STARTED FOR : "+methodName+"--------");
		extentTest.log(Status.INFO,methodName+" execution started!!");
		extentTest.log(Status.INFO, "Description: "+result.getMethod().getDescription());
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,methodName);
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("Driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(utils.TakeScreenshot.takesScreenshot(driver,methodName));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL,methodName);
		extentTest.log(Status.INFO, result.getThrowable());
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("Driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(utils.TakeScreenshot.takesScreenshot(driver,methodName+"-Fail"));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		System.out.println("--------TEST EXECUTION COMPLETED--------");
	}

}
