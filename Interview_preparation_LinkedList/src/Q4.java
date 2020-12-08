import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;

public class Q4 {

    //Given two singly linked lists sorted in non-decreasing order,
    // your task is to merge them. In other words, return a singly linked list,
    // also sorted in non-decreasing order, that contains the elements from both original lists.
    //For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
    //mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
    //For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
    //mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].



    ListNode<Integer> head1,head2,header;
    Q4()
    {
        head1 = null;
        head2 = null;
    }

    void insert1(Integer a[])
    {
        head1 =insert(a);
    }
    void insert2(Integer a[])
    {
        head2 = insert(a);
    }

    ListNode<Integer> insert(Integer []a)
    {
        ListNode<Integer> head = new ListNode<>(0);

        ListNode<Integer> temp = head;
        for (int i=0;i<a.length;i++)
        {
            temp.next = new ListNode<>(a[i]);
            temp = temp.next;
        }

        return head.next;
    }



    void printall()
    {
        ListNode<Integer> temp = header;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    void result()
    {
        header = mergeTwoLinkedLists(head1,head2);
    }

    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> head = new ListNode(0);
        ListNode<Integer> n = head;
        while(l1 != null && l2 != null)
        {
            if(l1.data < l2.data)
            {
                n.next = new ListNode(l1.data);
                l1 = l1.next;
                n = n.next;
            }
            else
            {
                n.next = new ListNode(l2.data);
                l2 = l2.next;
                n = n.next;
            }


        }
        if(l1 != null)
        {
            while(l1 != null)
            {
                n.next = new ListNode(l1.data);
                n=n.next;
                l1 = l1.next;
            }
        }
        if(l2 != null)
        {
            while(l2 != null)
            {
                n.next = new ListNode(l2.data);
                n=n.next;
                l2 = l2.next;
            }
        }
        return head.next;

    }

    public static void main(String[] args) {

        Q4 obj = new Q4();
        Integer a[] = {1, 2, 3};
        Integer b[] = {4,5,6};
        obj.insert1(a);
        obj.insert2(b);
        obj.result();
        obj.printall();


    }


}
