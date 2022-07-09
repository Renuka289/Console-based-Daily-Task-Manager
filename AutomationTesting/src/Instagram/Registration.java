package Instagram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Registration {

    public void Login() {

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
        
        
    } 
}

