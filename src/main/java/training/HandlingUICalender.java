package training;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingUICalender {

	public static void main(String[] args) {
		String monthNumber ="8";
		String date ="3";
		String Year ="2027";
		String[] actualDate= {monthNumber,date,Year};
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']/span")).click();
		driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
		//below is we converted from string to integer
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		//below what we did is we capture the data in a list because we canot get text because it is having subclasses
		List<WebElement> datelist = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));	
		for(int i=0;i<datelist.size();i++)
		{
			System.out.println(datelist.get(i).getAttribute("value"));//since in the HTML value is storing the date
			Assert.assertEquals(datelist.get(i).getAttribute("value"), actualDate[i]);
		}
		driver.close();
	}

}
