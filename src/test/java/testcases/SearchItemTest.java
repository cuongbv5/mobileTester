package testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;
import utilities.ScrollUtil;

public class SearchItemTest  extends TestBase{
	
	LoginScreen login;
	SearchScreen search;
	
	@BeforeTest
	public void init() {
		
		setUp();
		login = new LoginScreen(driver);
		search = new SearchScreen(driver);
		
	}
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="flipBoard")
	public void searchItemTest(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("FlipBoardSuite", "searchItemTest", data.get("Runmode"), excel);

	
		login.clickGetStartedBtn().chooseTopics(4).clickContinue().skipLogin().selectBottomPanel(3);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		search.searchFlipBoard(data.get("SearchText"));
	
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
