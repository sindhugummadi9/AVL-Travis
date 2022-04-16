package avlTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAvlTree {

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
    avlTree.insert(3);
    avlTree.insert(1);
    avlTree.insert(5);
    avlTree.insert(0);
    avlTree.insert(10);
    avlTree.delete(3);
    assertNull(avlTree.find(3));
  }

  @Test
  public void testInsertDuplicateKey(){
    avlTree.insert(3);
    assertThrows(RuntimeException.class, () -> avlTree.insert(3));
  }

  @Test
  public void testInsert(){
    avlTree.insert(15);
    avlTree.insert(12);
    avlTree.insert(10);
    avlTree.insert(9);
    assertThrows(RuntimeException.class, () -> avlTree.insert(12));
  }

  @Test
  public void testInsertRightNode(){
    avlTree.insert(15);
    avlTree.insert(12);
    avlTree.insert(10);
    avlTree.insert(17);
    assertEquals(12, avlTree.find(12).key);
  }

  @Test
  public void testDeleteLeftMostChild(){
    avlTree.insert(20);
    avlTree.insert(15);
    avlTree.insert(17);
    avlTree.insert(16);
    avlTree.insert(18);
    avlTree.insert(24);
    avlTree.delete(16);
    assertNull(avlTree.find(16));
  }

  @Test
  public void testDelete(){
    avlTree.insert(20);
    avlTree.insert(15);
    avlTree.insert(17);
    avlTree.insert(16);
    avlTree.insert(18);
    avlTree.insert(24);
    avlTree.delete(17);
    assertNull(avlTree.find(17));
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

  @Test
  public void testGetBalanceNull(){
    assertEquals(0, avlTree.getBalance(null));
  }

  @Test
  public void verifyDelete_whereLeftNodeIsNotNullButRightNodeIsNull(){
    AVLTree avl = new AVLTree();
    avl.insert(18);
    avl.insert(13);
    avl.insert(20);
    avl.insert(19);

    assertThrows(NullPointerException.class, () -> avl.delete(20));
  }

  @Test
  public void verifyDelete_whereLeftNodeIsNotNullButRightNodeIsNull_failingCase(){
    AVLTree avl = new AVLTree();
    avl.insert(18);
    avl.insert(13);
    avl.insert(20);
    avl.insert(19);

    avl.delete(20);
    assertNull(avl.find(20));
  }

}