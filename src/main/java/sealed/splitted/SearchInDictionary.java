package sealed.splitted;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

final class SearchInDictionary {

  private SearchInDictionary() {
  }

  static Optional<String> result(Node<String, String> dictionary,
                                 String searched) {
    return result(
        dictionary,
        searched,
        SearchInBinaryTree::resultFromBinaryTree,
        SearchInLeaf::resultFromLeaf,
        SearchInEmptyNode::resultFromEmptyNode
    );
  }

  static Optional<String> result(Node<String, String> dictionary,
                                 String searched,
                                 BiFunction<Node.BinaryTree<String, String>, String, Optional<String>> resultFromBinaryTree,
                                 BiFunction<Node.Leaf<String, String>, String, Optional<String>> resultFromLeaf,
                                 Supplier<Optional<String>> resultFromEmptyNode) {
    return switch (dictionary) {
      case Node.BinaryTree<String, String> binaryTree ->
          resultFromBinaryTree.apply(binaryTree, searched);
      case Node.Leaf<String, String> leaf ->
          resultFromLeaf.apply(leaf, searched);
      case Node.EmptyNode<String, String> _ -> resultFromEmptyNode.get();
    };
  }
}
