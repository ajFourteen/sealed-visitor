package classic;

import java.util.Optional;

final class SearchInDictionary implements NodeVisitor<String, String> {
  private final String searched;
  private String result;

  SearchInDictionary(final String searched) {
    this.searched = searched;
  }

  @Override
  public void visit(final BinaryTree<String, String> binaryTree) {
    int comparisonResult = searched.compareTo(binaryTree.key());
    if(comparisonResult == 0) {
      result = binaryTree.value();
    } else if (comparisonResult < 0) {
      binaryTree.left().accept(this);
    } else {
      binaryTree.right().accept(this);
    }
  }

  @Override
  public void visit(final Leaf<String, String> leaf) {
    if(searched.equals(leaf.key())) {
      result = leaf.value();
    }
  }

  @Override
  public void visit(final EmptyNode<String, String> emptyNode) {
  }

  @Override
  public Optional<String> result() {
    return Optional.ofNullable(result);
  }
}
