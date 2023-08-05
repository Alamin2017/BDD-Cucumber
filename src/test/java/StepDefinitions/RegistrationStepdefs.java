package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Random;
import static StepDefinitions.Hooks.driver;

public class RegistrationStepdefs {

    @Given("User go to the NopCommerce Home page")
    public void userGoToTheNopCommerceHomePage() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
    }
    @And("User navigate to the Registration page")
    public void userNavigateToTheRegistrationPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        Thread.sleep(2000);
    }
    @When("^User select the (.*) as gender$")
    public void userSelectTheTypeAsGender(String type) throws InterruptedException {
        if(type.equalsIgnoreCase("Male"))
        {
            driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        }
        else if(type.equalsIgnoreCase("Female"))
        {
            driver.findElement(By.xpath("//span[@class='female']")).click();
        }
        Thread.sleep(2000);
    }
    @And("User set first name and last name")
    public void userSetFirstNameAndLastName() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Al");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Amin");
        Thread.sleep(2000);
    }
    @And("^User set (.*) as date of birth$")
    public void userSetDobAsDateOfBirth(String DOB) throws InterruptedException {
        String date = DOB;
        String[] dateParts = date.split("/");
        String day1 = dateParts[0];
        String month1 = dateParts[1];
        String year1=dateParts[2];
        WebElement day=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        Thread.sleep(1000);
        WebElement month=driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        Thread.sleep(1000);
        WebElement year=driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        Thread.sleep(1000);

        day.click();
        Select se=new Select(day);
        se.selectByVisibleText(day1);
        Thread.sleep(1000);

        month.click();
        Select se1=new Select(month);
        se1.selectByIndex(Integer.parseInt(month1));
        Thread.sleep(1000);

        year.click();
        Select se2=new Select(year);
        se2.selectByVisibleText(year1);
        Thread.sleep(1000);
    }
    @And("User set <dynamicEmail> as email")
    public void userSetDynamicEmailAsEmail() throws InterruptedException {
        Random ran=new Random();
        String Email="Alamin"+ran.nextInt()+"@gmail.com";
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Email);
        Thread.sleep(2000);
    }
    @And("^User set (.*) as company details$")
    public void userSetCompanyNameAsCompanyDetails(String companyName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
        Thread.sleep(2000);
    }
    @And("^User set Newsletter option as (.*)$")
    public void userSetNewsletterOptionAsStatus(String status) throws InterruptedException {
        if(status.equalsIgnoreCase("checked"))
        {
            driver.findElement(By.xpath("//input[@id='Newsletter']"));
        }
        else if(status.equalsIgnoreCase("unchecked"))
        {
            driver.findElement(By.xpath("//input[@id='Newsletter']")).click();
        }
        Thread.sleep(2000);
    }
    @And("^User set (.*) as password and confirm password again$")
    public void userSetPasswordAsPasswordAndConfirmPasswordAgain(String password) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        Thread.sleep(2000);
    }
    @And("User click on the Register button")
    public void userClickOnTheRegisterButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        Thread.sleep(2000);
    }
    @Then("^Verify that the new account registration message (.*) is displayed$")
    public void verifyThatTheNewAccountRegistrationMessageMsgIsDisplayed(String expectedMessage) throws InterruptedException {
        String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(2000);
    }
}
