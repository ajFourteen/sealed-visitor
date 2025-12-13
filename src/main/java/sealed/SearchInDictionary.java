package sealed;

import java.util.Optional;

final class SearchInDictionary {

  private SearchInDictionary() {
  }

  static Optional<String> result(Node<String, String> dictionary, String searched) {
    return switch (dictionary) {
      case Node.BinaryTree<String, String> binaryTree -> resultFromBinaryTree(binaryTree, searched);
      case Node.Leaf<String, String> leaf -> resultFromLeaf(leaf, searched);
      case Node.EmptyNode<String, String> _ -> Optional.empty();
    };
  }

  private static Optional<String> resultFromBinaryTree(Node.BinaryTree<String, String> binaryTree, String searched) {
    int comparisonResult = searched.compareTo(binaryTree.key());
    if(comparisonResult == 0) {
      return Optional.of(binaryTree.value());
    } else if (comparisonResult < 0) {
      return result(binaryTree.left(), searched);
    } else {
      return result(binaryTree.right(), searched);
    }
  }

  private static Optional<String> resultFromLeaf(Node.Leaf<String, String> leaf, String searched) {
    if(searched.equals(leaf.key())) {
      return Optional.of(leaf.value());
    } else {
      return Optional.empty();
    }
  }
}
