# AppiumAutoTest - Android Mobile Testing Framework

A comprehensive Java-based automated testing framework for Android applications using Appium and Selenium WebDriver. This project enables end-to-end testing of mobile applications on Android devices and emulators with a robust testing infrastructure.

## Overview

AppiumAutoTest provides a reusable testing framework built on top of Appium and TestNG for automating Android application testing. The framework includes base test setup, device configuration, and example test cases for mobile application automation.

## Features

- **Appium Integration**: Full integration with Appium Java Client for Android automation
- **Selenium WebDriver**: Leverages Selenium for advanced element location and interaction strategies
- **TestNG Framework**: Uses TestNG for test execution and reporting
- **Base Test Classes**: Pre-configured base classes for quick test setup
- **Device Configuration**: Easy device and emulator configuration
- **Flexible Element Location**: Support for multiple locator strategies (XPath, ID, Accessibility ID, CSS, etc.)

## Technologies

- **Java 21**: Modern Java version with latest language features
- **Appium 10.1.1**: Mobile automation framework
- **Selenium 4.45.0**: Web automation and advanced element interactions
- **TestNG 7.11.0**: Testing framework for test execution and reporting
- **Maven**: Build and dependency management

## Prerequisites

- Java 21 or higher installed
- Node.js and npm (for Appium installation)
- Android SDK and emulator or physical Android device
- Maven for building and running tests
- Appium server running locally

## Project Structure

```
src/
├── main/java/org/example/
│   └── Main.java          # Entry point application
└── test/java/appiumTests/
    ├── BaseTest.java      # Base test class with Appium configuration
    └── WifiTests.java     # Example test cases for WiFi settings
```

## Getting Started

1. **Install Dependencies**:
   ```
   mvn clean install
   ```

2. **Configure Device**:
   - Update device name and APK path in `BaseTest.java`
   - Ensure Android emulator is running or device is connected

3. **Run Tests**:
   ```
   mvn test
   ```

## Configuration

Edit `BaseTest.java` to configure:
- Android emulator device name
- APK file path
- Appium server host and port
- Desired capabilities

## Example Test

The `WifiTests` class demonstrates:
- Element location using multiple strategies
- Explicit waits for element visibility
- User interactions (click, getAttribute)
- Test assertions

## License

This project is provided as-is for mobile testing automation purposes.