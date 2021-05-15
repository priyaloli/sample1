package urbanladder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import java.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Base 
{
    
	protected static WebDriver driver;
    static String pPath= System.getProperty("user.dir");
    
    public static WebDriver driver(String browser)
    {
    	if(browser.equalsIgnoreCase("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "\\driver\\chromedriver.exe"));
    		driver = new ChromeDriver();
    	} else if(browser.equalsIgnoreCase("firefox")){
    		System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir") + "\\driver\\geckodriver.exe"));
    		driver = new FirefoxDriver();
    	}
        return driver;
    
    }
      
    public void geturl(String url)
    {
    	driver.get(url);
    }
    public void maximize()
    {
        driver.manage().window().maximize();
    }
    public void timeout() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
    public void click(WebElement element) {
		element.click();
	}
    public void sKeys(String xpath, String string) {
		driver.findElement(By.xpath(xpath)).sendKeys(string);
	}
    public void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
    }

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();

	}
      public String excel(String sheetName, int row, int cell) throws IOException {
		File loc = new File(System.getProperty("user.dir") + "\\InputData\\InputData.xlsx");
		FileInputStream f = new FileInputStream(loc);
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet s = wb.getSheet(sheetName);

		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(cell);
		DataFormatter formatter = new DataFormatter();

		String value = formatter.formatCellValue(c);
		wb.close();
		return value;
	}
}
