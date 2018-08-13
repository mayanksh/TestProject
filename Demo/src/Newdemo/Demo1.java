package Newdemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Demo1 {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","/Users/mayank/Downloads/gecko/geckodriver");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=us&.lang=en-US&.done=https%3A%2F%2Fwww.yahoo.com");
		driver.findElement(By.id("createacc")).click();
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("max");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("max");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("9255978349");
		Thread.sleep(1000);
		String MainWindow = driver.getWindowHandle();  //handleindow b4 opening new window AND string has parent window now
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[2]/ul/li/a/b")).click();
		
		//to handle all new opened window
		
		Set<String> s1=driver.getWindowHandles();  //Set(bcz no duplication) here has now both parent & child 
		Iterator<String> i1= s1.iterator();       //iterator is to go back n forth b/w parent and child window
		
		while(i1.hasNext()) {                    //has next is to goto next node
			String childWindow= i1.next();      
			
			if(!MainWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//		driver.findElement(By.xpath("/html/body/main/nav/ul/li[6]/a")).click();
				//
				
				try {
					Thread.sleep(10000); 
				}
				
				catch (InterruptedException e) {
					e.printStackTrace();
				
				}
				Actions a1 = new Actions(driver);   //mousehover action
				a1.moveToElement(driver.findElement(By.xpath("/html/body/header/div/div[1]/div[2]/div[3]/table/tbody/tr/td[3]/ul/li[1]/a/b"))).build().perform();
				
				try {
					Thread.sleep(3000L);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				driver.close();
				
			
				}
		
		}
	}
}
	