# SANTE-PRICE INDEX

SANTE-PRICE INDEX is an Android application built using Kotlin and Jetpack Compose for tracking mandi/market prices of fruits and vegetables in real time.  
The app is designed for vendors, small shop owners, and local traders to monitor prices, calculate profits, and display selling boards easily.

The application uses Firebase Realtime Database for live data storage and retrieval, along with offline caching support for uninterrupted access.

---

# Features

## Live Market Price Tracking
- View latest mandi prices
- Monitor modal, minimum, and maximum prices
- Track multiple commodities at once
- Real-time Firebase integration

## Offline Support
- Firebase offline persistence enabled
- DataStore caching support
- Previously loaded prices available without internet

## Trends & Analytics
- 7-day commodity trend tracking
- Interactive trend graph
- Historical price comparison

## Profit Calculator
- Selling price estimation
- Waste/spoilage calculation
- Transport cost inclusion
- Profit margin calculation
- Break-even analysis

## Digital Shop Board
- Create editable product boards
- Present mode for customer display
- Add/remove/reorder products

## Modern UI
- Jetpack Compose UI
- Dark industrial theme
- Responsive layouts
- Smooth animations

---

# Tech Stack

- Kotlin
- Jetpack Compose
- Firebase Realtime Database
- Android DataStore
- MVVM Architecture
- Coroutines
- Material 3

---

# Project Structure

```text
app/
 ├── MainActivity.kt
 ├── SantePriceApp.kt
 ├── ViewModels.kt
 ├── PriceRepository.kt
 ├── DataStore.kt
 ├── MyApp.kt
```

---

# Firebase Database Structure

```json
{
  "mandi_prices": {
    "Onion": {
      "day1": {
        "arrivalDate": "2026-05-08",
        "commodity": "Onion",
        "market": "Bangalore",
        "maxPrice": 20,
        "minPrice": 15,
        "modalPrice": 18,
        "state": "Karnataka"
      }
    }
  }
}
```

---

# Setup Instructions

## 1. Clone Repository

```bash
git clone https://github.com/jasonsamueldas/sante-price-index.git
```

---

## 2. Open in Android Studio

Open the project folder using Android Studio.

---

## 3. Connect Firebase

### Create Firebase Project
Go to:

https://console.firebase.google.com

### Add Android App

Use package name:

```text
com.example.santepricev2
```

### Download Configuration File

Download:

```text
google-services.json
```

Place it inside:

```text
app/google-services.json
```

---

## 4. Enable Firebase Realtime Database

In Firebase Console:

- Build
- Realtime Database
- Create Database
- Start in test mode

---

## 5. Add Sample Data

Upload mandi price data in the following structure:

```text
mandi_prices
 └── Tomato
      └── day1
      └── day2
      └── day3
```

---

## 6. Run the App

Connect an Android device or emulator and run:

```bash
Run > Run App
```

---

# Firebase Offline Persistence

Offline support is enabled using:

```kotlin
FirebaseDatabase.getInstance().setPersistenceEnabled(true)
```

This allows:
- cached data access
- offline trends
- persistent watchlist support

---

# Security Rules

Recommended Firebase Realtime Database rules:

```json
{
  "rules": {
    ".read": true,
    ".write": false
  }
}
```

This allows public read access while preventing external modifications.

---

# Screens

- Watch Screen
- Calculator Screen
- Shop Board
- Trends Screen
- Learn Screen

---

# Future Improvements

- Admin dashboard
- Auto-updating mandi data
- Multi-language support
- User authentication
- Push notifications
- Export reports
- Cloud Functions integration

---

# Author

Developed as an Android + Firebase based market price tracking system using Kotlin and Jetpack Compose.

---

# License

This project is open-source and available under the MIT License.
