package com.ulan;
/*
A right rotation is an operation which shifts each element of the array to the right.
For example, if a right rotation is 1 and array is {1,2,3,4,5}, the new array will be {5,1,2,3,4}.
Another example, if a right rotation is 2 and array {1,2,3,4,5}, the new array will be {4,5,1,2,3}, because
{1,2,3,4,5} ->  {5,1,2,3,4} ->  {4,5,1,2,3}.
 */
import java.util.Scanner;

public class RightRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int shiftN = sc.nextInt();

//        System.out.println("str: \"" + str + "\" | str length: " + str.length() + " | n: " + shiftN);
        String[] nums = str.split(" ");
        int[] arrNum = new int[nums.length];

        int realN = shiftN % arrNum.length;

        int i = 0;
        for (String s : nums) {
            arrNum[i] = Integer.parseInt(s);
//            System.out.println("arrNum[" + i + "] = " + arrNum[i]);
            i++;
        }
//        System.out.println(Arrays.toString(arrNum));

        for (i = 0; i < realN; i++) {
            int lastNum = arrNum[arrNum.length - 1];
            for (int j = arrNum.length - 1; j > 0; j--) {
                arrNum[j] = arrNum[j-1];
            }
            arrNum[0] = lastNum;
        }

        for (i = 0; i < arrNum.length; i++) {
            System.out.print(arrNum[i] + " ");
        }
//        System.out.println( Arrays.toString(arrNum));
    }
}
