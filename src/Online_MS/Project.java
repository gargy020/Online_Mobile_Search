package Online_MS;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Project {

	public static void main(String args[]) throws InterruptedException {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter browser name: ");
	String name = s.nextLine();
	WebDriver driver;
	if (name.toLowerCase().contains("edge")) {
		System.setProperty("webdriver.edge.driver","C:\\Users\\2317747\\eclipse-workspace\\selenium_example\\Browser\\msedgedriver.exe");
		driver = new EdgeDriver();

	} else {
		System.out.println("Browser name is incorrect");
		return;
	}
	driver.get("https://www.amazon.in");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
    search.sendKeys("mobile smartphones under 30000");
    Thread.sleep(2000);
    driver.findElement(By.id("nav-search-submit-button")).click();
        
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.className("a-button-text")).click();
    
	/* To verify if mobile smartphones under 30000 Selected properly*/
    String v1=driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]")).getText();
    if(v1.contains("mobile smartphones under 30000")) {
    System.out.println("mobile smartphones under 30000 selected");
    }
    else {
    	System.out.println("mobile smartphones under 30000 not Selected");
    }
    
    
	/* To Count no of Sort options in dropdown */
    String c = driver.findElement(By.className("a-popover-inner")).getText();
    String lst[]=c.split("\n");
    System.out.println("No of option in sort list is " +(lst.length));
    

	/* To Select Newest Arrivals */
     Thread.sleep(2000);
     Actions a=new Actions(driver); 
     a.moveToElement(driver.findElement(By.xpath("//a[text()='Newest Arrivals']"))).click().build().perform();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
	/* verify if Newest Arrivals is selected properly */
     String v =driver.findElement(By.className("a-dropdown-prompt")).getText();
     if(v.equals("Newest Arrivals"))
     {
    	 System.out.println("Newest Arrivals Selected");
     }
     else {
    	 System.out.println("Newest Arrivals not Selected");
     }
     /* To verify page and results*/
     String v2=driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")).getText();
     String v3="1-16 of over 1,000 results for";
     String v4="1-16 of over 3,000 results for";
     if(v2.equals(v3)|| v2.equals(v4) ) {
     System.out.println("Results verified");
     }
     else
     {
     	System.out.println("Results not verified");
     }
     
     Thread.sleep(4000);
    
     driver.quit();
}
}