package sample.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel extends AppModel{
    ObservableList<UserModel> os ,options = null;
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String state;
    private String dob;
    private String address;
    private String table;

    public UserModel() {
    }

    public UserModel(String firstName) {
        this.firstName = firstName;
    }

    public UserModel(int id, String firstName, String middleName,
                     String lastName, String email, String gender,
                     String phone, String state, String dob,
                     String address, String table) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.state = state;
        this.dob = dob;
        this.address = address;
        this.table = table;
    }

    public UserModel(int id, String firstName, String middleName,
                     String lastName, String email, String gender,
                     String phone, String state, String dob,
                     String address) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.state = state;
        this.dob = dob;
        this.address = address;
    }

    public ObservableList<UserModel> getOs() {
        return os;
    }

    public ObservableList<UserModel> getOptions() {
        return options;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getState() {
        return state;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getTable() {
        return table;
    }

    public boolean insertUser(String firstName, String middleName,
                              String lastName, String email, String gender,
                              String phone, String state,
                              String dob, String address, String table) throws SQLException {
        super.insert(firstName,middleName,
                lastName,email,gender,
                phone,state,dob,address,table);
        return true;
    }

    public void selectUser(String table) throws SQLException {
        rs = super.selectAll(table);
        os = FXCollections.observableArrayList();

            while(rs.next()){
                os.add(new UserModel(rs.getInt("id"),
                        rs.getString("firstname"), rs.getString("middlename"),
                        rs.getString("lastname"), rs.getString("email"),
                        rs.getString("gender"), rs.getString("phone"),
                        rs.getString("state"), rs.getString("dob"),
                        rs.getString("address")));
            }


    }

    public boolean deleteUser(String table, int id) throws SQLException {
        if (super.delete(table, id));
        return true;
    }

    public void selectUse(String table) throws SQLException {
        rs = super.selectAl(table);
        options = FXCollections.observableArrayList();

        while (rs.next()){
            options.add(new UserModel(rs.getString("firstname")));
            options.toString();

        }
    }


}
