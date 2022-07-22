package Workshop4.src;

import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("A","a");
        Person person2 = new Person("B","b");
        Person person3 = new Person("C","c");

        Voting first = new Voting(0,"Money or Knowledge?",false);

        ArrayList<Voting> votings= new ArrayList<Voting>();

        votings.add(first);

        VotingSystem theMain = new VotingSystem(votings);

        //  2)CREATING CHOICES:
        ArrayList<String> a = new ArrayList<>();
        a.add("House");
        a.add("Pool");
        a.add("Castle");
        a.add("School");
        theMain.createVoting("Where to live?",true,1,a);

        // 1)CREATING CHOICES:
        theMain.getVoting(0).createChoice("Money");
        theMain.getVoting(0).createChoice("Knowledge");
        theMain.getVoting(0).createChoice("Both");
        theMain.getVoting(0).createChoice("None");

        /*
                VOTING #1
                   start:
         */

        theMain.vote(0,person1);    //ANONYMOUS

        ArrayList<String> person2Choices = new ArrayList<>();
        person2Choices.add("Money");
        person2Choices.add("Both");
        theMain.vote(0,person2,person2Choices);

        ArrayList<String> person3Choices = new ArrayList<>();
        person3Choices.add("None");
        theMain.vote(0,person3,person3Choices);

                    /*       the end        */
        System.out.println("Voting #1:");
        theMain.printResults(0);
        System.out.println();
        theMain.printVoters(0);
        System.out.println();
        theMain.printVoting(0);
        System.out.println();
        System.out.println();
        System.out.println();


        /*
                VOTING #2
                   start:
         */

        ArrayList<String> person1C = new ArrayList<>();
        person1C.add("School");
        person1C.add("House");
        theMain.getVoting(1).vote(person1,person1C);

        theMain.getVoting(1).vote(person2); //ANONYMOUS

        theMain.getVoting(1).vote(person3); //ANONYMOUS

                /*       the end        */
        System.out.println("Voting #2:");
        theMain.printResults(1);
        System.out.println();
        theMain.printVoters(1);
        System.out.println();
        theMain.printVoting(1);

    }
}
/**
 * Voting #1:
 * 1.Money #1
 * ************************
 * 2.Knowledge #0
 * ************************
 * 3.None #2
 * ************************
 * 4.Both #1
 * ************************
 *
 * 1.Money #1
 * 1.B bDate: <<Mon Mar 14 12:44:38 IRST 2022>>
 * 2.Knowledge #0
 * 3.None #2
 * 1.ANONYMOUS
 * 2.C cDate: <<Mon Mar 14 12:44:39 IRST 2022>>
 * 4.Both #1
 * 1.B bDate: <<Mon Mar 14 12:44:38 IRST 2022>>
 *
 * 	Money or Knowledge?
 * Choices:
 * 1.Money
 *     *************************
 * 2.Knowledge
 *     *************************
 * 3.None
 *     *************************
 * 4.Both
 *     *************************
 *
 *
 *
 * Voting #2:
 * 1.School #1
 * ************************
 * 2.Castle #0
 * ************************
 * 3.House #2
 * ************************
 * 4.Pool #1
 * ************************
 *
 * VOTE IS ANONYMOUS!
 *
 * 	Where to live?
 * Choices:
 * 1.School
 *     *************************
 * 2.Castle
 *     *************************
 * 3.House
 *     *************************
 * 4.Pool
 *     *************************
 */
