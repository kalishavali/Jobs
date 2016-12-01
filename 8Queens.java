Re: 8Queens Problem
VS
 
Vamsi Saikam
Thu 01-Dec-16 4:11 PM
Inbox
To:
KALISHAVALI SHAIK (kalishavali.rgukt@live.in);
Evernote

import java.util.Scanner;


public class Solution {
    
    
    public static void main(String[] argv)
    {
    
        int board[][]={{7,7,7,7,7,7,7,7},{7,9,9,9,9,9,9,7},{7,9,11,11,11,11,9,7},{7,9,11,13,13,11,9,7},{7,9,11,13,13,11,9,7},{7,9,11,11,11,11,9,7},{7,9,9,9,9,9,9,7},{7,7,7,7,7,7,7,7}};
        
        
        int n;
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        
        while(n>0)
        {
            String s;
            s =sc.next();
            
            int x=(int)s.charAt(0)-97;
            int y = (int)s.charAt(1)-48;
            System.out.println(7+7+board[x][y-1]);
            
        n--;
        }
        
    }
    
    
}
