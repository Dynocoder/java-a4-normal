import java.util.Arrays;
import java.util.Scanner;


/*
* The Main class of the assignment.
* the Class asks the user for their choice of action and then performs the action on
* */
public class Main {
    public static void main(String[] args) {

        int nSuits;
        int nRanks;
        int userChoice;

//        The scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("How many Suits? ");
        nSuits = sc.nextInt();


        System.out.print("How many Ranks? ");
        nRanks = sc.nextInt();

//        Declaring and initializing the deckOfCards object named "deck".
        DeckOfCards deck = new DeckOfCards(nRanks, nSuits);

        do {
            System.out.println(deck.toString());
            System.out.println("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
            userChoice = sc.nextInt();

//            User Choice Conditions
            if (userChoice == 1) {
                deck.shuffle();
            } else if (userChoice == 2) {
                System.out.print("How many Cards? ");
                for (Card card: deck.deal(sc.nextInt())) {
                    System.out.print(card.toString() + " ");
                }
                System.out.println();
                deck.shuffle();
            } else if (userChoice == 3) {
                System.out.print("How many Cards? ");
                deck.histogram(sc.nextInt());
            }


        } while(userChoice != 4);

        System.out.println("BYE!");

    }
}
