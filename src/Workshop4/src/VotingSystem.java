package Workshop4.src;

import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    VotingSystem(ArrayList<Voting> votingList){
        this.votingList = votingList;
    }

    public void createVoting(String question,
                             boolean isAnonymous, int type,
                             ArrayList<String> choices){
        votingList.add(new Voting(type,question,isAnonymous));
        for (String choice : choices) {
            votingList.get(votingList.size() - 1).createChoice(choice);
        }
    }

    public Voting getVoting(int index){
        return votingList.get(index);
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    public void printResults(int index){
        votingList.get(index).printResults();
    }

    public void printVoters(int index){
        votingList.get(index).printVoters();
    }

    public void printVoting(int index){
        System.out.println("\t" + votingList.get(index).getQuestion());
        System.out.println("Choices: ");
        int i = 0;
        for (String x :
                votingList.get(index).getChoices()) {
            ++i;
            System.out.println(i+"."+x);
            System.out.println("    *************************");
        }
    }

    public void vote(int index, Person voter){
        votingList.get(index).vote(voter);
    }
    public void vote(int index, Person voter, ArrayList<String> voter_choices){
        votingList.get(index).vote(voter,voter_choices);
    }

}
