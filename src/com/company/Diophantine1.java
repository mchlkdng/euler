package com.company;

import static java.lang.Math.sqrt;

public class Diophantine1 {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        int nMaxCount = 0;
        long number = 0;
        int nCount = 0;
        while (nCount <= 1000)
        {
            nCount = 0;
            number++;
            long xMax = 2*number;
            for (long x = xMax; x > number; x--)
            {
                // 1/y = 1/n - 1/x
                long divisor = number * x;
                long counter = x - number;
                if (divisor % counter == 0)
                {
                    nCount++;
                }
            }
            if (nCount > nMaxCount)
            {
                System.out.println("number: " + number + " count: " + nCount);
                nMaxCount = nCount;
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - millis) / 1000.0);
    }

    private static boolean isNumber(double ratio) {
        return (ratio == Math.floor(ratio)) && !Double.isInfinite(ratio);
    }
}
