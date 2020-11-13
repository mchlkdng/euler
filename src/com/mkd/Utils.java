package com.mkd;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Utils {
    public static boolean isPrime(long number) {
        if (number > 2)
        {
            if (number % 2 == 0)
            {
                return false;
            }

            for (int t = 3; t <= sqrt(number); ++t)
            {
                if (number % t == 0)
                {
                    return false;
                }
            }

            return true;
        }
        return number == 2;
    }

    public static List<Long> primeFactorize(long number) {
        List<Long> factors = new ArrayList<>();
        for (long t = 2; t <= number / t; t++)
        {
            while (number % t == 0)
            {
                factors.add(t);
                number /= t;
            }
        }

        if (number > 1)     //number itself is prime
        {
            factors.add(number);
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.print(getDivisors(100000000));
    }

    public static List<Long> getDivisors(long number)
    {

        /*
            Consider the divisors of 30: 1,2,3,5,6,10,15,30.
            It can be seen that for every divisor d of 30, d+30/d is prime.

            Find the sum of all positive integers n not exceeding 100 000 000
            such that for every divisor d of n, d+n/d is prime.

            36

            L1: 2 2 3 3
            L2: 2 3 4 6 9
            L3: 2 6 12 18 3 12 18 4 36

         */

        List<Long> factors = primeFactorize(number);

        int count = -1;
        List<Long> currentList = new ArrayList<>(factors);
        List<Long> nextList = new ArrayList<>();
        while (nextList.size() > count) {
            count = nextList.size();
            for (int index = 0; index < currentList.size(); index++) {
                long mp1 = currentList.get(index);
                if (!nextList.contains(mp1)) {
                    nextList.add(mp1);
                }
                for (int index2 = index + 1; index2 < currentList.size(); index2++) {
                    long product = mp1 * currentList.get(index2);
                    if (product < number && !nextList.contains(product) && number % product == 0) {
                        nextList.add(product);
                    }
                }
            }
            currentList.clear();
            currentList.addAll(nextList);
        }
        nextList.add(1L);
        nextList.add(number);
        return nextList;
    }
}
