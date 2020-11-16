package com.mkd;

import java.util.*;

import static java.lang.Math.sqrt;

public class Utils {
    public static boolean isPrime(long number) {
        if (number > 2)
        {
            if (number % 2 == 0)
            {
                return false;
            }

            for (int t = 3; t <= sqrt(number); t += 2)
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

        while (number % 2 == 0)
        {
            factors.add(2L);
            number /=2;
        }

        for (long t = 3; t <= sqrt(number); t += 2)
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

    public static Collection<Long> getDivisors2(long number)
    {
        List<Long> result = new ArrayList<>();
        for (long t = 1; t <= sqrt(number); t++)
        {
            if (number % t == 0)
            {
                result.add(t);
            }
        }
        return result;
    }



    public static Set<Long> getDivisors(long number)
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

        long limit = (long)Math.sqrt(number) + 1;
        int count = -1;
        List<Long> currentList = new ArrayList<>(primeFactorize(number));
        Set<Long> result = new HashSet<>();
        while (result.size() > count) {
            count = result.size();
            for (int index = 0; index < currentList.size(); index++) {
                if (index > 0 && currentList.get(index).equals(currentList.get(index-1)))
                {
                    continue;
                }
                long mp1 = currentList.get(index);
                result.add(mp1);
                for (int index2 = index + 1; index2 < currentList.size(); index2++) {
                    long product = mp1 * currentList.get(index2);
                    if (product <= limit && !result.contains(product) && number % product == 0) {
                        result.add(product);
                        currentList.add(product);
                    }
                }
            }
        }
        currentList.add(1L);
        for (Long aLong : currentList) {
            result.add(number/aLong);
        }
        return result;
    }

    public static Set<Long> getDivisorsUsingDivisorCount(long number)
    {

        /*
            Consider the divisors of 30: 1,2,3,5,6,10,15,30.
            It can be seen that for every divisor d of 30, d+30/d is prime.

            Find the sum of all positive integers n not exceeding 100 000 000
            such that for every divisor d of n, d+n/d is prime.

            360

            L1: 2 2 2 3 3 5
            L2: 2 4 8
            L3: 2 6 12 18 3 12 18 4 36

         */

        List<Long> factors = primeFactorize(number);
        int divNum = countDivisors(factors);
        long limit = (long)Math.sqrt(number) + 1;

        List<Long> currentList = new ArrayList<>(factors);
        TreeSet<Long> result = new TreeSet<>();
        while (result.size() < divNum - 2) {
            for (int index = 0; index < currentList.size(); index++) {
                if (index > 0 && currentList.get(index).equals(currentList.get(index-1)))
                {
                    continue;
                }
                long mp1 = currentList.get(index);
                result.add(mp1);
                result.add(number/mp1);
                for (int index2 = index + 1; index2 < currentList.size(); index2++) {
                    long product = mp1 * currentList.get(index2);
                    if (product <= limit  && !result.contains(product) && number % product == 0) {
                        result.add(product);
                        result.add(number/product);
                    }
                }
            }
            currentList.clear();
            currentList.addAll(result);
        }
        result.add(1L);
        result.add(number);
        return result;
    }

    private static int countDivisors(List<Long> factors) {

        /*
            [2,2,2,3,3,3,5] -> 4*4*2
         */

        int count = 1;
        int lastIndex = 0;
        int nextIndex = 0;
        while (nextIndex < factors.size())
        {
            nextIndex = getNextIndex(factors, lastIndex);
            int factorsForPrime = nextIndex - lastIndex;
            count *= ++factorsForPrime;
            lastIndex = nextIndex;
        }
        return count;
    }

    private static int getNextIndex(List<Long> factors, int lastIndex)
    {
        long currentPrime = factors.get(lastIndex);
        for (int index = lastIndex;; index++) {
            if (index >= factors.size())
            {
                return factors.size();
            }
            if (factors.get(index) != currentPrime)
            {
                return index;
            }
        }
    }
}
