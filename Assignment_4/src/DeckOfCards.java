import java.sql.Array;
import java.util.Arrays;

public class DeckOfCards {
//    declaring the deck of Cards array
    Card[] deckOfCards;
    private int arrayLength;
    private static final int histogramCount = 100000;


    /*
    * @param rank - the highest rank the deck should have.
    * @param suits - the number of suits the deck should have.
    *
    * This function initializes the deckOfCards array and fills it with all the possible cards' rank and suit combination.
    * */
    public DeckOfCards(int rank, int suits) {
        this.arrayLength = rank*suits;
        this.deckOfCards = new Card[this.arrayLength];
        int indexCount = 0;


//        Filling the array with card objects
        for (int i = 1; i < suits+1; i++) {
            for (int j = 1; j<rank+1; j++) {
                Card card = new Card(j, i);
                deckOfCards[indexCount] = card;
                indexCount++;
            }
        }
    }

    /*
    * @param none
    * @return void
    *
    * the method will shuffle the deck by looping through the deckOfCards array and exchanging the value with some other
    * random index higher than the current index but lower than the length of the array.
    * */
    public void shuffle() {
        //        Declared inside the function to reduce scope of the variable.
        Card tempCard1;
        int randIndex;

        for (int i = 0; i < this.arrayLength; i++) {
//            generating a random number between i and the length of array(exclusive)
            randIndex = (int)(Math.random()*(this.arrayLength-i))+i;

//            Exchanging the values;
            tempCard1 = deckOfCards[randIndex];
            deckOfCards[randIndex] = deckOfCards[i];
            deckOfCards[i] = tempCard1;

        }
    }

    /*
    * @param n - the number of cards to deal.
    * @return Card[] - returns an array of the dealt cards.
    *
    * the method will return the array of the top n cards that are dealt to the user.
    * */
    public Card[] deal(int n) {
        Card[] card = new Card[n];
        for (int i = 0; i < n; i++) {
            card[i] = deckOfCards[i];
        }
        return card;
    }

    /*
    * @param n - the value to be mapped into a graph.
    * @return String - the method will return a mapped string of "*" characters whose length depict its value.
    *
    * This is a helper function. It takes in a double, after that the method will map that value to another value between 0 and 150.
    * Therefore, the maximum number of "*" in an array can be 150.
    * */
    private String graph(double n) {
        String graphString = "";
        for(int i = 0; i < (n/this.histogramCount)*150; i++) {
            graphString += "*";
        }
        return graphString;
    }


    /*
    * @param cards - The number of cards to deal in each draw.
    * @return void
    *
    * This is the histogram method. The method will perform histogramCount deals and add the values to an array at their
    * respective indexes. The deck is shuffled after each iteration.
    * After the deals are done, the data is displayed along with a graph with the help of the helper function graph().
    * */
    public void histogram(int cards) {
//        this.arrayLength = suits*rank (the highest possible value of a card)
//        this.arrayLength*cards (the number of times the highest value will be drawn)
        int histogram[] = new int[this.arrayLength*cards];

        for (int i = 0; i < this.histogramCount; i++) {
            Card chosen[] = deal(cards);
            int sum = 0;
            for (Card card: chosen) {
                sum += card.getValue();
            }
            histogram[sum]++;
            shuffle();
        }

        for (int i = 0; i < this.arrayLength*cards; i++) {
            if (histogram[i]>cards) {
                System.out.println(i + "\t:\t" + histogram[i] + "\t" + graph(histogram[i]));
            }
        }
    }


    /*
    * @param none
    * @return String - returns the arrayLength, lowest and highest value, top cards.
    *
    * this method returns the information about the deckOfCards object in the following way:
    * Deck of ? Cards: low=? high=? top=?, where the "?" represents the respective property of the object.
    * */
    @Override
    public String toString() {
        return "Deck of " + this.arrayLength + " cards: " +
                "low = " + 1 +
                " high = " + this.arrayLength + // arrayLength = suits*ranks;
                " top = " + this.deckOfCards[0];
    }
}
