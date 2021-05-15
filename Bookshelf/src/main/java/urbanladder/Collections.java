package urbanladder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Collections extends Bookshelves{
	
public ExtentReports report = ExtendReport.getReportInstance();
public ExtentTest logger;

	public void Clist() throws InterruptedException{
		
		driver.get("https://www.urbanladder.com/");
		
		//***** TO CLICK COLLLECTION ******//
		By collist = By.xpath("/html/body/div[1]/header/div[2]/div/nav/div/ul/li[10]/span");
		driver.findElement(collist).click();
		
	   
		//****** BEING AT HOME LIST *****//
		WebElement holist =driver.findElement(By.cssSelector(
				"#topnav_wrapper > ul > li.topnav_item.collectionsunit > div > div > ul > li:nth-child(1)>ul "));
		
		WebDriverWait w2 = new WebDriverWait(driver,30);
		w2.until(ExpectedConditions.elementToBeClickable(holist));
		sleep(1000);
		System.out.println(holist.getText());
		
		 report.flush();
		
	}
}