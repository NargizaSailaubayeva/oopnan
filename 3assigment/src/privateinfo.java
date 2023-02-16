public class privateinfo {
    private String login1 = "Se2214";
    private String pass1 = "se2214";
    private String iin1 = "123456789012";
//    private String iin;
    private String login;
    private String pass;
    public privateinfo(String login, String pass){
//        this.iin = iin;
        this.login = login;
        this.pass = pass;
    }
    public String getLogin1(){
        return login1;
    }
    public void setLogin1(String login1){
        this.login1 = login1;
    }
    public String getPass1() {
        return pass1;
    }
    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getIin1() {
        return iin1;
    }
    public void setIin1(String iin1) {
        this.iin1 = iin1;
    }

//    public String getIin() {
//        return iin;
//    }
//
//    public void setIin(String iin) {
//        this.iin = iin;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
