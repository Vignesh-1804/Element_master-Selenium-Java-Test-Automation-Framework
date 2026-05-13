package pages;
import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }
    By alertsFrameWindows = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    By alerts = By.xpath("//span[text()='Alerts']");
    By simpleAlert = By.id("alertButton");
    By confirmAlert = By.id("confirmButton");
    By promptAlert = By.id("promtButton");
    By confirmResult = By.id("confirmResult");
    By promptResult = By.id("promptResult");
    By browserWindows = By.xpath("//span[text()='Browser Windows']");
    By newTab = By.id("tabButton");
    public void openAlertPage() {
        driver.get(ConfigReader.getProperty("alert.url"));
    }
    public void clickSimpleAlert() {
        driver.findElement(simpleAlert).click();
    }
    public void clickConfirmAlert() {
        driver.findElement(confirmAlert).click();
    }
    public void clickPromptAlert() {
        driver.findElement(promptAlert).click();
    }
    public void acceptAlert() {
        switchToAlert().accept();
    }
    public void dismissAlert() {
        switchToAlert().dismiss();
    }
    public void enterPromptText(String text) {
        switchToAlert().sendKeys(text);
        switchToAlert().accept();
    }
    public void openBrowserWindows() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement parentMenu = driver.findElement(alertsFrameWindows);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", parentMenu);
        js.executeScript("arguments[0].click();", parentMenu);
        WebElement browserWindowMenu = driver.findElement(browserWindows);
        js.executeScript("arguments[0].click();", browserWindowMenu);
    }
    public void openNewTab() {
        driver.findElement(newTab).click();
    }
    public void switchToNewTab() {
        for(String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }
    public String getConfirmResultText() {
        return driver.findElement(confirmResult).getText();
    }
    public String getPromptResultText() {
        return driver.findElement(promptResult).getText();
    }
    public String getNewTabText() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }
    }
