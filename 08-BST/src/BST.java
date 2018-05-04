import java.util.Stack;

public class BST<E extends Comparable<E>> {
	// 用户不需要知道二分搜索树拥有怎样的节点，实现的原理是怎样的
	private class Node {
		public E e;
		public Node left, right;// 左孩子，右孩子

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;// 二分搜索树的根节点
	private int size;// 存储二分搜索树的元素个数

	public BST() {
		root = null;
		size = 0;
	}

	/**
	 * 获取二分搜索树的元素个数
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 判断二分搜索树是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 向二分搜索树中添加新的元素e
	 * @param e
	 */
	public void add(E e) {
		/*
		if(root == null) {
			root = new Node(e);
			size++;
		}
		else 
		*/	
		root = add(root,e);
	}
	
	/**
	 * 向以node为根的二分搜索树中插入元素e，递归算法
	 * 返回插入新节点后二分搜索树的根 
	 * @param node
	 * @param e
	 */
	private Node add(Node node,E e) {
		/*
		 if(e.equals(node.e))
			return;
		else if(e.compareTo(node.e) < 0 && node.left == null) {
			node.left = new Node(e);
			size++;
			return;
		}
		else if(e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node(e);
			size++;
			return;
		}
		*/
		if(node == null) {
			size++;
			return new Node(e);
		}
			
		if(e.compareTo(node.e) < 0)
			node.left = add(node.left,e);
		else if(e.compareTo(node.e) > 0)
			node.right = add(node.right,e);
		
		return node;
	}
	
	/**
	 * 判断二分搜索树中是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(root,e);
	}
	
	/**
	 * 看以node为根的二分搜索树中是否包含元素e，递归算法
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node,E e) {
		if(node == null)
			return false;
		if(e.compareTo(node.e) == 0)
			return true;
		else if(e.compareTo(node.e) < 0)
			return contains(node.left,e);
		else //e.compareTo(node.e) > 0
			return contains(node.right,e);
	}
	
	/**
	 * 二分搜索树的前序遍历
	 */
	public void preOrder() {
		preOrder(root);
	}
	
	/**
	 * 前序遍历以node为根的二分搜索树，递归算法
	 * @param node
	 */
	private void preOrder(Node node) {
		/*递归终止条件
		if(node == null)
			return;
		*/
		if(node != null) {
			System.out.println(node.e);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**
	 * 二分搜索树非递归的前序遍历
	 */
	public void preOrderNR() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
		}
	}
	
	/**
	 * 二分搜索树的中序遍历
	 */
	public void inOrder() {
		inOrder(root);
	}
	/**
	 * 中序遍历以node为根的二分搜索树，递归算法
	 * @param node
	 */
	private void inOrder(Node node) {
		if(node == null)
			return;
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	/**
	 * 二分搜索树的后序遍历
	 */
	public void postOrder() {
		postOrder(root);
	}

	/**
	 * 后序遍历以node为根的二分搜索树，递归算法
	 * @param node
	 */
	private void postOrder(Node node) {
		if(node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	@Override
	public String toString() {
		StringBuilder res =  new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	//
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if(node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}
		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right,depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i = 0 ; i < depth ; i ++)
			res.append("-- ");
		return res.toString();
	}
}
