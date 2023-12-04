package Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assigment2 extends Parameters {
	SoftAssert myAssertion = new SoftAssert();

	@BeforeTest
	public void Setup() {
		driver.get(myURL);

	}

	@Test(priority = 1)
	public void Contact() throws InterruptedException {
		driver.get(SignUpPage);
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement Button = driver.findElement(By.className("primary"));

		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastNames);
		Email.sendKeys(EmailFinal);
		Password.sendKeys(FinalPassoward);
		confirmPassword.sendKeys(FinalPassoward);
		Button.click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 2)
	public void LogoutTest() throws InterruptedException {

		driver.get(LogoutPage);
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void LoginTest() {

		driver.get(LogInPage);
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passInput = driver.findElement(By.id("pass"));
		WebElement loginbut = driver.findElement(By.id("send2"));

		emailInput.sendKeys(EmailFinal);
		passInput.sendKeys(FinalPassoward);
		loginbut.click();

	    myAssertion.assertEquals(driver.getCurrentUrl(),loggedInSucsess,"check if the current URL Match");
	    myAssertion.assertAll();

	}

	@AfterTest
	public void AfterTest() {

	}
}