package Education_LOB.Education_LOB;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {

	//public static void main(String[] args) throws InterruptedException {
	
	 public static void logout() throws InterruptedException, AWTException{
		 
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	    
	    WebDriver d = new ChromeDriver();  
	    WebDriverWait wait = new WebDriverWait(d,20);
	    d.get("https://system.netsuite.com/pages/customerlogin.jsp");
	    d.manage().window().maximize();
	    d.findElement(By.id("userName")).sendKeys("MDublish-consultant@Scholastic.com");
	    d.findElement(By.id("password")).sendKeys("welcome@121M");
	    d.findElement(By.id("submitButton")).click();

	    d.findElement(By.xpath("//input[@type= 'password']")).sendKeys("gulan");
	    d.findElement(By.xpath("//input[@type= 'submit']")).click();
	    Thread.sleep(10000);
	    
	    //Logout
	    
	    WebElement wb= d.findElement(By.xpath("//*[@id='spn_cRR_d1']/a/div[1]"));		       
	  
	    Actions act = new Actions(d);
	    act.moveToElement(wb).perform();
	    wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='ns-header-menu-userrole-item0']/a/span[1]"))));
	    act.moveToElement(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item0']/a/span[1]"))).perform();
	    act.click(d.findElement(By.xpath("//*[@id='ns-header-menu-userrole-item0']/a/span[1]"))).perform();
	    System.out.println("logout successfully");

	}

}
