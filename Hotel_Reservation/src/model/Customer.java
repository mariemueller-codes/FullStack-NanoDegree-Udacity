package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String emailRegex = "^(.+)@(.+).(.+)$";

    public Customer(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isEmailValid(email);
    }

    public void isEmailValid(String email){
        Pattern pattern = Pattern.compile(emailRegex);

        if (!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Invalid email");
        }
    }

    @Override
    public String toString(){
        return "First Name: " + this.firstName
            + " Last Name: " + this.lastName
            + " Email: " + this.email;
    }
    
}
