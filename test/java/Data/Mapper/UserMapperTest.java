/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 @author Mohammed Hadra (cph-mh879@cphbusiness.dk)
 **/
package Data.Mapper;

import Util.DBConnector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.*;
import Model.User;
import org.junit.rules.ExpectedException;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserMapperTest {
    private static final Connection connection = DBConnector.getInstance().getConnection();
    static User actualUser;
    static User expectedUser;

    static final UserMapper userMapper = new UserMapper();

    private static void resetAutoIncrement(){
        try {
            String query = "ALTER TABLE `Users` AUTO_INCREMENT = 1";
            Statement statement = connection.prepareStatement(query);

            statement.execute(query);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static User createNewUser(User user) {
        User tmpUser = user;

        try {
            String query = "INSERT INTO Users(Username, Password, Permissions, Name) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getUserPermissions());
            statement.setString(4,user.getName());
            statement.executeUpdate();
            ResultSet tableKeys = statement.getGeneratedKeys();
            tableKeys.next();
            tmpUser.setId(tableKeys.getInt(1));

            return tmpUser;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @BeforeAll
    public static void setUp() {
        actualUser = null;
        expectedUser = new User(100,"testuser","testpassword","Test Test",2);
    }

    @Test
    @Order(1)
    public void createUser(){
        actualUser = createNewUser(expectedUser);

        assertEquals(expectedUser.getName(),actualUser.getName());
    }


    @Test
    @Order(2)
    public void checkLogin() throws Exception {
        actualUser = userMapper.checkLogin(expectedUser.getUsername(), expectedUser.getPassword());

        if(actualUser==null){
            throw new Exception("Forkert login!");
        }
    }

    @Test
    @Order(3)
    public void compareUsers(){
        assertEquals(expectedUser.getId(),actualUser.getId());
        assertEquals(expectedUser.getUsername(),actualUser.getUsername());
        assertEquals(expectedUser.getPassword(),actualUser.getPassword());
        assertEquals(expectedUser.getName(),actualUser.getName());
        assertEquals(expectedUser.getUserPermissions(),actualUser.getUserPermissions());
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        Connection connection = DBConnector.getInstance().getConnection();
        try {
            String query = "DELETE FROM Users WHERE Username=? && Name=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,expectedUser.getUsername());
            statement.setString(2,expectedUser.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new SQLException();
        }
        resetAutoIncrement();
    }
}