package userinterface;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class APItestcases {
	
	
	 public WebDriver driver;
	  
  @Test(priority=1)
  public void LaunhCraigssite() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\muthu\\Downloads\\chromedriver.exe");	
	  driver = new ChromeDriver();
	  String baseurl ="https://sfbay.craigslist.org/";
	  driver.manage().window().maximize();
	  driver.get(baseurl);
	 }
  @Test(priority=2)
  public void Search() {
	 
	   driver.findElement(By.xpath("//*[@id=\'query\']")).sendKeys("toyota" + Keys.ENTER);
	   driver.findElement(By.xpath("//*[@id='searchform']/div[3]/div[3]/span[2]/a[3]")).click();
	   int count = 0;
	   for(WebElement link : driver.findElements(By.tagName("a"))) {
		   System.out.println(link.getText());
		   count ++;
	   }
       System.out.println("Total Link"+ count);
       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }
   @Test(priority=3)
   public void Savesearch() {
	   driver.findElement(By.xpath("//*[@id=\'searchform\']/div[1]/div[2]/a")).click();
	   driver.findElement(By.xpath("//*[@id='inputEmailHandle']")).sendKeys("testingdonehere@gmail.com");
	   driver.findElement(By.xpath("//*[@id='inputPassword']")).sendKeys("ShoppingForGoods12");
	   driver.findElement(By.xpath("/html/body/section/section/div/div[1]/form/div[3]/button")).click();
	   //Alert alert = driver.switchTo().alert();
	   //alert.dismiss();
	   }
   
   @Test(priority=4)
   public void Verifysearch(){
	   String saveconfirm = driver.findElement(By.xpath("/html/body/article/section/fieldset/div/p")).getText();
	   if((saveconfirm).contains("Your \"toyota\" search has been saved.")) {
	   	   System.out.println(" Save search is successful");
	   	   
	   }
	   else {
	   	   System.out.println(" save search is not successful ");
	   	
	   }
	   driver.close();
	   	}
  
 
  
  
  
}
