import java.util.Comparator;

/**
 *
 * @author loyyeeko
 */
public class BySuitInValueOrder implements Comparator<Card> {

  @Override
  public int compare(Card o1, Card o2) {
    if (o1.getSuit().ordinal() == o2.getSuit().ordinal()) {
      return o1.getValue() - o2.getValue();
    }
    return o1.getSuit().ordinal() - o2.getSuit().ordinal();

    /**
     * official
     * if (c1.getSuit() == c2.getSuit()) {
     * return c1.getValue() - c2.getValue();
     * }
     *
     * return c1.getSuit().compareTo(c2.getSuit());
     */
  }

}
