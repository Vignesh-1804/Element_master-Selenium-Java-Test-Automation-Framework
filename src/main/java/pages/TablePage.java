package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
public class TablePage extends BasePage {
    public TablePage(WebDriver driver) {
        super(driver);
    }
    By addButton = By.id("addNewRecordButton");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");
    By searchBox = By.id("searchBox");
    By deleteButton = By.id("delete-record-1");
    By nextButton = By.xpath("//button[text()='Next']");
    public void openTablePage() {
        driver.get(ConfigReader.getProperty("table.url"));
    }
    public void addRow() {
        driver.findElement(addButton).click();
        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(email).sendKeys("john@gmail.com");
        driver.findElement(age).sendKeys("25");
        driver.findElement(salary).sendKeys("50000");
        driver.findElement(department).sendKeys("QA");
        driver.findElement(submit).click();
    }
    public boolean isRecordPresent(String text) {
        return driver.getPageSource().contains(text);
    }
    public void searchRecord(String name) {
        driver.findElement(searchBox).sendKeys(name);
    }
    public void deleteRecord() {
        driver.findElement(deleteButton).click();
    }
    public void clickNextPage() {
        WebElement nextBtn = driver.findElement(nextButton);
        if(nextBtn.isEnabled()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", nextBtn);
            js.executeScript("arguments[0].click();", nextBtn);
        }
    }
}