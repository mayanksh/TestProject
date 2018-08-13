package Newdemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","/Users/mayank/Downloads/gecko/geckodriver");
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();   //maximize the browser
		driver.get("http://www.ksrtc.in/oprs-web/");    //to open the URL
		Thread.sleep(2000);  //for adding a wait
		driver.findElement(By.name("searchBtn")).click();   //click is use to click
		Alert alert= driver.switchTo().alert(); //switch to is used to switch to a particular alert 
		// alert method returns the alert type thats why we store the reference of alert type
		Thread.sleep(4000);
		alert.accept();  //accept method will click on the Ok button
		//different popups
		//1. alert.accept()
		//2. alert.sendkeys("wfrefw324") if popup want u to enter a any text
		//3. alert.dismiss() in case u have 2 options like OK n CANCEL, to click cancel we use the dismiss
		//4. alert.gettext() to return the value of string to verify or validate a test case. 
		driver.findElement(By.name("fromPlaceName")).sendKeys("chalakudi");
		Thread.sleep(2000);
		driver.quit();  //quit is to close browser
		

	}

}
