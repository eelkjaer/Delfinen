package Model;

public class Result {
    private int id;
    private Member member;
    private String diciplin;
    private Competition competition;
    private double result;
    private boolean training;

    public Result(int id, Member member, String diciplin, Competition competition, double result, boolean training) {
        this.id = id;
        this.member = member;
        this.diciplin = diciplin;
        this.competition = competition;
        this.result = result;
        this.training = training;
    }

    public int getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public String getDiciplin() {
        return diciplin;
    }

    public Competition getCompetition() {
        return competition;
    }

    public double getResult() {
        return result;
    }

    public boolean isTraining() {
        return training;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setDiciplin(String diciplin) {
        this.diciplin = diciplin;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setTraining(boolean training) {
        this.training = training;
    }
}
