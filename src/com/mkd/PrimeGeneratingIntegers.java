package com.mkd;

import java.util.List;

public class PrimeGeneratingIntegers {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        long sum = 0;
        for (long t = 1; t < 1000000; t++)
        {
            List<Long> divisors = Utils.getDivisors(t);
            if (isPrimeGeneratingInteger(t, divisors))
            {
                sum += t;
            }
            if (t % 10000 == 0)
            {
                System.out.println("number: " + t + " sum:" + sum);
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - millis) / 1000.0);
        System.out.println(sum);
    }

    private static boolean isPrimeGeneratingInteger(long number, List<Long> divisors) {
        for (Long divisor : divisors) {
            if (!Utils.isPrime(number/divisor + divisor))
            {
                return false;
            }
        }
        return true;
    }
}
