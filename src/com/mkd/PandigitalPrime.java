package com.mkd;

public class PandigitalPrime {
    public static void main(String[] args)
    {
        long millis = System.currentTimeMillis();
        for (long number = 987654321; number >= 123456789; number--)
        {
            String s = String.valueOf(number);
            if (isPalindrom(s, 9) && Utils.isPrime(number))
            {
                System.out.println(number);
                break;
            }
        }

        for (long number = 87654321; number >= 12345678; number--)
        {
            String s = String.valueOf(number);
            if (isPalindrom(s, 8) && Utils.isPrime(number))
            {
                System.out.println(number);
                break;
            }
        }

        for (long number = 7654321; number >= 1234567; number--)
        {
            String s = String.valueOf(number);
            if (isPalindrom(s, 7) && Utils.isPrime(number))
            {
                System.out.println(number);
                break;
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - millis) / 1000.0);
    }

    private static boolean isPalindrom(String sb, int i) {
        for (int t = 1; t <= i; t++)
        {
            if (!sb.contains(String.valueOf(t)))
            {
                return false;
            }
        }
        return true;
    }
}
