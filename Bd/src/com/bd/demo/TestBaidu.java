package com.bd.demo;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBaidu {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://www.baidu.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testcase() throws Exception {
		driver.get(baseUrl+"/");
		driver.findElement(By.id("kw")).sendKeys("testng");
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		assertEquals(title,"testng_°Ù¶ÈËÑË÷");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

