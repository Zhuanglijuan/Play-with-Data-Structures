
public class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = { 5, 3, 6, 8, 4, 2 };
		for (int num : nums)
			bst.add(num);

		//前序遍历
		bst.preOrder();
		System.out.println();
		//非递归前序遍历
		bst.preOrderNR();
		System.out.println();

		//中序遍历
		bst.inOrder();
		System.out.println();

		//后序遍历
		bst.postOrder();// 后序遍历的一个应用:为二分搜索树释放内存
		System.out.println();

		//toString
		System.out.println(bst);
	}
}
