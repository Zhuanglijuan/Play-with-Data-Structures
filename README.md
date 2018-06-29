# 数据结构练习代码 #
1. [动态数组](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/01-Array/src)
2. [栈](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/02-Stack/src)
3. [数组队列](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/03-Array-Queue/src)
4. [循环队列](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/04-Loop-Queue/src)
5. 链表 
	1. [实现链表](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/05-LinkedList/src)
	2. [使用链表实现栈](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/06-Implement-Stack-in-LinkedList/src)
	3. [使用链表实现队列](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/07-Implement-Queue-in-LinkedList/src)
	4. LeetCode中和链表相关的问题
		1. [删除链表中等于给定值 val 的所有节点](https://leetcode-cn.com/problems/remove-linked-list-elements/description/)。
		2. 示例:
		```
			输入: 1->2->6->3->4->5->6, val = 6
			输出: 1->2->3->4->5
		```
		3. [解答](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/203-Remove-LinkedList-Elements/src)

6. [二分搜索树](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/08-Binary-Search-Tree/src)
	1. 添加元素

	```java
		/**
		 * 向二分搜索树中添加新的元素e
		 * @param e
		 */
		public void add(E e) {
			root = add(root,e);
		}
		
		/**
		 * 向以node为根的二分搜索树中插入元素e，递归算法
		 * 返回插入新节点后二分搜索树的根 
		 * @param node
		 * @param e
		 */
		private Node add(Node node,E e) {
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
	```
	2. 查询操作

	```java
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
	```
	3. 前序遍历(递归实现)

	```java
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
	```
	4. 前序遍历(非递归实现)

	```java
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
	```
	5. 中序遍历

	```java
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
	
	```
	6. 后序遍历

	```java
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
	```
	7. 层序遍历
	
	```java
		/**
		 * 二分搜索树的层序遍历
		 */
		public void levelOrder() {
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node cur = queue.remove();
				System.out.println(cur.e);
				if(cur.left != null)
					queue.add(cur.left);
				if(cur.right != null)
					queue.add(cur.right);
			}
		}
	```
	8. 寻找二分搜索树的最小元素

	```java
		public E minimum() {
			if(size == 0)
				throw new IllegalArgumentException("BST is empty");
			
			return minimum(root).e;
		}

		private Node minimum(Node node) {
		if(node.left == null)
			return node;
		return minimum(node.left);
	}
	```
	9. 寻找二分搜索树的最大元素

	```java
		public E maximum() {
			if(size == 0)
				throw new IllegalArgumentException("BST is empty");
			
			return maximum(root).e;
		}
		
		/**
		 * 返回以node为根的二分搜索树的最大值所在的节点
		 * @param node
		 * @return
		 */
		private Node maximum(Node node) {
			if(node.right == null)
				return node;
			return maximum(node.right);
		}
	```
	10. 从二分搜索树中删除最小值所在节点，返回最小值

	```java
	
	public E removeMin() {
			E ret = minimum();
			root = removeMin(root);
			return ret;
		}
		/**
		 * 删除以node为根的二分搜索树中的最小节点
		 * 返回删除节点后新的二分搜索树的根
		 * @param node
		 * @return
		 */
		private Node removeMin(Node node) {
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			node.left = removeMin(node.left);
			return node;
		}
	```
	11. 从二分搜索树中删除最大值所在节点，返回最大值

	```java
		public E removeMax() {
			E ret = maximum();
			root = removeMax(root);
			return ret;
		}
		/**
		 * 删除以node为根的二分搜索树中的最大节点
		 * 返回删除节点后新的二分搜索树的根
		 * @param node
		 * @return
		 */
		private Node removeMax(Node node) {
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			node.right = removeMin(node.right);
			return node;
		}
	```
	12. 从二分搜索树中删除元素为e的节点
	```java
	public void remove(E e) {
		root = remove(root, e);
	}

	/**
	 * 删除掉以node为根的二分搜索树中值为e的节点，递归算法 返回删除节点后新的二分搜索树的根
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
				// 待删除节点左节点为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			// 待删除节点右子树为空的情况
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// 待删除节点左右子树不为空的情况
			// 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);// size++
			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = node.right = null;// size--

			return successor;
		}
	}
	```

7. 集合
	1. [二分搜索树为底层实现集合](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/09-Set/01-Set-Basics-and-BSTSet/src)
	2. [链表为底层实现集合](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/09-Set/02-LinkedListSet/src)
	3. [LeetCode中与集合相关的问题](https://leetcode-cn.com/problems/unique-morse-code-words/description/)
		1. [解答](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/09-Set/804-Unique-Morse-Code-Words/src)

8. 映射
	1. [使用链表实现map](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/10-Map/01-LinkedListMap)
	2. [使用二分搜索树实现map](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/10-Map/02-BSTMap)
	3. LeetCode中与映射相关的问题
		1. [349. Intersection of Two Arrays](https://leetcode-cn.com/problems/intersection-of-two-arrays/description/)
			1. [解答](https://github.com/Zhuanglijuan/Play-with-Data-Structures/blob/master/349-Intersection-of-Two-Arrays/src/Solution.java)

		2. [350. Intersection of Two Arrays II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/)
			1. [解答](https://github.com/Zhuanglijuan/Play-with-Data-Structures/blob/master/350-Intersection-of-Two-Arrays-II/src/Solution.java)

9. 堆和优先队列
	1. [使用动态数组实现最大堆，使用最大堆实现优先队列](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/11-Heap-and-Priority-Queue/src)
	2. [347. Top K Frequent Elements](https://leetcode-cn.com/problems/top-k-frequent-elements/description/)
		1. [解答](https://github.com/Zhuanglijuan/Play-with-Data-Structures/blob/master/347-Top-K-Frequent-Elements/src/Solution.java)