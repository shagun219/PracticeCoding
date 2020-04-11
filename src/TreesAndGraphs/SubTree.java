package TreesAndGraphs;

public class SubTree {

    public boolean isSubtree(BinaryTreeNode<Integer> givenRoot, BinaryTreeNode<Integer> testRoot)  {
        makeFullBinaryTree(givenRoot);
        makeFullBinaryTree(testRoot);
        StringBuilder givenPath = new StringBuilder();
        StringBuilder testPath = new StringBuilder();
        BinaryTreeTraversals.preOrder(givenRoot, givenPath);
        BinaryTreeTraversals.preOrder(testRoot, testPath);
        return isSubString(givenPath.toString(), testPath.toString());
    }

    public void makeFullBinaryTree(BinaryTreeNode<Integer> root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        if(root.left == null) {
            root.left = new BinaryTreeNode<>(Integer.MIN_VALUE);
        }
        else {
            makeFullBinaryTree(root.left);
        }
        if(root.right == null) {
            root.right = new BinaryTreeNode<>(Integer.MIN_VALUE);
        }
        else {
            makeFullBinaryTree(root.right);
        }
    }

    public boolean isSubString(String gStr, String tStr) {
        char[] gChars = gStr.toCharArray();
        char[] tChars = tStr.toCharArray();
        char startChar = tChars[0];
        int i = 0;
        while(i <= gChars.length - tChars.length) {
            while(gChars[i] != startChar && i <= gChars.length - tChars.length)  {
                i++;
            }
            if(checkMatch(gChars, tChars, i)) {
                return true;
            }
            i += tChars.length;
        }


        return false;
    }

    public boolean checkMatch(char[] gChars, char[] tChars, int index) {
        if(index < 0 || index > gChars.length || (gChars.length-index < tChars.length)) {
            return false;
        }
        for(int i = 0; i < tChars.length; i++) {
            if(tChars[i] != gChars[index+i]) {
                return false;
            }
        }
        return true;
    }
}
