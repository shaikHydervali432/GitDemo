package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UIDropdownsProtractor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		driver.findElement(By.name("name")).sendKeys("shaik");
		driver.findElement(By.name("email")).sendKeys("shaik146@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Shaik@146");
		driver.findElement(By.xpath("//div[@class='form-check']/input[@class='form-check-input']")).click();
		WebElement gender = driver.findElement(By.xpath("//div[@class='form-group']/select"));
		Select dropdown = new Select(gender);
		dropdown.getFirstSelectedOption();
		dropdown.selectByIndex(0);
		driver.findElement(By.id("inlineRadio1")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".form-control")).sendKeys("15-03-2024");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
	}

}
