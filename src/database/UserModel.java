package database;


import java.sql.Date;

public class UserModel {

    private String firstName;
    private String lastName;
    private Date dob;
    private double amount;

    public UserModel(String firstName, String lastName, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public UserModel(String firstName, String lastName, Date dob, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
