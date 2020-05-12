package Data.Handler;

import Data.Mapper.*;
import Model.*;

import java.util.ArrayList;

public class ResultHandler {
    private final ResultMapper resultMapper = new ResultMapper();
    private ArrayList<Result> results;

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public void updateResults(ArrayList<Member> members, ArrayList<Competition> competitions) {
        this.results = resultMapper.getResults(members,competitions);
    }
}
