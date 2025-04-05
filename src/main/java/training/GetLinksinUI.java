package training;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLinksinUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerSection = driver.findElement(By.cssSelector(".navFooterVerticalRow.navAccessibility"));
		System.out.println(footerSection.findElements(By.tagName("a")).size());
		WebElement subFooterSection = driver.findElement(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div[1]"));
		System.out.println(subFooterSection.findElements(By.tagName("a")).size());
		//below is opening all the links in new tabs
		for (int i = 0; i < subFooterSection.findElements(By.tagName("a")).size(); i++) 
		{
			String linksTobeClick = Keys.chord(Keys.CONTROL, Keys.ENTER); //click and enter both are same
			System.out.println(subFooterSection.findElements(By.tagName("a")).get(i).getText());
			subFooterSection.findElements(By.tagName("a")).get(i).sendKeys(linksTobeClick);
		}
		//getting the tab tittle
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}
	}

	}

