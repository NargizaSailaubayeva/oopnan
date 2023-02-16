import java.sql.SQLException;

public class CheckInfo extends privateinfo{
    public CheckInfo(String login, String pass){
        super(login, pass);
    }
    public boolean checkinf() throws SQLException {
        DBconnect db = new DBconnect();

        boolean iin2 = db.check_iin_db(this.getLogin());
        boolean login2 = db.check_login_db(this.getLogin());
        boolean pass2 = db.check_password_db(this.getPass());
        if(login2 & pass2) {
            return true;
        }
        else if(iin2 & pass2) {
            return true;
        }
        else{
            return false;
        }
    }
}
