package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mendix.tool.SharedDriver;
import com.mendix.util.DataProviderUtil.staticProviderClass;



public class MaterialNavScript {

	WebDriver driver;

	/**
	 * Create Material with Nav.
	 * @throws AWTException 
	 */

	@Test(dataProvider="CreateMaterial_Fill_In_JDE",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		SharedDriver.pageContainer.materialNavPage.enterLocalData();
		SharedDriver.pageContainer.materialNavPage.enterPlantData(dataMap.get("Plant"));
		SharedDriver.pageContainer.materialNavPage.clickEditPlanningData();
		SharedDriver.pageContainer.materialNavPage.selectRoundingPrecision();
		SharedDriver.pageContainer.materialNavPage.clickLocalAction();
		SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
		SharedDriver.pageContainer.materialNavPage.clickSaveButton();
		
		
	}
		 	
}

