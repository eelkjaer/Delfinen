package Model;

public class Result {
    private int id;
    private Member member;
    private String diciplin;
    private Competition competition;
    private double resultMeters;
    private double resultTime;
    private boolean training;

    public Result(int id, Member member, String diciplin, Competition competition, double resultMeters, double resultTime , boolean training) {
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
        String str = String.format("%n%n" +
                "Svømmer: %s (%d)%n"+
                "Diciplin: %s%n"+
                "Stævne: %s, %s - %s%n"+
                "Meter svømmet: %.2f meter%n"+
                "Tid: %.2f sekunder%n%n",
                member.getName(),member.getId(),
                diciplin,
                competition.getName(),competition.getLocation(),competition.getTimestamp().toString(),
                resultMeters,
                resultTime);

        return str;
    }
}
