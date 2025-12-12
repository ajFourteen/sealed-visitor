package classic;

import java.util.Optional;

interface NodeVisitor<K, V> {

  void visit(BinaryTree<K, V> binaryTree);

  void visit(Leaf<K, V> leaf);

  void visit(EmptyNode<K, V> emptyNode);

  Optional<V> result();
}
