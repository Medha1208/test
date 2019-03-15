package Trade_SO;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Education_LOB.Education_LOB.Sales;

@Test
public class ReturnReceived {

	public static void receivedReturn() throws InterruptedException, AWTException{
	
//	public static void main(String[] args) throws InterruptedException, AWTException {
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
	       
	        System.out.println("INTL Customer Services role selected");
	       
	      d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys(Sales.invoiceId); 
	      // d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys("INV-14552983"); 
	        Robot rb=new Robot();
	      
	        rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	        rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	        System.out.println("Invoice selected");
	       
	        //click on 'view' button
	       d.findElement(By.xpath("//*[@id='row0']/td[1]/a[2]")).click();
	       Thread.sleep(5000);
	      
	       //click on 'authorize return' button
	       d.findElement(By.xpath("//*[@id='return']")).click();
	       Thread.sleep(10000);
	       System.out.println("'authorize return' button selected");
	       
	       // save button
	       d.findElement(By.xpath("//*[@id='btn_secondarymultibutton_submitter']")).click();
	      
	       //capture RET no:
	       
	       Sales.returnReceivedId = d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[1]")).getText();
	        System.out.println(Sales.returnReceivedId);

	}

}
