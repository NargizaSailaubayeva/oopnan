public class CheckLogin extends loginCheck{
    String regex = "\\d+";
    public CheckLogin(String login, String pass){
        super(login, pass);

    }
    public boolean check(String login) {
        for (char i : this.getLogin().toCharArray()) {
            if (Character.isUpperCase(i)) {
                this.count++;
            } else if (Character.isLowerCase(i)) {
                this.count2++;
            } else if (this.getLogin().matches(regex)) {
                this.count3++;
            }
        }
        if (count > 0 && count2 > 0) {
            return true;
        }
        else if (count3 > 0){
            return true;
        }
        return false;
    }
    public boolean checklength(String pass) {
        if (this.getPass().length() < 6) {
            return true;
        }
        else {
            return false;
        }
    }
}
