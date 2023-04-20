package TreesAndGraphs;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestIsomorphicTree {

    @Test
    public void testIsomorphicTree() {
        BinaryTreeNode<String> tree1 = getTree1();
        BinaryTreeNode<String> tree2 = getTree2();

        BinaryTreeNode<String> tree3 = getTree2();

        IsomorphicTree<Integer> it = new IsomorphicTree<>();
        //Assert.assertTrue(it.isIsomorphic(tree1, tree2));
        Assert.assertTrue(it.isIsomorphic(getTreeInt1(), getTreeInt2()));
        //Assert.assertFalse(it.isIsomorphic(tree2, tree3));

        //Assert.assertFalse(it.isIsomorphic(getTree1(), getTree3()));

    }

    private BinaryTreeNode<Integer> getTreeInt1() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        return node1;
    }

    private BinaryTreeNode<Integer> getTreeInt2() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        node1.left = node3;
        node1.right = node2;
        node2.left = node5;
        node2.right = node4;
        return node1;
    }

    private BinaryTreeNode<String> getTree1() {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> nodeD = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> nodeE = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> nodeF = new BinaryTreeNode<>("F");
        BinaryTreeNode<String> nodeG = new BinaryTreeNode<>("G");
        BinaryTreeNode<String> nodeI = new BinaryTreeNode<>("I");
        BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>("J");
        BinaryTreeNode<String> nodeK = new BinaryTreeNode<>("K");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        nodeD.left = nodeI;

        nodeE.right = nodeJ;
        nodeJ.left = nodeK;

        return nodeA;
    }

    private BinaryTreeNode<String> getTree2() {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> nodeD = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> nodeE = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> nodeF = new BinaryTreeNode<>("F");
        BinaryTreeNode<String> nodeG = new BinaryTreeNode<>("G");
        BinaryTreeNode<String> nodeI = new BinaryTreeNode<>("I");
        BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>("J");
        BinaryTreeNode<String> nodeK = new BinaryTreeNode<>("K");

        nodeA.left = nodeC;
        nodeA.right = nodeB;

        nodeC.left = nodeG;
        nodeC.right = nodeF;

        nodeB.left = nodeE;
        nodeB.right = nodeD;

        nodeE.left = nodeJ;
        nodeD.right = nodeI;

        nodeJ.right = nodeK;

        return nodeA;
    }

    private BinaryTreeNode<String> getTree3() {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> nodeD = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> nodeE = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> nodeF = new BinaryTreeNode<>("F");
        BinaryTreeNode<String> nodeG = new BinaryTreeNode<>("G");
        BinaryTreeNode<String> nodeI = new BinaryTreeNode<>("I");
        BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>("J");
        BinaryTreeNode<String> nodeK = new BinaryTreeNode<>("K");

        nodeA.left = nodeC;
        nodeA.right = nodeB;

        nodeC.left = nodeG;
        nodeC.right = nodeF;

        nodeB.left = nodeE;
        nodeB.right = nodeD;

        nodeE.left = nodeJ;
        nodeD.right = nodeI;

        nodeJ.left = nodeK;

        return nodeA;
    }

    private BinaryTreeNode<String> getTree4() {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        return nodeA;
    }

    private BinaryTreeNode<String> getTree5() {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C");

        //nodeA.left = nodeC;
        nodeA.right = nodeB;

        return nodeA;
    }
}
