/** https://www.hackerrank.com/challenges/stockmax **/

import java.io.*;
import java.util.*;

public class StockMax {

    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int t = in.nextInt();
        
        while(t-- > 0){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            
            int maxSoFar = 0;
            long profitSoFar = 0;
            for(int i = n - 1; i >= 0; i--){
                if(maxSoFar < arr[i]){
                    maxSoFar = arr[i];
                }
                // deduct pruchased cost (arr[i]) and add selling cost (maxSoFar)
                profitSoFar = (profitSoFar - arr[i]) + maxSoFar;
            }
            
            System.out.println(profitSoFar);
        }
    }
}
