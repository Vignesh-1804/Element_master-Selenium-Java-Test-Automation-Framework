package listeners;

import base.BaseTest;

import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener extends BaseTest
        implements ITestListener {

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = ExtentManager
                .getReport()
                .createTest(
                        result.getName()
                );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String path =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getName()
                );

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getReport().flush();
    }
}