package youtube.com.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import youtube.com.actiondriver.Action;
import youtube.com.base.baseClass;



public class ListenerClass extends ExtentManager implements ITestListener {

	 public void onTestStart(ITestResult result) {
	  test = extent.createTest(result.getName());
	 }
	 public void onTestSuccess(ITestResult result) {
	  if (result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, "Pass Test case is: " + result.getName());
	  }
	 }
	 public void onTestFailure(ITestResult result) {
	  if (result.getStatus() == ITestResult.FAILURE) {
	   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	   test.log(Status.FAIL,
	     MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

	   String pathString = Action.screenShot(baseClass.driver, result.getName());
	   test.addScreenCaptureFromPath(pathString);
	  }
	 }

	 public void onTestSkipped(ITestResult result) {
	  if (result.getStatus() == ITestResult.SKIP) {
	   test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
	  }
	 }
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  // TODO Auto-generated method stub
	 }
	 public void onStart(ITestContext context) {
	  // TODO Auto-generated method stub

	 }
	 public void onFinish(ITestContext context) {
	  // TODO Auto-generated method stub
	 }

}
