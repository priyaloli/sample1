package urbanladder;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtendReport {
    public static ExtentReports report;

    public static ExtentReports getReportInstance() {

        if (report == null) {
        	String reportName = DateUtils.getTimeStamp() + ".html";
        	//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Test_reports/" +reportName);
        	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/TestReport/extentreport.html"));
            report = new ExtentReports();
            report.attachReporter(htmlReporter);

            report.setSystemInfo("OS", "WINDOWS 10");
            report.setSystemInfo("Environment", "UTA");
            report.setSystemInfo("Build Number", "10.8.1");
            report.setSystemInfo("Browser", "Chrome");

            htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
            htmlReporter.config().setReportName("All Headlines UI Test Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

        }
        return report;
    }

	
}