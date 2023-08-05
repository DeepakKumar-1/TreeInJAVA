package BinaryTrees;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){

    }
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public  TreeNode(int val){
            this.val = val;
        }
    }

    private TreeNode root;
    // Insert Elements
    public void populate(Scanner sc){
        System.out.print("Enter the Value of Root Node: ");
        int val = sc.nextInt();
        root = new TreeNode(val);
        populate(sc, root);
    }
    public void populate(Scanner sc, TreeNode node){
        System.out.print("Do You want to Enter left of: " + node.val + ": ");
        boolean left = sc.nextBoolean();
        if(left){
            System.out.print("Enter the Value of Left of: " + node.val + ": ");
            int val = sc.nextInt();
            node.left = new TreeNode(val);
            populate(sc, node.left);
        }
            System.out.print("Do You want to Enter right of: " + node.val + ": ");
            boolean right = sc.nextBoolean();
            if(right){
                System.out.print("Enter the Value of right of: " + node.val + ": ");
                int val = sc.nextInt();
                node.right = new TreeNode(val);
                populate(sc, node.right);
            }

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


    public static void main(String []args){
        BinaryTree bt = new BinaryTree();
        // insert Values
        bt.populate(new Scanner(System.in));

        // Display Binary Tree
        bt.inOrder();
    }
}
