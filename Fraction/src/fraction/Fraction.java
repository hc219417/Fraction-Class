package fraction;

import static fraction.Utility.greatestCommonDivisor;

public class Fraction {
    // the numer and denom fields represent a fraction
    // CLASS INVARIANTS:
    // CI1: denom is not 0,
    // CI2: denom is positive,
    // CI3: numer and denom are in lowest terms.

    private final long numer;
    private final long denom;

    // full service c-tor for fractions
    public Fraction(long numer, long denom) {
        // CI1. Cannot fix -- must throw exception.
        if(denom == 0) {
            throw new ZeroDenomException();
        }
        // CI2. Can fix.
        if(denom < 0){
            numer *= -1;
            denom *= -1;
        }
        // CI3. Can fix.
        long gcd = greatestCommonDivisor(numer, denom);
        if(gcd != 1){
            numer /= gcd;
            denom /= gcd;
        }
        // all class invariants now satisfied, initialize fields:
        this.numer = numer;
        this.denom = denom;
    }
    // one arg c-tor for longs
    public Fraction(long number){
        this(number, 1);
    }
    // zero arg c-tor for longs
    public Fraction(){
        this(0, 1);
    }
    // toString and toDouble
    public String toString() {
        return numer + " / " + denom;
    }
    public double toDouble(){
        return 1.0 * numer / denom;
    }
    // adds the rhs object to the calling object
    // using a/b + c/d = (ad + bc) / bd
    public Fraction plus(Fraction rhs){
        long up = numer * rhs.denom + rhs.numer * denom;
        long dn = denom * rhs.denom;
        return new Fraction(up, dn);
    }
    // subtracts the rhs object from the calling object
    // using a/b - c/d = (ad - bc) / bd
    public Fraction minus(Fraction rhs){
        long up = numer * rhs.denom - rhs.numer * denom;
        long dn = denom * rhs.denom;
        return new Fraction(up, dn);
    }
    // multiplies the rhs object by the calling object
    // using a/b * c/d = ac / bd
    public Fraction times(Fraction rhs){
        long up = numer * rhs.numer;
        long dn = denom * rhs.denom;
        return new Fraction(up, dn);
    }
    // divides the calling object by the rhs object
    // using a/b / c/d = ad / bc
    public Fraction dividedBy(Fraction rhs){
        long up = numer * rhs.denom;
        long dn = denom * rhs.numer;
        return new Fraction(up, dn);
    }
}
