package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.WidgetPage;

public class WidgetTest extends BaseTest {

    @Test
    public void verifySlider() {

        WidgetPage widgetPage =
                new WidgetPage(driver);

        widgetPage.openSliderPage();

        widgetPage.moveSlider();

        Assert.assertTrue(true);
    }
    @Test
    public void verifyDatePicker() {

        WidgetPage widgetPage =
                new WidgetPage(driver);

        widgetPage.openDatePicker();

        widgetPage.selectDate();

        Assert.assertTrue(true);
    }

    @Test
    public void verifyAccordion() {

        WidgetPage widgetPage =
                new WidgetPage(driver);

        widgetPage.openAccordionPage();

        System.out.println(
                driver.getCurrentUrl()
        );

        widgetPage.expandAccordion();

        Assert.assertTrue(
                widgetPage.isAccordionExpanded()
        );
    }
}