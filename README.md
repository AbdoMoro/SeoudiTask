# PrestaShop Automation Framework

A Selenium-Java framework to automate the End-to-End shopping flow on [demo.prestashop.com](https://demo.prestashop.com/).

## 📋 Overview
* **Scenario:** User Registration → Search Product → Verify Image → Add to Cart → Verify Cart.
* **Tech Stack:** Java, Selenium WebDriver, TestNG, Maven.

## ⚡ Key Features
* **Page Object Model (POM):** Clean separation of test logic and page locators.
* **Fluent Interface:** Method chaining for readable tests.
* **Robustness:** Uses Explicit Waits, JS actions, and centralized iFrame handling.
* **Dynamic Data:** auto-generates unique emails using UUIDs to prevent test failures.
