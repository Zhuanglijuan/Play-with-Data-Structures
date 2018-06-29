
public class Test {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		ListNode head = new ListNode(nums);
		System.out.println(head);
		
		ListNode res = (new Solution3()).removeElements(head, 4);
		System.out.println(res);
	}
	

	/*public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		ListNode head = new ListNode(nums);
		System.out.println(head);
		
		ListNode res = (new Solution2()).removeElements(head, 4);
		System.out.println(res);
	}
	*/
}
