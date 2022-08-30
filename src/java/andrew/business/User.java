package andrew.business;

import java.io.Serializable;
public class User implements Serializable {
    private String fullName;
    private String email;
    private String bookTitle;
    
    public User() {
        fullName = "";
        email = "";
        bookTitle = "";
    }
    
    public User(String fullName, String email, String bookTitle) {
        this.fullName = fullName;
        this.email = email;
        this.bookTitle = bookTitle;
    }

    //Getters and Setters for variables
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
}
