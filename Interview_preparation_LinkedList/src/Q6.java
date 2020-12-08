public class Q6 {


    //Given a singly linked list of integers l and a non-negative integer n,
    // move the last n list nodes to the beginning of the linked list.
    //
    //
    //For l = [1, 2, 3, 4, 5] and n = 3, the output should be
    //rearrangeLastN(l, n) = [3, 4, 5, 1, 2];
    //For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
    //rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6].

    ListNode<Integer> head;
    Q6()
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
        head = rearrangeLastN(head,k);
    }

    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int k) {

        ListNode<Integer> n = l;
        int len = 0;
        while( n != null)
        {
            len++;
            n= n.next;
        }
        ListNode<Integer> start = new ListNode(0);
        ListNode<Integer> s1 = start;


        int s = len-k;
        while(s != 0 && l != null)
        {
            s1.next = new ListNode(l.data);
            s1 = s1.next;
            l = l.next;
            s--;
        }
        ListNode<Integer> end = new ListNode(0);
        ListNode<Integer> e1 = end;
        while(l != null)
        {
            e1.next = new ListNode(l.data);
            e1 = e1.next;
            l = l.next;
        }
        e1.next = start.next;
        return end.next;


    }

    public static void main(String[] args) {

        Q6 obj = new Q6();
        int []a ={1,2,3,4,5};
        obj.insert(a);
        obj.result(3);
        obj.printall();
    }


}
