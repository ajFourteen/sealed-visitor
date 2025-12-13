package sealed.splitted;

sealed interface Node<K, V> {

  K key();

  V value();

  record Leaf<K, V>(K key, V value) implements Node<K, V> {}

  record BinaryTree<K, V>(K key, V value, Node<K, V> left, Node<K, V> right) implements Node<K, V> {}

  record EmptyNode<K, V>() implements Node<K, V> {

    @Override
    public K key() {
      throw new UnsupportedOperationException();
    }

    @Override
    public V value() {
      throw new UnsupportedOperationException();
    }
  }
}
