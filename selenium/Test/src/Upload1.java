import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;


public class Upload1 {
    
    public static void main(String []args) throws IOException, InterruptedException, AWTException {
    	
            System.setProperty("webdriver.chrome.driver", "/home/vacation/ChromeDriver/chromedriver_linux64/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriver driver = new ChromeDriver(chromeOptions);
            
            //Add the staging link below:
            String link="http://master.hetzner.vacationlabs.com/";
            //Add the path to images folder below : 
            String path="/home/vacation/Dropbox/Redchilli/[imagecyborg.com]/";
            
            //Sign-in
            driver.get(link+"signin");
            driver.findElement(By .id("user_email")).sendKeys("info@redchilliadventure.com");
            driver.findElement(By .id("user_password")).sendKeys("born2rule21*");
            driver.findElement(By .name("commit")).click();
            driver.manage().window().maximize();
          
            //Logo upload
            driver.get(link+"admin/website#/general");
            Thread.sleep(3000);
            driver.findElement(By .linkText("Change Logo Image")).click();
            
            browsImage(path+"[www.redchilliadventure.com][892]Red_Chilli_Logo_v4.png"); 
         
            
            //Banner slides -Home page ---incomplete
            
        /*    driver.get(link+"admin/website#/pages/23161/banner/12180");
        	Thread.sleep(5000);
        	
        	driver.findElement(By .linkText("Change banner Image")).click();
        	Thread.sleep(5000);
            //driver.findElement(By .className("single_file_upload_input")).sendKeys(path+"Home banner/1[www.redchilliadventure.com][783]Explore_with_experts.JPG");
            driver.findElement(By.xpath("//span[contains(text(),'Upload from your system')]")).click();
            browsImage(path+"Home banner/1[www.redchilliadventure.com][783]Explore_with_experts.JPG");
      	  Thread.sleep(5000); 
           
            Thread.sleep(5000);
            //driver.findElement(By .className("btn")).click();
            */
            
            //collection image upload
            //Add the collection ids here and place the images in "<path>/Collections" folder . Image names should be collection_id.jpg
            
            int[] collections = new int[]{ 2028,1992,1976,1997,1996,2063}; 
            
            for (int j = 0; j < collections.length; j++)
            {
            	System.out.println("Element at index " + j + " : "+ collections[j]);
                  
            	driver.get(link+"admin/trips#/collections/"+collections[j]+"/edit");
            	Thread.sleep(5000);
            	// driver.findElement(By .linkText("Change Collection Image")).click();
            	Thread.sleep(5000);
            	System.out.println(driver.findElement(By .className("single_file_upload_input")).isDisplayed());
                driver.findElement(By .className("single_file_upload_input")).sendKeys(path+"Collections/"+collections[j]+".jpg");
                Thread.sleep(5000);
            }

          
           
            //Trip image upload
            
            //Add the trip ids here and place the images in "<path>/Trips" folder . Image names should be trip_id.jpg
            int[] trips = new int[]{14034,14037,14048,14049,14093,14213,14224,14255,14696,15732,52890 }; 
            
            for (int i = 0; i < trips.length; i++)
            {
            	  System.out.println("Element at index " + i +  " : "+ trips[i]);
           
            	  driver.get("http://master.hetzner.vacationlabs.com/admin/trips#/short_tours/"+(trips[i])+"/edit/basic_content");
            	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
            	  Thread.sleep(5000);

            	  // driver.findElement(By.xpath("//span[contains(text(),'Add Images')]")).click();
            	  Thread.sleep(5000);

            	  driver.findElement(By .className("multiple_image_upload_input")).sendKeys(path+"Trips/"+(trips[i])+".jpg");
            	  Thread.sleep(5000);
           }
           
           
           //driver.quit();

    }







public static void browsImage (String path) throws AWTException {
	StringSelection imgpath = new StringSelection(path);
    
    // Copy to clipboard
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgpath,null);
  
    System.out.println("selection" +imgpath);
  
    //sendKeys("[www.redchilliadventure.com][54]Red_Chilli_Logo_v4.png");
   // Thread.sleep(1000);
    Robot robot = new Robot();
   // Thread.sleep(1000);
    
    // Press Enter
   robot.keyPress(KeyEvent.VK_ENTER);

    // Release Enter
   robot.keyRelease(KeyEvent.VK_ENTER);

    // Press CTRL+V
    robot.keyPress(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_V);

    // Release CTRL+V
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
   // Thread.sleep(1000);
   
    //Press Enter 
   robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
	
}
}