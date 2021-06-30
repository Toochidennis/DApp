package sample.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidationModel extends AppModel{
    String username;
    String password;
    String table;

    public ValidationModel() {
    }

    public ValidationModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ResultSet validateAdmin(String table, String username,
                                  String password) throws SQLException {
        rs = super.selectAccount(table, username, password);
        if(rs != null) return rs;
        return null;

    }
}
