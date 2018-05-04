
public class Main {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = { 5, 3, 6, 8, 4, 2 };
		for (int num : nums)
			bst.add(num);

		//ǰ�����
		bst.preOrder();
		System.out.println();
		//�ǵݹ�ǰ�����
		bst.preOrderNR();
		System.out.println();

		//�������
		bst.inOrder();
		System.out.println();

		//�������
		bst.postOrder();// ���������һ��Ӧ��:Ϊ�����������ͷ��ڴ�
		System.out.println();

		//toString
		System.out.println(bst);
	}
}
