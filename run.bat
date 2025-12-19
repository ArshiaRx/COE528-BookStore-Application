@echo off
REM Compile the application (outputs to current directory respecting package structure)
javac --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -d . *.java

REM Run the application
java --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml bookstoreapp.BookstoreApp

