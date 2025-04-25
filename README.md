# Pizza Order App (Java)

This project is a **Pizza Order Application** implemented in Java with a touch of CSS for styling. It provides a user-friendly interface for managing pizza orders, including selecting pizza types, sizes, toppings, and managing the order summary.

## Features
- **Pizza Customization**: Select from various pizza types, sizes, and toppings.
- **Order Summary**: Displays a detailed summary of the order, including price calculations.
- **Interactive UI**: A simple, intuitive user interface for easy navigation.
- **Lightweight Design**: Built for efficiency and performance.

## Tech Stack
- **Java**: Core logic and application functionality (98.7% of the codebase).
- **CSS**: Styling for the user interface (1.3% of the codebase).

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or above.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Lanamahd/Pizza_order_App_Java.git
   cd Pizza_order_App_Java

2. Compile the Java files:
   ```bash
    javac -d bin src/*.java

3. Run the application:
   ```bash
    java -cp bin Main

## File Structure
/
├── src/                     # Java source code files
│   ├── Main.java            # Entry point of the application
│   ├── Order.java           # Handles order details and logic
│   ├── Pizza.java           # Defines pizza types, sizes, and toppings
│   └── UI.java              # User interface logic
├── assets/                  # CSS files for styling
│   └── styles.css           # Styles for the UI
├── README.md                # Project documentation
└── LICENSE                  # License for the project

## Usage
1. Launch the application by running Main.java.
2. Follow the on-screen instructions to:
- Customize your pizza order.
- Add or remove items from your order.
- View the final order summary with pricing.
