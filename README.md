# ElementMaster – Selenium Java Automation Framework

ElementMaster is a Selenium-Java Test Automation Framework developed using the Page Object Model (POM) design pattern and TestNG framework. The framework automates advanced UI element interactions for a Selenium practice web application.

This project is designed with reusable, scalable, and maintainable automation architecture following industry-standard automation practices.



# Features

- Selenium WebDriver automation
- Page Object Model (POM) architecture
- TestNG framework integration
- WebDriverManager support
- Explicit wait handling using WebDriverWait
- Screenshot capture on test failure
- ExtentReports HTML reporting
- Configurable browser execution
- Data-driven testing using DataProvider
- Reusable utility methods
- Maven project structure



# Tech Stack

 Technology  Usage 
 Java - Programming Language 
 Selenium WebDriver - Browser Automation 
 TestNG - Test Framework 
 Maven - Build Tool 
 WebDriverManager - Driver Management 
 ExtentReports - Test Reporting 
 IntelliJ IDEA - IDE 
 Git & GitHub - Version Control 



# Application Under Test

Demo Website Used:

https://demoqa.com/



# Automated Modules

## Forms Module
- Fill practice form
- Radio button validation
- Checkbox validation
- Empty field validation

## Web Tables Module
- Add new row
- Search records
- Delete records
- Verify pagination

## Alerts & Windows Module
- Handle simple alerts
- Handle confirm alerts
- Handle prompt alerts
- Switch between windows and tabs

## Frames Module
- Switch to iframe
- Handle nested frames
- Verify frame elements

## Widgets Module
- Date picker handling
- Slider interaction
- Accordion interaction

# Framework Components
BasePage
Contains reusable Selenium methods:

click()
sendKeys()
waitForElement()
selectDropdown()
switchToFrame()

# BaseTest
Handles:

Browser setup
Driver initialization
Browser teardown

# TestListener
Handles:

Screenshot capture
Report updates
Failure logging

# Configuration
config.properties

browser=chrome
base.url=https://demoqa.com
form.url=https://demoqa.com/automation-practice-form
table.url=https://demoqa.com/webtables
alert.url=https://demoqa.com/alerts
frame.url=https://demoqa.com/frames
widget.url=https://demoqa.com/date-picker
accordion.url=https://demoqa.com/accordian
timeout=10
headless=false

# Maven Dependencies
Selenium Java
TestNG
WebDriverManager
ExtentReports
Commons IO

# Running the Project
Using Maven
mvn test
Using TestNG

Run:

testng.xml

# Reports
After execution:

ExtentReports HTML report generated inside /reports
Failed screenshots stored inside /screenshots

# Best Practices Used
No hardcoded values
No Thread.sleep()
Explicit waits using WebDriverWait
Reusable page methods
Proper package separation
Clean and maintainable framework design

# Future Enhancements
Parallel execution
Excel/JSON data-driven testing
Jenkins CI/CD integration
Docker execution
Headless browser support
Selenium Grid integration