package classic;

interface Node<K, V> {

  void accept(NodeVisitor<K, V> visitor);

  K key();

  V value();
}
