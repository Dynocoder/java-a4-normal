public class Card {
    private int rank;
    private int suit;
    private int value;

    /*
    * @param rank - the rank of the card to create.
    * @param suit - the suit of the card to create.
    *
    * the constructor method sets up the rank and the suit of the card, it also sets the value of the card as a product
    * of rank and suit.
    * */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = rank*suit;
    }

    /*
    * @param none
    * @return int - returns the rank of the card
    * */
    public int getRank() {
        return rank;
    }

    /*
    * @param none
    * @return int - returns the suit of the card.
    * */
    public int getSuit() {
        return suit;
    }

    /*
    * @param none
    * @return int - returns the value of the card.
    * */
    public int getValue() {
        return value;
    }


    /*
    * @param none
    * @return String - returns a string "SxRy" where x and y are suit and rank respectively.
    * */
    @Override
    public String toString() {
        return "Card " +
                "S" + suit +
                "R" + rank;
    }
}
