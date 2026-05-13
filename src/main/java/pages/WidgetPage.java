package pages;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigReader;
public class WidgetPage extends BasePage {
    public WidgetPage(WebDriver driver) {
        super(driver);
    }
    By widgets = By.xpath("//h5[text()='Widgets']");
    By slider = By.xpath("//input[@type='range']");
    By dateInput = By.id("datePickerMonthYearInput");
    public void openSliderPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement widgetMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(widgets));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", widgetMenu);
        js.executeScript("arguments[0].click();", widgetMenu);
        WebElement sliderMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Slider']")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", sliderMenu);
        js.executeScript("arguments[0].click();", sliderMenu);
    }
    public void moveSlider() {
        WebElement slide = driver.findElement(slider);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slide, 50, 0).perform();
    }
    public void openDatePicker() {
        driver.get(ConfigReader.getProperty("widget.url"));
    }
    public void selectDate() {
        driver.findElement(dateInput).click();
    }
    public void openAccordionPage() {
        driver.get(ConfigReader.getProperty("accordion.url"));
    }
    public void expandAccordion() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var footer=document.querySelector('footer');" + "if(footer){footer.style.display='none';}");
        js.executeScript("var ad=document.getElementById('fixedban');" + "if(ad){ad.style.display='none';}");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement accordion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion']/div[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", accordion);
        js.executeScript("arguments[0].click();", accordion);
    }
    public boolean isAccordionExpanded() {
        WebElement accordionBody = driver.findElement(By.xpath("//div[contains(@class,'collapse show')]"));
        return accordionBody.isDisplayed();
    }
}