package com.ulan;

import java.util.Scanner;
/*3-5 Profit
        Typical task for a job interview.
        Ann put M money in the bank. The bank increases Ann's deposit by P percent every year. Ann wants to know how
        many years should pass until her deposit in the bank reaches K money. Can you help her to answer this question?

        Input contains three integers - M, P, K. It is guaranteed that all numbers are positive and K≥M.
        Output the answer to Ann's question.
        Sample Input 1:
        1 100 8
        Sample Output 1:
        3

        Sample Input 2:
        100 15 120
        Sample Output 2:
        2*/
public class Profit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double moneyM = sc.nextDouble();
        double percentP = sc.nextDouble();
        double goalK = sc.nextDouble();
        int year = 0;

        while (moneyM < goalK) {
            year++;
            moneyM = moneyM + moneyM * percentP / 100;
        }
        System.out.println(year);
    }


}
