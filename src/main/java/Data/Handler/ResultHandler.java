/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 **/
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

    public Result addResult(Result result){
        if(!results.contains(result)){
            results.add(result);
        }
        return result;
    }

    public void updateResults(ArrayList<Member> members, ArrayList<Competition> competitions) {
        this.results = resultMapper.getResults(members,competitions);
    }


    public Result registerResult(Member member, int diciplin,Competition competition, double resultTime, String training){
        String diciplinStr = "";
        switch (diciplin){
            case 1:
                diciplinStr = "crawl";
            case 2:
                diciplinStr = "buttefly";
            case 3:
                diciplinStr = "rygcrawl";
            case 4:
                diciplinStr = "bryst";
        }
        boolean trainingbool = training.equals("ja".toLowerCase());

        Result tmpResult = resultMapper.addNewResult(member,diciplinStr,competition,100.0,resultTime,trainingbool);

        return addResult(tmpResult);
    }
}
