package training;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleTabWindow {
		public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		//we are switching to newWindow and window type is tab which will open new tab
		driver.switchTo().newWindow(WindowType.TAB);
		/**we need to switch to new tab but selenium by default will be in parent window so we need to switch to child window,
		for that we need window name or window handle this is achieved by **/
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>it= windows.iterator();
		String parentWindowId=it.next();
		String childWindowId=it.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName=driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		driver.switchTo().window(parentWindowId);
		//driver.findElement(By.name("name")).sendKeys(courseName);
		//taking partial screenshot
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		System.out.println(name.getRect().getDimension().getHeight());
		name.getRect().getDimension().getWidth();
		File file=name.getScreenshotAs(OutputType.FILE);
		// to get the physical File from file object there is a class in java FileUtils
		FileUtils.copyFile(file, new File("screenshot.png"));
		
		
		

	}

}
