package day0612;

public class MainTest {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode listNodeNext1 = l1 ;
        ListNode listNodeNext2 = l2 ;
        ListNode tempNode = result;
        do{
            if (null == listNodeNext1) listNodeNext1 = new ListNode(0);
            if (null == listNodeNext2) listNodeNext2 = new ListNode(0);
            tempNode.val = listNodeNext1.val + listNodeNext2.val;
            listNodeNext1 = listNodeNext1.next;
            listNodeNext2 = listNodeNext2.next;
            if ((null == listNodeNext1) && (null == listNodeNext2)) {
                break;
            }
            tempNode.next = new ListNode(0);
            tempNode = tempNode.next;


        }while (null != result.next);
            plus(result);

        return result;
    }


    public static void plus(ListNode result) {
        if (result.next != null) {
            if (result.val >= 10) {
                result.val = result.val - 10;
                ListNode next = result.next;
                next.val += 1;
                plus(next);
            } else {
                plus(result.next);
            }

        } else {
            if (result.val >= 10) {
                result.val = result.val - 10;
                result.next = new ListNode(1);
            }
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1,l2);
        ListNode temp = result;

        do {
            System.out.print(temp.val);
            temp = temp.next;
        }
        while(null !=  temp );
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
