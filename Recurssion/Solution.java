package Recurssion;


import java.util.*;

public class Solution {

    static final int OUT = 0;
    static final int IN = 1;

    static int countWords(String str)
    {
        int state = OUT;
        int wc = 0;
        int i = 0;

        while (i < str.length())
        {

            if (str.charAt(i) == ' ' || str.charAt(i) == '\n'
                    || str.charAt(i) == '\t')
                state = OUT;

            else if (state == OUT)
            {
                state = IN;
                ++wc;
            }

            ++i;
        }
        return wc;
    }

    public static int countTank(String s){
        int n = s.length();
        char[] ch = s.toCharArray();
        int ans =0;
        for(int i =1; i<n; i++) {

                if (i < n-1 && ch[i] == '_' && ch[i - 1] == 'H' && ch[i + 1] == 'H') {
                    ans++;
                    ch[i] = 'T';
                    ch[i + 1] = 'T';
                    ch[i - 1] = 'T';
                }
                if (ch[i] == '_' && ch[i - 1] == 'H') {
                    ans++;
                    ch[i] = 'T';
                    ch[i - 1] = 'T';
                }
                if (ch[i] == '_' &&  i == n-2 && ch[i + 1] == 'H' ) {
                    ans++;
                    ch[i] = 'T';
                    ch[i + 1] = 'T';

                }
            }
        if(ch[0] == '_' && ch[1] == 'H'){
            ans++;
        }
        for(int i =0; i<n;i++){
            if(ch[i] == 'H'){
                return -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

//        LinkedListReversal l = new LinkedListReversal();
//        MyLinkedList m = new MyLinkedList();
//        m.addNode(5);
//        m.addNode(4);
//        m.addNode(3);
//        m.addNode(2);
//        m.addNode(1);
//
//        ListNode k = l.reverseList(m.head);
        int ans = countTank("_H_H_H_H_H");
          System.out.println(ans);

    }
}
