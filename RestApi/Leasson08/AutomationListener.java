package Leasson08;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class AutomationListener implements ITestListener {

    public void onFinish(ITestContext execution)
    {
        System.out.println("------------ Execution Ended ------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test)
    {
        System.out.println("------------ Skipping Test: "+test.getName()+" ------------");
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("------------ Starting Test: "+test.getName()+" ------------");
    }

    public void onTestSuccess(ITestResult test)
    {
        System.out.println("------------ Test: "+test.getName()+" Passed ------------");
    }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("------------ Test: "+test.getName()+" Failed ------------");
    }
}


