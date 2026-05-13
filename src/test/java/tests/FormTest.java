package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
public class FormTest extends BaseTest {
    @Test
    public void verifyFormSubmission() {
        FormPage formPage = new FormPage(driver);
        formPage.openFormPage();
        formPage.fillForm();
        formPage.submitForm();
        Assert.assertTrue(formPage.isSubmissionSuccess());
    }
    @Test
    public void verifyRadioButtonSelection() {
        FormPage formPage = new FormPage(driver);
        formPage.openFormPage();
        formPage.selectMaleRadio();
        Assert.assertTrue(formPage.isMaleSelected());
    }
    @Test
    public void verifyCheckboxSelection() {
        FormPage formPage = new FormPage(driver);
        formPage.openFormPage();
        formPage.selectHobby();
        Assert.assertTrue(formPage.isHobbySelected()
        );
    }
    @Test
    public void verifyMandatoryFieldValidation() {
        FormPage formPage = new FormPage(driver);
        formPage.openFormPage();
        formPage.submitForm();
        Assert.assertTrue(formPage.isValidationErrorDisplayed());
    }
}