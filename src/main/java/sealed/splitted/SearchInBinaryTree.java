package sealed.splitted;

import java.util.Optional;
import java.util.function.BiFunction;

final class SearchInBinaryTree {
  private SearchInBinaryTree() {
  }

  static Optional<String> resultFromBinaryTree(
      Node.BinaryTree<String, String> binaryTree,
      String searched) {
    return resultFromBinaryTree(binaryTree, searched, SearchInDictionary::result);
  }

  static Optional<String> resultFromBinaryTree(
      Node.BinaryTree<String, String> binaryTree,
      String searched,
      BiFunction<Node<String, String>, String, Optional<String>> result
  ) {
    int comparisonResult = searched.compareTo(binaryTree.key());
    if(comparisonResult == 0) {
      return Optional.of(binaryTree.value());
    } else if (comparisonResult < 0) {
      return result.apply(binaryTree.left(), searched);
    } else {
      return result.apply(binaryTree.right(), searched);
    }
  }
}
