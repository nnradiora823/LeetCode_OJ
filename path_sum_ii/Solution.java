package path_sum_ii;

import java.util.ArrayList;

import datastructure.TreeNode;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSumHelper(root, paths, path, sum);
        return paths;
    }
    
    public void pathSumHelper(TreeNode root, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, int sum){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null && sum == root.val){
            paths.add((ArrayList<Integer>)path.clone());
            path.remove(path.size()-1);
            return;
        }
        pathSumHelper(root.left, paths, path, sum-root.val);
        pathSumHelper(root.right, paths, path, sum-root.val);
        path.remove(path.size()-1);
    }
}
