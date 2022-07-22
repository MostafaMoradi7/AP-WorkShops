package Workshop4.src;

import java.util.Objects;

public class Vote {
    private final Person voter;
    private final String date;

    public Vote(Person voter, String date){
        this.voter = voter;
        this.date = date;
    }
    public Vote(){
        this.voter = null;
        this.date = null;
    }

    public Person getVoter() {
        return voter;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return voter.equals(vote.voter) && date.equals(vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }
}
