package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Accountstransfer {
		

	public WebDriver driver;
	public String val;	


	@Given("^Login in to the application$")
	public void loginInToTheApplication() throws Throwable {
		String filepath = System.getProperty("user.dir") + "\\Browser\\";
		System.setProperty("webdriver.chrome.driver", filepath + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://elastic.rapidtestpro.com:8086");		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("labuser");
		driver.findElement(By.id("password")).sendKeys("labuser@01");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	}

	@And("^click on the transfer$")
	public void clickOnTheTransfer() throws Throwable {		
		val = driver.findElement(By.xpath("//div[@class='panel panel-success']/div/div[1]/div[2]/h1/span")).getText();
		driver.findElement(By.xpath("//a[text()='Transfer ']")).click();
	}
	@And("^click the transfer$")
	public void clickTheTransfer() throws Throwable {				
		driver.findElement(By.xpath("//a[text()='Transfer ']")).click();
	}
	
	@And("^select the between accounts$")
	public void selectTheBetweenAccounts() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Between Accounts']")).click();
	}

	@And("^Fill the between accounts form and click on transfer$")
	public void fillTheBetweenAccountsFormAndClickOnTransfer() throws Throwable {
		WebElement element = driver.findElement(By.id("transferFrom"));
		Select ddl = new Select(element);
		ddl.selectByValue("Primary");		
		driver.findElement(By.id("amount")).sendKeys("10");
		driver.findElement(By.xpath("//button[text()='Transfer']")).click();
	}

	@Then("^Validate with the savings account balance from the amount you have entered$")
	public void validateWithTheSavingsAccountBalanceFromTheAmountYouHaveEntered() throws Throwable {
		WebElement el = driver.findElement(By.xpath("//div[@class='panel panel-success']/div/div[1]/div[2]/h1/span"));
		if(el.getText()!=val)
		{
			System.out.println("The transaction is completed sucessfully");
		}
		else
		{
			System.out.println("The transaction is failed");
		}
		
	}

	@And("^click on Add/Edit Recipient$")
	public void clickOnAddEditRecipient() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add/Edit Recipient']")).click();
	}

	@And("^Wait for the page to load$")
	public void waitForThePageToLoad() throws Throwable {
		Thread.sleep(5000);
	}

	@Given("^Enter five records to add recipient in the Recipient information$")
	public void EnterfiverecordstoaddrecipientintheRecipientinformation(DataTable dt) throws Throwable {
		 List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		 for(int i=0;i<list.size();i++)
		 {
			 driver.findElement(By.id("recipientName")).sendKeys(list.get(i).toString());
		 }
	}

	@And("^Enter the details in the Recipient form$")
	public void enterTheDetailsInTheRecipientForm() throws Throwable {
		driver.findElement(By.id("recipientName")).sendKeys("Ram");
		driver.findElement(By.id("recipientEmail")).sendKeys("Ram@gmail.com");
		driver.findElement(By.id("recipientPhone")).sendKeys("9950987654");
		driver.findElement(By.id("recipientAccountNumber")).sendKeys("9087654321");
		driver.findElement(By.id("recipientDescription")).sendKeys("recipient details");
		driver.findElement(By.xpath("//button[text()='Add/Edit Recipient']")).click();
		System.out.println("details added sucessfully");
	}
	


}
