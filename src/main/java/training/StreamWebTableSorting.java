package training;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamWebTableSorting {

	public void SortingTable() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		// capture all the WebElements into List
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		// capture text all of webelements into originalList
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sorting the originalList
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		System.out.println("Orginal List is in SOrted order");
	}
	public void getPrice() {
		//below code is to get the price of Bean 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		// capture all the WebElements into List
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//getVeggiePrice is a separate method we created to get the price
		List<String> price= elementsList.stream().filter(s -> s.getText().contains("Beans")).map(s -> getVeggiePrice(s))
				.collect(Collectors.toList());
		price.forEach(s->System.out.println(s));	
	}
	private static String getVeggiePrice(WebElement s) {
	//s already contains //tbody/tr/td[1] xpath so instead of writing again  //tbody/tr/td[1]/following-sibling::td[1] we simply write s.
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

	public void paginationGettingRicePrice() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<String> price;
		do
		{
		List<WebElement>vegFruitRow=driver.findElements(By.xpath("//tr/td[1]"));
		 price=vegFruitRow.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
		 price.stream().forEach(s->System.out.println(s));
		
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
	}
		

	public static void main(String[] args) {
		StreamWebTableSorting ss = new StreamWebTableSorting();
		ss.paginationGettingRicePrice();

	}
}
