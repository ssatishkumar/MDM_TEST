package com.mendix.page;

import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.ExcelUtil;

public class MaterialApprovalPage {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new process Info page.
	 *
	 * @param driver the driver
	 */
	public MaterialApprovalPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}



	@FindBy(how=How.CSS, using="div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")
	WebElement txtboxRequestId;

	@FindBy(how=How.XPATH, using=".//*[@class='glyphicon glyphicon-search']")
	WebElement btnReqIdSearch;

	//	@FindBy(how=How.XPATH, using="button//*[text()='Search']")
//	@FindBy(how=How.CSS, using="button[text='Search']")
	@FindBy(how=How.XPATH, using="//*[text()='Search']")
	WebElement btnReqIdMyTaskSearch;

	@FindBy(how=How.XPATH, using="//label[text()='Request ID']/../../div[2]/input")
	WebElement txtboxReqIdSearch;

	@FindBy(how=How.XPATH, using="(.//button[text()='Search'])[1]")
	WebElement btnReqIdEnterSearch;

	@FindBy(how=How.XPATH, using=".//button[text()='Open Task']")
	WebElement btnOpenTask;

	@FindBy(how=How.XPATH, using="//a[text()=' My Tasks']")
	WebElement menuMyTask;

	@FindBy(how=How.XPATH, using="//span[@class='glyphicon glyphicon-flash']")
	WebElement btnlocalAction;

	@FindBy(how=How.CSS, using=".glyphicon.glyphicon-ok")
	WebElement btnGDAApproval;


	@FindBy(how=How.XPATH, using="//*[text()='Proceed']")
	WebElement btnProceed;

	@FindBy(how=How.XPATH, using=".//button[text()='Submit Global Request']")
	WebElement btnGlobalRequest;

	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;

	@FindBy(how=How.XPATH, using="//*[text()='OK']")
	WebElement btnMsgReqIdOkdraft;
	/**
	 * Enter UserName.
	 * Enter Password
	 * 
	 * Click Login
	 *
	 * @param strMenuName the str menu name
	 * @return 
	 * @return true, if successful
	 */


	public boolean reqIdSearchMyTasks(String strValue) 

	{
		Sync.waitForSeconds(Constants.WAIT_6);
//		driver.switchTo().window("Application");
		Sync.waitForElementToBeClickable(driver, menuMyTask);
		
		Button.jsclick("Search My task", menuMyTask, driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait My taska to load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver, btnReqIdMyTaskSearch);
		Sync.waitForObject(driver, "Wait for button Request Id search", btnReqIdMyTaskSearch);
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.jsclick("Search My task", btnReqIdMyTaskSearch, driver);
		Sync.waitForSeconds(Constants.WAIT_3);
		Textbox.click("Click Enter Request Id", txtboxReqIdSearch);
		Sync.waitForSeconds(Constants.WAIT_3);
		Textbox.enterValue("Enter Request Id textbox", txtboxReqIdSearch, strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Click Search Button", btnReqIdEnterSearch);
		Sync.waitForSeconds(Constants.WAIT_1);
		return Button.click("Click Open Task", btnOpenTask);

	}

	public boolean approvalBtnClick()
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Wait My tasks to load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver, btnlocalAction);
		Button.click("Click Local Action button", btnlocalAction);
		Sync.waitForSeconds(Constants.WAIT_5);
		return Button.jsclick("Click Approval Button", btnGDAApproval, driver);
	}

	public boolean submitGlobalRequest()
	{

		Sync.waitForElementToBeClickable(driver, btnlocalAction);
		Button.click("Click Local Action button", btnlocalAction);
		return Button.click("Click Approval button", btnGlobalRequest);
	}

	public boolean submitGlobalRequest_draft()
	{

		Sync.waitForElementToBeClickable(driver, btnlocalAction);
		Button.click("Click Local Action button", btnlocalAction);
		Button.click("Click Approval button", btnGlobalRequest);
		Actions btnselect = new Actions(driver);
		btnselect.moveToElement(btnMsgReqIdOk);
		btnselect.build();
		btnselect.perform();
		return Button.click("Click Ok Button", btnMsgReqIdOk);
	}

	public  void launchUFT() throws IOException {
		Runtime.getRuntime().exec("C:\\Users\\IBM_ADMIN\\git\\MDM_TEST\\MDM_POC\\AutoIt UFT Launch\\UFT.exe");
		
	}


	public void duplicateCheck() {
		try {
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_5);
			/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

			WebElement ele = wait.until(new Function<WebDriver, WebElement>()

			{

			public WebElement apply(WebDriver driver)

			            {         

			WebElement element = driver.findElement(By.xpath(".//*[text()='Open Record']"));

			String getTextOnPage = element.getText();

			if(getTextOnPage.equals("Selenium Certification Training"))

			{

			System.out.println(getTextOnPage);

			return element;

			}                                             

			else

			{

			System.out.println("FluentWait Failed");

			                        return null;

			}}

			});*/
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_3);
			
			driver.manage().window().setPosition(new Point(-2000, 0)) ;
			
			Sync.waitForSeconds(Constants.WAIT_3);
			
			driver.manage().window().maximize();
			
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			
		
			driver.findElement(By.xpath(".//*[text()='Open Record']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(".//*[text()='Export to Excel']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[text()='Confirm and Approve']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[text()='Confirm and Approve']")).sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("//*[text()='Proceed']")).click();
			Sync.waitForSeconds(Constants.WAIT_5);
			
			

			Actions actions = new Actions(driver);
			actions.moveToElement(btnMsgReqIdOk);
			actions.perform();

			Button.click("Click Ok Button", btnMsgReqIdOk);
		
			/*try
			{
				if(btnMsgReqIdOkdraft.isEnabled())
				{
					Button.click("Click Ok Button", btnMsgReqIdOkdraft);
					System.out.println("Button is Clicked");
				}
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());


			}*/
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());


		}
	}
}
