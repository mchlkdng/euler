package com.mkd;

import java.util.Collection;

public class PrimeGeneratingIntegers {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        long sum = 1;   // 1 is prime generating
        long elements = 0;
        for (long t = 2; t < 100000000; t++)
        {
            Collection<Long> divisors = Utils.getDivisors(t);
            if (isPrimeGeneratingInteger(t, divisors))
            {
                sum += t;
                elements++;
            }
            if (t % 100000 == 0)
            {
                System.out.println("number: " + t + "elements:" + elements + " sum:" + sum + " time passed: " + (System.currentTimeMillis() - millis) / 1000.0);
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - millis) / 1000.0);
        System.out.println(sum);

        //result 1739023853137
        //time: 1183.875s
    }

    private static boolean isPrimeGeneratingInteger(long number, Collection<Long> divisors) {
        for (Long divisor : divisors) {
            if (!Utils.isPrime(number/divisor + divisor))
            {
                return false;
            }
        }
        return true;
    }
}
