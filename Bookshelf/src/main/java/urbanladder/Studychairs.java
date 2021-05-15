package urbanladder;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Studychairs extends Giftcards {

	public void studychair() throws InterruptedException {

		// To select the study
		driver.navigate().to("https://www.urbanladder.com/");

		// To search the 'Study Chairs'
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Study Chairs");
		sleep(1000);
		click(driver.findElement(By.xpath("//span[@class='search-icon icofont-search']")));
		sleep(2000);

		// To click 'Recommended'
		WebElement high = driver
				.findElement(By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span"));
		moveToElement(high);

		// To click the 'Price: High to Low'
		click(driver.findElement(
				By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]")));
		System.out.println("First 3 study chair details with highest recommendation : ");
		sleep(2000);

		// To print product name and price
		List<WebElement> priceno1 = driver.findElements(By.xpath("//div[@class='price-number']/span"));
		List<WebElement> productname1 = driver.findElements(By.xpath("//span[@class='name']"));
		String price1, name1;
		for (int i = 0; i < 3; i++) {
			name1 = productname1.get(i).getText();
			System.out.println("Product Name : " + name1);
			price1 = priceno1.get(i).getText();
			price1 = price1.replaceAll("₹", "Rs.");
			System.out.println("Price : " + price1);
		}
		quit();
	}
}
