package userinterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UITestcases {
	
	public WebDriver driver;
	
	
  @Test(priority=1)
  public void LoginAccount() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\muthu\\Downloads\\chromedriver.exe");	
	    driver = new ChromeDriver();
	   String baseurl ="https://sfbay.craigslist.org/";
	   driver.manage().window().maximize();
		driver.get(baseurl);
		driver.findElement(By.xpath("//*[@id='postlks']/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='inputEmailHandle']")).sendKeys("testingdonehere@gmail.com");
		driver.findElement(By.xpath("//*[@id='inputPassword']")).sendKeys("ShoppingForGoods12");
		driver.findElement(By.xpath("/html/body/section/section/div/div[1]/form/div[3]/button")).click();
		
	  }
  
  @Test(priority=2)
  public void Search() {
	  driver.findElement(By.xpath("/html/body/article/header/div/span[3]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\'savedsearchlist\']/tbody/tr/td[6]/a/button")).click();
	  driver.findElement(By.xpath("/html/body/article/section/fieldset/form/table/tbody/tr[4]/td/input")).clear();
      driver.findElement(By.xpath("/html/body/article/section/fieldset/form/table/tbody/tr[4]/td/input")).sendKeys("toyota prius");
	  driver.findElement(By.xpath("/html/body/article/section/fieldset/form/table/tbody/tr[7]/td[2]/button")).click();

  }
  @Test(priority=3)
  public void VerifyNameChange() {
	  String itemname = driver.findElement(By.xpath("//*[@id='savedsearchlist']/tbody/tr/td[3]")).getText();
		if( (itemname).equalsIgnoreCase("toyota prius")) {
			System.out.println("Item name has been changed");
			}
		else{
			System.out.println("Item name is not been changed");
		}
}
  
  @Test(priority=4)
  public void VerifyDeletion() {
	  driver.findElement(By.xpath("//*[@id=\'savedsearchlist\']/tbody/tr/td[6]/form/button")).click();
		
		String confirmmessage= driver.findElement(By.xpath("/html/body/article/section/fieldset/div/p")).getText();
	   if(confirmmessage.equals("\"toyota prius\" was deleted.")) {
		   System.out.println("Deletion is successful");
		   
	   }
	   else {
		   System.out.println("Deletion is not successful ");
	   }
	   driver.close();
  }
}
