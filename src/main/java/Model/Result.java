package Model;

public class Result {
    private int id;
    private Member member;
    private String diciplin;
    private Competition competition;
    private double resultMeters;
    private int resultTime;
    private boolean training;

    public Result(int id, Member member, String diciplin, Competition competition, double resultMeters, int resultTime , boolean training) {
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

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", member=" + member +
                ", diciplin='" + diciplin + '\'' +
                ", competition=" + competition +
                ", resultMeters=" + resultMeters +
                ", resultTime=" + resultTime +
                ", training=" + training +
                '}';
    }
}
