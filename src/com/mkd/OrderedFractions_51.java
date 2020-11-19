package com.mkd;

/*
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
    1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size,
find the numerator of the fraction immediately to the left of 3/7.

 */
public class OrderedFractions_51 {

    static double target = 3.0/7.0;
    static Fraction result = new Fraction(0, 1);

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();

        for (int d = 2; d <= 1000000; d++)
        {
            buildFractions(d);
        }
        System.out.println(result);
        System.out.println((System.currentTimeMillis() - millis)/1000.0);
    }

    private static void buildFractions(int d) {
        int n = findN(d);
        for (; n < d; n++)
        {
            Fraction fraction = new Fraction(n, d);
            if (fraction.getDouble() < target) {
                if (fraction.getDouble() > result.getDouble())
                {
                    result = fraction;
                }
            }
            else
            {
                break;
            }
        }
    }

    private static int findN(int d) {
        int retVal = 2;
        for (int n = 2; n < d; n+=200)
        {
            Fraction fraction = new Fraction(n, d);
            if (fraction.getDouble() < target) {
                retVal = n;
            }
            else
            {
                break;
            }
        }
        return retVal;
    }

    private static class Fraction
    {
        final int numerator;
        final int divisor;

        Fraction(int numerator, int divisor) {
            this.numerator = numerator;
            this.divisor = divisor;
        }

        public double getDouble() {
            return ((double)numerator)/divisor;
        }

        @Override
        public String toString() {
            return "" + numerator + "/" + divisor;
        }
    }
}
