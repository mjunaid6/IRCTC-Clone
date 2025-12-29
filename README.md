# 🚂 IRCTC-Clone: Java Railway Booking Backend Simulation

<div align="center">

**A high-performance Java-based backend simulation of the Indian Railway Catering and Tourism Corporation (IRCTC) system.**

</div>

## 📖 Overview

This project is a pure **Java Backend Application** designed to simulate the server-side architecture of a massive railway reservation system. It focuses on solving complex engineering challenges like **concurrency control** for seat allocation, **data integrity** for PNR generation, and **efficient search algorithms** for train routing.

## ✨ Core Backend Features

* **Train Search Engine:** Optimized lookups for trains between stations with support for intermediate halts.
* **Seat Inventory Management:** Real-time tracking of seat availability across multiple classes (1A, 2A, 3A, SL).
* **Concurrency Handling:** Synchronized booking logic to prevent race conditions during peak ticket booking simulations.
* **PNR Lifecycle:** Generation of unique 10-digit Passenger Name Records (PNR) and automated status updates (CNF/RAC/WL).
* **Fare Calculation Module:** Dynamic pricing engine based on distance, quota (General/Tatkal), and passenger age/gender.
* **User Security:** Backend logic for encrypted password storage and session-based authentication.



## 🛠️ Tech Stack

**Core Logic:**
* <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java"> (JDK 11+)

**Build & Management:**
* <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt="Gradle"> (or Maven)

**Data Persistence:**
* In-memory Collections (HashMaps/Lists) or integration with **JDBC** for SQL-based storage.

## 🚀 Getting Started

### Prerequisites
* **Java Development Kit (JDK)**: Version 11 or higher.
* **Build Tool**: Gradle (included via wrapper).

### Installation & Execution

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/mjunaid6/IRCTC-Clone.git](https://github.com/mjunaid6/IRCTC-Clone.git)
    cd IRCTC-Clone
    ```

2.  **Build the project**
    ```bash
    ./gradlew build
    ```

3.  **Run the Main Simulation**
    ```bash
    ./gradlew run
    ```

## 📁 Project Structure

```text
IRCTC-Clone/
├── src/
│   ├── main/
│   │   ├── java/com/irctc/clone/
│   │   │   ├── model/        # Entities: Train, Ticket, User, Station
│   │   │   ├── service/      # Logic: BookingService, SearchService, PNRGenerator
│   │   │   ├── repository/   # Data Layer: Mock Database or File Handler
│   │   │   ├── exception/    # Custom Exceptions (e.g., SeatNotAvailableException)
│   │   │   └── Main.java     # System Entry Point
│   │   └── resources/        # Mock data (train_schedule.csv, config.properties)
│   └── test/                 # Unit Tests for Booking and Search logic
├── build.gradle              # Project dependencies
└── settings.gradle           # Module settings

```
## ⚙️ Logic Architecture
The system follows a modular N-Tier architecture:

Discovery: SearchService executes a filtering algorithm over the TrainRepository.

Transaction: BookingService manages a synchronized block to verify seat availability and decrement inventory.

Generation: PNRService creates a unique record and maps the Ticket object to the user's profile.

<div align="center">

⭐ Star this repo if you find it helpful!

Made with ❤️ by mjunaid6

</div>
