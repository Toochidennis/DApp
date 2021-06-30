package sample.util;


import java.sql.*;

public class Db {
    private  static Connection conn = null;
    private static PreparedStatement prepStmt = null;
    private static ResultSet rs =null;
    private String sql = "";


    static
    {
        String db = "digital_dreams";
        String url = "jdbc:mysql://localhost/" + db;
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return conn;

    }

    public boolean insert(String[] fieldsArray, String[] valueArray,
                          String table) throws SQLException {
        StringBuilder fieldString = new StringBuilder();
        StringBuilder valueString = new StringBuilder();

        for (String s : fieldsArray) {
            fieldString.append(s).append(",");
            valueString.append("?").append(",");
        }

        fieldString.deleteCharAt(fieldString.length() - 1);
        valueString.deleteCharAt(valueString.length() - 1);

        sql = "INSERT INTO " + table + "("+ fieldString +")" + " values("+valueString+")";

        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        for (int i = 0; i < valueArray.length; i++){
            int c  = 1 + i;
            prepStmt.setString(c,valueArray[i]);
        }
        prepStmt.executeUpdate();
        return true;
    }

    public boolean update(String[] fieldsArray, String[] valuesArray, String table
                          ) throws SQLException {
        StringBuilder fieldString = new StringBuilder();
        for (String s : fieldsArray) {
            fieldString.append(s).append(",");
        }

        fieldString.deleteCharAt(fieldString.length() - 1);

        sql = "UPDATE" + " "+ table +" "+ "SET" + " " + fieldString + " " + "WHERE  id = ?";

        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        for (int i = 0; i < valuesArray.length; i++){
            int c = 1 + i;
            if(i == valuesArray.length-1){
                int id = Integer.parseInt(valuesArray[i]);
                prepStmt.setInt(c,id);
            }
            prepStmt.setString(c,valuesArray[i]);
        }
        prepStmt.executeUpdate();

        return true;

        /*UPDATE table SET firstname =? lastname=? WHERE id =? */
    }

    public ResultSet selectAll(String table, int id) throws SQLException {
        sql = "SELECT * FROM" + " " + table + " " + "WHERE id=?";
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        prepStmt.setInt(1,id);
        rs  = prepStmt.executeQuery();

        return rs;

        /*SELECT * FROM table*/
    }


    public ResultSet selectAll(String table) throws SQLException {
        sql = "SELECT * FROM" + " " + table;
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs  = prepStmt.executeQuery();

        return rs;

        /*SELECT * FROM table*/
    }

    public boolean delete(String table, int id) throws SQLException {

        sql = "DELETE FROM" + " " + table + " " + "WHERE id =?";
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        prepStmt.setInt(1,id);
        prepStmt.executeUpdate();

            return true;
        /*DELETE FROM user WHERE id = ?*/
    }

    public boolean deleteAll(String table ) throws SQLException {
        sql = "DELETE FROM" + " " + table ;
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        prepStmt.executeUpdate();

            return true;

        /*DELETE FROM user WHERE id = ?*/
    }


    public ResultSet selectFirst(String table) throws SQLException {
        sql = "SELECT * FROM" + " " + table;
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = prepStmt.executeQuery();
        rs.first();

        return rs;

    }

    public ResultSet selectLast(String table) throws SQLException {
        sql = "SELECT * FROM" + " " + table;
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = prepStmt.executeQuery();
        rs.last();

        return rs;
    }

    public ResultSet selectTopWithLimit(String table, int limit) throws SQLException {
        sql = "SELECT * FROM" + " " + table + " " + "LIMIT ?";
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        prepStmt.setInt(1,limit);
        rs = prepStmt.executeQuery();

        return rs;

       /*SELECT * FROM table LIMIT ?*/
    }

