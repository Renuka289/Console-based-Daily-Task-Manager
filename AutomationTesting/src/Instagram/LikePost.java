package Instagram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LikePost {

    
    private static WebElement picture;
    private static WebElement Like;

    public void Like() {
       
        WebDriver driver  = new EdgeDriver();
        driver.get("https://www.instagram.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("lavista2004");
        driver.findElement(By.name("password")).sendKeys("vqiJ<?JaXfY*9^m");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/section/div/button")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();

         picture  = driver.findElement(By.xpath(
        		 "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/main/section/div/div[2]/div[2]/div/article[1]/div/div[2]/div/div/div/div[3]"));
         picture.click();

         Like = driver.findElement(By.xpath(
        		 "/html/body/div[1]/div/div[1]/div/div[1]/div/div/div[1]/div[1]/section/main/section/div/div[2]/div[2]/div/article[1]/div/div[3]/div/div/section[1]/span[1]/button"));
         Like.click();

    }

}

