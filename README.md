# Urban Ladder Automation Testing Project

This repository contains an automated test suite for [Urban Ladder](https://www.urbanladder.com), implemented using Selenium WebDriver with Java, following the Cucumber BDD approach with Gherkin syntax. The test framework includes support for Extent Reports and Cucumber Reports for detailed test reporting.

---

## Features Automated

✅ **Search Functionality**  
✅ **Filter Application (e.g., category, price range)**  
✅ **Add to Cart**  
✅ **Checkout Process**

---

## Tech Stack
<div style="display: flex; align-items: center;">
  <img alt="Java" src="https://img.shields.io/badge/Java-007396?logo=java&logoColor=white&style=flat" />
  <img alt="Maven" src="https://img.shields.io/badge/Maven-C71A36?logo=apache-maven&logoColor=white&style=flat" />
</div>

**Version Control and Testing tools used:**

<div style="display: flex; align-items: center;">
<img alt="GitHub" src="https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white&style=flat" />
<img src="https://img.shields.io/badge/Selenium-green?style=flat&logo=selenium&logoColor=white" alt="Selenium Badge">
<img src="https://img.shields.io/badge/IDE-IntelliJ-blue?style=flat&logo=intellijidea&logoColor=white" alt="IntelliJ IDEA Badge">
</div>

**Operating System and browsers used:**

<div style="display: flex; align-items: center;">
<img alt="Windows" src="https://img.shields.io/badge/Windows-00ADEF?logo=windows&logoColor=white&style=flat" />
<img alt="Chrome" src="https://img.shields.io/badge/Chrome-4285F4?logo=google-chrome&logoColor=white&style=flat" />
</div>

**FrameWork**

<div style="display: flex; align-items: center;">
<img src="https://img.shields.io/badge/Cucumber-green?logo=cucumber&logoColor=white&style=flat" alt="Cucumber Framework">
</div>

---

## Project Structure
```
Urban-Ladder
│── src
│── test
│   ├── java
│   │   ├── hooks
│   │   │   ├── CucumberHooks.java
│   │   ├── runner
│   │   │   ├── TestRunner.java
│   │   ├── stepsDefinitions
│   │   │   ├── Add_to_CartSteps.java
│   │   │   ├── homepageSteps.java
│   │   │   ├── SearchSteps.java
│   │   ├── utils
│   │   │   ├── ExtentReport.java
│── resources
│   ├── features
│   │   ├── addtocart.feature
│   │   ├── homepage.feature
│   │   ├── Search.feature
```

---

## Reports
**After test execution, reports are generated in the reports/ directory**:
- extentReport.html
- cucumber-report.html
  
**These reports include**:
- Scenario-wise status
- Step-level logs
- Screenshots on failure
- Execution time

---

## 🎯 Conclusion
The Urban Ladder automation testing project ensures a high-quality, seamless, and secure e-commerce experience for fitness enthusiasts. 

By combining  automation testing with Cucumber, we enhance the efficiency, maintainability, and reliability of our tests. 🚀

---

📌 **For any questions, feel free to reach out!**
satyajit1025@gmail.com
