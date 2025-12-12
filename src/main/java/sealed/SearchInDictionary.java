package sealed;

import java.util.Optional;

final class SearchInDictionary {
  private final Node<String, String> dictionary;

  SearchInDictionary(Node<String, String> dictionary) {
    this.dictionary = dictionary;
  }

  Optional<String> result(final String searched) {
    return searchInNode(dictionary, searched);
  }

  private Optional<String> searchInNode(Node<String, String> node, String searched) {
    return switch (node) {
      case Node.BinaryTree<String, String> binaryTree -> searchInBinaryTree(binaryTree, searched);
      case Node.Leaf<String, String> leaf -> searchInLeaf(leaf, searched);
      case Node.EmptyNode<String, String> _ -> Optional.empty();
    };
  }

  private Optional<String> searchInBinaryTree(Node.BinaryTree<String, String> binaryTree, String searched) {
    int comparisonResult = searched.compareTo(binaryTree.key());
    if(comparisonResult == 0) {
      return Optional.of(binaryTree.value());
    } else if (comparisonResult < 0) {
      return searchInNode(binaryTree.left(), searched);
    } else {
      return searchInNode(binaryTree.right(), searched);
    }
  }

  private Optional<String> searchInLeaf(Node.Leaf<String, String> leaf, String searched) {
    if(searched.equals(leaf.key())) {
      return Optional.of(leaf.value());
    } else {
      return Optional.empty();
    }
  }
}
