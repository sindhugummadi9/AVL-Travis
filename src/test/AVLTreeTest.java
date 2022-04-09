import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTreeTest {

  private AVLTree avlTree;

  @BeforeEach
  void setup(){
    avlTree = new AVLTree();
  }

  @Test
  public void testFindWithOneElement(){
    avlTree.insert(2);
    AVLTree.Node node = avlTree.find(2);
    assertEquals(2, node.key);
  }

  @Test
  public void testFindWithTwoElements(){
    avlTree.insert(2);
    avlTree.insert(3);
    AVLTree.Node node = avlTree.find(3);
    assertEquals(3, node.key);
  }

}