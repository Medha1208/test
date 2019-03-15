package Education_LOB.Education_LOB;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintSO {

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
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

	    //Sales_order no.

	    d.findElement(By.xpath("//input[@id='_searchstring']")).sendKeys("SO-296411"); 
	    Robot rb=new Robot();
	    rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	    System.out.println("Sales order searched");
	    
	    //click on view link
	    d.findElement(By.xpath("//*[@id='row0']/td[1]/a[2]")).click();
	    Thread.sleep(10000);

        // Store and Print the name of the First window on the console
        String handle= d.getWindowHandle();
        System.out.println(handle);
        
        //click on print image
      //*[@id='tdbody_menu_print']/div/img
	    d.findElement(By.xpath("//*[@id='ext-gen34']")).click();
	    
	    // Store and Print the name of all the windows open	              	    
        Set handles = d.getWindowHandles();
        System.out.println(handles);

        // Pass a window handle to the other window
        for (String handle1 : d.getWindowHandles()) {
         System.out.println(handle1);
         d.switchTo().window(handle1);
         }

        // Closing Pop Up window
        d.close();
	    	    
	}

}
