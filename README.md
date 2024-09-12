**Demoblaze Automation Project**
This is an automated testing project for the Demoblaze e-commerce website. The project is built using Java, Selenium WebDriver, Maven, and TestNG. It is designed to automate functional and UI test cases for various features of the website, ensuring smooth user interactions and proper functionality.

## Technologies Used

- **Java**: For scripting the test cases.
- **Selenium WebDriver**: For automating browser interactions.
- **Maven**: For dependency management and project build.
- **TestNG**: For organizing and executing test cases.



**Project Setup and Execution Guide**
This project is structured within the following folder hierarchy:
Selenium/
└── src/
    └── test/
        └── java/
            └── TestAutomationProject/
                └── HomePage.java

**Prerequisites**
Before running the project, ensure you have the following installed on your machine:

1.**Java Development Kit (JDK)** – Make sure JDK 8 or above is installed.
2.**Maven** – Used to build and manage dependencies.
3.**Selenium WebDriver** – Integrated into the project.
4.**TestNG** – Test framework for running the tests.

**Test Cases**:
The following test cases have been automated to ensure the core functionalities of the website work as expected:

1.**Test Filtering by Phones**
Verifies that the user can filter products by the "Phones" category and view the correct items.

2.**Verify Upper Menu Buttons**
Ensures that the buttons in the top navigation menu (Home, Contact, About Us, etc.) work correctly and lead to the appropriate sections.

3.**Test Contact-Us Menu**
Automates the validation of the "Contact Us" form, ensuring that users can submit inquiries.

4.**Test Empty Field Validation**
Checks that the form fields on various pages (e.g., login, contact, order) display appropriate error messages when submitted with empty fields.

5.**Test Invalid Field Validation**
Verifies that invalid data in form fields triggers the correct validation messages.

6.**Test Add to Cart**
Ensures that products can be added to the shopping cart and that the cart accurately reflects the selected items.

7.**Test Verify Order**
Automates the process of verifying that an order has been successfully placed and appears in the order history.

8.**Test Submit Order**
Simulates the order submission process and verifies that the order is processed correctly.
