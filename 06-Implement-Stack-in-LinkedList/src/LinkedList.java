//添加操作
//addLast(e) O(n)
//addFirst(e) O(1)
//add(index,e) O(n/2) = O(n)
//删除操作
//removeLast(e) O(n)
//removeFirst(e) O(1)
//remove(index,e) O(n/2) = O(n)
//更新操作
//set(index,e) O(n)
//查找操作
//get(index) O(n)
//contains(e) O(n)
public class LinkedList<E> {
	private class Node {
		public E e;
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	private Node dummyHead;
	private int size;

	public LinkedList() {
		dummyHead = new Node(null, null);
		size = 0;
	}

	// 获取链表中的元素个数
	public int getSize() {
		return size;
	}

	// 返回链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 在链表的index(0-based)位置添加新的元素e
	public void add(int index, E e) {
		if (index < 0 || index > size)
			throw new IllegalArgumentException("Add failed. Illegal Index");
		Node prev = dummyHead;
		for (int i = 0; i < index; i++)
			prev = prev.next;
		prev.next = new Node(e, prev.next);
		size++;
	}

	// 在链表头添加新的元素e
	public void addFirst(E e) {
		/*
		 * Node node = new Node(e); 
		 * node.next = head; 
		 * head = node;
		 */
		// head = new Node(e, head);
		// size++;
		add(0, e);
	}

	// 在链表末尾添加新的元素e
	public void addLast(E e) {
		add(size, e);
	}
	
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed. Illegal Index");
		Node cur = dummyHead.next;
		for(int i = 0; i < index ; i ++)
			cur = cur.next;
		return cur.e;
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public void set(int index, E e) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Update failed. Illegal Index");
		Node cur = dummyHead.next;
		for(int i = 0; i < index ; i ++)
			cur = cur.next;
		cur.e = e;
	}
	
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.e.equals(e))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	/**
	 * 从链表中删除index(0-based)未知的元素，返回删除的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed. Illegal Index");
		Node prev = dummyHead;
		for(int i = 0; i < index ; i ++) {
			prev = prev.next;
		}
		
		Node delNode = prev.next;
		prev.next = delNode.next;
		delNode.next = null;
		size-- ;
		return delNode.e;
	}
	
	//从链表中删除第一个元素，返回删除的元素
	public E removeFirst() {
		return remove(0);
	}
	
	//从链表中删除最后一个元素
	public E removeLast() {
		return remove(size - 1);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		/*Node cur = dummyHead.next;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}*/
		for(Node cur = dummyHead.next ; cur != null; cur = cur.next) {
			res.append(cur + "->");
		}
		res.append("null");
		return res.toString();
	}
}
