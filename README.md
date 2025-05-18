# 🔧 Cross-Platform BDD Framework with Git Integration

This project is a **Java BDD Cucumber framework** that automates web and Git operations using:

- ✅ Selenium / Appium (multi-platform support)
- ✅ Git command-line operations
- ✅ Allure + Cucumber HTML Reporting
- ✅ TestNG runner
- ✅ Maven for build and execution

---

## 📁 Project Folder Structure

![Screenshot 2025-05-19 021058](https://github.com/user-attachments/assets/8f7a61e0-db6b-4a1a-85b7-d884d40ef32a)

📝 Sample Git Feature
![Screenshot 2025-05-19 021546](https://github.com/user-attachments/assets/cd9bb63a-1534-48cc-94cb-d3faddf1f2b1)

🧰 Git Automation Scenarios
Git operations like clone, update file, commit, push are done via GitCommand.java.
File editing and pushing logic is implemented in:
gitSteps.java
GitCommand.java

## ▶️ How to Run via Maven
### 💻 Run all tests:
```bash
mvn clean test
```
### 🧪 Run only Git scenarios:
```bash
mvn clean test -Dcucumber.filter.tags="@git" -DrunGit=true
```
📊 Reporting
✅ Allure Report:
Results are saved to: target/allure-results/
# Generate Allure report
mvn allure:report

# Serve Allure report locally
mvn allure:serve

✅ Cucumber HTML Report:
Automatically generated at:
target/cucumber-reports/Cucumber.html
![Screenshot 2025-05-19 021904](https://github.com/user-attachments/assets/44c7ff3a-38cc-4d08-b668-c6871277b9de)

📦 Future Enhancements
Externalize Git repo & file path configs
Add Jenkins CI integration
Use SSH keys or encrypted tokens for secure Git operations

👤 Maintainer
AkashQA0303
GitHub Repo: https://github.com/AkashQA0303/CloudBees.git