    public ResultSet selectAccount(String table, String username,
                               String password) throws SQLException {
        sql = "SELECT * FROM" + " "+ table +" " + "WHERE username = ? and " +
                "password =?";
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        prepStmt.setString(1, username);
        prepStmt.setString(2, password);
        rs = prepStmt.executeQuery();

       return rs;


        /*SELECT * FROM user where username =? and password =?*/
    }

    public ResultSet selectAl(String table) throws SQLException {
        sql = "SELECT firstname FROM" + " "+ table;
        prepStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = prepStmt.executeQuery();

        return rs;


        /*SELECT * FROM user where username =? and password =?*/
    }

}


   /* public static ResultSet selectAll(String table) throws SQLEception {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String query = "SELECT * FROM " + table;

        rs = stmt.executeQuery(query);
        return rs;
    }

    public static ResultSet selectWithId(int id,String table) throws SQLException {
        String query = "SELECT * FROM " + table + " WHERE id = ?";
        prepStmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        prepStmt.setInt(1,id);
        rs = prepStmt.executeQuery();
        return rs;
    }


    public static ResultSet selectFields(String table,String[] fields) throws SQLException {
        StringBuffer cond = new StringBuffer();
        for(int i=0; i<fields.length; i++){
            cond.append(fields[i] + ",");
        }
        cond.deleteCharAt(cond.length() - 1);

        String sql = "SELECT " + cond + " FROM " + table;
        prepStmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = prepStmt.executeQuery();

        return rs;
    }


    public void insertFields(String table,String[] fields) throws SQLException {
        StringBuffer cond = new StringBuffer();
        for(int i=0; i<fields.length; i++){
            cond.append(fields[i] + ",");
        }
        cond.deleteCharAt(cond.length() - 1);

        String date = "2021-07-09";
        Date dob = Date.valueOf(date);
        UserModel user = new UserModel("Toni", "John", dob, 1000 );

        String sql = "INSERT INTO " + table + " " + "("+ cond +")" + " VALUES(?,?,?,?) ";
        System.out.println(sql);
        prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, user.getFirstName());
        prepStmt.setString(2, user.getLastName());
        prepStmt.setDate(3, user.getDob());
        prepStmt.setDouble(4, user.getAmount());

        prepStmt.executeUpdate();

        System.out.println("Done! :(");

    }
*/

  /* public void selectWithId(String sql, int value) throws SQLException {
       prepStmt = dbInstance.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

       if (value == 0){
           rs  = prepStmt.executeQuery();
           StringBuffer sb = new StringBuffer();
           while(rs.next()) {
               sb.append("id" + " ").append(rs.getInt("id")).append("\t");
               sb.append("firstname" + " ").append(rs.getString("firstname")).append(" \t");
               sb.append("lastname" + " ").append(rs.getString("lastname")).append(" \t");
               sb.append("dob" + " ").append(rs.getString("dob")).append(" \t");
               sb.append("amount" + " ").append(rs.getString("amount")).append("\n");

               System.out.println(sb.toString());
           }
       }else {
           prepStmt.setInt(1, value);
           rs = prepStmt.executeQuery();
           StringBuffer sb = new StringBuffer();
           while (rs.next()) {
               sb.append("id" + " ").append(rs.getInt("id")).append("\t");
               sb.append("firstname" + " ").append(rs.getString("firstname")).append(" \t");
               sb.append("lastname" + " ").append(rs.getString("lastname")).append(" \t");
               sb.append("dob" + " ").append(rs.getString("dob")).append(" \t");
               sb.append("amount" + " ").append(rs.getString("amount")).append("\n");

               System.out.println(sb.toString());
           }
       }

       *//*SELECT * FROM user where id =?*//*
   }*/

    /*String sb = "id" + " " + rs.getInt("id") + "\t" +
            "firstname" + " " + rs.getString("firstname") + " \t" +
            "lastname" + " " + rs.getString("lastname") + " \t" +
            "dob" + " " + rs.getString("dob") + " \t" +
            "amount" + " " + rs.getString("amount") + "\n";
        System.out.println(sb);*/

