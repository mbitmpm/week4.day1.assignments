package week4.day1.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablecountRowColumn {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://html.com/tags/table/");
		
		List<WebElement> findElements = driver.findElements(By.xpath("(//table)"));
		int tableCount = findElements.size();
		
		for(int i=1;i<=tableCount;i++)
		{
			int rowCount = driver.findElements(By.xpath("(//table)["+i+"]//tr")).size();
			
			System.out.println("The total number of rows in" + i + "st table is :" + rowCount);
			
			int colCount=driver.findElements(By.xpath("(//table)["+i+"]//td")).size();
			
			System.out.println("The total number of column in" + i + "nd table is :" +colCount);
		}
		
		
	}

}
