package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;

public class Listeners extends base implements ITestListener {
    static ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extenTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test= extent.createTest(result.getMethod().getMethodName());
        extenTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extenTest.get().log(Status.PASS,"Test pass");
        extenTest.get().pass(result.getThrowable());

        WebDriver driver = null;
        String testMethodName =  result.getMethod().getMethodName();
        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }


        try {
            extenTest.get().addScreenCaptureFromPath(getScrrenshotpath(testMethodName,driver),result.getMethod().getMethodName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extenTest.get().fail(result.getThrowable());

        WebDriver driver = null;
        String testMethodName =  result.getMethod().getMethodName();
        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }


        try {
            extenTest.get().addScreenCaptureFromPath(getScrrenshotpath(testMethodName,driver),result.getMethod().getMethodName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }




}

