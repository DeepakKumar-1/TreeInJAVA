package BinarySearchTree;

import BinaryTrees.BinaryTree;
import com.sun.source.tree.Tree;

import java.util.Scanner;

public class BST {
    public BST(){

    }
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    private TreeNode root;

    public boolean isEmpty(){
        return root == null;
    }


    // Insert Method Way 1

    public TreeNode insertNode(TreeNode root, int val){
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(root.val >= val){
            root.left = insertNode(root.left, val);
        }
        if(root.val < val){
            root.right = insertNode(root.right, val);
        }
        return root;
    }



    // Insert Method Way2
    public void insert(TreeNode root , int val){

        if(root == null){
            return;
        }
        if(root.val >= val && root.left == null){
            // insert in left
            root.left = new TreeNode(val);
            return;
        }

        if(root.val < val  && root.right == null){
            root.right = new TreeNode(val);
            return;
        }
        // go on left
        if(root.left != null && root.val >= val){
            insert(root.left, val);
        }
        // go on right
        if(root.right != null && root.val < val){
            insert(root.right, val);
        }
    }
    public void insert(int val){
        if(isEmpty()){
            root = new TreeNode(val);
            return;
        }
        insert(root, val);
    }


    // pre Order Traversal
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    // in Order Traversal
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    // Post Order Traversal
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }


    private int height(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private boolean isBalancedBST(TreeNode root){
        if(root == null){
            return true;
        }

        return Math.abs(height(root.left)- height(root.right))<=1 && isBalancedBST(root.left) && isBalancedBST(root.right);
    }
    public  boolean isBalancedBST(){
        return isBalancedBST(root);
    }

    public static void main(String []args){
        BST bst = new BST();
        bst.insert(15);
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(12);

        bst.inOrder();
    }


}
