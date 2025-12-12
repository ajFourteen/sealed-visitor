package classic;

record Leaf<K, V>(K key, V value) implements Node<K, V> {

  @Override
  public void accept(final NodeVisitor<K, V> visitor) {
    visitor.visit(this);
  }
}
