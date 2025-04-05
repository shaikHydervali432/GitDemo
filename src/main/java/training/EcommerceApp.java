package training;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		/**Below is implicit wait**/
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		addtoCart(driver,itemsNeeded);// in this method we need to pass actual driver and itemsneeded so that this method gets activated
		/**EcommerceApp app = new EcommerceApp();
		app.addtoCart(driver, itemsNeeded);
		**/
		WebDriverWait explictWait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit wait syntax
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		explictWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promocode")));
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		explictWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void addtoCart(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> vegetables = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for (int i = 0; i < vegetables.size(); i++) {
			String[] items = vegetables.get(i).getText().split("-");
			String formattedItems = items[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded); //converting to arraylist to increase size dynamically

			if (itemsNeededList.contains(formattedItems)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}


/**
 * The below code will not work because in UI vegetables showing as Cucumber -1kg, Brocolli -1kg etc., 
 * so we are enhancing by splitting and trimming as above
  List<WebElement> vegetables =driver.findElements(By.xpath("//div[@class='products']")); 
  for (int i = 0; i< vegetables.size(); i++) 
  	{ 
  	String items = vegetables.get(i).getText(); 
  		if(items.contains("Cucumber")) 
  		{
 			driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).getText(); break;
  		}
  		 }
 **/