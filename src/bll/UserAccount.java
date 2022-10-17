
package bll;


public class UserAccount {
    private String uid;
    private String fullname;
    private String username;
    private String password;
    private String role;
    private int isLoggedIn;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public void setisLoggedIn(int loggedin){
        this.isLoggedIn = loggedin;
    }
    
    public int getisLoggedIn(){
        return isLoggedIn;
    }
    
    
}
