package bookstoreapp;

/**
 * Owner class for bookstore application
 */
public class Owner {
    private String username;
    private String password;
    
    public Owner(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}

