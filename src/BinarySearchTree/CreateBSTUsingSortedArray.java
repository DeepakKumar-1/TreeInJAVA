package BinarySearchTree;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Scanner;

public class CreateBSTUsingSortedArray {
    private static class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){
        }
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static TreeNode createBST(int []nums, int s, int e){
        if(s > e){
            return null;
        }

        int mid = s+ (e-s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, s, mid-1);
        root.right = createBST(nums, mid+1, e);
        return root;
    }

    private static TreeNode createBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        TreeNode root = createBST(nums);
        inOrder(root);
    }

}
