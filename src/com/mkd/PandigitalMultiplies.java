package com.mkd;

public class PandigitalMultiplies {
    public static void main(String[] args)
    {
        long max = 0;
        for (long number = 1; number < 10000; number++)
        {
            StringBuffer sb = new StringBuffer();
            int n = 1;
            while (sb.length() < 9)
            {
                sb.append(number*n++);
            }
            if (sb.length() == 9)
            {
                long candidate = Long.valueOf(sb.toString());
                if (candidate > max && isPalindrom(sb))
                {
                    System.out.println("" + number + "   " + candidate);
                    max = candidate;
                }
            }
        }
    }

    private static boolean isPalindrom(StringBuffer sb) {
        for (int t = 1; t < 10; t++)
        {
            if (sb.indexOf(String.valueOf(t)) == -1)
            {
                return false;
            }
        }
        return true;
    }
}
