package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeFirstCommonAncestor<T extends Comparable> {

    public BinaryTreeNodeWithParent<T> findFirstCommonAncestor(BinaryTreeNodeWithParent<T> n, BinaryTreeNodeWithParent<T> m) {
        int NDepth = findDepth(n);
        int MDepth = findDepth(m);
        int diff = NDepth - MDepth;
        BinaryTreeNodeWithParent<T> shallower = diff > 0 ? m : n;
        BinaryTreeNodeWithParent<T> deeper = diff > 0 ? n : m;
        int absDiff = Math.abs(diff);
        while(absDiff > 0 && deeper != null) {
            deeper = deeper.parent;
            absDiff--;
        }
        while(shallower != deeper && shallower != null && deeper != null) {
            shallower = shallower.parent;
            deeper = deeper.parent;
        }
        return shallower == null || deeper == null ? null : shallower;
    }

    public int findNodeLevel(BinaryTreeNodeWithParent<T> s,  BinaryTreeNodeWithParent<T> n, int level) {
        if(s == null || n == null) {
            return -1;
        }
        if(s ==  n) {
            return level;
        }
        int l = findNodeLevel(s.left, n, level+1);
        return l == -1 ? findNodeLevel(s.right, n, level+1) : l;
    }

    public int findDepth(BinaryTreeNodeWithParent<T> n) {
        int depth = -1;
        while(n != null) {
            n = n.parent;
            depth++;
        }
        return depth;
    }

    public BinaryTreeNodeWithParent<T> findFirstCommonAncestor(BinaryTreeNodeWithParent<T> root,
            BinaryTreeNodeWithParent<T> n, BinaryTreeNodeWithParent<T> m) {
        if(root == null || n == null | m == null) {
            return null;
        }
        if(root == n || root == m) {
            return root;
        }
        if(n == m) {
            return n;
        }
        boolean isNPresent = cover(root, n);
        boolean isMPresent = cover(root, m);
        if(!isNPresent || !isMPresent) {
            return null;
        }
        boolean isNInLeftSubtree = cover(root.left, n);
        boolean isMInLeftSubtree = cover(root.left, m);
        if(isNInLeftSubtree != isMInLeftSubtree) {
            return root;
        }
        return isNInLeftSubtree ? findFirstCommonAncestor(root.getLeft(), n, m) :
                findFirstCommonAncestor(root.getRight(), n, m);
    }

    private boolean cover(BinaryTreeNodeWithParent<T> root, BinaryTreeNodeWithParent<T> node) {
        if(root == null || node == null) {
            return false;
        }
        if(root == node) {
            return true;
        }
        return cover(root.left, node) || cover(root.right, node);
    }
}
