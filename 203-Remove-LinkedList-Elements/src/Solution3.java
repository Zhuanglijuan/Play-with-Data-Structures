
public class Solution3 {
	public ListNode removeElements(ListNode head,int val) {
		if(head == null)
			return null;
		
		head.next = removeElements(head.next, val);
		/*
		if(head.val == val)
			return head.next;
		else {
			return head;
		}
		*/
		return head.val == val ? head.next : head;
	}
}
