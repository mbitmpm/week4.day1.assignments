package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chittogarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		1. Launch the URL https://www.chittorgarh.com/

		driver.get("https://www.chittorgarh.com/");
//		2. Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();

//		3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();

//		4. Get all the Security names

		List<String> lstname = new ArrayList<String>();
		
		
		WebElement tabValues = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
		List<WebElement> rowValues = tabValues.findElements(By.xpath("//tr"));
	
		for (int i = 1; i <= rowValues.size() - 1; i++) {
			WebElement findElement = rowValues.get(i).findElement(By.xpath("//th[" + i + "]"));
			
			if (findElement.getText().equals("Security Name")) {
				
				for (int j = 1; j <= rowValues.size() - i; j++) 
				{
					String securityNames = tabValues.findElement(By.xpath("//tr[" + j + "]//td[" + i + "]")).getText().trim()+ "\n ";
					
					lstname.add(securityNames);
				}
				System.out.println(lstname);
				
				
				// ensure there are duplicates values in the name list
				
				Set<String> targetSet = new TreeSet<String>(lstname);
				System.out.println(targetSet);
				
				if (targetSet.size() < lstname.size()) {
					System.out.println("It contains duplicates security names");
				}
				
				break;
			}
		}

	}

}
