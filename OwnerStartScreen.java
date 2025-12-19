package bookstoreapp;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class OwnerStartScreen {

    public Group display(BookstoreApp app){
        
        Group screen = new Group();
        VBox vbox = new VBox(10);
        
        Button buttonBooks = new Button("Books");
        buttonBooks.setMaxSize(100, 200);
        Button buttonCustomers = new Button("Customers");
        buttonCustomers.setMaxSize(100, 200);
        Button buttonLogout = new Button("Log Out");
        buttonLogout.setMaxSize(100, 200);
        //button sizing and initalization
        
        buttonBooks.setOnAction(e ->{
            app.showOwnerBooksScreen();
        });
        
        buttonCustomers.setOnAction(e ->{
            app.showOwnerCustomersScreen();
        });
        
        buttonLogout.setOnAction(e ->{
            app.showLoginScreen();
        });
        
        vbox.getChildren().addAll(buttonBooks, buttonCustomers, buttonLogout);
        vbox.setAlignment(Pos.CENTER);
        //adding buttons to a vertical column
        
        // Use StackPane to center the VBox in the middle of the window
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vbox);
        StackPane.setAlignment(vbox, Pos.CENTER);
        stackPane.setMinSize(600, 400);
        stackPane.setPrefSize(600, 400);
        stackPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        screen.getChildren().addAll(stackPane);
        
        return screen;
    }
    
}

