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

6. [二分搜索树](https://github.com/Zhuanglijuan/Play-with-Data-Structures/tree/master/08-BST/src)
	1. 添加元素

	```
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

	```
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

	```
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

	```
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

	```
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

	```
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