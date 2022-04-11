import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    avlTree.insert(3);
    avlTree.insert(2);
    AVLTree.Node node = avlTree.find(3);
    assertEquals(3, node.key);
  }

  @Test
  public void testHeight(){
    avlTree.insert(2);
    avlTree.insert(3);
    assertEquals(1, avlTree.height());
  }

  @Test
  public void testDeleteNode(){
    avlTree.insert(2);
    avlTree.insert(3);
    avlTree.insert(5);
    avlTree.delete(3);
    assertNull(avlTree.find(3));
  }

  @Test
  public void testInsertDuplicateKey(){
    avlTree.insert(3);
    assertThrows(RuntimeException.class, () -> avlTree.insert(3));
  }

  @Test
  public void testDeleteNotPresentNode(){
    avlTree.delete(3);
    assertEquals(-1, avlTree.height());
  }

  @Test
  public void testDeleteFirstNode(){
    avlTree.insert(2);
    avlTree.insert(3);
    avlTree.insert(5);
    avlTree.delete(2);
    assertNull(avlTree.find(2));
  }

  @Test
  public void testDeleteLastNode(){
    avlTree.insert(2);
    avlTree.insert(3);
    avlTree.insert(5);
    avlTree.delete(5);
    assertNull(avlTree.find(5));
  }

}