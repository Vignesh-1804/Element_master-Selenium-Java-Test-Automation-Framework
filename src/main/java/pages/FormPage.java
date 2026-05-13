package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
public class FormPage extends BasePage {
    public FormPage(WebDriver driver) {
        super(driver);
    }
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By maleRadio = By.xpath("//label[text()='Male']");
    By mobile = By.id("userNumber");
    By submit = By.id("submit");
    By hobby = By.xpath("//label[text()='Sports']");
    By successModal = By.id("example-modal-sizes-title-lg");
    public void openFormPage() {
        driver.get(ConfigReader.getProperty("form.url"));
    }
    public void fillForm() {
        driver.findElement(firstName).sendKeys("Tharunis");
        driver.findElement(lastName).sendKeys("TK");
        driver.findElement(email).sendKeys("test@gmail.com");
        driver.findElement(maleRadio).click();
        driver.findElement(mobile).sendKeys("9876543210");
    }
    public void submitForm() {
        WebElement submitButton = driver.findElement(submit);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        js.executeScript("arguments[0].click();", submitButton);
    }
    public boolean isSubmissionSuccess() {
        return driver.findElement(successModal).isDisplayed();
    }
    public void selectMaleRadio() {
        driver.findElement(maleRadio).click();
    }
    public boolean isMaleSelected() {
        return driver.findElement(By.id("gender-radio-1")).isSelected();
    }
    public void selectHobby() {
        driver.findElement(hobby).click();
    }
    public boolean isHobbySelected() {
        return driver.findElement(By.id("hobbies-checkbox-1")).isSelected();
    }
    public boolean isValidationErrorDisplayed() {
        WebElement form = driver.findElement(By.id("userForm"));
        String className = form.getAttribute("class");
        return className.contains("was-validated");
    }
}