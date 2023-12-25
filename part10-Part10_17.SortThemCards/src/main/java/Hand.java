
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author loyyeeko
 */
public class Hand implements Comparable<Hand> {
  final private List<Card> hand;

  public Hand() {
    hand = new ArrayList<>();

  }

  public void add(Card card) {
    hand.add(card);
  }

  public void print() {
    hand.stream().forEach(System.out::println);
  }

  public void sort() {
    Comparator<Card> comparator = Comparator.comparing(Card::getValue).thenComparing(Card::getSuit);
    Collections.sort(hand, comparator);
  }

  public void sortBySuit() {
    // Comparator<Card> comparator =
    // Comparator.comparing(Card::getSuit).thenComparing(Card::getValue);

    // Collections.sort(hand, comparator);
    Collections.sort(hand, new BySuitInValueOrder());

  }

  @Override
  public int compareTo(Hand o) {
    final int currVal = hand.stream().map(card -> card.getValue()).reduce(0,
        (acc, curr) -> acc += curr);

    final int objVal = o.hand.stream().map(card -> card.getValue()).reduce(0,
        (acc, curr) -> acc += curr);

    if (currVal == objVal) {
      return 0;
    } else if (currVal < objVal) {
      return -1;
    } else {
      return 1;
    }

  }
}
