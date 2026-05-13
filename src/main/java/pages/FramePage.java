package pages;
import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }
    public void openFramePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement parentMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Alerts, Frame & Windows']")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", parentMenu);
        js.executeScript("arguments[0].click();", parentMenu);
        WebElement frameMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Frames']")));
        js.executeScript("arguments[0].click();", frameMenu);
    }
    public void switchToFrame() {
        driver.switchTo().frame("frame1");
    }
    public String getFrameText() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }
    public void switchBack() {
        driver.switchTo().defaultContent();
    }
    public boolean isMainPageDisplayed() {
        return driver.findElement(By.xpath("//h1")).isDisplayed();
    }
}