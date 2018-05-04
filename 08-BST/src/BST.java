import java.util.Stack;

public class BST<E extends Comparable<E>> {
	// �û�����Ҫ֪������������ӵ�������Ľڵ㣬ʵ�ֵ�ԭ����������
	private class Node {
		public E e;
		public Node left, right;// ���ӣ��Һ���

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;// �����������ĸ��ڵ�
	private int size;// �洢������������Ԫ�ظ���

	public BST() {
		root = null;
		size = 0;
	}

	/**
	 * ��ȡ������������Ԫ�ظ���
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * �ж϶����������Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * �����������������µ�Ԫ��e
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
	 * ����nodeΪ���Ķ����������в���Ԫ��e���ݹ��㷨
	 * ���ز����½ڵ������������ĸ� 
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
	 * �ж϶������������Ƿ����Ԫ��e
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(root,e);
	}
	
	/**
	 * ����nodeΪ���Ķ������������Ƿ����Ԫ��e���ݹ��㷨
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
	 * ������������ǰ�����
	 */
	public void preOrder() {
		preOrder(root);
	}
	
	/**
	 * ǰ�������nodeΪ���Ķ������������ݹ��㷨
	 * @param node
	 */
	private void preOrder(Node node) {
		/*�ݹ���ֹ����
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
	 * �����������ǵݹ��ǰ�����
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
	 * �������������������
	 */
	public void inOrder() {
		inOrder(root);
	}
	/**
	 * ���������nodeΪ���Ķ������������ݹ��㷨
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
	 * �����������ĺ������
	 */
	public void postOrder() {
		postOrder(root);
	}

	/**
	 * ���������nodeΪ���Ķ������������ݹ��㷨
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
