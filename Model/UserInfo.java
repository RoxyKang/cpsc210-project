package Model;

public class UserInfo {
    private String username;
    private String password;
    private int userid;

    public UserInfo(int id, String username, String password) {
        this.userid = id;
        this.username = username;
        this.password = password;
    }

    public UserInfo() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(int id){
        this.userid = id;
    }

    public int getUserID(){
        return this.userid;
    }
}

