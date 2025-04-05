package training;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("banana");
		//We will get one result
		List<WebElement> vegFruitRow=driver.findElements(By.xpath("//tr/td[1]"));
		//after applying filter we will get one result
		List<WebElement>filteredList= vegFruitRow.stream().filter(s->s.getText().contains("Banana")).collect(Collectors.toList());
		Assert.assertEquals(vegFruitRow.size(), filteredList.size());
	}

}
