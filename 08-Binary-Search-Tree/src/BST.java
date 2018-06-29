import java.util.LinkedList;
import java.util.Queue;
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
	 * 
	 * @param e
	 */
	public void add(E e) {
		root = add(root, e);
	}

	/**
	 * ����nodeΪ���Ķ����������в���Ԫ��e���ݹ��㷨 ���ز����½ڵ������������ĸ�
	 * 
	 * @param node
	 * @param e
	 */
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}

		if (e.compareTo(node.e) < 0)
			node.left = add(node.left, e);
		else if (e.compareTo(node.e) > 0)
			node.right = add(node.right, e);

		return node;
	}

	/**
	 * �ж϶������������Ƿ����Ԫ��e
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}

	/**
	 * ����nodeΪ���Ķ������������Ƿ����Ԫ��e���ݹ��㷨
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node, E e) {
		if (node == null)
			return false;
		if (e.compareTo(node.e) == 0)
			return true;
		else if (e.compareTo(node.e) < 0)
			return contains(node.left, e);
		else // e.compareTo(node.e) > 0
			return contains(node.right, e);
	}

	/**
	 * ������������ǰ�����
	 */
	public void preOrder() {
		preOrder(root);
	}

	/**
	 * ǰ�������nodeΪ���Ķ������������ݹ��㷨
	 * 
	 * @param node
	 */
	private void preOrder(Node node) {
		/*
		 * �ݹ���ֹ���� if(node == null) return;
		 */
		if (node != null) {
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
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
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
	 * 
	 * @param node
	 */
	private void inOrder(Node node) {
		if (node == null)
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
	 * 
	 * @param node
	 */
	private void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	/**
	 * �����������Ĳ������
	 */
	public void levelOrder() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node cur = queue.remove();
			System.out.println(cur.e);
			if (cur.left != null)
				queue.add(cur.left);
			if (cur.right != null)
				queue.add(cur.right);
		}
	}

	/**
	 * Ѱ�Ҷ�������������СԪ��
	 * 
	 * @return
	 */
	public E minimum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		return minimum(root).e;
	}

	/**
	 * ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
	 * 
	 * @param node
	 * @return
	 */
	private Node minimum(Node node) {
		if (node.left == null)
			return node;
		return minimum(node.left);
	}

	/**
	 * Ѱ�Ҷ��������������Ԫ��
	 * 
	 * @return
	 */
	public E maximum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		return maximum(root).e;
	}

	/**
	 * ������nodeΪ���Ķ��������������ֵ���ڵĽڵ�
	 * 
	 * @param node
	 * @return
	 */
	private Node maximum(Node node) {
		if (node.right == null)
			return node;
		return maximum(node.right);
	}

	/**
	 * �Ӷ�����������ɾ����Сֵ���ڽڵ㣬������Сֵ
	 * 
	 * @return
	 */
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}

	/**
	 * ɾ����nodeΪ���Ķ����������е���С�ڵ� ����ɾ���ڵ���µĶ����������ĸ�
	 * 
	 * @param node
	 * @return
	 */
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	/**
	 * �Ӷ�����������ɾ�����ֵ���ڽڵ㣬�������ֵ
	 * 
	 * @return
	 */
	public E removeMax() {
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}

	/**
	 * ɾ����nodeΪ���Ķ����������е����ڵ� ����ɾ���ڵ���µĶ����������ĸ�
	 * 
	 * @param node
	 * @return
	 */
	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMin(node.right);
		return node;
	}

	/**
	 * �Ӷ�����������ɾ��Ԫ��Ϊe�Ľڵ�
	 * 
	 * @param e
	 */
	public void remove(E e) {
		root = remove(root, e);
	}

	/**
	 * ɾ������nodeΪ���Ķ�����������ֵΪe�Ľڵ㣬�ݹ��㷨 ����ɾ���ڵ���µĶ����������ĸ�
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private Node remove(Node node, E e) {
		if (node == null)
			return null;
		if (e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else {// e.compareTo(node.e) = 0
				// ��ɾ���ڵ���ڵ�Ϊ�յ����
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			// ��ɾ���ڵ�������Ϊ�յ����
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// ��ɾ���ڵ�����������Ϊ�յ����
			// �ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ�
			// ������ڵ㶥���ɾ���ڵ��λ��
			Node successor = minimum(node.right);// size++
			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = node.right = null;// size--

			return successor;
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	// ������nodeΪ���ڵ㣬���Ϊdepth���������������ַ���
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}
		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++)
			res.append("-- ");
		return res.toString();
	}
}
