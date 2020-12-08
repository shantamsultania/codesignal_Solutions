import java.util.List;

public class Q2 {


    // Given a singly linked list of integers, determine whether or not it's a palindrome.
    //
    //Note: in examples below and tests preview linked lists are presented as arrays just
    // for simplicity of visualization: in real data you will be given a head node l of the linked list
    //
    //
    ListNode<Integer> head;
    Q2()
    {
        head = null;
    }
    void insert(int []a)
    {
        head = new ListNode<>(a[0]);
        ListNode<Integer> temp = head;

        for (int i=1;i<a.length;i++)
        {
            temp.next = new ListNode<>(a[i]);
            temp = temp.next;
        }
    }

    boolean isListPalindrome()
    {
        return isListPalindrome(head);
    }
    boolean isListPalindrome(ListNode<Integer> l) {

        ListNode<Integer> prev = null;
        ListNode<Integer> current = l;
        ListNode<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        while (l != null && prev != null)
        {
            if (!l.data.equals(prev.data))
            {
                return false;
            }
            l= l.next;
            prev=prev.next;
        }
        return true;

    }
}
