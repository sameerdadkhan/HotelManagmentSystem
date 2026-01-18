# Hotel Reservation & Management Simulation (CCP)

## Project Overview
This repository contains the source code for the **Complex Computing Problem (CCP)** assignment. The project creates a **Java-based simulation engine** designed to manage the core operations of a hotel network, specifically focusing on the **Reservation** and **Check-In** lifecycles.

The system is built using **Object-Oriented Design (OOD)** principles, utilizing the **Controller Pattern** to manage interactions between the Hotel Chain, Rooms, and Guests.

## Key Functionalities
The system implements the following logic:
* **Chain Management:** Ability to manage multiple hotel branches (e.g., "Grand Royal Hotels").
* **Inventory Control:** Tracking of different room categories (Standard, Executive Suite) and their real-time availability.
* **Reservation Logic:** Validates dates and inventory before generating unique reservation IDs.
* **State Management:** Automatically transitions rooms from `FREE` to `RESERVED` or `OCCUPIED`.

## Technology Stack
* **Primary Language:** Java (JDK 17 or higher)
* **Testing Framework:** JUnit 5
* **Development Environment:** Eclipse IDE
* **Version Control:** Git

## Project Structure
The codebase is organized into two main packages:
* `src/com/hotel/system` - Contains the core business entities (`Hotel`, `Room`, `Guest`, `Reservation`).
* `src/com/hotel/test` - Contains the JUnit test suite for validation.

## How to Run the Simulation
1.  **Clone** this repository to your local machine.
2.  Open **Eclipse IDE** and select `Import > Existing Projects into Workspace`.
3.  Navigate to `src/com/hotel/system/Main.java`.
4.  Right-click the file and select **Run As > Java Application**.
5.  View the transaction logs in the **Console** output.

## Testing
Unit tests cover all critical paths including:
* Successful reservation creation.
* Boundary testing for date ranges.
* Exception handling for unavailable inventory.

To run tests, right-click `HotelChainTest.java` and select **Run As > JUnit Test**.
