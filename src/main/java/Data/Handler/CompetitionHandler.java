/**
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 @author Jacob Lange Nielsen (cph-jn352@cphbusiness.dk)
 **/
package Data.Handler;

import Data.Mapper.*;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitionHandler {
    private final CompetitionMapper competitionMapper = new CompetitionMapper();
    private ArrayList<Competition> competitions;

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public void addToCompetitions(Competition competition){
        if(!competitions.contains(competition)){
            competitions.add(competition);
        }
    }

    public void updateCompetitions() {
        this.competitions = competitionMapper.getCompetitions();
    }

    public Competition getCompetitionById(int id) {
        for (Competition c : competitions) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Competition addNewCompetition(String name, String location, LocalDate datetime) {
        return competitionMapper.addNewCompetition(name,location,datetime);
    }
}
