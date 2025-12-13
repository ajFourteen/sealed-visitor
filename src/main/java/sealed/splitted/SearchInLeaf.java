package sealed.splitted;

import java.util.Optional;

final class SearchInLeaf {

  private SearchInLeaf() {
  }

  static Optional<String> resultFromLeaf(Node.Leaf<String, String> leaf,
                                         String searched) {
    if (searched.equals(leaf.key())) {
      return Optional.of(leaf.value());
    } else {
      return Optional.empty();
    }
  }
}
