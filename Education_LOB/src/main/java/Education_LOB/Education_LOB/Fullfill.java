package Education_LOB.Education_LOB;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Fullfill {	
	
	public static void validation() throws InterruptedException, AWTException{
	
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
    wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='ns-header-menu-userrole-item4']/a/span[1]"))));
    act.moveToElement(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item4']/a/span[1]"))).perform();
    act.click(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item4']/a/span[1]"))).perform();
    System.out.println("Warehouse Manager role selected");
   
    //search for created sales order
    d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys(Sales.salesId);
    
    Robot rb=new Robot();
  
    rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
    System.out.println("SO selected");
 
    d.findElement(By.xpath("//*[@id='row0']/td[1]/a[1]")).click();
    System.out.println("edit button clicked");
    d.findElement(By.xpath("//*[@id='process']")).click();
    System.out.println("Fullfil button clicked");
    Thread.sleep(10000);
    d.findElement(By.xpath("//*[@id='btn_multibutton_submitter']")).click();
    System.out.println("Item fullf;ilment created");
    Thread.sleep(12000);
    
    Sales.fullfillId = d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[1]")).getText();
    System.out.println(Sales.fullfillId);
    
    //Status of fullfillment: SHIPPED
    
    String x = d.findElement(By.xpath("//*[@id='main_form']/table/tbody/tr[1]/td/div[1]/div[4]/div[3]")).getText();
    System.out.println("Fullfillment status is" +x);
    
    //click on logout
    //d.findElement(By.xpath("//*[@id='spn_cRR_d1']/a/div[1]"));		       
   // Thread.sleep(12000); 
   // act.moveToElement(wb).perform();
   // wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='ns-header-menu-userrole-item0']/a/span[1]"))));
    
   // act.click(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item0']/a/span[1]"))).perform();
   // System.out.println("logout successfully");
    
    
   
    
}}

