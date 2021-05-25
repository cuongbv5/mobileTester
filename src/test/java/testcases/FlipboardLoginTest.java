package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import base.TestBase;
import screens.ChooseTopicsScreen;
import screens.LoginScreen;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class FlipboardLoginTest extends TestBase {
	
	
	LoginScreen login;
	ChooseTopicsScreen  topicScreen;
	
	@BeforeTest
	public void init() {
		
		setUp();
		login = new LoginScreen(driver);
		topicScreen = new ChooseTopicsScreen(driver);
	}
	
	@Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="flipBoard")
	public void validateGetStartedButton(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("FlipBoardSuite", "validateGetStartedButton", data.get("Runmode"), excel);
	
		login.clickGetStartedBtn();
		Assert.fail("Failing the test");
	}

	@Test(priority=2,dataProviderClass=DataProviders.class,dataProvider="flipBoard")
	public void chooseTopicsTest(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("FlipBoardSuite", "chooseTopicsTest", data.get("Runmode"), excel);
	
		topicScreen.chooseTopics(4).clickContinue();
		
	}
	
	
	@AfterTest
	public void quitDriver() {
		
		quit();
	}

}
