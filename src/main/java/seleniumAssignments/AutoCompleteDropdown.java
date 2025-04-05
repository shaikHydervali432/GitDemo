package seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutoCompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement userDropDown= driver.findElement(By.className("ui-autocomplete-input"));
		userDropDown.sendKeys("ind");
		/**userDropDown.sendKeys(Keys.DOWN);
		userDropDown.sendKeys(Keys.DOWN);
		**/
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(userDropDown).click(driver.findElement(By.xpath("//li//div[text()='United Kingdom (UK)']"))).build().perform();
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
	}

}
