package Data;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ResultMapper {
    public ArrayList<Result> getResults(ArrayList<Member> members, ArrayList<Competition> competitions){
        ArrayList<Result> tmpResults = new ArrayList<>();

        Connection connection = DBConnector.getInstance().getConnection();
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
                int resultTime = resultset.getInt("ResultTime");
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

    public Result addNewResult(Member member, String diciplin, Competition competition, Double resultMeters, int resultTime, boolean training){
        int memberId = member.getId();
        int competitionId = competition.getId();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            String query = "INSERT INTO Results(MemberID, Disciplin, CompetitionID, ResultMeters, ResultTime, Training) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,memberId);
            statement.setString(2,diciplin);
            statement.setInt(3,competitionId);
            statement.setDouble(4,resultMeters);
            statement.setInt(5,resultTime);
            statement.setBoolean(6,training);
            statement.executeUpdate();
            ResultSet tableKeys = statement.getGeneratedKeys();
            tableKeys.next();
            int id = tableKeys.getInt(1);

            Result tmpResult = new Result(id,member,diciplin,competition,resultMeters,resultTime,training);

            return tmpResult;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
