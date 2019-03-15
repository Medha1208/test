package Education_LOB.Education_LOB;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintShippingLabel {

	public static void main(String[] args) throws InterruptedException, AWTException {
		//SO-296515
		
		  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		  
		    WebDriver d = new ChromeDriver();  
		    WebDriverWait wait = new WebDriverWait(d,20);
		    d.get("https://system.netsuite.com/pages/customerlogin.jsp");
		    d.manage().window().maximize();
		    d.findElement(By.id("userName")).sendKeys("MDublish-consultant@Scholastic.com");
		    d.findElement(By.id("password")).sendKeys("welcome@121M");
		    d.findElement(By.id("submitButton")).click();

		    d.findElement(By.xpath("//input[@type= 'password']")).sendKeys("delhi");
		    d.findElement(By.xpath("//input[@type= 'submit']")).click();
		    Thread.sleep(10000);
		    
		    //Change Role
		    
		    WebElement wb= d.findElement(By.xpath("//*[@id='spn_cRR_d1']/a/div[1]"));		       
		  
		    Actions act = new Actions(d);
		    act.moveToElement(wb).perform();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='ns-header-menu-userrole-item6']/a/span[1]"))));
		    act.moveToElement(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item6']/a/span[1]"))).perform();
		    act.click(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item6']/a/span[1]"))).perform();
		    System.out.println(" INTL Accountant role selected");
		   
		    //Sales_order no.

		   
		    d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys("SO-296515"); 
		    Robot rb=new Robot();
		    rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		    System.out.println("Sales order searched");
		    
		    //click on view link
		    d.findElement(By.xpath("//*[@id='row0']/td[1]/a[2]")).click();
		    Thread.sleep(10000);
		    
		    //capture invoice number\
		    d.findElement(By.xpath("//span[contains(text(),'Opportunities')]"));	
	
		
		

	}

}
