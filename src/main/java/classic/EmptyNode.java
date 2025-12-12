package classic;

final class EmptyNode<K, V> implements Node<K, V> {
  @Override
  public void accept(final NodeVisitor<K, V> visitor) {
    visitor.visit(this);
  }

  @Override
  public K key() {
    throw new UnsupportedOperationException();
  }

  @Override
  public V value() {
    throw new UnsupportedOperationException();
  }
}
