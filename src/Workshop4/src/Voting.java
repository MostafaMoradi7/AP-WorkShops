package Workshop4.src;

import java.util.*;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        choices = new HashMap<String, HashSet<Vote>>();
        voters = new ArrayList<Person>();
    }

    public String getQuestion() {
        return question;
    }


    public ArrayList<String> getChoices(){
        return new ArrayList<>(choices.keySet());
    }

    public void createChoice(String newChoice){
        choices.put(newChoice,new HashSet<Vote>());
    }

    public void vote(Person person){    // ANONYMOUS FORM
        if (choices.size()!=0){
            Random random = new Random();
            int x = random.nextInt(choices.size()),i=0;
            //  PICKING A RANDOM NUMBER WHICH IS LESS THAN OR EQUAL THE SIZE OF CHOICES
            //  SO WE CAN VOTE RANDOMLY... .
            String y = "";
            for (String string :
                    choices.keySet()) {
                if (i == x){
                    y = string;
                    break;
                }
                ++i;
            }
            //  IN ANONYMOUS VOTING, DATE IS NOT AVAILABLE.
            choices.get(y).add(new Vote());
            //  ADDING PERSON'S NAME TO THE LIST OF VOTERS:
            voters.add(person);
        }
    }
    public void vote(Person person, ArrayList<String> voter_choices){
        Date date = new Date();
        for (String votersChoices :
                voter_choices) {
            choices.get(votersChoices).add(new Vote(person,date.toString()));
        }
        voters.add(person);
    }



    public void printResults(){
        int i = 0;
        for (String x :
                choices.keySet()) {
            ++i;
            System.out.println(i + "." + x + " " + "#" + choices.get(x).size());
            System.out.println("************************");
        }
    }

    public void printVoters(){
        if (!isAnonymous){
            int i = 0,j;
            for (String x: choices.keySet()){
                ++i;
                System.out.println(i + "." + x + " #"+choices.get(x).size());
                j = 0;
                for (Vote y: choices.get(x)){
                    ++j;
                    if (y.getVoter() != null)
                        System.out.println(j+"."+y.getVoter().toString() + "Date: <<" + y.getDate()+">>");
                    else
                        System.out.println(j+".ANONYMOUS");
                }
            }
        }else
            System.out.println("VOTE IS ANONYMOUS!");
    }


}

