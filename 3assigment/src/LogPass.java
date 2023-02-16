import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class LogPass {
    public static void main(String[] args) throws SQLException, LoginException, NoSuchAlgorithmException {
        DBconnect db = new DBconnect();

        int count = 0;
        boolean isTrue = false;
        RunTimer time = new RunTimer(isTrue, count);
        while (!isTrue){
//            System.out.print("IIN: ");
//            Scanner in = new Scanner(System.in);
//            String iin = in.nextLine();
            System.out.print("Username or IIN: ");
            Scanner log = new Scanner(System.in);
            String login = log.nextLine();
            System.out.print("Password: ");
            Scanner pas = new Scanner(System.in);
            String pass_1 = pas.nextLine();
            String pass = db.hash(pass_1);
            CheckInfo CheckInfo = new CheckInfo(login, pass);
            CheckLogin CheckLogin = new CheckLogin(login, pass);
            if(!CheckLogin.check(login)){
               isTrue = false;
               System.out.println("Login must contain uppercase and lowercase letter, please try again.");
            }
            else{
                if(CheckLogin.checklength(pass)){
                    System.out.println("Password must be at least 6, please try again.");
                }
                else {
                    if (CheckInfo.checkinf()) {
                        System.out.println("You successfully logged in.");
                        isTrue = true;
                    } else {
                        System.out.println("Invalid data, please try again.");
                        count++;
                        time.timeRun(count);
                    }
                }
            }
        }
    }
}
