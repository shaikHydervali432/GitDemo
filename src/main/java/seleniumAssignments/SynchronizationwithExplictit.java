package seleniumAssignments;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationwithExplictit {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		/**System.out.println(driver.findElement(By.cssSelector("p.text-center.text-white")).getText());
		String credentials = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		credentials.split(credentials);
		String[] fromattedCredentials = credentials.split(" ");
		for(int i=0;i<fromattedCredentials.length;i++)
		{
			System.out.println(fromattedCredentials[i]);
		}
		**/
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@type='radio' and @value ='user']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		sel.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-info']")));
		List<WebElement> phones = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for (int i = 0; i < phones.size(); i++) {

			driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		}
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		
	}

}
