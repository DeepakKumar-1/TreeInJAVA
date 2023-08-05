package BinarySearchTree;

public class BalancedBST {

    public static void main(String []args){
        BST bst = new BST();
        int []nums = new int[]{5, 6, 3, 8};
        for(int val : nums){
            bst.insert(val);
        }
        bst.inOrder();

        boolean res = bst.isBalancedBST();
        System.out.println(res);
    }
}
