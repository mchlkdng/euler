package com.company;

import java.util.HashMap;
import java.util.Map;

public class CollatzSequence {

    private static int longestPath = 0;
    private static int longestNumber = 0;

    public static void main(String[] args) {
        Map<Integer, Integer> mapNumber2Chain = new HashMap<>();
        for (int t = 113300; t < 1000000; t++)
        {
//            if (t % 100 == 0) System.out.println(t);
            int steps = process(t);
            if (steps > longestPath)
            {
                longestPath = steps;
                longestNumber = t;
            }
        }
        System.out.println(longestNumber);
    }

    private static int process(long number)
    {
        int steps = 0;
        while (number != 1) {
//            System.out.println(number);
            steps++;
            if (number % 2 == 0) {
                number /= 2;
            }
            else {
                number *= 3;
                number++;
            }
//            if (number < 0)
//            {
//                break;
//            }
        }
        return steps;
    }

}
