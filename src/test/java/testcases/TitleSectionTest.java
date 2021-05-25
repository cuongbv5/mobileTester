package testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.HomeScreen;
import screens.LoginScreen;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;
import utilities.ScrollUtil;

public class TitleSectionTest  extends TestBase{
	
	LoginScreen login;
	HomeScreen home;
	
	@BeforeTest
	public void init() {
		
		setUp();
		login = new LoginScreen(driver);
		home = new HomeScreen(driver);
		
	}
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="flipBoard")
	public void validateTitle(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("FlipBoardSuite", "validateTitle", data.get("Runmode"), excel);

		System.out.println("Inside Validate title test : "+data.get("TestData"));
		login.clickGetStartedBtn().chooseTopics(4).clickContinue().skipLogin();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		home.gotoTitleSection(2);
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScrollUtil.scrollUp(2, driver);
	}

	
	@AfterTest
	public void quitDriver() {
		
		quit();
	}

}
