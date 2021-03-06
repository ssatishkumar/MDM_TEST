package com.mendix.page;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.Sync;


public class Material_Nav_Page {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new home page changes
	 *
	 * @param driver the driver
	 */
	public Material_Nav_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	

	@FindBy(how=How.XPATH, using="//*[text()='Local Data']")
	WebElement textLocalData;
	
	@FindBy(how=How.XPATH, using="(.//*[@class='glyphicon glyphicon-edit'])[5]")
	WebElement BtnEditPlantData;
	
	@FindBy(how=How.XPATH, using="(.//*[@class='glyphicon glyphicon-new-window'])[6]")
	WebElement BtnAddPlantData;
	
	@FindBy(how=How.XPATH, using="//button[text()='Select']")
	WebElement BtnPlantSelect;
	
	@FindBy(how=How.XPATH, using="(.//button[text()='Edit'])[1]")
	WebElement BtnPlantEdit;
	
	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;
	
	public boolean enterLocalData() {

//		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		Button.click("Local Data", textLocalData);
		Sync.waitForObject(driver, BtnAddPlantData);
		return Button.click("Click Edit button", BtnAddPlantData);
		
	}
	
	public boolean clickAddPlantData() {

		Sync.waitForObject(driver, BtnAddPlantData);
		return Button.click("Click Edit button", BtnAddPlantData);
		
	}
	
	
	public boolean enterPlantData() {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, BtnAddPlantData);
		Button.click("Local Plant Data", BtnAddPlantData);
		
		
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='DZ10']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='DZ10']")));
		driver.findElement(By.xpath("//div[text()='DZ10']")).click();
		return Button.click("Click Select Button", BtnPlantSelect);
	
	}
	
	public void clickEditPlanningData() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		driver.findElement(By.xpath("(//button[text()='Edit'])[5]")).click();
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		Sync.waitForSeconds(Constants.WAIT_6);
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//*[text()='OK'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_3);
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//*[text()='OK'])[1]")));*/
	}
	
	public void selectRoundingPrecision()
	{
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Rounding Precision']/../div/div/select"));
		Select roundPrecisiondropDown= new Select(dropdown);
		roundPrecisiondropDown.selectByVisibleText("0.01");
		
	}
	public void clickLocalAction()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).click();
	}
	
	public void clickValidatLocalData()
	{
		
		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();
		
	
	}
	
	public void clickValidateLocalData_Planning()
	{
		
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Planning Data to Load", driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();
		
	
	}
	
	public void clickSaveButton()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, "Wait for Click Save button", driver.findElement(By.xpath(".//button[text()='Save']")));
//		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-ok']")));
		Button.jsclick("Click Save Button", driver.findElement(By.xpath(".//button[text()='Save']")), driver);
//		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-ok']")).click();
	
	}
	
	
	
	public void clickFinancetab() throws InterruptedException
	{
//		TimeUnit.SECONDS.sleep(30);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Click element", driver.findElement(By.xpath("//a[text()='Finance']")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='Finance']")));
		Button.jsclick("Click Finance Tab", driver.findElement(By.xpath("//a[text()='Finance']")), driver);
//		driver.findElement(By.xpath("//a[text()='Finance']")).click();
	
	}
	
	public void clickEditFinanceData() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")));
		driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")).click();
		/*Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Sync.waitForSeconds(Constants.WAIT_6);
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//*[text()='OK'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_3);
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//*[text()='OK'])[1]")));*/
	}
	
	
	
	
	
	public void selectVATPostingGroup()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='VAT Prod. Posting Group']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for VAT posting group Select", dropdown);
		Sync.waitForElementToBeClickable(driver, dropdown);
		Button.click("Wait for VAT posting group Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("NO_VAT, 0% VAT");
		
	}
	
	public void selectItemDepositGroupCode()
	{
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Item Deposit Group Code']/../div/div/select"));
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("02, Keg");
		
	}
	
	public void submitGlobalRequestTest() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Submit Global Request", driver.findElement(By.cssSelector("button:contains(Submit Global and Local Request)")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("button:contains(Submit Global and Local Request)")));
		Button.jsclick("Click Global submit Global Request", driver.findElement(By.cssSelector("button:contains(Submit Global and Local Request)")), driver);
//		Button.click("Click Global submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}
	
	public void submitGlobalLocalRequestTest() throws InterruptedException {

		TimeUnit.MINUTES.sleep(2);
		Sync.waitForObject(driver, "Wait for Submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Button.jsclick("Click Global submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")), driver);
//		Button.click("Click Global submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}
	
	
	public void clickSiteNewTab(){
		
		/*Sync.waitForObject(driver, "Wait for Site New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Click New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);*/
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[text()='Site']")));
		Sync.waitForObject(driver, "Wait for Click element", driver.findElement(By.xpath("//a[text()='Site']")));
		driver.findElement(By.xpath("//a[text()='Site']")).click();
	}
	
	public void clickSiteNewButton(){

		Sync.waitForObject(driver, "Wait for Site New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Click New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);
	
	}
	
	public void selectLocationCode()
	{
		/*WebElement dropdown =driver.findElement(By.xpath("//*[text()='Item Deposit Group Code']/../div/div/select"));
		Select LocationCodeDropDown= new Select(dropdown);
		LocationCodeDropDown.selectByVisibleText("DZ01, Brewery Rouiba");
*/		
		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Location Code']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("DZ01, Brewery Rouiba");
	}
	
	public void selectReplenishmentSystem()
	{
//		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
//		Select LocationCodeDropDown= new Select(dropdown);
//		LocationCodeDropDown.selectByVisibleText("2, Transfer");
		
		Sync.waitUntilObjectDisappears(driver, "Wait for Replenishment System", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("2, Transfer");
		
	}
	
	public void clickSiteValidateButton(){


		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='Validate Local Data']")));
		Button.click("Click New Button", driver.findElement(By.xpath("//*[text()='Validate Local Data']")));
		Sync.waitForSeconds(Constants.WAIT_2);
	
	}
	
	public void clickSiteSaveButton(){

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(".glyphicon.glyphicon-ok")));
		Button.click("Click New Button", driver.findElement(By.cssSelector(".glyphicon.glyphicon-ok")));
		Sync.waitForSeconds(Constants.WAIT_2);
	
	}
	
	public void scrolltoRoundingPrecision() throws InterruptedException {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)");
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//*[text()='Rounding Precision']/../div/div/select')]")));
		
		Point hoverItem =driver.findElement(By.xpath(".//*[text()='Rounding Precision']")).getLocation();
		((JavascriptExecutor)driver).executeScript("return window.title;");    
		Thread.sleep(6000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
//		js.executeScript("$(\".mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })");
	}
	
	public void clickEditSiteData() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("(//*[text()='Add'])[3]/../button[2]/span")));
		driver.findElement(By.xpath("(//*[text()='Add'])[3]/../button[2]/span")).click();
	}
	
	
}
	
	
