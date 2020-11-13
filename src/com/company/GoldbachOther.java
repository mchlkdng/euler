package com.company;

import static java.lang.Math.sqrt;

public class GoldbachOther {
    public static void main(String[] args) {
        long number = 1;
        long square = 0;
        while (true)
        {
            number++;
            if (number % 200 == 0)
            {
                System.out.println(number);
            }
            boolean test = false;
            if (number % 2 == 1)
            {
                for (int t = 0; t <= number; t++)
                {
                    if (isPrime(t))
                    {
                        long candidate = number - t;
                        if (isDoubleSquare(candidate))
                        {
                            square = candidate;
                            test = true;
                            break;
                        }
                    }
                }
            }
            else {
                continue;
            }
            if (!test)
            {
                System.out.println("number: " + number + " square:" + square);
                break;
            }
        }
    }

    private static boolean isDoubleSquare(long candidate) {
        double sqrt = sqrt(candidate/2);
        return (sqrt == Math.floor(sqrt)) && !Double.isInfinite(sqrt);
    }

    private static boolean isPrime(long number) {
        if (number > 1)
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
        return false;
    }
}
