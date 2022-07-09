package Instagram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng {
    WebDriver driver;  
    @BeforeTest
    public void SetUp() {
    System.setProperty("webdriver.edge.driver","C:\\Users\\HCLTSS\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
      WebDriver driver=new EdgeDriver();
      driver.get("https://www.instagram.com");    		  
    }

    @Test 
    public void Test() {
        Registration A = new Registration();
        A.Login();
        Follow B = new Follow();
        B.FollowAcc();
        LikePost C = new LikePost();
        C.Like();
        Comment D = new Comment();
        D.CommentPost();
    }
        
    @AfterTest
    public void close() {
    	driver.close();
    }
     
}