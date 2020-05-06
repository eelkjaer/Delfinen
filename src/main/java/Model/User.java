package Model;

public class User {
    private String username;
    private String password;
    private int userPermissions;


    public User(String username, String password, int userPermissions){
        this.username = username;
        this.password = password;
        this.userPermissions = userPermissions;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserPermissions() {
        return userPermissions;
    }
}
