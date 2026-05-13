package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void verifySimpleAlert() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openAlertPage();

        alertPage.clickSimpleAlert();

        alertPage.acceptAlert();

        Assert.assertTrue(true);
    }

    @Test
    public void verifyConfirmAlert() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openAlertPage();

        alertPage.clickConfirmAlert();

        alertPage.dismissAlert();

        Assert.assertTrue(
                alertPage.getConfirmResultText()
                        .contains("Cancel")
        );
    }

    @Test
    public void verifyPromptAlert() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openAlertPage();

        alertPage.clickPromptAlert();

        alertPage.enterPromptText("Hello");

        Assert.assertTrue(
                alertPage.getPromptResultText()
                        .contains("Hello")
        );
    }
    @Test
    public void verifyNewTab() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openBrowserWindows();

        alertPage.openNewTab();

        alertPage.switchToNewTab();

        Assert.assertTrue(
                alertPage.getNewTabText()
                        .contains("This is a sample page")
        );
    }
}