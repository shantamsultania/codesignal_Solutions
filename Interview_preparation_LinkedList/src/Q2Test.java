import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q2Test {

    @Test
    void test1()
    {
        Q2 obj = new Q2();
        int a[] = {0,1,0};
        obj.insert(a);
        assertTrue(obj.isListPalindrome());
    }

    @Test
    void test2()
    {
        Q2 obj = new Q2();
        int a[] = {1,2,2,3};
        obj.insert(a);
        assertFalse(obj.isListPalindrome());
    } @Test
    void test4()
    {
        Q2 obj = new Q2();
        int a[] = {1, 2, 3, 1, 2, 3};
        obj.insert(a);
        assertFalse(obj.isListPalindrome());
    }
    @Test
    void test3()
    {
        Q2 obj = new Q2();
        int a[] = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
        obj.insert(a);
        assertTrue(obj.isListPalindrome());
    } @Test
    void test5()
    {
        Q2 obj = new Q2();
        int a[] = {0, 0};
        obj.insert(a);
        assertTrue(obj.isListPalindrome());
    }

}