package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2EMakeaTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//div[contains(text(),'round trip')]")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Ajmer')]")).click();
		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']"))
				.click();
		Thread.sleep(5000);

		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Return Date')]")).getAttribute("style"));
		// div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar r-icoktb'] --> one way
		//// div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar r-icoktb'] -->
		// roundtrip
		/**
		 * if(driver.findElement(By.xpath("//div[contains(text(),'Return
		 * Date')]")).getAttribute("style").contains("1")) { Assert.assertFalse(false);
		 * } else { Assert.assertTrue(true); }
		 **/
		driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();

		int i = 1;
		while (i < 5) {
			driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz']/div[3])[1]")).click();
			i++;
		}
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-obd0qt r-k8qxaj r-d9fdf6']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Currency')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='INR']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Students')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']"))
				.click();

	}

}
