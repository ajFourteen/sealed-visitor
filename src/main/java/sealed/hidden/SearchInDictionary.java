package sealed.hidden;

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
    if(binaryTree.keyEquals(searched)) {
      return binaryTree.value();
    } else  {
      return result(binaryTree.next(searched), searched);
    }
  }

  private static Optional<String> resultFromLeaf(Node.Leaf<String, String> leaf, String searched) {
    if(leaf.keyEquals(searched)) {
      return leaf.value();
    } else {
      return Optional.empty();
    }
  }
}
