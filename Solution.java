//solution: https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//todo: handle irregular outer arrays
//todo: accept mask instead of fixed hourglass shape
//todo: handle non 3x3 inner array
//todo: handle sums up to Integer.NEG_MAX (done)
public class Solution {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int i = 0;
        int j = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxRow = rows - 3;
        int maxCol = cols - 3;
        int [][] boxArr = new int[3][3];

        System.out.println(String.format("rows: %d", rows));
        System.out.println(String.format("cols: %d", cols));
        System.out.println(String.format("maxRow: %d", maxRow));
        System.out.println(String.format("maxCol: %d", maxCol));

        for (;i<=maxRow;i++) {
            System.out.println(String.format("i: %d", i));
            j = 0;
            
            for (;j<=maxCol;j++) {
                System.out.println(String.format("upper left: %d/%d", i, j));
                
                //print current matrix
                int k = 0;
                for (int row=i;row<i+3;row++, k++) {
                    int l = 0;

                    for (int col=j;col<j+3;col++, l++) {
                        System.out.print(String.format("%d ", arr[row][col]));
                        boxArr[k][l] = arr[row][col];
                    }

                    System.out.println("");
                }
            
                int sum = getSum(boxArr);
                System.out.println(String.format("sum:%d", sum));

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println(String.format("maxSum: %d", maxSum));

        return maxSum;
    }

    private static final int getSum(int[][] box) {
        int result = box[0][0] + box [0][1] + box [0][2]
            + box[1][1]
            + box[2][0] + box[2][1] + box [2][2];

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
