package Data.Mapper;

import Model.User;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class UserMapperTest {
    User actualUser;
    User expectedUser;
    UserMapper userMapper;
    ArrayList<User> user;

    @Before
    public void setUp() {
        //int id,String username, String password, String name,int userPermissions
        //1	admin
        //2	mod
        //3	user
        //4	simon
        expectedUser = new User(1,"admin","admin","emil",3);

       userMapper = new UserMapper();
       User user1 = new User(1,"admin","admin","emil",3);
       User user2 = new User(2,"mod","mod","andreas",2);
       User user3 = new User(3,"user","user","thor",1);
       User user4 = new User(4,"simon","simon","simon",1);

       actualUser = user3;

       user = new ArrayList<>();
       user.add(user1);
       user.add(user2);
       user.add(user3);
       user.add(user4);
    }

    @Test(expected=Exception.class)
    public void getUsers() throws Exception {
        ArrayList<User> users = userMapper.getUsers();
        int actual = users.size();
        int expected = 4;
        assertEquals(actual,expected);
        throw new Exception("Mega fejl");
    }

    @Test
    public void getUsersFail() throws Exception {
        try {
            ArrayList<User> users = userMapper.getUsers();
            int actual = users.size();
            int expected = 40;

            throw new Exception("fejl");
        } catch (Exception e){
            assertEquals("fejl",e.getMessage());
        }

    }

    @Test
    public void checkName(){
    String actualUsersName = actualUser.getName();
    String expectedUsersName = "thor";
        assertEquals(expectedUsersName,actualUsersName);
    }
}