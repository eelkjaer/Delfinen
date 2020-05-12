package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CompetitionMapper {
    public ArrayList<Competition> getCompetitions(){
        ArrayList<Competition> tmpCompetitions = new ArrayList<>();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Competitons;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int id = resultset.getInt("ID");
                String name = resultset.getString("Name");
                String location = resultset.getString("Location");
                LocalDateTime datetime = resultset.getTimestamp("DateTime").toLocalDateTime();

                Competition tmpCompetition = new Competition(id,name,location,datetime);

                tmpCompetitions.add(tmpCompetition);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpCompetitions;
    }

    /**
     * Tilføj nyt entry til databasen
     * @param name Konkurrencens navn
     * @param location Konkurrencens placering
     * @param datetime Hvornår starter konkurrencen
     * @return Konkurrence(Competition) objekt
     */
    public Competition addNewCompetition(String name, String location, LocalDateTime datetime){
        Connection connection = DBConnector.getInstance().getConnection();
        try {
            String query = "INSERT INTO Competitons(Name, Location, DateTime) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,name);
            statement.setString(2,location);
            statement.setTimestamp(3, Timestamp.valueOf(datetime));
            statement.executeUpdate();
            ResultSet tableKeys = statement.getGeneratedKeys();
            tableKeys.next();
            int id = tableKeys.getInt(1);

            return new Competition(id,name,location,datetime);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
