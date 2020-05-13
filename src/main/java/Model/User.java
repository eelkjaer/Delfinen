/**
 @author Mohammed Hadra (cph-mh879@cphbusiness.dk)
 **/
package Model;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private int userPermissions;


    public User(int id,String username, String password, String name,int userPermissions){
        this.id = id;
        this.username = username;
        this.password = password;
        this.userPermissions = userPermissions;
        this.name = name;
    }

    public User(int id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public int getUserPermissions() {
        return userPermissions;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userPermissions=" + userPermissions +
                '}';
    }
}
