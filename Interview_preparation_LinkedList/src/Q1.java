import java.util.List;

public class Q1 {

    // Easy
    //
    // Given a singly linked list of
    // integers l and an integer k,
    // remove all elements from list l that have a value equal to k.

    //Example
    //
    //For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
    //removeKFromList(l, k) = [1, 2, 4, 5];
    //For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
    //removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].

    ListNode<Integer> head;
    Q1()
    {
        head = null;
    }
    void insert(int a[])
    {
        head = new ListNode<>(a[0]);
        ListNode<Integer> temp = head;

        for (int i=1;i<a.length;i++)
        {
            temp.next = new ListNode<>(a[i]);
            temp = temp.next;
        }
    }

    void printall()
    {
        ListNode<Integer> temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }



    void result(int k)
    {
        head = removeKFromList(head,k);
    }

    ListNode<Integer>  removeKFromList(ListNode<Integer> l, int k) {

        ListNode<Integer> n = new ListNode<>(0);
        ListNode<Integer> n1 = n;

        while ( l != null)
        {
            if (l.data != k)
            {
                n1.next = new ListNode<>(l.data);
                n1 = n1.next;
            }
            l = l.next;
        }

        return n.next;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
        int []a= {3,1,2,3,4,5};
        obj.insert(a);
        obj.result(3);
        obj.printall();

    }


}
