package com.pmdc;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
	public void test_login_with_incorrect_credetials() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to("http://103.139.122.250/");
		driver.findElement(By.name("email")).sendKeys("qasim@malik.com");
		driver.findElement(By.name("password")).sendKeys("abcdefg");
		driver.findElement(By.id("m_login_signin_submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String errorText = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/form/div[1]")).getText();
		assertTrue(errorText.contains("Incorrect email or password"));
		driver.quit();
	}

}
