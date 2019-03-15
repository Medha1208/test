package Education_LOB.Education_LOB;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

@Test
public class SalesOrder {

	public static void create() throws InterruptedException, AWTException {
	
		    {	
		       System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		        
		        WebDriver d = new ChromeDriver();  
		        WebDriverWait wait = new WebDriverWait(d,20);
		        d.get("https://system.netsuite.com/pages/customerlogin.jsp");
		        d.manage().window().maximize();
		        d.findElement(By.id("userName")).sendKeys("MDublish-consultant@Scholastic.com");
		        d.findElement(By.id("password")).sendKeys("welcome@121M");
		        d.findElement(By.id("submitButton")).click();

		        d.findElement(By.xpath("//input[@type= 'password']")).sendKeys("bangalore");
		        d.findElement(By.xpath("//input[@type= 'submit']")).click();
		        Thread.sleep(10000);
		        
		        //Sales order
		        WebElement wb= d.findElement(By.xpath("//span[contains(text(),'Opportunities')]"));		       
		        d.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		        Actions act = new Actions(d);
		        act.moveToElement(wb).perform();
		        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[contains(text(),'Transactions')]"))));
		        act.moveToElement(d.findElement(By.xpath("//span[contains(text(),'Transactions')]"))).perform();
		        Thread.sleep(5000);        
		        JavascriptExecutor executor = (JavascriptExecutor)d;
			    executor.executeScript("arguments[0].click();", d.findElement(By.xpath("(.//a/span[contains(text(),'Sales Order')])[1]")));
		                 
		        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//span[contains(text(),'Sales Order')])[1]"))));
		        
		        //act.click(d.findElement(By.xpath("(//span[contains(text(),'Sales Order')])[1]"))).perform();
		        System.out.println("Sales Order");
		        
		        //Page3: SALES ORDER
		        Robot rb=new Robot();
		        
		        d.findElement(By.xpath("//*[@id='inpt_customform1']")).sendKeys("INTL Education Sales Order"); 
		        d.findElement(By.xpath("//*[@id='entity_display']")).sendKeys("P05005 BEACH HAVEN SCHOOL");
		        Thread.sleep(12000);
		        //JavascriptExecutor executor2 = (JavascriptExecutor)d;
				//executor2.executeScript("arguments[0].click()", d.findElement(By.xpath("//*[@id='inpt_customform1']")));
		       
		        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='entity_display']"))));
		        d.findElement(By.xpath("//*[@id='entity_display']")).sendKeys("P05005 BEACH HAVEN SCHOOL");
		        Thread.sleep(12000);
		        	       
                //rb.keyPress(java.awt.event.KeyEvent.VK_ALT);
		        rb.keyPress(java.awt.event.KeyEvent.VK_DOWN);
                //rb.keyRelease(java.awt.event.KeyEvent.VK_ALT);
		        rb.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
		        rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		        rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		               
		        Thread.sleep(12000);
		        System.out.println("Sales Order2");
		        
		        //Insert Item ISBN Code 
		      
		      //executor.executeScript("window.scrollBy(0,2000)");
		        
		        //d.findElement(By.xpath("//*[@id='item_custcol_isbn_display']"));
		        Thread.sleep(12000);
		       
		      //executor.executeScript("arguments[0].scrollIntoView();",d.findElement(By.xpath("//*[@id='item_splits']/tbody/tr[2]/td[3]/div")));
		      
		        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='item_splits']/tbody/tr[2]/td[3]/div")))); 
		        d.findElement(By.xpath("//*[@id='item_splits']/tbody/tr[2]/td[3]/div")).click();
		        d.findElement(By.xpath("//input[@id='item_custcol_isbn_display']")).sendKeys("9781338047431");
		        System.out.println("Scrolled");
		        
		        //Click on save button
		        Thread.sleep(10000);
		        rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		        d.findElement(By.xpath("//*[@id='btn_secondarymultibutton_submitter']")).click();	      
		        //System.out.println(d.findElement(By.xpath("//input[@id='btn_secondarymultibutton_submitter']")).getAttribute("value"));
		       
		        //Alert box 
		        Thread.sleep(5000);
		        d.switchTo().alert().getText();
		        d.switchTo().alert().dismiss();
		        System.out.println("saved");
		       
		        //Dismiss leave site
		        Thread.sleep(5000);
		        d.switchTo().alert().accept();
		        Thread.sleep(15000);
		        System.out.println("saved2");
		        
		       //get the SO created
		       
		     Sales.salesId = d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[1]")).getText();
		     System.out.println(Sales.salesId);
		     
		     //sales order status : pending fulfillment
		     String x  = d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[3]")).getText();		    
		     System.out.println("Sales order status:" +x);		        	
		    
}}}