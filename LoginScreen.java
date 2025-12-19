package bookstoreapp;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import java.util.ArrayList;


public class LoginScreen {
    
    private Owner owner;
    private ArrayList<Customer> customers;
    private BookstoreApp app;
    
    public Group display(Owner owner, ArrayList<Customer> customers, BookstoreApp app){
        this.owner = owner;
        this.customers = customers;
        this.app = app;
        
        Group screen = new Group();
        
        TextField fieldUsername = new TextField();
        TextField fieldPassword = new TextField();
        
        Label greeting = new Label("Welcome to the Bookstore App!");
        Label labelUser = new Label("Username:");
        Label labelPass = new Label("Password: ");
        Label errorLogin = new Label("");
        
        Button buttonLogin = new Button("Login");
        buttonLogin.setMaxSize(100, 200);
        //button sizing and initalization
        
        buttonLogin.setOnAction(e ->{
            
            String username = fieldUsername.getText();
            String password = fieldPassword.getText();
            
            if(username.equals(owner.getUsername()) == true && password.equals(owner.getPassword()) == true){  
            //switch screen to owner main screen
                app.showOwnerStartScreen();
            }
            else{
                boolean login = false;
                Customer loggedInCustomer = null;

                for(int i = 0; i < customers.size(); i++){
                    //customers is the arraylist of customers
                    
                    if(username.equals(customers.get(i).getUser()) == true && password.equals(customers.get(i).getPass()) == true){
                        
                        //switch screen to customer main screen
                        login = true;
                        loggedInCustomer = customers.get(i);
                        break;
                    }
                }
           
                if(login == false){
                    
                    errorLogin.setText("Incorrect Login Credentials!");
                    errorLogin.setTextFill(Color.color(1,0,0));
                    fieldPassword.clear();
                } else {
                    app.showCustomerStartScreen(loggedInCustomer);
                }
            }
            
        });
        
        GridPane gridPane = new GridPane();
        
        gridPane.add(greeting, 0, 0);
        gridPane.add(labelUser, 0, 1);
        gridPane.add(labelPass, 0, 2);
        gridPane.add(fieldUsername, 1, 1);
        gridPane.add(fieldPassword, 1, 2);
        gridPane.add(buttonLogin, 1, 3);
        gridPane.add(errorLogin, 1, 4);
        //adding all the elements to a grid
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        //formatting the grid
        
        // Use StackPane to center the GridPane in the middle of the window
        // StackPane will center its children by default
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(gridPane);
        StackPane.setAlignment(gridPane, Pos.CENTER);
        
        // Since Group doesn't respect layout, we need to bind StackPane size
        // to the scene size. We'll do this by making it fill available space
        stackPane.setMinSize(600, 400);
        stackPane.setPrefSize(600, 400);
        stackPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        screen.getChildren().addAll(stackPane);
        
        return screen;
    }
    
}

