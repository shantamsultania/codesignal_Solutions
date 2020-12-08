import java.util.Stack;

public class Q5 {

    //
    ///
    ///
    //Given a linked list l, reverse its nodes k at a time and return the modified list.
    // k is a positive integer that is less than or equal to the length of l.
    // If the number of nodes in the linked list is not a multiple of k,
    // then the nodes that are left out at the end should remain as-is.
    //
    //You may not alter the values in the nodes - only the nodes themselves can be changed.
    //
    //For l = [1, 2, 3, 4, 5] and k = 2, the output should be
    //reverseNodesInKGroups(l, k) = [2, 1, 4, 3, 5];
    //For l = [1, 2, 3, 4, 5] and k = 1, the output should be
    //reverseNodesInKGroups(l, k) = [1, 2, 3, 4, 5];
    //For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
    //reverseNodesInKGroups(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].



    ListNode<Integer> head;
    Q5()
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
        head = reverseNodesInKGroups(head,k);
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {



        ListNode<Integer> n = new ListNode(0);
        ListNode<Integer> n1 = n;
        while(l != null)
        {
            ListNode checker = l;
            int c = k;
            Stack<Integer> st = new Stack<Integer>();

            while( l != null && c >0)
            {
                st.push(l.data);
                l = l.next;
                c--;
            }
            if(c != 0)
            {
                n1.next = checker;
                break;
            }

            while(!st.isEmpty())
            {
                n1.next = new ListNode(st.pop());
                n1 = n1.next;
            }


        }
        return n.next;


    }

    public static void main(String[] args) {
        int []a={1,2,3,4,5};

        Q5 obj = new Q5();
        obj.insert(a);
        obj.result(2);
        obj.printall();

    }


}
