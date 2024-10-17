package librerias;

// import java.util.*;

/**
 * A tuple of two classes that implement Comparable
 */
public class ComparableTuple<X extends Comparable<? super X>, Y extends Comparable<? super Y>>
    extends Tuple<X, Y>
    implements Comparable<ComparableTuple<X, Y>> {
  public ComparableTuple(X x, Y y) {
    super(x, y);
  }

  /**
   * Implements lexicographic order
   */
  public int compareTo(ComparableTuple<X, Y> other) {
    int d = this.first.compareTo(other.first);
    if (d == 0)
      return this.second.compareTo(other.second);
    return d;
  }
}