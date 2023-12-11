package fraction;

import static fraction.Utility.greatestCommonDivisor;

public class Tests {
    public static void testGcd(){
        System.out.println("");
        System.out.println("Test Greatest Common Divisor");
        System.out.println("");
        for(long i = -21; i < 31; i += 2){
            for(long j = -17; j < 31; j += 3){
                System.out.printf("\n(%5d,%5d) --> %5d", i, j,
                        greatestCommonDivisor(i,j));
            }
        }
        System.out.println("");
    }
    private static void testCTors(){
        System.out.println("Fraction tests.");
        System.out.println("");
        System.out.println("Test C-tor");
        System.out.println("Expected outcome: 4/25, -4/25, -4/25, "
                + "4/25, 17/1, 0/1.");
        System.out.println("");
        Fraction rat01 = new Fraction(144, 900);
        Fraction rat02 = new Fraction(-144, 900);
        Fraction rat03 = new Fraction(144, -900);
        Fraction rat04 = new Fraction(-144, -900);
        Fraction rat05 = new Fraction(17);
        Fraction rat06 = new Fraction();
        System.out.println("rat01 = " + rat01);
        System.out.println("rat02 = " + rat02);
        System.out.println("rat03 = " + rat03);
        System.out.println("rat04 = " + rat04);
        System.out.println("rat05 = " + rat05);
        System.out.println("rat06 = " + rat06);
        System.out.println("");
        System.out.println("Try bad input");
        try {
            Fraction rat00 = new Fraction(0, 0);
            System.out.println("Bad test for Zero Denominator Exception");
        } catch (ZeroDenomException zde) {
            System.out.println("Expected Zero Denominator Exception: " + zde);
        } catch (Exception e) {
            System.out.println("This should never happen.");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Test toDouble. Expect 0.16");
        System.out.println("rat04 to double: " + rat04.toDouble());
    }
    public static void testMath(){
        Fraction threeHalves = new Fraction(3, 2);
        Fraction oneQuarter = new Fraction(1,4);
        Fraction zero = new Fraction();
        Fraction five = new Fraction(5);

        System.out.println("\nMath Tests\n");
        System.out.println("\nTest plus:\n");
        System.out.println("should be 7/4 : " + threeHalves.plus(oneQuarter));
        System.out.println("should be 7/4 : " + oneQuarter.plus(threeHalves));
        System.out.println("should be 3/1 : " + threeHalves.plus(threeHalves));
        System.out.println("should be 13/2 : " + threeHalves.plus(five));
        System.out.println("should be 3/2 : " + threeHalves.plus(zero));
        System.out.println("\nTest minus:\n");
        System.out.println("should be 5/4 : " + threeHalves.minus(oneQuarter));
        System.out.println("should be -5/4 : " + oneQuarter.minus(threeHalves));
        System.out.println("should be 0/1 : " + threeHalves.minus(threeHalves));
        System.out.println("should be -7/2 : " + threeHalves.minus(five));
        System.out.println("should be 3/2 : " + threeHalves.minus(zero));
        System.out.println("\nTest times:\n");
        System.out.println("should be 3/8 : " + threeHalves.times(oneQuarter));
        System.out.println("should be 3/8 : " + oneQuarter.times(threeHalves));
        System.out.println("should be 9/4 : " + threeHalves.times(threeHalves));
        System.out.println("should be 15/2 : " + threeHalves.times(five));
        System.out.println("should be 0/1 : " + threeHalves.times(zero));
        System.out.println("\nTest dividedBy:\n");
        System.out.println("should be 6/1 : " + threeHalves.dividedBy(oneQuarter));
        System.out.println("should be 1/6 : " + oneQuarter.dividedBy(threeHalves));
        System.out.println("should be 1/1 : " + threeHalves.dividedBy(threeHalves));
        System.out.println("should be 3/10 : " + threeHalves.dividedBy(five));
        // System.out.println("exception thrown : " + threeHalves.dividedBy(zero));
        try {
            System.out.print("exception thrown : " );
            System.out.println(threeHalves.dividedBy(zero));
        } catch (ZeroDenomException zde) {
            System.out.println("ZeroDenomException");
        }
        System.out.println("");
    }
    public static void exam(){
        Fraction a = new Fraction(1284, 2889);
        Fraction b = new Fraction(385,462);
        Fraction c = new Fraction();
        System.out.println(" 1: " + a);
        System.out.println(" 2: " + b);
        System.out.println(" 3: " + b.plus(a));
        System.out.println(" 4: " + b.minus(c));
        System.out.println(" 5: " + b.times(a));
        System.out.println(" 6: " + a.dividedBy(b));
        System.out.println(" 7: " + a.dividedBy(a));
        System.out.println(" 8: " + a.times(a));
        System.out.println(" 9: " + a.times(c));
        try {
            System.out.print("10: " );
            System.out.println(a.dividedBy(c));
        } catch (ZeroDenomException zde) {
            System.out.println("ZeroDenomException");
        }
    }
    public static void main(String[] args) {
        System.out.println("\nStart Fraction Tests.\n");
        // testGcd();
        testCTors();
        testMath();
        exam();
        System.out.println("\nEnd Fraction Tests.\n");
    }
}
