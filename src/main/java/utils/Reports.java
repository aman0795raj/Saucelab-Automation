package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports generateReports() {
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(new File(utils.Constants.REPORT_FOLDER));
		sparkReport.config().setDocumentTitle("SAUCELABS AUTOMATION");
		sparkReport.config().setReportName("SAUCELABS AUTOMATION REPORT");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReport);
		extentReports.setSystemInfo("Username", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Operation System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		return extentReports;
	}
}
