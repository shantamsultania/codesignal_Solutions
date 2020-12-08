import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;

public class Q3 {

    //You're given 2 huge integers represented by linked lists.
    // Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits.
    // The represented number might have leading zeros.
    // Your task is to add up these huge integers and return the result in the same format.
    //
    //
    //For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
    //addTwoHugeNumbers(a, b) = [9876, 5434, 0].
    //
    //Explanation: 987654321999 + 18001 = 987654340000.
    //
    //For a = [123, 4, 5] and b = [100, 100, 100], the output should be
    //addTwoHugeNumbers(a, b) = [223, 104, 105].

    ListNode<Integer> head1,head2,header;
    Q3()
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

    ListNode<Integer> reverse(ListNode<Integer> l)
    {
        ListNode<Integer> prev = null;
        ListNode<Integer> current = l;
        ListNode<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
        header = addTwoHugeNumbers(head1,head2);
    }

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        ListNode<Integer> l1 = reverse(a);
        ListNode<Integer> l2 = reverse(b);


        if(l1 == null || l2 == null)
        {
            return null;
        }

        int carry = 0;
        ListNode<Integer> dummynode = new ListNode(0);
        ListNode<Integer> head = dummynode;

        int x = 0,y=0;
        while(l1 != null || l2 != null)
        {

            if(l1 != null)
            {
                x = l1.data;
            }
            else
            {
                x = 0;
            }
            if(l2 != null)
            {
                y = l2.data;
            }
            else
            {
                y = 0;
            }

            int sum = carry+x+y;

            carry = sum /10000;
            head.next = new ListNode(sum%10000);
            head = head.next;
            if(l1 != null)
            {
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2 = l2.next;
            }
        }

        if(carry > 0)
        {
            head.next = new ListNode(carry);
        }
        return reverse(dummynode.next);

    }

    public static void main(String[] args) {

        Q3 obj = new Q3();
        Integer a[] = {9876, 5432, 1999};
        Integer b[] = {1, 8001};
        obj.insert1(a);
        obj.insert2(b);
        obj.result();
        obj.printall();


    }


}
