/** https://www.hackerrank.com/challenges/funny-string **/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            String s = in.nextLine();
            char cArr[] = s.toCharArray();
            
            int p1 = 0, p2 = cArr.length - 1;
            boolean cond = true;
            while(p1 <= p2){
                if(Math.abs(cArr[p1] - cArr[p1 + 1]) != Math.abs(cArr[p2] - cArr[p2 - 1])){
                    cond = false;
                    break;
                }
                p1++;
                p2--;
            }
            if(cond){
                sb.append("Funny\n");
            }
            else{
                sb.append("Not Funny\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
