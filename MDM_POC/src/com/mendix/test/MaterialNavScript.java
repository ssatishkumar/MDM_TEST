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

	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{
		SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
		SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.get("Material Group"));
		SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
		SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
		SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
		SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
		SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
		SharedDriver.pageContainer.materialPage.clickLocalAction();
	}
//	@Test(dataProvider="CreateMaterial_Fill_In_JDE",dataProviderClass=staticProviderClass.class)
	@Test
	public void Material_Create_Fill_In_Data_JDE_Planning() throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		SharedDriver.pageContainer.materialNavPage.enterLocalData();
		SharedDriver.pageContainer.materialNavPage.enterPlantData();
		SharedDriver.pageContainer.materialNavPage.clickEditPlanningData();
		SharedDriver.pageContainer.materialNavPage.selectRoundingPrecision();
		SharedDriver.pageContainer.materialNavPage.clickLocalAction();
		SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
		SharedDriver.pageContainer.materialNavPage.clickSaveButton();
	}

	@Test
	public void Material_Create_Fill_In_Data_JDE_Finance() throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.materialNavPage.clickFinancetab();
	SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();
	SharedDriver.pageContainer.materialNavPage.selectVATPostingGroup();
	SharedDriver.pageContainer.materialNavPage.selectItemDepositGroupCode();
	SharedDriver.pageContainer.materialNavPage.clickLocalAction();
	SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
	SharedDriver.pageContainer.materialNavPage.clickSaveButton();
	}
	
	@Test
	public void Material_Create_Fill_In_Data_JDE_Site() throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
	SharedDriver.pageContainer.materialNavPage.clickSiteNewButton();
	SharedDriver.pageContainer.materialNavPage.selectLocationCode();
	SharedDriver.pageContainer.materialNavPage.selectReplenishmentSystem();
	SharedDriver.pageContainer.materialNavPage.clickSiteValidateButton();
	SharedDriver.pageContainer.materialNavPage.clickSiteSaveButton();
	SharedDriver.pageContainer.materialNavPage.submitGlobalRequestTest();
	SharedDriver.pageContainer.materialPage.getRequestId();
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check(Map<String,String> dataMap) throws InterruptedException, FileNotFoundException, IOException 
	{

		SharedDriver.pageContainer.processInfoPage.processInfoSearch();
		SharedDriver.pageContainer.processInfoPage.reqIdSearch(dataMap.get("RequestId"));
		SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
		Thread.sleep(3000);
		SharedDriver.pageContainer.processInfoPage.browserClose();
	}

}

