# Bookstore Application

A JavaFX-based desktop application for managing a bookstore with separate interfaces for owners and customers. This application supports book management, customer management, and a points-based loyalty system.

![Bookstore Application](images/login-screen.png)

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Features

### Owner Features
- **Book Management**: Add, view, and delete books from the inventory
- **Customer Management**: Add and delete customer accounts
- **Data Persistence**: All data is saved to text files (`books.txt` and `customers.txt`)

### Customer Features
- **Browse Books**: View available books with prices
- **Purchase Books**: Buy books with standard payment
- **Points System**: Earn and redeem loyalty points
  - Earn 10 points per $1 CAD spent
  - Redeem 100 points for $1 CAD discount
- **Status Tiers**: 
  - Silver: Less than 1000 points
  - Gold: 1000+ points

![Owner Dashboard](images/owner-dashboard.png)

## Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher (tested with JDK 21)
  - Download from: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)
- **JavaFX SDK**: Version 21.0.2 or compatible
  - Download from: [OpenJFX](https://openjfx.io/)
  - Extract to a location on your system
- **Operating System**: Windows, Linux, or macOS

## Installation

1. **Clone or download the repository**
   ```bash
   git clone <repository-url>
   cd COE528-BookStore-Application
   ```

2. **Install JDK**
   - Download and install JDK 11 or higher
   - Verify installation:
     ```bash
     java -version
     javac -version
     ```

3. **Download and Extract JavaFX SDK**
   - Download JavaFX SDK 21.0.2 from [OpenJFX](https://openjfx.io/)
   - Extract the SDK to your project directory
   - Rename the extracted folder to `javafx-sdk-21.0.2`
   - The structure should be: `COE528-BookStore-Application/javafx-sdk-21.0.2/lib/`

## Usage

### Running the Application

#### Using the Run Script:
```bash
./run.sh
```

Or on Windows:
```cmd
run.bat
```

#### Manual Compilation and Execution:
```bash
# Compile
javac --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -d . *.java

# Run
java --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml bookstoreapp.BookstoreApp
```

### Default Login Credentials

**Owner Account:**
- Username: `admin`
- Password: `admin`

**Customer Accounts:**
- No default customer accounts exist initially
- Create customer accounts through the owner interface

### Application Flow

1. **Login Screen**: Enter credentials to access the application
   ![Login Screen](images/loginUI.png)

2. **Owner Interface**: 
   - Navigate to Books or Customers management
   - Add/delete books and customers
   ![Owner Books Screen](images/AppUI.png)
   ![Owner Customers Screen](images/CustomerView.png)

3. **Customer Interface**:
   - Browse available books
   - Select books to purchase
   - Choose to buy with or without points redemption
   ![Customer Screen](images/ShelfView.png)

## Project Structure

```
COE528-BookStore-Application/
├── images/                    # Screenshots and images
│   ├── login-screen.png
│   ├── owner-dashboard.png
│   └── ...
├── javafx-sdk-21.0.2/        # JavaFX SDK (download and extract here)
├── Book.java                  # Book entity class
├── BookStore.java             # Application state manager
├── BookstoreApp.java          # Main application class
├── Customer.java              # Customer entity class
├── Owner.java                 # Owner entity class
├── LoginScreen.java           # Login interface
├── OwnerStartScreen.java      # Owner main menu
├── OwnerBooksScreen.java      # Book management screen
├── OwnerCustomersScreen.java  # Customer management screen
├── CustomerStartScreen.java   # Customer main screen
├── CustomerCostScreen.java    # Purchase confirmation screen
├── FileManager.java           # File I/O operations
├── books.txt                  # Book data storage
├── customers.txt              # Customer data storage
└── run.sh                     # Run script (or run.bat for Windows)
```

**Note**: The `bookstoreapp/` folder contains compiled `.class` files that are automatically generated when you compile the source code. These files are not included in the repository and will be created during compilation.

## Screenshots

### Login Screen
![Login Screen](images/login-screen.png)
The initial login interface where users authenticate.

### Owner Dashboard
![Owner Dashboard](images/owner-dashboard.png)
Main menu for owners to access book and customer management.

### Book Management
![Book Management](images/owner-books.png)
Interface for adding and managing books in the inventory.

### Customer Management
![Customer Management](images/owner-customers.png)
Interface for managing customer accounts.

### Customer Shopping Interface
![Customer Screen](images/customer-screen.png)
Customer view for browsing and purchasing books.

## Data Persistence

The application stores data in plain text files:
- `books.txt`: Contains book inventory (format: `BookName Price`)
- `customers.txt`: Contains customer accounts (format: `Username Password Points`)

Data is automatically saved when:
- Books are added or deleted
- Customers are added or deleted
- Customers make purchases

## Technical Details

- **Language**: Java
- **Framework**: JavaFX 21.0.2
- **Architecture**: MVC-like pattern with separate screen classes
- **Data Storage**: Plain text files
- **Package**: `bookstoreapp`

## Troubleshooting

### Application won't start
- Ensure JavaFX SDK is downloaded and extracted to `javafx-sdk-21.0.2/` directory
- Verify Java version is 11 or higher: `java -version`
- Check that all `.java` files are in the root directory
- Make sure the JavaFX SDK path in the run script matches your installation

### Blank window appears
- Recompile the application
- Check for runtime errors in the terminal
- Ensure JavaFX modules are properly loaded

### ClassNotFoundException
- Make sure you're running from the project root directory
- Compile the application first (the `bookstoreapp/` folder will be created automatically)
- Check that the package structure is correct

## Contributing

This is a course project (COE528). For contributions or improvements:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is part of a course assignment. Please refer to your course guidelines for usage and distribution policies.

## Contact

For questions or issues, please refer to the course instructor or create an issue in the repository.

---

**Note**: This application was developed as part of COE528 coursework. Users must download and install JavaFX SDK separately as it is not included in this repository.


