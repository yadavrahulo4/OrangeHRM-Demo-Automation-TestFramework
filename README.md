# OrangeHRM Web Automation Test Framework

![Java](https://img.shields.io/badge/Java-17-brightgreen)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-blue)
![TestNG](https://img.shields.io/badge/TestNG-Framework-orange)
![ExtentReports](https://img.shields.io/badge/Reports-Extent-green)

Welcome to the **OrangeHRM Web Automation Test Framework**, a comprehensive test automation suite designed for reliable, robust, and scalable testing of the OrangeHRM demo application. Built with Java, Selenium WebDriver, TestNG, and Extent Reports, this framework provides all you need for seamless automated testing.

## 🌟 Features
- **Page Object Model (POM)** design for modular and maintainable test scripts.
- **Parallel Execution** capabilities via TestNG XML configurations.
- **Customizable TestNG Listeners** for test management and logging.
- **Detailed Reporting** with Extent Reports, including screenshots for test failures.
- **Cross-Browser Support** with configurations for Chrome, Firefox, and Edge.

## 🛠️ Tools & Technologies
- **Java 17**
- **Selenium WebDriver**
- **TestNG Framework**
- **Extent Reports**
- **Maven** (for dependency management)

## ⚙️ Setup & Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yadavrahulo4/OrangeHRM-Demo-Automation-TestFramework.git
   ```
2. **Import the Project**:
   - Open your IDE (e.g., IntelliJ, Eclipse) and import the project as a Maven project.

3. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

4. **Configure Browser and Environment**:
   - Update `config.properties` to set up the desired browser, environment, and other settings.

## 🚀 Running Tests
### Via TestNG XML
To run all tests specified in the `testng.xml` configuration file:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Individual Test Classes
To execute a single test class:
```bash
mvn test -Dtest=ClassName
```

## 📊 Reports
Upon execution, **Extent Reports** will generate a detailed HTML report showing:
- Test pass/fail status
- Execution time
- Logs and screenshots (for failed tests)

Reports are located in the `test-output/ExtentReports` folder.

## 📂 Project Structure
- `src/main/java` - Core framework components and page classes.
- `src/test/java` - Test classes organized by feature.
- `src/test/resources` - Configuration files and test data.
- `test-output` - Generated test reports and logs.

## 📌 Important Considerations
- Ensure the WebDriver binaries are up-to-date and compatible with your browser versions.
- Customize the `config.properties` file for additional settings like base URLs, credentials, and reporting paths.

## 🤝 Contribution
Contributions, issues, and feature requests are welcome! Please feel free to submit a pull request or create an issue for any bugs or enhancements.


This template should provide a clear and professional overview of your framework! Feel free to adapt it with project-specific details as needed.
