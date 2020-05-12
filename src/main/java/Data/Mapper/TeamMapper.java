package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.util.ArrayList;

public class TeamMapper {
    public ArrayList<Team> getTeams(ArrayList<Member> members, ArrayList<User> users){
        ArrayList<Team> tmpTeams = new ArrayList<>();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT Teams.ID AS \"TeamID\", Teams.Name AS \"TeamName\", GROUP_CONCAT(DISTINCT TeamMembers.MemberID SEPARATOR \";\") AS \"MemberID\", Users.ID AS \"CoachID\"\n" +
                    "FROM Teams\n" +
                    "INNER JOIN TeamMembers ON TeamMembers.TeamID = Teams.ID\n" +
                    "INNER JOIN Users ON Users.ID = Teams.CoachID\n" +
                    "GROUP BY Teams.ID;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int id = resultset.getInt("TeamID");
                String name = resultset.getString("TeamName");
                int coachID = resultset.getInt("CoachID");
                String[] memberIDs = resultset.getString("MemberID").split(";");

                User coach = null;
                for(User u:users){
                    if(u.getId() == coachID){
                        coach = u;
                    }
                }

                ArrayList<Member> teamMembers = new ArrayList<>();
                for(Member m:members){
                    for (String memberID : memberIDs) {
                        if (m.getId() == Integer.parseInt(memberID)) {
                            teamMembers.add(m);
                        }
                    }
                }

                Team tmpTeam = new Team(id,name,coach,teamMembers);

                tmpTeams.add(tmpTeam);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpTeams;
    }
}
