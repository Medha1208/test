package Trade_SO;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Education_LOB.Education_LOB.Sales;

@Test(groups= {"regression"})
public class Sales_Order_Trade {

	public static void create() throws InterruptedException, AWTException {

	//public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        
        WebDriver d = new ChromeDriver();  
        WebDriverWait wait = new WebDriverWait(d,20);
        d.get("https://system.netsuite.com/pages/customerlogin"
        		+ ".jsp");
        d.manage().window().maximize();
        
        d.findElement(By.id("userName")).sendKeys("MDublish-consultant@Scholastic.com");
        d.findElement(By.id("password")).sendKeys("welcome@121M");
        d.findElement(By.id("submitButton")).click();

        d.findElement(By.xpath("//input[@type= 'password']")).sendKeys("delhi");
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
        System.out.println("Sales Order");
        
        //Page3: SALES ORDER
        Robot rb=new Robot();
        
        d.findElement(By.xpath("//*[@id='inpt_customform1']")).sendKeys("INTL Trade Sales Order"); 
        d.findElement(By.xpath("//*[@id='entity_display']")).sendKeys("");
        
        Thread.sleep(12000);
        
       
        
        d.findElement(By.xpath("//*[@id='entity_display']")).sendKeys("P07180 PALMERSTON NORTH CITY LIBRARY");
        Thread.sleep(12000);
            
        rb.keyPress(java.awt.event.KeyEvent.VK_DOWN);
        rb.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
        rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
               
        Thread.sleep(12000);
        System.out.println("Sales Order2");
        
        //Insert Item ISBN Code 
      
        Thread.sleep(12000);
            
       // wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='item_splits']/tbody/tr[2]/td[3]/div")))); 
       // d.findElement(By.xpath("//*[@id='item_splits']/tbody/tr[2]/td[3]/div")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@id='item_custcol_isbn_display']")))); 
        d.findElement(By.xpath("//input[@id='item_custcol_isbn_display']")).click();
        
        d.findElement(By.xpath("//input[@id='item_custcol_isbn_display']")).sendKeys("9781338047431");
        System.out.println("Scrolled");
        
        //Value for tax code alert opens
        
        //Click on save button
        Thread.sleep(10000);
        rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
        d.findElement(By.xpath("//*[@id='btn_secondarymultibutton_submitter']")).click();
 	      
        //Do u want to change shipping address?
        
        //Dismiss alert
        Thread.sleep(5000);
        d.switchTo().alert().dismiss();
        System.out.println("Shipping address prompt dismissed");
        System.out.println("SO is getting created");
        
    
        
        Thread.sleep(5000);
        d.switchTo().alert().accept();
       System.out.println("Leave site prompt occured");
       //get the SO created
       
        Declares.salesId = d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[1]")).getText();
        System.out.println(Declares.salesId);
        	   
       
	}

}
