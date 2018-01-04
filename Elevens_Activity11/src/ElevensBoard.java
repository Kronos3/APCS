import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {
    
    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;
    
    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    
    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};
    
    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
    
    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }
    
    /**
     * Look for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return a list of the indexes of an 11-pair, if an 11-pair was found;
     *         an empty list, if an 11-pair was not found.
     */
    private List<Integer> findPairSum11(List<Integer> selectedCards) {
        List<Integer> out = new ArrayList<Integer>();
        for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
            int k1 = selectedCards.get(sk1);
            for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
                int k2 = selectedCards.get(sk2);
                if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11) {
                    out.add (k1);
                    out.add (k2);
                    return out;
                }
            }
        }
        return out;
    }
    
    /**
     * Look for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return a list of the indexes of a JQK, if a JQK was found;
     *         an empty list, if a JQK was not found.
     */
    private List<Integer> findJQK(List<Integer> selectedCards) {
        int k = 0;
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 0; i != selectedCards.size(); i++) {
            String currentRank = cardAt(cardIndexes().get(i)).rank();
            if (currentRank.equals("king")) {
                k |= 1;
                out.add (cardIndexes().get(i));
            }
            else if (currentRank.equals("queen")) {
                k |= 1 << 1;
                out.add (cardIndexes().get(i));
            }
            else if (currentRank.equals("jack")) {
                k |= 1 << 2;
                out.add (cardIndexes().get(i));
            }
            
        }
        if (k != 7)
            out.clear();
        return out;
    }
    
    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        return playIfPossible();
    }
    
    /**
     * Looks for a legal play on the board.  If one is found, it plays it.
     *
     * @return true if a legal play was found (and made); false othewise.
     */
    public boolean playIfPossible() {
        return playPairSum11IfPossible() || playJQKIfPossible();
    }
    
    /**
     * Looks for a pair of non-face cards whose values sum to 11.
     * If found, replace them with the next two cards in the deck.
     * The simulation of this game uses this method.
     *
     * @return true if an 11-pair play was found (and made); false othewise.
     */
    private boolean playPairSum11IfPossible() {
        List<Integer> toReplace = findPairSum11(cardIndexes());
        if (toReplace.size() == 0)
            return false;
        replaceSelectedCards(toReplace);
        return true;
    }
    
    /**
     * Looks for a group of three face cards JQK.
     * If found, replace them with the next three cards in the deck.
     * The simulation of this game uses this method.
     *
     * @return true if a JQK play was found (and made); false othewise.
     */
    private boolean playJQKIfPossible() {
        List<Integer> toReplace = findJQK(cardIndexes());
        if (toReplace.size() == 0)
            return false;
        replaceSelectedCards(toReplace);
        return true;
    }
}
