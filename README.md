# AwesomeLoginCleanArquitecture

![Log in App - Jetpack Compose](https://github.com/ahuamana/Yaku-Lab-Official/assets/60039961/a771fe1f-2a4d-4175-8b43-ffda687f6b61)


## Introduction

This app is developed using Jetpack Compose, Clean Architecture, and MVVM design pattern. The app includes a login screen and a subsequent screen that displays a list of resources. The services for login and data retrieval are simulated using the "https://reqres.in/" API.

## Requirements

To run the app, you need the following:

- Android device or emulator running Android OS (version 8.0 or above)
- Android Studio Flamingo | 2022.2.1 Patch
- Java version SDK 17
- Internet connection to communicate with the API

## Architecture

The app follows the Clean Architecture principles, which promotes separation of concerns and modularization of components. It consists of the following layers:

1. **Presentation Layer**: This layer contains the user interface components developed using Jetpack Compose. It interacts with the ViewModel layer to display data and handle user actions.

2. **ViewModel Layer**: This layer implements the MVVM (Model-View-ViewModel) design pattern. It communicates with the Use Case layer to retrieve data and update the UI. It also handles user actions and triggers appropriate actions in the Use Case layer.

3. **Use Case Layer**: This layer contains the business logic of the app. It interacts with the Data Layer to retrieve and process data. It provides the necessary data to the ViewModel layer for display.

4. **Data Layer**: This layer communicates with external data sources, such as APIs or databases. It retrieves and processes data, and provides it to the Use Case layer.

5. **Architecture Framework Layer**: This layer provides the architectural framework and structure for the app. It includes the base classes and interfaces that define the core architectural components, such as base ViewModel, base Use Case, and base Repository.

## Technologies Used

- Android Jetpack Compose
- Kotlin

## Getting Started

To run the app locally, follow these steps:

1. Clone the repository: `git clone <repository-url>`
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Project Structure

The project structure follows a modular approach, with the following modules:

- **app**: Contains the main app module, including the UI and app entry point.
- **presentation**: Contains the UI components implemented using Jetpack Compose.
- **domain**: Contains the business logic and use case implementations.
- **data**: Contains the data layer implementations, including API communication.

## Code Organization

The code is organized based on feature modules, following the Clean Architecture principles. Each feature module includes the necessary components for that specific feature, such as UI, ViewModel, and Use Case.

## Clean Architecture Layers

1. **Presentation Layer**: Contains the UI components implemented using Jetpack Compose. It interacts with the ViewModel layer and displays data to the user.

2. **ViewModel Layer**: Implements the MVVM design pattern. It communicates with the Use Case layer and provides data to the UI. It also handles user actions and triggers appropriate actions in the Use Case layer.

3. **Use Case Layer**: Contains the business logic of the app. It interacts with the Data Layer and provides the necessary data to the ViewModel layer. It follows the Clean Architecture principles and separates the business logic from the UI and Data Layer.

4. **Data Layer**: Communicates with external data sources, such as APIs or databases. It retrieves and processes data, and provides it to the Use Case layer.

5. **Architecture Framework Layer**: Provides the architectural framework and structure for the app. It includes the base classes and interfaces that define the core architectural components.

## MVVM

The app follows the MVVM (Model-View-ViewModel) design pattern. The ViewModel layer acts as an intermediary between the UI and the Use Case layer. It retrieves data from the Use Case layer and provides it to the UI for display. It also handles user actions and triggers appropriate actions in the Use Case layer.

## API Integration

The app integrates with the "https://reqres.in/" API to simulate login and data retrieval. The API provides endpoints for user authentication and retrieving a list of resources. The data is fetched asynchronously and displayed in the app.

## Code Documentation

The code is thoroughly documented with comments to improve code readability and understanding. Each class, function, and important code block is documented to provide context and explain its purpose.

## Conclusion

The "AwesomeLoginCleanArquitecture" app demonstrates the implementation of Clean Architecture and MVVM design pattern using Jetpack Compose. It showcases the separation of concerns and modularity, making the codebase more maintainable and testable. The use of appropriate technologies and best practices ensures clean and efficient code.
