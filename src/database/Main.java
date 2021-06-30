package database;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final String CONN =  "jdbc:mysql://localhost/ddl_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;


    public static void main(String[] args) {

        try {
            //connecting to the database through driver manager
            conn = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("Connected!!");
            insertUser();
            updateUser();
            deleteUser();
            showUser();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (conn !=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
    public static void insertUser(){
        Scanner input = new Scanner(System.in);

        //getting info from a user
        System.out.println("Enter firstname");
        String firstName = input.nextLine();
        System.out.println("Enter lastname");
        String lastName = input.nextLine();
        System.out.println("Enter your date in this format yyyy-mm-dd");
        String date = input.nextLine();
        Date dob = Date.valueOf(date);
        System.out.println("Enter amount");
        double amount = input.nextDouble();


        // initialize class UserModel
        UserModel model = new UserModel(firstName, lastName, dob, amount);


        // inserting data to the database using prepared statement
        String sql = "insert into user(firstName, lastName, dob, amount) values(?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, model.getFirstName());
            stmt.setString(2, model.getLastName());
            stmt.setDate(3, model.getDob());
            /*  stmt.setDate(3,Date.valueOf(LocalDate.now(ZoneId.of(ZoneOffset.UTC.getId()))));*/
            stmt.setDouble(4, model.getAmount());
            stmt.executeUpdate();
            System.out.println( " User successfully inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    public static void showUser(){

        // getting info database
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //  stmt.execute("Insert into user (firstName, lastName, dob, amount) values (+ "firstName, lastName, dob, amount )");

            rs = stmt.executeQuery("select * from user");

            /*rs.last();
            System.out.println(rs.getRow());*/

            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2)+  "\t" + rs.getString(3) + "\t" + rs.getString(4)+ "\t" + rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println("Error: ex.printStackTrace()");
        }

    }

    public static void updateUser(){
        try {
           // String query = "update user set firstname = 'Toochi', lastname = 'Dennis' where id = 2";
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("update user set firstname = 'john', lastname = 'Dennis' where id = 9");
            stmt.executeUpdate();
            System.out.println("Updated Successfully");

        }catch(SQLException ex){
         ex.printStackTrace();
        }
    }
    public static void deleteUser(){
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("delete from user where id = 11 ");
            stmt.executeUpdate();
            System.out.println("Deleted successfully!");
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }


}
