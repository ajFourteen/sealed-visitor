package sealed.splitted;

import java.util.Optional;

final class SearchInEmptyNode {

  private SearchInEmptyNode() {
  }

  static Optional<String> resultFromEmptyNode() {
    return Optional.empty();
  }
}
