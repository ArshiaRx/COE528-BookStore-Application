package bookstoreapp;

import java.util.ArrayList;
import java.io.IOException;

/**
 * BookStore class to manage application state
 */
public class BookStore {
    private static Owner owner;
    private static ArrayList<Customer> customers;
    private static ArrayList<Book> books;
    
    static {
        // Initialize owner with default credentials
        owner = new Owner("admin", "admin");
        
        // Initialize customers list
        customers = new ArrayList<>();
        
        // Try to load customers from file, if it exists
        try {
            ArrayList loadedCustomers = FileManager.read("customers");
            customers = (ArrayList<Customer>) loadedCustomers;
        } catch (IOException e) {
            // File doesn't exist, start with empty list
            customers = new ArrayList<>();
        }
        
        // Initialize books list
        books = new ArrayList<>();
        
        // Try to load books from file, if it exists
        try {
            ArrayList loadedBooks = FileManager.read("books");
            books = (ArrayList<Book>) loadedBooks;
        } catch (IOException e) {
            // File doesn't exist, add some default books
            books = new ArrayList<>();
            books.add(new Book("Java Programming", 49.99));
            books.add(new Book("Data Structures", 59.99));
            books.add(new Book("Algorithms", 54.99));
        }
    }
    
    public static Owner getOwner() {
        return owner;
    }
    
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    public static ArrayList<Book> getBooks() {
        return books;
    }
    
    public static void addCustomer(Customer customer) {
        customers.add(customer);
        try {
            FileManager.write(new ArrayList<>(customers), "customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteCustomer(Customer customer) {
        customers.remove(customer);
        try {
            FileManager.write(new ArrayList<>(customers), "customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveBooks() {
        try {
            FileManager.write(new ArrayList<>(books), "books");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveCustomers() {
        try {
            FileManager.write(new ArrayList<>(customers), "customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

