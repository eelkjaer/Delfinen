package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.util.ArrayList;

public class ResultMapper {
    private Connection connection = DBConnector.getInstance().getConnection();

    public ArrayList<Result> getResults(ArrayList<Member> members, ArrayList<Competition> competitions){
        ArrayList<Result> tmpResults = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Results;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int id = resultset.getInt("ID");
                int memberID = resultset.getInt("MemberID");
                String diciplin = resultset.getString("Disciplin");
                int competitionID = resultset.getInt("CompetitionID");
                double resultMeters = resultset.getDouble("ResultMeters");
                double resultTime = resultset.getDouble("ResultTime");
                boolean training = resultset.getBoolean("Training");

                Member member = null;
                for(Member m:members){
                    if(m.getId() == memberID){
                        member = m;
                    }
                }

                Competition competition = null;
                for(Competition c:competitions){
                    if(c.getId() == competitionID){
                        competition = c;
                    }
                }

                Result tmpResult = new Result(id,member,diciplin,competition,resultMeters,resultTime,training);

                tmpResults.add(tmpResult);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpResults;
    }

    /**
     * @param member Member objekt som skal tilknyttes
     * @param diciplin ENUM('bryst','crawl','rygcrawl','butterfly')
     * @param competition Competition objekt som skal tilknyttes
     * @param resultMeters Default: 100.0
     * @param resultTime Tid i sekunder
     * @param training self-explainitory
     * @return Result objekt
     */
    public Result addNewResult(Member member, String diciplin, Competition competition, Double resultMeters, double resultTime, boolean training){
        int memberId = member.getId();
        int competitionId = competition.getId();

        try {
            String query = "INSERT INTO Results(MemberID, Disciplin, CompetitionID, ResultMeters, ResultTime, Training) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,memberId);
            statement.setString(2,diciplin);
            statement.setInt(3,competitionId);
            statement.setDouble(4,resultMeters);
            statement.setDouble(5,resultTime);
            statement.setBoolean(6,training);
            statement.executeUpdate();
            ResultSet tableKeys = statement.getGeneratedKeys();
            tableKeys.next();
            int id = tableKeys.getInt(1);

            return new Result(id,member,diciplin,competition,resultMeters,resultTime,training);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
