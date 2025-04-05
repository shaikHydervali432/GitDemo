package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class QAClickNoHardCoding {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String userOption = driver.findElement(By.xpath("//div[@class='right-align']//label[3]")).getText();
		driver.findElement(By.id("checkBoxOption3")).click();
		System.out.println(userOption);
		Thread.sleep(5000);
		Select sel = new Select(driver.findElement(By.name("dropdown-class-example")));
		sel.selectByVisibleText(userOption);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(userOption);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals("Hello Option3, share this practice page and share your knowledge", alertMessage);
		driver.switchTo().alert().accept();	

	}

}
