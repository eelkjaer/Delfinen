package Data.Handler;

import Data.Mapper.*;
import Model.*;

import java.util.ArrayList;

public class CompetitionHandler {
    private final CompetitionMapper competitionMapper = new CompetitionMapper();
    private ArrayList<Competition> competitions;

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public void updateCompetitions(){
        this.competitions = competitionMapper.getCompetitions();
    }
}
