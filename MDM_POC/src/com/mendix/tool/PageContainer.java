package com.mendix.tool;

import org.openqa.selenium.WebDriver;

import com.mendix.page.LoginPage;
import com.mendix.page.MaterialApprovalPage;
import com.mendix.page.HomePage;
import com.mendix.page.MaterialPage;
import com.mendix.page.Material_Nav_Page;
import com.mendix.page.ProceesInfoPage;



public class PageContainer {

public WebDriver driver;
public LoginPage loginPage;
public MaterialPage materialPage;
public HomePage homePage;
public ProceesInfoPage processInfoPage;
public MaterialApprovalPage materialApprovalPage;
public Material_Nav_Page materialNavPage;

public PageContainer(WebDriver driver){
	this.driver=driver;
	initPages();
}


private void initPages() {
	loginPage = new LoginPage(driver);
	materialPage = new MaterialPage(driver);	
    homePage = new HomePage(driver);
    processInfoPage = new ProceesInfoPage(driver);
    materialApprovalPage = new MaterialApprovalPage(driver);
    materialNavPage = new Material_Nav_Page(driver);
	
}

}
