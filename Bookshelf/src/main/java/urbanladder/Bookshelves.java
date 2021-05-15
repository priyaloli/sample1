package urbanladder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bookshelves extends Base {
	
	 public ExtentReports report = ExtendReport.getReportInstance();
	    public ExtentTest logger;
    
	public void sBookshelf() throws IOException,InterruptedException
    {
    	 
    	 Properties prop=new Properties();
    	 FileInputStream readFile=null;
		try {                                                                                                    
    			readFile = new FileInputStream((System.getProperty("user.dir") + "\\InputData\\config.properties")); 
    			prop.load(readFile);                                                                                 
    			driver(prop.getProperty("Browser"));                                                          
    			geturl(prop.getProperty("url"));                                                                     
    		} catch (IOException io) {                                                                               
    			io.printStackTrace();                                                                                
    		} finally {                                                                                              
    			if (readFile != null) {                                                                              
    				try {                                                                                            
    					readFile.close();                                                                            
    				} catch (IOException e) {                                                                        
    					// TO DO Auto-generated catch block                                                          
    					e.printStackTrace();                                                                         
    				}                                                                                                
    			}                                                                                                    
    		}                                                                 //                                       
		timeout();
		maximize();
		sleep(10000);
		
		//****** TO CLOSE POPUP *******//
		
		WebElement close = driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div[1]/div/div[2]/a[1]"));
		click(close);
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(close));

		
		//****** TO SEARCH FOR BOOKSHELVES ********//
		
				
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Bookshelves");
		sleep(3000);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/header/div[1]/div/section[2]/div/form/div/button/span"))).click();
				   	
    	 
		//****TO CHECK PRICE RATE****//
    	
	    WebElement price = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[2]/div[1]"));
        Actions a1 = new Actions(driver);
        a1.moveToElement(price).build().perform();
        
        
        //************DRAG AND DROP ****************//
        
        WebElement drag = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
         Actions a2 = new Actions(driver);
         a2.dragAndDropBy(drag, -206, 0).build().perform();
         sleep(3000);
        
        
 		//****** SELECT STORAGE TYPE AS OPEN *****//
 		
         WebElement storagetype = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[3]/div[1]"));
         moveToElement(storagetype);
 		click(driver.findElement(By.xpath("//*[@id=\"filters_storage_type_Open\"]")));

 		
 		//******TO KNOW STOCK*****//
 		
 		By stock = By.xpath("//input[@id='filters_availability_In_Stock_Only']");
 		driver.findElement(stock).click();
 		sleep(3000);
 		
 	    //**** TO PRINT PRODUCT NAME AND PRICE ****//
 			
 		System.out.println("First 3 Bookshelves below Rs. 15000, with Storage type as open & exclude out of stock : ");       
 	    List<WebElement> pri1 = driver.findElements(By.xpath("//div[@class='price-number']/span"));
 		List<WebElement> pro1 = driver.findElements(By.xpath("//span[@class='name']"));
 			
 			String price1, name1;
 			
 			for (int i = 0; i < 3; i++)
 			{
 				name1 = pro1.get(i).getText();
 				System.out.println("Product Name : " + name1);
 				price1 = pri1.get(i).getText();
 				price1 = price1.replaceAll("₹", "Rs.");
 				System.out.println("Price : " + price1);
 				
 				
 				
 			}
   
 			
    }
	
}	
