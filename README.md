# ModernUIX 🚀

Modern Android UI Components Library with sleek animations and material design. Built purely with Java and AndroidX.

[![GitHub License](https://img.shields.io/github/license/your-username/ModernUIX)](https://opensource.org/licenses/MIT)
[![GitHub Release](https://img.shields.io/github/v/release/your-username/ModernUIX)](https://github.com/your-username/ModernUIX/releases)
[![Android API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://android-arsenal.com/api?level=21)

## Features ✨

- 🎨 Modern UI Components with smooth animations
- 📱 Optimized for both phones and tablets
- 🌈 Customizable themes and attributes
- ⚡ No external dependencies
- 🛠️ Built with Java & AndroidX

## Components 📦

| Component | Description |
|-----------|-------------|
| `ModernButton` | Gradient buttons with ripple effect |
| `ModernRadioGroup` | Animated radio group with moving selector |
| `ModernSwitch` | iOS-style switch with smooth transition |
| `ModernPopup` | Bottom sheet dialog with blur effect |

## Installation 📥

Add to your `build.gradle`:

```groovy
repositories {
    maven {
        url "https://maven.pkg.github.com/ModernUIX/ModernUIX"
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
            password = project.findProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation 'com.github.modernuix:modernuix:1.0.0'
}
