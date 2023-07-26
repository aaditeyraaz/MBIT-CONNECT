package SpleshScreen;

public class User {

    private  String name,email,pass,regno;

    public User() {

    }

    public User(String name, String email, String pass, String regno) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.regno = regno;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }



}
