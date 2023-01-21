# Assignment for the role of QA Engineer at India Today Group 
## Selenium-Java Automation Framework
### Build on <i>Maven build management tool</i> and integrated with <i>TestNG</i>

# Dependencies Used:
1. Selenium WebDriver    - 4.6.0    -- For automating Browser UI scenarios
2. TestNG                - 7.4.0    -- The Test Runner to execute Suite
3. Maven Surefire Plugin - 3.0.0    -- To Run as Maven Test
4. Cucumber              - 7.10.1   -- To Run tests in BDD fashion
5. Common.io             - 2.11.0   -- To include common utils like FileCopy to move captures screenshots to reports

# Design Patterns Used:
1. Factory Design Pattern:
    * For driver initialization based on different browser name as input, Factory Design pattern is used

2. Page Object Model and Page Factory 
    * Web Pages designed based POM & Page Factory


# Some of the Best Coding Practices followed:
1. Appropriate Naming Conventions
2. Usage of proper Intendation
3. Usage of DRY (Don't Repeat Yourself) Principle 
4. Avoiding longer lines of code in each file
6. Proper exception handling
7. Provide comments for each step


# How to design your new test ?
* Step 1 : Use the main source(src/main) for your framework design and test source(src/test) for project specific configuration and tests
* Step 2 : Use base/WebDriverImpl class to add Project specific reusable methods
* Step 3 : Use base/WebDriverBase and base/HelperBase interfaces to implemenent abstract menthods in WebDriverImpl
* Step 4 : Use reporter/ScreenShotListener implementing ITestListener to capture screenshots on failure.
* Step 5 : Use testExecutionEngine/ExecutionEngine for defining and configuring before/after methods
* Step 6 : Use utils/CommonUtils class to configure Framework specific generic methods
* Step 7 : Use src/test/pageObjects/ to have locators specific to each page available in pages/
* Step 8 : Use src/test/pages to configure page specific methods
* Step 9 : Use src/test/testcases/ to define sequence of testSteps and perform assertions
* Step 10: Use src/test/resources/config.properties for configuring dynamic parameters like LangaugeToToggle, ThemeToSelect
* Step 11: For reports, after a run is completed, navigate to testNG reports


# Ways to Run Test:
* Approach 1 : Use Run Suite Option from testng.xml
* Approach 2 : Use Run As/TestNG Suite
* Approach 3 : Use "Run All" option available in testcases/ValidateSportsTakTest.java
* Approach 4 : Using command line, Navigate to project directory(./SportsTak) and execute "mvn clean test"

# Where to find your Test Run reports
* target/surefire-reports

# Scope for Enhancements:
### Jenkins can be integrated if infrasturcture is available with above mvn command 
### Retry of failure tests by adding RetryLogic by implementing IRetryAnalyzer Listener



