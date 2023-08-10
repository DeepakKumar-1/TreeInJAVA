package SegmentTrees;

public class SumSegmentTree {

    private static class TreeNode{
        int val;
        int startInterval;
        int endInterval;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, int startInterval, int endInterval){
            this.val = val;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
        public TreeNode( int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    private TreeNode root;

    public SumSegmentTree(int []a){
        // create a tree using this array
        this.root = createSegmentTree(a, 0, a.length-1);

    }

    private TreeNode createSegmentTree(int[] a, int s, int e) {
        if(s == e){
            TreeNode n = new TreeNode(a[s], s, e);
            return n;
        }
        int mid = s + (e-s)/2;
        TreeNode n = new TreeNode(s, e);
        n.left = createSegmentTree(a, s, mid);
        n.right = createSegmentTree(a, mid+1, e);
        n.val = n.left.val + n.right.val;
        return n;
    }
    // qsi - > query start index , qei - > query end Index
    public int query(int qsi, int qei){
        return query(this.root, qsi, qei);
    }
    private int query(TreeNode root, int qsi, int qei){
        // Case 1 : completely inside
        if(root.startInterval <= qsi && root.endInterval <= qei){
            return root.val;
        }
        // Case 2 : Completely Outside
        else if(root.startInterval < qsi || root.endInterval > qei){
            return 0;
        }
        // Case 3 : Overlapping then deduce result from both sides
        else{
            return query(root.left, qsi, qei) + query(root.right, qsi, qei);
        }
    }

    // update method
    public void update(int ind, int val){
        // check if index lies in range
        if(ind >= root.startInterval && ind <= root.endInterval){
            this.root.val = update(root, ind, val);
        }
    }

    private int update(TreeNode node, int ind, int val){
        if(node.startInterval == ind && node.endInterval == ind){
            node.val = val;
            return node.val;
        }

        int leftAns = update(node.left, ind, val);
        int rightAns = update(node.right, ind, val);
        node.val = leftAns + rightAns;
        return node.val;
    }

    public static void main(String []args){
        int []a = {6, 7, -2, -8, 4, 9};
        SumSegmentTree st = new SumSegmentTree(a);

    }
}
