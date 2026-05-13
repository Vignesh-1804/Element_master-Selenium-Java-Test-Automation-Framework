package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FramePage;

public class FrameTest extends BaseTest {

    @Test
    public void verifyFrameText() {

        FramePage framePage =
                new FramePage(driver);

        framePage.openFramePage();

        framePage.switchToFrame();

        String text =
                framePage.getFrameText();

        Assert.assertEquals(
                text,
                "This is a sample page"
        );

        framePage.switchBack();
    }
    @Test
    public void verifyMainPageAccessible() {

        FramePage framePage =
                new FramePage(driver);

        framePage.openFramePage();

        framePage.switchToFrame();

        framePage.switchBack();

        Assert.assertTrue(
                framePage.isMainPageDisplayed()
        );
    }
}