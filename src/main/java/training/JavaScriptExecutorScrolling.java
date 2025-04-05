package training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorScrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//casting to driver to javascriptExcecutor so that it will execute javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//below step we need to go console and write this 
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=2000");
		List<WebElement>price= driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum =0;
		for(int i=0;i<price.size();i++)
		{
			System.out.println(price.get(i).getText());
			sum = sum + Integer.parseInt(price.get(i).getText());
			
		}
		System.out.println(sum);
		//splitting this string 'Total Amount Collected: 296' and getting only 296
		int total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum,total);
		
	}

}
