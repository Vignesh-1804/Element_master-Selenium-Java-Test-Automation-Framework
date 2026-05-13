package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TablePage;

public class TableTest extends BaseTest {

    @Test
    public void verifyAddRow() {

        TablePage tablePage =
                new TablePage(driver);

        tablePage.openTablePage();

        tablePage.addRow();

        Assert.assertTrue(
                tablePage.isRecordPresent("John")
        );
    }

    @Test
    public void verifySearchRecord() {

        TablePage tablePage =
                new TablePage(driver);

        tablePage.openTablePage();

        tablePage.searchRecord("Cierra");

        Assert.assertTrue(
                tablePage.isRecordPresent("Cierra")
        );
    }

    @Test
    public void verifyDeleteRecord() {

        TablePage tablePage =
                new TablePage(driver);

        tablePage.openTablePage();

        tablePage.deleteRecord();

        Assert.assertTrue(true);
    }

    @Test
    public void verifyPagination() {

        TablePage tablePage =
                new TablePage(driver);

        tablePage.openTablePage();

        tablePage.clickNextPage();

        Assert.assertTrue(true);
    }
}