package com.mkd;

import java.util.ArrayList;
import java.util.List;

import static com.mkd.Utils.isPrime;

public class CircularPrimes {
    public static void main(String[] args) {
        int count = 0;
        for (int t = 2; t < 1000000; t++)
        {
            if (isPrime(t) && isCircularPrime(t))
            {
                System.out.println(t);
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isCircularPrime(int t)
    {
        List<Integer> circulars = getCirculars(t);
        for (int circular : circulars)
        {
            if (!isPrime(circular))
            {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getCirculars(int t) {
        List<Integer> retVal = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        int position = 10;
        while (t > 0) {
            int value = t % position;
            t -= value;
            t /= position;
            numbers.add(value);
        }

        for (int i = 0; i < numbers.size(); i++)
        {
            int number = buildNumber(numbers);
            retVal.add(number);
            Integer removedNumber = numbers.remove(0);
            numbers.add(removedNumber);
        }

        return retVal;
    }

    static int buildNumber(List<Integer> numbers)
    {
        int number = 0;
        int position = 1;
        for (Integer integer : numbers) {
            number += integer * position;
            position *= 10;
        }
        return number;
    }
}
