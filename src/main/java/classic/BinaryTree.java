package classic;

record BinaryTree<K, V>(K key, V value, Node<K, V> left, Node<K, V> right)
    implements Node<K, V> {

  @Override
  public void accept(final NodeVisitor<K, V> visitor) {
    visitor.visit(this);
  }
}
