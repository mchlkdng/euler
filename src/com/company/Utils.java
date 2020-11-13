package com.company;

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
}
