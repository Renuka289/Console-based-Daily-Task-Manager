package Instagram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Follow {
    public static WebElement searchbox2;
    private static WebElement searchbox1;
    private static WebElement follow;
    public void FollowAcc() {
       
        WebDriver driver  = new EdgeDriver();
        driver.get("https://www.instagram.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("lavista2004");
        driver.findElement(By.name("password")).sendKeys("vqiJ<?JaXfY*9^m");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
 
        driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();

        searchbox1 = driver.findElement(By.xpath("//span[text()='Search']"));
        searchbox1.click();

        searchbox2= driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchbox2.sendKeys("#technology");
  
        searchbox2 = driver.findElement(By.xpath(
        		"/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/a"));
        searchbox2.sendKeys(Keys.ENTER);

        follow= driver.findElement(By.xpath("//button[text()='Follow']"));
        follow.click();
        
    }

}

