public class MyLinkedList {
	
	
	ListNode head;

	public MyLinkedList() {
		head = null;
	}
	
	public MyLinkedList(int val) {
		head = new ListNode(val);
	}

	public void add(int val) {
		if(head==null) {
			head = new ListNode(val);
			return;
		}
		ListNode copy = head;
		while(copy.next!=null) {
			copy=copy.next;
		}
		copy.next= new ListNode(val);
	}
	
	public boolean contains (int target) {
		boolean bool=false;
		ListNode copy = head;
		while(copy!=null) {
			if(copy.val==target) {
				bool=true;
			}
			copy=copy.next;
		}
		
		return bool;
	}
	
	
	public int get(int index) {
		ListNode copy = head;
		for(int i =0;i<index;i++) {
			if(copy==null) {
				throw new IndexOutOfBoundsException();
			}
			copy=copy.next;
		}
		return copy.val;
	}
	
	public int indexOf (int target) {
		int index = 0;
		ListNode copy = head;
		while(copy.next!=null) {
			if(copy.next.val==target) {
				System.out.println(index);
				return index;
			}
			index++;
			copy=copy.next;
		}
		return -1;
	}
	
	
	public void set(int newVal, int index) {
		ListNode copy = head;
		int indexCounter=0;
		while(indexCounter!=index) {
			indexCounter++;
//			System.out.println(copy.val);
			copy=copy.next;
		}
//		System.out.println(copy.val);
		copy.val = newVal;
		System.out.println(head);
	}
	
	public int size() {
		ListNode copy = head;
		int counter = 0;
		while(copy!=null) {
			counter++;
			copy=copy.next;
		}
		return counter;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	public int remove(int index) {
		ListNode copy = head;
		ListNode prev = null;
		if(index==0) {
			int returnVal = head.val;
			head = head.next;
			
			return returnVal;
		}
		for(int i =0;i<index;i++) { //iterate to index BEFORE supplied index
		    prev = copy;
			copy=copy.next;
		}
		int returnVal = copy.val;
		//[5, 6, 100, null]
		prev.next = copy.next;
		return returnVal;
	}
	
	public void add(int newVal, int index) {
		ListNode copy = head;
		ListNode previous = head;
		if(index==0) {
			ListNode newHead = new ListNode(newVal);
			newHead.next = head;
			head = newHead;
			return;
			
		}
		for(int i =0;i<index;i++) {
			if(previous.next==null) {
				throw new IndexOutOfBoundsException();
			}
			previous=copy;
		    copy=copy.next;
		}
		previous.next= new ListNode(newVal);
		previous.next.next = copy;
	}
	
	@Override
	public String toString() {
//		ListNode copy = head;
//		String s= "[";
//		s+=copy.val;
//		copy=copy.next;
//		while(copy!=null) {
//			s += ", ";
//			System.out.println("s  " + s);
//			s+=copy.val;
//			copy=copy.next;
//		}
//		return s + "]";
		
		ListNode copy = this.head;
		
		String s = "[";
		
		while (copy != null) {
			if (copy.next == null) { //last element, don't add comma
				s += copy.val;
				copy = copy.next;
			}
			else {
				s += copy.val + ", ";
				copy = copy.next;
			}
		}
		
		return s + "]";
	}
	
	private class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val=val;
		}
		@Override
		public String toString() {
			return "" + this.val;
		}
	}
}

