# SauceDemo Automation Project

This is a QA automation project developed using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. The project follows the **Page Object Model** (POM) structure and tests various
user flows on the [SauceDemo](https://www.saucedemo.com/) e-commerce demo site.

---

## 🛠️ Technologies & Tools

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- IntelliJ IDEA
- ChromeDriver / Cross-browser support
- Git

---

## 📂 Project Structure

```
com.saucedemo/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── Driver/               # WebDriver management
│   │   │   ├── Locators/            # Page classes with locators
│   │   │   ├── Test/                # Test classes by feature
│   │   │   └── Utilities/           # BaseTest, ConfigReader, helpers
│   │   └── resources/               # Test data/config files
│
├── pom.xml                         # Maven dependencies
├── AllTestSuit.xml                # TestNG suite file
├── CrossBrowserSuit.xml          # For parallel cross-browser tests
└── .gitignore
```

---

## ✅ Test Scenarios Covered

- User Login and Logout
- Listing and Sorting Products
- Adding Products to Cart
- Checkout Flow
- Link Controls
- Cross-browser Testing (via XML suite)

---

## 📌 How to Run

1. Clone the repository
2. Run the tests with TestNG suite files (e.g., `AllTestSuit.xml`)
3. Use your terminal or IDE TestNG runner

```bash
mvn clean test
```

---

## 📊 Future Improvements

- ✅ **Cucumber Integration** for BDD-style testing
- 🔄 **Reporting System** (e.g., ExtentReports or Allure)
- ⏱️ CI/CD Integration (e.g., GitHub Actions, Jenkins)

---

## 👨‍💻 Author

Kadirhan Sarıyılmaz - QA Engineer  
[LinkedIn](https://www.linkedin.com/in/kadirhansariyilmaz/) | [GitHub](https://github.com/kadirhanS)