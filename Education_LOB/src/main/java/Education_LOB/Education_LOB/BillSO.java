package Education_LOB.Education_LOB;

import java.awt.AWTException;
import java.awt.Robot;

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

@Test
public class BillSO {

	//public static void main(String[] args() throws InterruptedException, AWTException {
		
	 public static void invoice() throws InterruptedException, AWTException{
		   
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
	    
	    //Change Role
	    
	    WebElement wb= d.findElement(By.xpath("//*[@id='spn_cRR_d1']/a/div[1]"));		       
	  
	    Actions act = new Actions(d);
	    act.moveToElement(wb).perform();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='ns-header-menu-userrole-item6']/a/span[1]"))));
	    act.moveToElement(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item6']/a/span[1]"))).perform();
	    act.click(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item6']/a/span[1]"))).perform();
	    System.out.println(" INTL Accountant role selected");
	   
	    //Sales_order no.

	    d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys(Sales.salesId); 
	   // d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys("SO-296517"); 
	    Robot rb=new Robot();
	    rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	    System.out.println("Sales order searched");
	    
	    //click on view link
	    d.findElement(By.xpath("//*[@id='row0']/td[1]/a[2]")).click();
	    Thread.sleep(10000);
	    
	    // Sales_order status = Billed
	    
	   String x  =  d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[3]")).getText();
	   System.out.println(x);
	   
	 
	   //clicked on related records
	   d.findElement(By.xpath("//*[@id='rlrcdstabtxt']")).click();
	   System.out.println("Related records clicked");
	    Thread.sleep(10000);
	    
	    // capture invoice no:
	    
	    Sales.invoiceId  =  d.findElement(By.xpath("(//td [contains(text(), 'Invoice')]/following-sibling::td[1])[1]")).getText();
	    System.out.println(Sales.invoiceId);
	    
	    
	    
	/*   Sales.billId = d.findElement(By.xpath("//*[@id='linksrow0']/td[3]")).getText();
	   System.out.println(Sales.billId); */
	   
      //invoice link: //*[@id='linksrow1']/td[3]  	   
	 // Sales.invoiceId = d.findElement(By.xpath("//*[@id='linksrow1']/td[3]")).getText();
	 // System.out.println(Sales.invoiceId);
	 // Thread.sleep(10000);
	  
	 }
}
