import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.security.auth.login.LoginException;
import java.security.MessageDigest;

public class DBconnect {
    private static final String DB_username = "postgres";
    private static final String DB_password = "041325";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    public String hash(String I) throws LoginException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(I.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
        }
        String nan = builder.toString();
        nan = nan.toLowerCase();
        System.out.println(nan);
        return nan;
    }
    public Connection DB_connect(){
        Connection connection = null;

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_username, DB_password);
            if (connection != null){
                assert true;
            } else{
                System.err.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
    public boolean check_password_db(String s) throws SQLException {
        Connection connection = DB_connect();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT password FROM authentication";
        ResultSet result = statement.executeQuery(sqlQuery);
        boolean flag = false;
        while (result.next()) {
            String password = result.getString("password");
            if ((s.equals(password))) {
                flag = true;
                return true;
            }
        }
        if (!flag) {
            return false;
        }
        result.close();
        return false;
    }
    public boolean check_login_db(String s) throws SQLException {
        Connection connection = DB_connect();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT login FROM authentication";
        ResultSet result = statement.executeQuery(sqlQuery);
        boolean flag = false;
        while (result.next()) {
            String password = result.getString("login");
            if ((s.equals(password))) {
                flag = true;
                return true;
            }
        }
        if (!flag) {
            return false;
        }
        result.close();
        return false;
    }
    public boolean check_iin_db(String s) throws SQLException {
        Connection connection = DB_connect();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT iin FROM authentication";
        ResultSet result = statement.executeQuery(sqlQuery);
        boolean flag = false;
        while (result.next()) {
            String password = result.getString("iin");
            if ((s.equals(password))) {
                flag = true;
                return true;
            }
        }
        if (!flag) {
            return false;
        }
        result.close();
        return false;
    }
}
