package org.hum.study.datastruct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.hum.study.datastruct.stack.StackUtils;
import org.hum.study.datastruct.stack.StackUtils.Stack;

public class BinaryTreeUtils {

	static class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;
		public TreeNode() { }
		public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	static class BinaryTree<T> {
		public TreeNode<T> root;
		
		public void printPreOrder() {
			if (root == null) {
				System.out.println("tree is null");
			}
			
			printPreOrder(root);
		}
		
		// 递归先序遍历
		private void printPreOrder(TreeNode<T> node) {
			if (node == null || node.data == null) {
				return ;
			}
			System.out.println(node.data);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
		
		// 栈先序遍历
		public void printPreOrderByStack() {
			if (root == null) {
				System.out.println("tree is null");
			}
			
			Stack<TreeNode<T>> stack = new StackUtils.LinkedStack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode<T> node = stack.pop();
				System.out.println(node.data);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
		
		// 层级遍历
		public void levelOrder() {
			Queue<TreeNode<T>> list = new LinkedList<>();
			list.add(root);
			while (!list.isEmpty()) {
				TreeNode<T> node = list.poll();
				System.out.println(node.data);
				if (node.left != null) {
					list.add(node.left);
				}
				if (node.right != null) {
					list.add(node.right);
				}
			}
		}
		
		public static BinaryTree<Integer> createSimple() {
			BinaryTree<Integer> tree = new BinaryTree<Integer>();
			TreeNode<Integer> node2 = new TreeNode<Integer>(2, new TreeNode<Integer>(4, null, null), new TreeNode<Integer>(5, null, null));
			TreeNode<Integer> node3 = new TreeNode<Integer>(3, new TreeNode<Integer>(6, null, null), new TreeNode<Integer>(7, null, null));
			tree.root = new TreeNode<Integer>(1, node2, node3);
			return tree;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree.createSimple().levelOrder();
	}
}
