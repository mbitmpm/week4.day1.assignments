package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundTables {

	public static void main(String[] args) 
	{
		//driver setup
		
		WebDriverManager.chromedriver().setup();
		
		//chrome driver intialization
		
		ChromeDriver driver=new ChromeDriver();
		
		//URL MAXIMIZE Window
		
		driver.manage().window().maximize();
		
		//implicit wait 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//URL opening
		
		driver.get("http://www.leafground.com/pages/table.html");
		
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println("The current URL of the page : " + currentUrl);
		
		String title = driver.getTitle();
		
		System.out.println("The title of the page :" + title);
		
		//get the number of rows in the table
		
        int rowSize = driver.findElements(By.xpath("(//table)//tbody//tr")).size();
		System.out.println("The number of rows in the table :" + rowSize);
		
		int columnSize = driver.findElements(By.xpath("//table/tbody/tr/th")).size();
		
		System.out.println("The number of columns in the table :" + columnSize);
		
   	 	
	        for(int i=2;i<=rowSize;i++)
	        {
	        	
	        	String getDetails = driver.findElement(By.xpath("(//table/tbody)//tr["+i+"]/td")).getText();
	        	if( getDetails.equalsIgnoreCase("Learn to interact with Elements"))
	        	{
	        		
	        		String progressValue = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
	         
	        		System.out.println("Learn to interact with Elements Progress Value is : " +progressValue );
	        	}
	        	
	        }
	       
		

	
		List<String> progressValue=new ArrayList<String>();
		for(int j=2;j<=rowSize;j++)
		{
			
			String progressText = driver.findElement(By.xpath("(//table/tbody)//tr["+j+"]/td[2]")).getText();
			progressValue.add(progressText);
			
		}
		
		
	Collections.sort(progressValue);
	
	System.out.println("The least Progress Value :" + progressValue.get(1));
	

	
		
	}

	}


