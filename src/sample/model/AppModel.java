package sample.model;

import sample.util.Db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppModel extends Db {

     ResultSet rs =null;

    public boolean insert(String username,String password,String email,
                          String table) throws SQLException {

        if(super.insert(new String[]{"username", "password", "email"},
                new String[]{username, password, email}, table)) return true; return false;
    }

    public boolean insert(String firstName,String middleName,
                          String lastName,String email,String gender,
                          String phone,String state,String dob,String address,
                          String table) throws SQLException {

        if(super.insert(new String[]{"firstname","middlename","lastname",
                "email","gender","phone","state","dob","address"},
                new String[]{firstName,middleName,lastName,email,gender,
                phone,state,dob,address}, table))
                 return true; return false;
    }

    public boolean insert(String title, String instructor, String duration,
                          String description, String table) throws SQLException {
        if (super.insert(new String[]{"title", "instructor", "duration",
                "description"}, new String[]{title, instructor, duration,
                description}, table)) return true; return false;
    }

    public boolean update(String firstName,String id,String table) throws SQLException {
        if(super.update(new String[]{"firstname"},new String[]{firstName,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,String id,
                          String table) throws SQLException {

        if(super.update(new String[]{"firstname","middlename"},
                new String[]{firstName,middleName,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String id,String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname"},
                new String[]{firstName,middleName,lastName,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String email,String id,
                          String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname",
                        "email"},
                new String[]{firstName,middleName,lastName,email,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String email,
                          String gender,String id,String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname",
                        "email","gender"},
                new String[]{firstName,middleName,lastName,email,gender,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String email,
                          String gender,String phone,String id,String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname",
                        "email","gender","phone"},
                new String[]{firstName,middleName,lastName,email,gender,phone
                        ,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String email,
                          String gender,String phone,
                          String state,String id,String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname",
                        "email","gender","phone","state"},
                new String[]{firstName,middleName,lastName,email,gender,phone
                        ,state,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String email,
                          String gender,String phone,
                          String state,String dob,String id,String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname",
                        "email","gender","phone","state","dob"},
                new String[]{firstName,middleName,lastName,email,gender,phone
                        ,state,dob,id},
                table))
            return true; return false;
    }

    public boolean update(String firstName,String middleName,
                          String lastName,String email,
                          String gender,String phone,
                          String state,String dob,String address,String id,
                          String table) throws SQLException {
        if(super.update(new String[]{"firstname","middlename","lastname",
                        "email","gender","phone","state","dob","address"},
                new String[]{firstName,middleName,lastName,email,gender,phone
                        ,state,dob,address,id},
                table))
            return true; return false;
    }

    public ResultSet selectAll(String table) throws SQLException {
        rs = super.selectAll(table);
        if(rs != null) return rs;
        return null;
    }

    public ResultSet selectAll(String table,int id) throws SQLException {
        rs = super.selectAll(table,id);
        if(rs != null) return rs;
        return null;
    }

    public boolean deleteAll(String table) throws SQLException {
        if (super.deleteAll(table)) return true; return false;

    }

    public boolean delete(String table, int id) throws SQLException {
        if (super.delete(table, id)) return true; return false;

    }

    public ResultSet selectTopWithLimit(String table, int limit) throws SQLException {
        rs = super.selectTopWithLimit(table, limit);
        if(rs != null) return rs;
        return null;
    }

    public ResultSet selectFirst(String table) throws SQLException {
        rs = super.selectFirst(table);
        if(rs != null) return rs;
        return null;
    }

    public ResultSet selectLast(String table) throws SQLException {
        rs = super.selectLast(table);
        if(rs != null) return rs;
        return null;
    }

    public ResultSet verifyAccount(String table, String username,
                                 String password) throws SQLException {
        rs = super.selectAccount(table, username, password);
        if(rs != null) return rs;
        return null;

    }
    public ResultSet selectAl(String table) throws SQLException {
        rs = super.selectAl(table);
        if(rs != null) return rs;
        return null;
    }


}
