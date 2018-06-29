import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		/*int[] nums = { 5, 3, 6, 8, 4, 2 };
		for (int num : nums)
			bst.add(num);
		
		//层序遍历
		bst.levelOrder();
		System.out.println();

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
		System.out.println(bst);*/
		
		int n = 1000;
		Random random = new Random();
		
		for(int i = 0; i < n ; i ++)
			bst.add(random.nextInt(10000));
		ArrayList<Integer> nums = new ArrayList<>();
		while(!bst.isEmpty())
			nums.add(bst.removeMin());
		
		System.out.println(nums);
		for(int i = 1; i < nums.size(); i ++)
			if(nums.get(i-1) > nums.get(i))
				throw new IllegalArgumentException("Error");
		System.out.println("removeMin test completed");
		
		for(int i = 0; i < n ; i ++)
			bst.add(random.nextInt(10000));
		nums = new ArrayList<>();
		while(!bst.isEmpty())
			nums.add(bst.removeMax());
		
		System.out.println(nums);
		for(int i = 1; i < nums.size(); i ++)
			if(nums.get(i-1) < nums.get(i))
				throw new IllegalArgumentException("Error");
		System.out.println("removeMax test completed");
		
	}
}
