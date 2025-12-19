package bookstoreapp;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static bookstoreapp.BookStore.*;

/**
 *
 * @author a4rahim
 */
public class OwnerBooksScreen {
    private final TableView<Book> table = new TableView<>();
    
    public Group display(Stage primaryStage, BookstoreApp app) {
        Group screen = new Group();
        
        //Table Header
        final Label label = new Label("Books Shelf");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);

        // Load books
        ObservableList<Book> booksList = FXCollections.observableArrayList(getBooks());
        table.setItems(booksList);
                
        TableColumn<Book, String> BookName = new TableColumn<>("Book Name");
        BookName.setMinWidth(200);
        BookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Book, Double> BookPrice = new TableColumn<>("Book Price");
        BookPrice.setMinWidth(150);
        BookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        table.getColumns().addAll(BookName, BookPrice);
        
        // Add book fields
        TextField addBookName = new TextField();
        addBookName.setPromptText("Book Name");
        addBookName.setMaxWidth(200);
        
        TextField addBookPrice = new TextField();
        addBookPrice.setPromptText("Price");
        addBookPrice.setMaxWidth(150);
        
        Button addButton = new Button("Add Book");
        addButton.setOnAction(e -> {
            try {
                String name = addBookName.getText().trim();
                double price = Double.parseDouble(addBookPrice.getText().trim());
                if (!name.isEmpty() && price > 0) {
                    Book newBook = new Book(name, price);
                    getBooks().add(newBook);
                    booksList.add(newBook);
                    saveBooks();
                    addBookName.clear();
                    addBookPrice.clear();
                }
            } catch (NumberFormatException ex) {
                // Invalid price
            }
        });

        Button deleteButton = new Button("Delete Selected");
        deleteButton.setOnAction(e -> {
            Book selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                getBooks().remove(selected);
                booksList.remove(selected);
                saveBooks();
            }
        });
        
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            app.showOwnerStartScreen();
        });
        
        HBox addBox = new HBox(5);
        addBox.setAlignment(javafx.geometry.Pos.CENTER);
        addBox.getChildren().addAll(addBookName, addBookPrice, addButton, deleteButton);
        
        HBox backBox = new HBox(5);
        backBox.setPadding(new Insets(5));
        backBox.getChildren().add(backButton);
        
        final VBox vbox = new VBox();
        final VBox vbox = new VBox(10);
        vbox.setSpacing(10);

        vbox.setPadding(new Insets(20, 0, 0, 50));
        vbox.getChildren().addAll(backBox, label, table, addBox);
        
        screen.getChildren().addAll(vbox);
        return screen;
    }
}
