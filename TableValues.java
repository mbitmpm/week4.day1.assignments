package week4.day1.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableValues {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://html.com/tags/table/");
		
//		2. You have to print the respective values based on given Library
//		(hint: if the library was absolute usage, then print all its value)
		
	
			List<WebElement> findElements = driver.findElements(By.xpath("(//table[1])//tr"));
			
			 
			int size = findElements.size();
			
			System.out.println("The Library Values are :");
			System.out.println(findElements.get(0).getText());
			System.out.println('\n');
			System.out.println(findElements.get(1).getText());
			System.out.println(findElements.get(2).getText());
			
			 
			
	
		
	}

}
