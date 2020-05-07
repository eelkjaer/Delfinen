package Model;

import java.sql.Time;

public class Result {
    private int id;
    private Member member;
    private String diciplin;
    private Competition competition;
    private double resultMeters;
    private Time resultTime;
    private boolean training;

    public Result(int id, Member member, String diciplin, Competition competition, double resultMeters, Time resultTime , boolean training) {
        this.id = id;
        this.member = member;
        this.diciplin = diciplin;
        this.competition = competition;
        this.resultMeters = resultMeters;
        this.resultTime = resultTime;
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

    public double getResultMeters() {
        return resultMeters;
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

    public void setResultMeters(double resultMeters) {
        this.resultMeters = resultMeters;
    }

    public void setTraining(boolean training) {
        this.training = training;
    }
}
