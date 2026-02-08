package sealed.hidden;

import java.util.Optional;

sealed interface Node<K extends Comparable<K>, V> {

  boolean keyEquals(K other);

  Optional<V> value();

  final class Leaf<K extends Comparable<K>, V> implements Node<K, V> {
    private final K key;
    private final V value;

    Leaf(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public boolean keyEquals(K other) {
      return key.equals(other);
    }

    @Override
    public Optional<V> value() {
      return Optional.of(value);
    }
  }

  final class BinaryTree<K extends Comparable<K>, V> implements Node<K, V> {
    private final K key;
    private final V value;
    private final Node<K, V> left;
    private final Node<K, V> right;

    BinaryTree(K key, V value, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    @Override
    public boolean keyEquals(K other) {
      return key.equals(other);
    }

    @Override
    public Optional<V> value() {
      return Optional.of(value);
    }

    Node<K, V> next(K searched) {
      int comparisonResult = searched.compareTo(key);
      if(comparisonResult == 0) {
        throw new IllegalArgumentException();
      } else if (comparisonResult < 0) {
        return left;
      } else {
        return right;
      }
    }
  }

  final class EmptyNode<K extends Comparable<K>, V> implements Node<K, V> {

    @Override
    public boolean keyEquals(K other) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Optional<V> value() {
      throw new UnsupportedOperationException();
    }
  }
}
