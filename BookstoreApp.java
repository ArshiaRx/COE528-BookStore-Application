package bookstoreapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static bookstoreapp.BookStore.*;

/**
 * Main Application class for Bookstore App
 */
public class BookstoreApp extends Application {
    private Stage primaryStage;
    private LoginScreen loginScreen;
    private OwnerStartScreen ownerStartScreen;
    private CustomerStartScreen customerStartScreen;
    private OwnerBooksScreen ownerBooksScreen;
    private OwnerCustomersScreen ownerCustomersScreen;
    private CustomerCostScreen customerCostScreen;
    
    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        primaryStage.setTitle("Bookstore Application");
        
        // Initialize screens
        loginScreen = new LoginScreen();
        ownerStartScreen = new OwnerStartScreen();
        customerStartScreen = new CustomerStartScreen();
        ownerBooksScreen = new OwnerBooksScreen();
        ownerCustomersScreen = new OwnerCustomersScreen();
        customerCostScreen = new CustomerCostScreen();
        
        // Start with login screen
        showLoginScreen();
        
        primaryStage.show();
    }
    
    public void showLoginScreen() {
        LoginScreen login = new LoginScreen();
        Group loginGroup = login.display(getOwner(), getCustomers(), this);
        Scene scene = new Scene(loginGroup, 600, 400);
        primaryStage.setScene(scene);
    }
    
    public void showOwnerStartScreen() {
        Group ownerGroup = ownerStartScreen.display(this);
        Scene scene = new Scene(ownerGroup, 600, 400);
        primaryStage.setScene(scene);
    }
    
    public void showCustomerStartScreen(Customer customer) {
        ObservableList<Book> booksList = FXCollections.observableArrayList(getBooks());
        primaryStage.setUserData(this); // Store app reference for button handlers
        Group customerGroup = customerStartScreen.display(primaryStage, customer, booksList);
        Scene scene = new Scene(customerGroup, 800, 600);
        primaryStage.setScene(scene);
    }
    
    public void showOwnerBooksScreen() {
        Group booksGroup = ownerBooksScreen.display(primaryStage, this);
        Scene scene = new Scene(booksGroup, 700, 700);
        primaryStage.setScene(scene);
    }
    
    public void showOwnerCustomersScreen() {
        primaryStage.setUserData(this); // Store app reference for button handlers
        Group customersGroup = ownerCustomersScreen.display(primaryStage);
        Scene scene = new Scene(customersGroup, 800, 600);
        primaryStage.setScene(scene);
    }
    
    public void showCustomerCostScreen(Customer customer, double cost, boolean redeem) {
        primaryStage.setUserData(this); // Store app reference for button handlers
        Group costGroup = customerCostScreen.display(primaryStage, customer, cost, redeem);
        Scene scene = new Scene(costGroup, 600, 400);
        primaryStage.setScene(scene);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

