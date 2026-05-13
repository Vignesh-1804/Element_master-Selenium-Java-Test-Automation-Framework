package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ElementMasterReport.html"
                    );

            spark.config().setDocumentTitle(
                    "ElementMaster Automation Report"
            );

            spark.config().setReportName(
                    "Selenium Java Automation Framework"
            );

            spark.config().setTheme(
                    Theme.DARK
            );

            spark.config().setTimeStampFormat(
                    "EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"
            );

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Project Name",
                    "ElementMaster"
            );

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + Java + TestNG"
            );

            extent.setSystemInfo(
                    "Automation Tester",
                    "A. Vigneshwaran"
            );

            extent.setSystemInfo(
                    "Operating System",
                    System.getProperty("os.name")
            );

            extent.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version")
            );

            extent.setSystemInfo(
                    "Browser",
                    "Chrome"
            );
        }

        return extent;
    }
}