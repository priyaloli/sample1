package urbanladder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.annotations.BeforeClass;
//import java.io.IOException;
import org.testng.annotations.Test;

public class Main extends Base {
	
	public static ExtentReports report= createExtentReport();

	
	public ExtentTest logger;
	@BeforeClass
	public static ExtentReports createExtentReport() {
		return ExtendReport.getReportInstance();
	}
	
	
	@Test(groups = "Smoke", priority = 1)
	public void book() throws Exception {
		
		logger=report.createTest("Bokshelves");
		Bookshelves b = new Bookshelves();
		b.sBookshelf();
		logger.pass("SUCCESSFULLY");


	}
	
	@Test(groups= "Smoke", priority = 2)
	 public void collection() throws Exception {
		
		logger=report.createTest("Collection submenu");
		logger.log(Status.PASS,"Done collections");

		Collections c= new Collections();
		c.Clist();
	}

	@Test(groups= "Regression" ,priority = 3)
	public void GiftCard() throws Exception {
		
		logger=report.createTest("GiftCards");
		logger.log(Status.PASS,"Done GiftCards");
		
		Giftcards g = new Giftcards();
		g.gift();
	}
	
	@Test(groups="Regression", priority=4)
	public void chair() throws Exception{
		
		logger=report.createTest("Study chairs");
		logger.log(Status.PASS,"Done Studychairs");
		
		Studychairs s= new Studychairs();
		s.studychair();
	}
	
	public void closeBrowser() {
        report.flush();
        driver.quit();
    }
	
}
