package urbanladder;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;



public class Giftcards extends Collections {
	public ExtentReports report = ExtendReport.getReportInstance();
	public ExtentTest logger;

	
        public void gift() throws IOException, InterruptedException
        {
        	
            //********* TO CLICK GIFT CARD *******//
             By gt= By.xpath("/html/body/div[1]/header/section/div/ul[2]/li[3]/a");
             driver.findElement(gt).click();
             
             
             //*** TO CHOOSE BIRTHDAY GIFT ******//
             By birth = By.xpath("/html/body/div[1]/div/main/section/section[1]/ul/li[3]/div/h3");
             driver.findElement(birth).click();
             driver.findElement(By.xpath("//*[@id=\"ip_2251506436\"]")).sendKeys("5000");
             
             By next = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button");
             driver.findElement(next).click();
             
             
             
             //******** TO GIVE  RECEIPT NAME ********//
             driver.findElement(By.xpath("//*[@id=\"ip_4036288348\"]")).sendKeys(excel("Sheet1",1, 4));
             
             
             //******* TO GIVE RECEIPT E-MAIL ADDRESS *****//
             driver.findElement(By.xpath("//*[@id=\"ip_137656023\"]")).sendKeys(excel("Sheet1",1, 5));
             
             
             //******** TO GIVE OUR NAME **********//
             driver.findElement(By.xpath("//*[@id=\"ip_1082986083\"]")).sendKeys(excel("Sheet1",1, 1));
             
             
             //******** TO GIVE OUR E-MAIL ADDRESS *****//
             driver.findElement(By.xpath("//*[@id=\"ip_4081352456\"]")).sendKeys(excel("Sheet1",1, 2));
            

             //****** TO GIVE OUR PHONE NUMBER ****//
             driver.findElement(By.xpath("//*[@id=\"ip_2121573464\"]")).sendKeys(excel("Sheet1",1, 3));
             
             
             //********** TO SELECT CLICK ********//
             click(driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")));   
             sleep(2000);
             
           
             //***** TO DISPLAY ERROR MESSAGE*****//
             WebElement email = driver.findElement(By.xpath("//*[@id=\"ip_137656023\"]"));
            
     		String error = email.getAttribute("validationMessage");
     		System.out.println("Error Message:");
     		System.out.println(error);
     		
     		
     		//****** TO TAKE SCREEENSHOT OF ERROR MESSAGE******//
     		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		String screenshot = "Error Message";
    		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshot\\" + screenshot + ".png"));
           
            report.flush();

         }
        
}

  
